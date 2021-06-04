package constructor_chaining;

public class Son extends Parent {

    private final double pi = Math.PI;

    public Son() {
        printPi();
    }

    public void printPi(){
        System.out.println(pi);
    }

}
