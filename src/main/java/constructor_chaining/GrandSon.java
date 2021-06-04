package constructor_chaining;

public class GrandSon extends Son{
    private String pi = "This is Pi";

    public GrandSon() {
        printPi();
    }

    public void printPi() {
        System.out.println(pi);
    }
}
