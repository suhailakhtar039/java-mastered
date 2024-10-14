package Encapsulation;

public class Main {
    public static void main(String[] args) {

        // Player player = new Player();
        //
        // player.name = "suhail";
        // player.health = 200;
        // player.weapon = "sword";
        //
        // int damage = 10;
        //
        // player.loseHealth(damage);
        // System.out.println("health = " + player.healthRemaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("suhail", 200, "sword");
        System.out.println("Initial health is " + enhancedPlayer.healthRemaining());

    }
}
