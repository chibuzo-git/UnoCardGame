import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/***
 * Deck class contains a number of UnoCards and the number of cards in the deck.
 */
public class UnoDeck {
    private UnoCard[] cards;
    private int cardsInDeck;

    /**
     * Constructor for Deck Class, creates a deck of 108 UnoCards with unassigned values.
     */
    public UnoDeck(){
        cards = new UnoCard[116];
    }

    /**
     * The deck has just been created reset() assigns the UnoCards with colors and values.
     */
    public void reset(){
        UnoCard.Color[] colors = UnoCard.Color.values();
        UnoCard.DarkColor[] darkColors = UnoCard.DarkColor.values();
        cardsInDeck = 0;
        for (int i = 0; i< colors.length-1; i++) {
            UnoCard.Color color = colors[i];
            UnoCard.DarkColor darkColor = darkColors[i];
            //making first 0 card
            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0), darkColor, UnoCard.DarkValue.getDarkValue(0));
            //making the other cards
            for (int j = 1; j < 10; j++) {
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j), darkColor, UnoCard.DarkValue.getDarkValue(j));
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j), darkColor, UnoCard.DarkValue.getDarkValue(j));
            }
            UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.DrawTwo, UnoCard.Value.Skip, UnoCard.Value.Reverse};
            for (UnoCard.Value value : values) {
                cards[cardsInDeck++] = new UnoCard(color, value, darkColor, UnoCard.DarkValue.Skip_Everyone);
                cards[cardsInDeck++] = new UnoCard(color, value, darkColor, UnoCard.DarkValue.Draw_Five);
            }
        }
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Flip, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Blue, UnoCard.Value.Flip, UnoCard.DarkColor.Purple, UnoCard.DarkValue.Flip);
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Flip, UnoCard.DarkColor.Pink, UnoCard.DarkValue.Flip);
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Yellow, UnoCard.Value.Flip, UnoCard.DarkColor.Orange, UnoCard.DarkValue.Flip);

        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Red, UnoCard.Value.Flip, UnoCard.DarkColor.Teal, UnoCard.DarkValue.Flip);
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Blue, UnoCard.Value.Flip, UnoCard.DarkColor.Purple, UnoCard.DarkValue.Flip);
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Green, UnoCard.Value.Flip, UnoCard.DarkColor.Pink, UnoCard.DarkValue.Flip);
        cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Yellow, UnoCard.Value.Flip, UnoCard.DarkColor.Orange, UnoCard.DarkValue.Flip);

        UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.Wild, UnoCard.Value.Wild_four};
        for (UnoCard.Value value: values){
            for (int i = 0; i<4; i++){
                cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, value, UnoCard.DarkColor.Wild, UnoCard.DarkValue.Wild_Draw_Color);
            }
        }
    }

    /**
     * Refills the deck by adding cards that have been played to the deck.
     * @param cards
     */
    public void replaceDeckWith(ArrayList<UnoCard> cards){
        this.cards = cards.toArray(new UnoCard[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }

    /**
     * Checks if the deck is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return cardsInDeck ==0;
    }

    /**
     * Rearranges the order of cards in the deck.
     */
    public void shuffle(){
        int n = cards.length;
        Random random = new Random();
        for (int i = 0; i<cards.length; i++){
            int randomValue = i + random.nextInt(n -i);
            UnoCard randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

   /**
     * Draw a random card from the deck.
     * @return UnoCard
     * @throws IllegalArgumentException
     */
    public UnoCard drawCard() throws IllegalArgumentException{
        if (isEmpty()){
            throw new IllegalArgumentException("No Cards in deck to draw from");
        }
        return cards[--cardsInDeck];
    }

    /**
     * GUI method
     * @return ImageIcon
     * @throws IllegalArgumentException
     */
    public ImageIcon drawCardImage() throws IllegalArgumentException{
        if (isEmpty()){
            throw new IllegalArgumentException("No Cards in deck to draw from");
        }
        return new ImageIcon(cards[--cardsInDeck].toString());
    }

    /**
     * Method used to perform  Draw2 and Draw4, it allows multiple cards to be drawn from the deck.
     * @param n
     * @return UnoCard[]
     */
    public UnoCard[] drawCard(int n){
        if (n<0){
            throw new IllegalArgumentException("Must draw positive cards but tried to draw "+n+" cards.");
        }
        if(n>cardsInDeck){
            throw new IllegalArgumentException("Cannot draw "+n+" cards. only "+cardsInDeck+"cards left");
        }
        UnoCard[] ret = new UnoCard[n];
        for (int i = 0; i<n; i++){
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }
     public static void main(String[] args) {
        UnoDeck deck  = new UnoDeck();
        deck.reset();
    }
}

