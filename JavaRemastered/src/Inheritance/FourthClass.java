package Inheritance;

public class FourthClass {
    public static void main(String[] args) {

        Animal animal = new Animal("Generic Animal", "Huge", 400);
        // doAnimalStuff(animal, "Fast");

        Dog dog = new Dog();
        doAnimalStuff(dog, "slow");

    }
    public static void doAnimalStuff(Animal animal, String speed){
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("____________");
    }
}
