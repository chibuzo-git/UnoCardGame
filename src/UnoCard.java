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
    enum DarkColor{
        Teal, Pink, Purple, Orange, Wild;
        private static final DarkColor[] darkColors = DarkColor.values();
        public static DarkColor getDarkColor(int i){return DarkColor.darkColors[i];}
    }
    enum Value{
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Skip, Reverse, Wild_four, Wild, Flip;
        private static final Value[] values = Value.values();
        public static Value getValue(int i){
            return Value.values[i];
        }
    }
    enum DarkValue{
        Six, Skip_Everyone, Three, Two, Draw_Five, Eight, Five, Flip, Four, Nine, One, Reverse, Seven, Wild_Draw_Color;
        private static final DarkValue[] darkValues = DarkValue.values();
        public static DarkValue getDarkValue(int i){return DarkValue.darkValues[i];}
    }

    /**
     * Card class that is able to create the uno cards
     * @param color Initializes the colour
     * @param value Initializes the value
     */
    private Color color;
    private final Value value;
    private DarkColor darkColor;
    private final DarkValue darkValue;
    public UnoCard(final Color color, final Value value, final DarkColor darkColor, final DarkValue darkValue){
        this.color = color;
        this.value = value;
        this.darkColor = darkColor;
        this.darkValue = darkValue;
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
    public DarkColor getDarkColor(){return this.darkColor;}
    public DarkValue getDarkValue(){return this.darkValue;}
    public void setColor(Color color) {
        this.color = color;
    }
    public void setDarkColor(DarkColor darkColor) {
        this.darkColor = darkColor;
    }

    public int getScore() {
        int lightScore = getLightScore();
        int darkScore = getDarkScore();
        return Math.max(lightScore, darkScore); // Use the higher of the two scores
    }

    private int getLightScore() {
        switch (this.value) {
            case Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine:
                return this.value.ordinal(); // ordinal gives the position in enum (0 for Zero, 1 for One, etc.)
            case DrawTwo, Skip, Reverse, Flip:
                return 20;
            case Wild, Wild_four:
                return 50;
            default:
                return 0;
        }
    }

    private int getDarkScore() {
        switch (this.darkValue) {
            case Six, Three, Two, Eight, Five, Four, Nine, One, Seven, Flip:
                return 20;
            case Skip_Everyone, Wild_Draw_Color:
                return 50;
            case Draw_Five:
                return 40;
            default:
                return 0;
        }
    }

//    /**
//     * string representation of each card for identification
//     * @return the card colour and value on string representation
//     */
//    public String toString(){
//        return color.toString() + "_" + value.toString();
//    }
}
