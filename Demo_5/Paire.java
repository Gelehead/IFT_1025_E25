public class Paire<A, B> {
    private A x;
    private B y;

    public Paire( A x, B y) {
        this.x = x;
        this.y = y;
    }

    public A getX() { return x; }
    public B getY() { return y; }
    public void setX(A x) { this.x = x; }
    public void setY(B y) { this.y = y; }
}
