package az.sibdtm.assignments.OOP2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Person> personList = new ArrayList<>();
        Person person1=new Person("Murad","Mahmudov",25);
        Person person2=new Person("Ilyas","Mammadov",15);
        Person person3=new Person("Natiq","Mammadyarov",30);
        Person person4=new Person("Umud   ","ismayilov",18);
        Person person5=new Person("Nahid","Qasimov",22);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        for (Person person:personList){
            System.out.println(person.toString());
        }
        System.out.println("------------------------------------------------");

        personList=sortPerson(personList);

        for (Person person:personList){
            System.out.println(person.toString());
        }
    }
    public static List<Person> sortPerson(List<Person> list){
        list.sort((o1, o2) -> {return o1.getAge()- o2.getAge();});
        return list;
    }
}
