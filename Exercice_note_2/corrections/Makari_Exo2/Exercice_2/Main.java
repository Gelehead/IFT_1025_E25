/**Parsa Makari
 * Matricule 20121030
 *  01/06/25
 */
public class Main{
    // La fonction ci-dessus appel toutes les methodes definies, dans notre class test.
    public static void main(String[] args){
        Vecteur v = new Vecteur(new double[]{3.0,2.0,4.0});
        v.setElement(2, 3.0);
        System.out.println(v);
        System.out.println("vec_rep: " + Test.vec_rep());
        System.out.println("vec_dot: " + Test.vec_dot());
        System.out.println("vec_set: " + Test.vec_set());
        System.out.println("vec_get: " + Test.vec_get());
        System.out.println("vec_getelement_oob: " + Test.vec_getelement_oob());

        System.out.println("mat_dot_bad_dim: " + Test.mat_dot_bad_dim());
        System.out.println("mat_setget: " + Test.mat_setget());
        System.out.println("mat_addscalaire: " + Test.mat_addscalaire());
        System.out.println("mat_multscalaire: " + Test.mat_multscalaire());
        System.out.println("mat_transpose: " + Test.mat_transpose());
        System.out.println("mat_identite: " + Test.mat_identite());
        System.out.println("mat_getcell_oob: " + Test.mat_getcell_oob());
            }
        }

