import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * this class handles the panel for a players hand and updates the players hand appropriately
 * @author chibuzo okpara
 */
public class UnoPlayerHandPanel extends JPanel {
    private Game model;
    private List<JLabel> cardLabels;

    public UnoPlayerHandPanel(Game model) {
        this.model = model;
        setLayout(new FlowLayout());
        cardLabels = new ArrayList<>();
        this.setPreferredSize(new Dimension(500,700));
    }

    public void updatePlayerHand(ArrayList<UnoCard> hand) {
        removeAll(); // Remove all existing card labels
        cardLabels.clear(); // Clear the list of card labels
        System.out.println("updating hand:"+hand);
        for (UnoCard card : hand) {

            try {

                ImageIcon cardImage = GameIcons.loadCardImage(card); // Load the image for the card
                JLabel cardLabel = new JLabel(cardImage); // Create a label with the card image
                cardLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Set border for the label

                cardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        cardLabelClicked(cardLabel, hand.indexOf(card)); // Add mouse click listener
                    }
                });

                cardLabels.add(cardLabel); // Add the label to the list of card labels
                add(cardLabel); // Add the label to the panel
            } catch (FileNotFoundException e) {
                System.err.println("Error loading card image: " + e.getMessage());

            }
        }

        revalidate();
        repaint();
    }

    private void cardLabelClicked(JLabel clickedLabel, int cardIndex) {
        System.out.println("Card clicked at index(playerhand panel): " + cardIndex);
        model.setSelectedCardIndex(cardIndex); // Update the selected card index in the Game model

        // Update the border of the clicked label and reset others
        for (JLabel label : cardLabels) {
            if (label == clickedLabel) {
                label.setBorder(BorderFactory.createLineBorder(Color.RED, 3)); // Highlight the selected card
            } else {
                label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Reset border for non-selected cards
            }
        }
    }

//    private void highlightSelectedCard(int cardIndex) {
//        for (int i = 0; i < cardLabels.size(); i++) {
//            JLabel label = cardLabels.get(i);
//            if (i == cardIndex) {
//                label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
//            } else {
//                label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//            }
//        }
//    }
}

