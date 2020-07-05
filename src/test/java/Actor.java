public class Actor {

    private int age;
    String firstName;
    String lastName;
    double height;
    double weight;

    public Actor(int age, String firstName, String lastName, double height, double weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    void speak(){
        System.out.println("I'm speaking");
    }

    void play() {
        System.out.println("I'm playing");
    }

    void sing(){
        System.out.println("I'm singing");
    }

}
