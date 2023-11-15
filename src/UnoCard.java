/**
 * Creates a card class that contains all createable cards
 * @author Emmanuel Adekoya
 * @version 1.0
 */
public class UnoCard {
    enum Color{
        Red, Blue, Green, Yellow, Wild;
        private static final Color[] colors = Color.values();
        public static Color getColor(int i){
            return Color.colors[i];
        }
    }
    enum Value{
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Skip, Reverse, Wild_four, Wild;
        private static final Value[] values = Value.values();
        public static Value getValue(int i){
            return Value.values[i];
        }
    }
    private final Color color;
    private final Value value;

    /**
     * Card class that is able to create the uno cards
     * @param color Initializes the colour
     * @param value Initializes the value
     */
    public UnoCard(final Color color, final Value value){
        this.color = color;
        this.value = value;
    }

    /**
     * Gets the colour of selected card
     * @return the colour of the card
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * Gets the value of selected card
     * @return the value on the card
     */
    public Value getValue(){
        return this.value;
    }

//    /**
//     * string representation of each card for identification
//     * @return the card colour and value on string representation
//     */
//    public String toString(){
//        return color.toString() + "_" + value.toString();
//    }
}
