/**
 * this method handles all the information on the current state of the game including current player,
 * @author chibuzo okpara
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UnoGameInfo extends JPanel {
        private JLabel currentPlayerLabel;
        private JLabel gameDirectionLabel;
        private JLabel validColor;
        private Game model;

        public UnoGameInfo(Game model) {
            this.model = model;
            initializeUI();
            updateGameInfo();
        }

        private void initializeUI() {
            setPreferredSize(new Dimension(200, 700));
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            currentPlayerLabel = new JLabel("Current Player: ");
            gameDirectionLabel = new JLabel("Direction: Clockwise");
            validColor = new JLabel("Valid color now is: ");

            add(currentPlayerLabel);
            add(gameDirectionLabel);
            add(validColor);
        }

        public void updateGameInfo() {
            String currentPlayer = "Current Player: " + model.getCurrentPlayer();
            currentPlayerLabel.setText(currentPlayer);

            String direction = model.getDirection() ? "Counter-Clockwise" : "Clockwise";
            gameDirectionLabel.setText("Direction: " + direction);

            String vColor = "Valid color now is: " + model.getValidColor();
            validColor.setText(vColor);
        }

        public void handleGameUpdate(UnoGameEvent e) {
            if (e.getEventType() == UnoGameEvent.EventType.TURN_CHANGED) {
                updateGameInfo();
            }
        }
    }


