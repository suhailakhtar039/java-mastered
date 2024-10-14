package Encapsulation;

public class Main {
    public static void main(String[] args) {

        Player player = new Player();

        player.name = "suhail";
        player.health = 200;
        player.weapon = "sword";

        int damage = 10;

        player.loseHealth(damage);
        System.out.println("health = " + player.healthRemaining());

    }
}
