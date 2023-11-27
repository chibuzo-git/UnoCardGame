import javax.swing.*;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * @author chibuzo okpara
 */
public class GameIcons {
    public static boolean flipped = true;
    public void flip(){
        flipped = !flipped;
    }

    public static ImageIcon loadCardImage(UnoCard card) throws FileNotFoundException {
        String cardName = getCardImageName(card);
        String path = "/combined/" + cardName + ".png";
        URL imageUrl = GameIcons.class.getResource(path);

        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            throw new FileNotFoundException("Image file not found: " + path);
        }
    }

    private static String getCardImageName(UnoCard card) {
        if (flipped) {
            String color = card.getColor().toString();
            String value = card.getValue().toString();
            return color + "_" + value;
        } else if (!flipped) {
            String darkColor = card.getDarkColor().toString();
            String darkValue = card.getDarkValue().toString();
            return darkColor + "_" + darkValue;
        }
        return "Wild_Flip";
    }

    public boolean isLightSideActive(){
        return flipped;
    }

}
