package reflections_home_work;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Sherman", 30);
        Person person1 = JsonMapper.convertFromJson("{\"name\" : \"Sherman\" , \"age\" : 30}", Person.class);
        System.out.println(person1.getName() + " " + person1.getAge());

    }

}
