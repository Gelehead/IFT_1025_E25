package Personnages;

public abstract class Personnage implements Personnage_interface {
    int hp;
    String name;

    public void attaquer(Personnage perso) {
        System.out.println("killed " + perso.name);
    }

    @Override
    public String toString(){
        return this.name + " : " + this.hp;
    }
    public void afficher() {
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
}
