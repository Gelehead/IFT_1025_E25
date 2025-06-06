public final class C extends B implements  Whooperable {

    @Override
    public void whoop() {
        System.out.println("Gazoline");
    }
    @Override
    public void foo() {
        System.out.println(this.bar());
    }
    @Override
    public void baz() {
        super.foo();
    }
    public String getB() {
        return super.b;
    }
}
