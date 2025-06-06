import java.util.Arrays;
public class Foo {
    int[] elements;

    public Foo(int[] e){
        elements = e;
    }

    public boolean egal(Object o){
        return this == o;
    }

    public boolean egal(int[] tab) {
        return Arrays.equals(this.elements, tab);
    }
}
