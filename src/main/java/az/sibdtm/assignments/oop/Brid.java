package az.sibdtm.assignments.oop;

public class Brid extends Animal{

    public Brid() {
        super();
    }

    public Brid(String animalClass, Short weight, String color, String typeFood, String livingEnvironment) {
       super(animalClass, weight,  color, typeFood, livingEnvironment);
    }

    public void qanadCırp(){
        System.out.println(this.getAnimalClass()+"qanadlarini cirpir");
    }


}
