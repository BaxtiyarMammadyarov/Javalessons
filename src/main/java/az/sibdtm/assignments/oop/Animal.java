package az.sibdtm.assignments.oop;

public class Animal {
    private  String animalClass;
    private Short weight;
    private String color;
    private String typeFood;
    private String livingEnvironment;



    public Animal() {
    }

    public Animal(String animalClass, Short weight, String color, String typeFood, String livingEnvironment) {
        this.animalClass = animalClass;
        this.weight = weight;
        this.color = color;
        this.typeFood = typeFood;

        this.livingEnvironment = livingEnvironment;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getLivingEnvironment() {
        return livingEnvironment;
    }

    public void setLivingEnvironment(String livingEnvironment) {
        this.livingEnvironment = livingEnvironment;
    }
  public void eat(String foodName){
      System.out.println(foodName+" eat");
  }

}
