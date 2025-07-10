package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private Image imageCourrante;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();

        HBox barre = new HBox();
        barre.setSpacing(15);
        barre.setAlignment(Pos.CENTER);
        root.getChildren().add(barre);

        GridPane grille = new GridPane();
        root.getChildren().add(grille);

        primaryStage.setTitle("Demo 6 - Mosaique de la Reine");
        primaryStage.setScene(new Scene(root, 500, 525));
        primaryStage.show();

        // Instancier les boutons/CheckBox
        Button boutonHappy = new Button("Happy! :D");
        Button boutonSad = new Button("Sad :(");
        CheckBox watCheck = new CheckBox("wat");
        CheckBox danseCheck = new CheckBox("Danse! ~o~");

        barre.getChildren().addAll(boutonHappy, boutonSad, watCheck, danseCheck);

        // CHANGED: Charger les images depuis les resources
        Image imageHappy, imageSad, imageWat, imageBlack;
        
        try {
            // Load from resources directory (src/main/resources/)
            imageHappy = new Image(getClass().getResourceAsStream("/happy.png"));
            imageSad = new Image(getClass().getResourceAsStream("/sad.png"));
            imageWat = new Image(getClass().getResourceAsStream("/wat.png"));
            imageBlack = new Image(getClass().getResourceAsStream("/black.png"));
            
            // Vérifier si les images ont chargé correctement
            if (imageHappy.isError() || imageSad.isError() || imageWat.isError() || imageBlack.isError()) {
                System.err.println("Some images failed to load from resources!");
                throw new Exception("Images failed to load from resources");
            } else {
                System.out.println("All images loaded successfully from resources");
            }
            
        } catch (Exception e) {
            System.out.println("Could not load image files from resources, using colored rectangles instead");
            System.out.println("Make sure your images are in src/main/resources/");
            // Utiliser des images colorées de remplacement
            imageHappy = createColoredImage(Color.YELLOW);
            imageSad = createColoredImage(Color.BLUE);
            imageWat = createColoredImage(Color.RED);
            imageBlack = createColoredImage(Color.BLACK);
        }
        
        imageCourrante = imageHappy;

        // Créer les ImageView avec gestion correcte des lambdas
        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < 5; ++j){
                ImageView view = new ImageView();
                view.setImage(imageHappy);
                view.setFitWidth(100);
                view.setFitHeight(100);
                grille.add(view, i, j);

                // Créer une référence finale pour la lambda
                final ImageView currentView = view;
                final Image watImage = imageWat;
                
                // Comportement des ImageView lorsque la souris passe dessus
                currentView.setOnMouseEntered(event -> {
                    if(watCheck.isSelected()){
                        currentView.setImage(watImage);
                    }
                });
                currentView.setOnMouseExited(event -> {
                    if(watCheck.isSelected()){
                        currentView.setImage(imageCourrante);
                    }
                });
            }
        }

        // Comportement des boutons
        boutonHappy.setOnAction(event -> {
            setImages(grille, imageHappy);
            imageCourrante = imageHappy;
        });

        boutonSad.setOnAction(event -> {
            setImages(grille, imageSad);
            imageCourrante = imageSad;
        });

        // Animation (pour la danse)
        AnimationTimer timer = new AnimationTimer() {
            private long derniereFois = 0;
            private ImageView derniereImageView;
            Random rng = new Random();
            private static final long ANIMATION_INTERVAL = 200_000_000; // 0.2 seconds
            
            @Override
            public void handle(long now) {
                if(now >= derniereFois + ANIMATION_INTERVAL){
                    derniereFois = now;
                    if(derniereImageView != null){
                        derniereImageView.setImage(imageBlack);
                    }

                    // Choisir une nouvelle image
                    int quelleImage = rng.nextInt(3);
                    int position = rng.nextInt(25);
                    derniereImageView = (ImageView) grille.getChildren().get(position);
                    switch (quelleImage){
                        case 0:
                            derniereImageView.setImage(imageHappy);
                            break;
                        case 1:
                            derniereImageView.setImage(imageSad);
                            break;
                        case 2:
                            derniereImageView.setImage(imageWat);
                            break;
                    }
                }
            }
        };

        // Comportement des CheckBox
        danseCheck.setOnAction(event -> {
            if(danseCheck.isSelected()){
                timer.start();
                boutonHappy.setDisable(true);
                boutonSad.setDisable(true);
                if(watCheck.isSelected()){
                    watCheck.fire();
                }
                setImages(grille, imageBlack);
            } else {
                timer.stop();
                boutonHappy.setDisable(false);
                boutonSad.setDisable(false);
                setImages(grille, imageCourrante);
            }
        });

        watCheck.setOnAction(event -> {
            if(watCheck.isSelected()){
                if(danseCheck.isSelected()){
                    danseCheck.fire();
                }
            }
        });
    }

    /**
     * Créer une image colorée simple pour les tests
     */
    private Image createColoredImage(Color color) {
        javafx.scene.image.WritableImage image = new javafx.scene.image.WritableImage(100, 100);
        javafx.scene.image.PixelWriter writer = image.getPixelWriter();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                writer.setColor(x, y, color);
            }
        }
        return image;
    }

    /**
     * Méthode qui parcourt la grille et remplace toutes les images
     */
    private void setImages(GridPane grille, Image img){
        for(Node n : grille.getChildren()){
            ((ImageView)n).setImage(img);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}