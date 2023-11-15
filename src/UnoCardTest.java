/**
 * Test cases for the UnoCard Class
 * @author Emmanuel Adekoya
 * @version 1.0
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class UnoCardTest {
    private static UnoCard card;
    private static int counter;
    @BeforeAll
    private static void setup(){
        card = null;
    }
    @AfterEach
    private void summary(){
        counter+=1;
    }
    @AfterAll
    private static void tearDown(){
        System.out.println("Tests passed " + counter);
        System.out.println("All tests are done");
    }

    /**
     * Tests the getColor method for each color in the deck
     */
    @Test
    public void test_GetColor(){
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Six);
        assertEquals(card.getColor(), UnoCard.Color.Red);
        card = new UnoCard(UnoCard.Color.Blue, UnoCard.Value.Six);
        assertEquals(card.getColor(), UnoCard.Color.Blue);
        card = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Six);
        assertEquals(card.getColor(), UnoCard.Color.Green);
        card = new UnoCard(UnoCard.Color.Yellow, UnoCard.Value.Six);
        assertEquals(card.getColor(), UnoCard.Color.Yellow);
        card = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Six);
        assertEquals(card.getColor(), UnoCard.Color.Wild);
    }

    /**
     * Tests the getValue method for all value in the deck
     */
    @Test
    public void test_GetValue(){
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero);
        assertEquals(card.getValue(), UnoCard.Value.Zero);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One);
        assertEquals(card.getValue(), UnoCard.Value.One);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Two);
        assertEquals(card.getValue(), UnoCard.Value.Two);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Three);
        assertEquals(card.getValue(), UnoCard.Value.Three);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Four);
        assertEquals(card.getValue(), UnoCard.Value.Four);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Five);
        assertEquals(card.getValue(), UnoCard.Value.Five);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Six);
        assertEquals(card.getValue(), UnoCard.Value.Six);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Seven);
        assertEquals(card.getValue(), UnoCard.Value.Seven);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Eight);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Nine);
        assertEquals(card.getValue(), UnoCard.Value.Nine);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.DrawTwo);
        assertEquals(card.getValue(), UnoCard.Value.DrawTwo);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Skip);
        assertEquals(card.getValue(), UnoCard.Value.Skip);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Reverse);
        assertEquals(card.getValue(), UnoCard.Value.Reverse);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Wild_four);
        assertEquals(card.getValue(), UnoCard.Value.Wild_four);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Wild);
        assertEquals(card.getValue(), UnoCard.Value.Wild);
    }

    /**
     * Tests that the toString() method creates a string representation of cards.
     */
    @Test
    public void test_ToString(){
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Six);
        assertEquals(card.toString(), "Red_Six");
        card = new UnoCard(UnoCard.Color.Blue, UnoCard.Value.Zero);
        assertEquals(card.toString(), "Blue_Zero");
        card = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Five);
        assertEquals(card.toString(), "Green_Five");
        card = new UnoCard(UnoCard.Color.Yellow, UnoCard.Value.Three);
        assertEquals(card.toString(), "Yellow_Three");
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Reverse);
        assertEquals(card.toString(), "Red_Reverse");
        card = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Skip);
        assertEquals(card.toString(), "Green_Skip");
        card = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Wild);
        assertEquals(card.toString(), "Wild_Wild");
        card = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Wild_four);
        assertEquals(card.toString(), "Wild_Wild_four");
    }
}
