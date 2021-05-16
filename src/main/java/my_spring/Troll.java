package my_spring;

public class Troll {

    @InjectRandomInt(min = 10, max = 20)
    private int power;

    public int getPower(){
        return power;
    }
}
