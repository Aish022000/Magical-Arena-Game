package arena;

public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void fight() {
        while (player1.isAlive() && player2.isAlive()) {
            if (player1.getHealth() < player2.getHealth()) {
                attack(player1, player2);
                if (!player2.isAlive()) break;
                attack(player2, player1);
            } else {
                attack(player2, player1);
                if (!player1.isAlive()) break;
                attack(player1, player2);
            }
        }
    }

    private void attack(Player attacker, Player defender) {
        int attackRoll = Dice.roll();
        int defendRoll = Dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendDamage = defender.getStrength() * defendRoll;

        int damageDealt = attackDamage - defendDamage;
        if (damageDealt > 0) {
            defender.reduceHealth(damageDealt);
        }

        System.out.println(attacker + " attacks with roll " + attackRoll + " (damage: " + attackDamage + ")");
        System.out.println(defender + " defends with roll " + defendRoll + " (defended: " + defendDamage + ")");
        System.out.println(defender + " health: " + defender.getHealth());
    }
}
