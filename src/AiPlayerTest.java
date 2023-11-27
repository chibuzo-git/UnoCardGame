/**
 * Test cases for the AiPlayer Class
 * @author Duabo Dagogo Longjohn
 */
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AiPlayerTest {
    Game game = new Game(new String[]{"player1", "player2"});
    AiPlayer AI = new AiPlayer(game);

    /**
     * Test make move, if a move is made the ai will have less cards in hand than before
     * else if a card is drawn the ai will have more cards in hand than before.
     */
    @Test
    public void testMakeMove(){
        Integer count = AI.getHand().size();
        AI.makeMove();
        Integer newCount = AI.getHand().size();
        assertNotEquals(count, newCount);
    }

    /**
     * Tests add card to ai hand.
     */
    @Test
    public void TestAddCardToHand(){
        UnoCard card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Flip, UnoCard.DarkColor.Purple, UnoCard.DarkValue.Four);
        AI.addCardToHand(card);
        assertTrue(AI.getHand().contains(card));
    }

    /**
     * Tests remove card from ai hand.
     */
    @Test
    public void TestRemoveCardFromHand(){
        UnoCard card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Flip, UnoCard.DarkColor.Purple, UnoCard.DarkValue.Four);
        AI.addCardToHand(card);
        AI.removeCardFromHand(card);
        assertFalse(AI.getHand().contains(card));
    }
}
