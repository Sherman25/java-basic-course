package my_spring;

public class IRobotImpl implements IRobot{

    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom(){
        speaker.speak("Started");
        cleaner.clean();
        speaker.speak("Finished");
    }

}
