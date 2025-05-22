package Personnages;

public abstract class Personnage implements Interface_personnage{
    int hp;
    String name;
    public void afficher(){
        System.out.println(
                """
                                            ________
                                        _jgN########Ngg_
                                      _N##N@@""  ""9NN##Np_
                                     d###P            N####p
                                     "^^"              T####
                                                       d###P
                                                    _g###@F
                                                 _gN##@P
                                               gN###F"
                                              d###F
                                             0###F
                                             0###F
                                             0###F
                                             "NN@'
                                                
                                              ___
                                             q###r
                                              ""
                        """
        );
    }
    public void attaquer(Personnage personnage) {
        System.out.println(" you killed : " + personnage.name);
    }

}
