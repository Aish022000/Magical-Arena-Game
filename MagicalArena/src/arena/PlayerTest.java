package arena;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testReduceHealth() {
        Player player = new Player(100, 10, 5);
        player.reduceHealth(20);
        assertEquals(80, player.getHealth());
    }

    @Test
    public void testIsAlive() {
        Player player = new Player(100, 10, 5);
        assertTrue(player.isAlive());
        player.reduceHealth(100);
        assertFalse(player.isAlive());
    }
}
