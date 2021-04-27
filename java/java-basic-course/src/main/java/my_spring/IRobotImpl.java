package my_spring;

public class IRobotImpl implements IRobot{

    /** IRobotImpl responsibilities and probable issues:
        1) To choose an implementation of the object
        2) To know how to build an object by using implementation.
            Changes in SpeakerImpl and CleanerImpl design(singleton, builder,...), can cause a compilation error
        3) To know how to config created objects.
     */
    private Speaker speaker = new SpeakerImpl();
    private Cleaner cleaner = new CleanerImpl();

    public void cleanRoom(){
        speaker.speak("Started");
        cleaner.clean();
        speaker.speak("Finished");
    }

}
