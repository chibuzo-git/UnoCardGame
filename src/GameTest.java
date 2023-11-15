/**
 * Test cases for the game Class
 * @author Emmanuel Adekoya
 * @version 1.0
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class GameTest {
    private static Game game1;
    private static int counter;

    /**
     * initializes the game to null
     */
    @BeforeAll
    private static void setup(){
        game1 = null;
    }

    /**
     * Increments the count value for successfully completed test cases
     */
    @AfterEach
    private void summary(){
        counter+=1;
    }

    /**
     * Displays the number of test cases passed by the end of the program
     */
    @AfterAll
    private static void tearDown(){
        System.out.println("Tests passed " + counter);
        System.out.println("All tests are done");
    }

    /**
     * Tests that the current player is the first player that was instantiated at the start of the game
     */
    @Test
    public void test_CurrentPlayer(){
        game1 = new Game(new String[]{"player1", "player2", "player3", "player4"});
        assertEquals(game1.getCurrentPlayer(), "player1");
    }

    /**
     * Tests that the initialized previous player is player 4 and updates as the current player changes
     */
    @Test
    public void test_PreviousPlayer(){
        game1 = new Game(new String[]{"player1", "player2", "player3", "player4"});
        game1.getCurrentPlayer();
        assertEquals(game1.getPreviousPlayer(1), "player4");
    }

    /**
     * Tests that all players have the same number of cards as the gam begins
     */
    @Test
    public void test_PlayerHandSize() {
        game1 = new Game(new String[]{"player1", "player2", "player3", "player4"});
        assertEquals(game1.getPlayerHandSize("player1"), 7);
        assertEquals(game1.getPlayerHandSize("player2"), 7);
        assertEquals(game1.getPlayerHandSize("player3"), 7);
        assertEquals(game1.getPlayerHandSize("player4"), 7);
    }

    /**
     * Tests that all players have non empty hands as fo the start of the game
     */
    @Test
    public void test_HasEmptyHand() {
        game1 = new Game(new String[]{"player1", "player2", "player3", "player4"});
        assertEquals(game1.hasEmptyHand("player1"), false);
        assertEquals(game1.hasEmptyHand("player2"), false);
        assertEquals(game1.hasEmptyHand("player3"), false);
        assertEquals(game1.hasEmptyHand("player4"), false);
    }

    /**
     * Tests the gameOver() method to see the current state of the game
     */
    @Test
    public void test_GameOver(){
        game1 = new Game(new String[]{"player1", "player2", "player3", "player4"});
        assertEquals(game1.gameOver(), false);
        //As there is no method to clear out a players hand (due to the laws of the game)
        //Manual testing would have to be implemented for when a hand is empty and the game is finished
    }

    /**
     * Tests for the current direction the game is in
     */
    @Test
    public void test_GameDirection() {
        game1 = new Game(new String[]{"player1", "player2", "player3", "player4"});
        assertEquals(game1.getDirection(), false);
    }

}
