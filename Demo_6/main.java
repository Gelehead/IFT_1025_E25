public class main {
    public static void main(String[] args) {
        ChainedList<String> list = new ChainedList<>();
        list.addLast("pas");
        list.addFirst("n'est");
        list.addLast("pipe");
        list.addFirst("ceci");

        System.out.println(list.getCell(3));
    }
}
