/**
 * Test cases for the UnoDeck Class
 * @author Duabo Dagogo Longjohn
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnoDeckTest {

    /**
     * Test DrawCard() method, a drawn card is random
     * so in this test i check if the card returned is of UnoCard class.
     */
    @Test
    public void testDrawCard() {
        UnoDeck unoDeck = new UnoDeck();
        unoDeck.reset();
        UnoCard unoCard = unoDeck.drawCard();
        UnoCard unoCard2 = new UnoCard(UnoCard.Color.Red, UnoCard.Value.DrawTwo);
        assertEquals(unoCard.getClass(), unoCard2.getClass());
    }

    /**
     * Test DrawCard(int n) method that draws multiple cards, the drawn cards are random
     * so in this test i check if the cards returned are of UnoCard class.
     */
    @Test
    public void testMultipleDrawCard() {
        UnoDeck unoDeck = new UnoDeck();
        unoDeck.reset();
        int n = 2;
        UnoCard[] unoCard = unoDeck.drawCard(2);
        UnoCard unoCard2 = new UnoCard(UnoCard.Color.Red, UnoCard.Value.DrawTwo);
        for (int i = 0; i < n; i++) {
            assertEquals(unoCard[i].getClass(), unoCard2.getClass());
        }
    }

    /**
     * Test shuffle() method, create two decks then populate them
     * shuffle the two decks then draw a card each from the two decks and
     * check that they are not equal.
     */
    @Test
    public void testShuffle() {
        UnoDeck unoDeck = new UnoDeck();
        unoDeck.reset();
        UnoDeck unoDeck2 = new UnoDeck();
        unoDeck2.reset();
        unoDeck.shuffle();
        unoDeck2.shuffle();
        String a = unoDeck.drawCard().toString();
        String b = unoDeck2.drawCard().toString();
        assertNotEquals(a, b);
    }
}
