import javax.swing.*;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * @author chibuzo okpara
 */
public class GameIcons {

    public static ImageIcon loadCardImage(UnoCard card) throws FileNotFoundException {
        String cardName = getCardImageName(card);
        String path = "/small/" + cardName + ".png";
        URL imageUrl = GameIcons.class.getResource(path);

        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            throw new FileNotFoundException("Image file not found: " + path);
        }
    }

    private static String getCardImageName(UnoCard card) {
        String color = card.getColor().toString();
        String value = card.getValue().toString();
        return color + "_" + value;
    }

}
