package animal;

public class Dog implements Animal {

    @Override
    public void makeVoice() {
        System.out.println("au au");
    }

    public void bringStick() {
        System.out.println("This is your stick");
    }
}
