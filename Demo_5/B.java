public class B extends A {
    protected String b;

    @Override
    public void foo() {
        super.foo();
        System.out.println("Foo B");
    }
    @Override
    public void baz() {
        System.out.println("Baz");
    }

    public String getA(){
        return super.a;
    }
}
