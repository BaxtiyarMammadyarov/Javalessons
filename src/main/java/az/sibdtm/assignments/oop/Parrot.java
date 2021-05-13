package az.sibdtm.assignments.oop;

public class Parrot extends Brid implements AnimalFly{

    private  String name;

    public Parrot() {
        super();
    }

    public Parrot(String name,String animalClass, Short weight, String color, String typeFood, String livingEnvironment) {
        super( animalClass, weight, color,typeFood, livingEnvironment);
        this.name = name;
    }

    public void fly() {
        System.out.println(this.name+" fly");
    }

}
