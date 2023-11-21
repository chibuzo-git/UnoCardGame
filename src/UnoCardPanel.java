import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

/**
 * this class handles the panel where the card pile is and updates the top card appropriately
 * @author chibuzo okpara
 */
public class UnoCardPanel extends JPanel {
    private JLabel topCardLabel;
    public UnoCardPanel(){
        setLayout(new BorderLayout());
        topCardLabel = new JLabel("",JLabel.CENTER);
        topCardLabel.setHorizontalAlignment(JLabel.CENTER);
        this.setPreferredSize(new Dimension(500,600));
        this.add(topCardLabel, BorderLayout.CENTER);

    }

    public void updateTopCard(UnoCard topCard) {
        try {
            ImageIcon cardImage = GameIcons.loadCardImage(topCard);
            topCardLabel.setIcon(cardImage);
        } catch (FileNotFoundException e) {
            topCardLabel.setText("Image not found");
            System.err.println("Error loading card image: " + e.getMessage());
        }
    }
}
