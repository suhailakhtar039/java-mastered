import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    int age;
    Person(){}
    Person(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
public class PlayAround {
    public static void main(String[] args) {
        Person p1 = new Person(24);
        Person p2 = new Person(25);
        Person p3 = new Person(30);
        Person p4 = new Person(15);
        Person p5 = new Person(26);
        Person p6 = new Person(28);

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        arrayList.add(p5);
        arrayList.add(p6);

        List<Person> filteredPerson = arrayList.stream().filter(person -> person.age > 25).toList();
        System.out.println(filteredPerson);
        filteredPerson.forEach(System.out::println);
    }
}
