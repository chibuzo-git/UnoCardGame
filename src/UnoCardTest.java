/**
 * Test cases for the UnoCard Class
 * @author Emmanuel Adekoya, Duabo Dagogo Longjohn
 * @version 2.0
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
     * Tests the getColor method for each color on the light side.
     */
    @Test
    public void test_GetColor(){
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getColor(), UnoCard.Color.Red);
        card = new UnoCard(UnoCard.Color.Blue, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getColor(), UnoCard.Color.Blue);
        card = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getColor(), UnoCard.Color.Green);
        card = new UnoCard(UnoCard.Color.Yellow, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getColor(), UnoCard.Color.Yellow);
        card = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getColor(), UnoCard.Color.Wild);
    }

    /**
     * Tests the getValue method for each value on the light side.
     */
    @Test
    public void test_GetValue(){
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Zero);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.One);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Two, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Two);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Three, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Three);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Four, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Four);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Five, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Five);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Six);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Seven, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Seven);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Eight, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Eight);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Nine, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Nine);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.DrawTwo, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.DrawTwo);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Skip, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Skip);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Reverse, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Reverse);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Wild_four, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Wild_four);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Wild, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Wild);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Flip, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getValue(), UnoCard.Value.Flip);
    }

    /**
     * Tests the getColor method for each color on the dar side.
     */
    @Test
    public void test_GetDarkColor() {
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getDarkColor(), UnoCard.DarkColor.Teal);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One, UnoCard.DarkColor.Pink, UnoCard.DarkValue.Eight);
        assertEquals(card.getDarkColor(), UnoCard.DarkColor.Pink);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One, UnoCard.DarkColor.Purple, UnoCard.DarkValue.Eight);
        assertEquals(card.getDarkColor(), UnoCard.DarkColor.Purple);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One, UnoCard.DarkColor.Orange, UnoCard.DarkValue.Eight);
        assertEquals(card.getDarkColor(), UnoCard.DarkColor.Orange);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One, UnoCard.DarkColor.Wild, UnoCard.DarkValue.Eight);
        assertEquals(card.getDarkColor(), UnoCard.DarkColor.Wild);
    }

    /**
     * Tests the getValue method for each value on the dark side.
     */
    @Test
    public void test_GetDarkValue() {
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.One);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.One);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Two);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Two);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Three);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Three);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Four);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Four);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Five);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Five);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Six);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Six);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Seven);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Seven);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Eight);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Eight);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Nine);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Nine);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Skip_Everyone);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Skip_Everyone);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Reverse);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Reverse);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Draw_Five);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Draw_Five);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Wild_Draw_Color);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Wild_Draw_Color);
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.getDarkValue(), UnoCard.DarkValue.Flip);
    }


    /**
     * Tests that the toString() method creates a string representation of cards.

    @Test
    public void test_ToString(){
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Six, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Red_Six");
        card = new UnoCard(UnoCard.Color.Blue, UnoCard.Value.Zero, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Blue_Zero");
        card = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Five, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Green_Five");
        card = new UnoCard(UnoCard.Color.Yellow, UnoCard.Value.Three, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Yellow_Three");
        card = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Reverse, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Red_Reverse");
        card = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Skip, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Green_Skip");
        card = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Wild, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Wild_Wild");
        card = new UnoCard(UnoCard.Color.Wild, UnoCard.Value.Wild_four, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        assertEquals(card.toString(), "Wild_Wild_four");
    }
    */

}
