import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * this class is the frame for the UnoGame and all the components are initialized here
 * @author chibuzo okpara
 */
public class UnoGameFrame extends JFrame implements UnoGameView {
    private final Game model;
    private UnoGameController controller;
    private GameIcons icons;
    private UnoCardPanel cardPanel;
    private UnoGameButtonPanel buttons;
    private UnoPlayerHandPanel handPanel;
    private UnoGameInfo unoGameInfo;

    public UnoGameFrame() {
        super("Uno");
        this.icons = new GameIcons();
        this.model = new Game(createPlayers());
        this.model.addView(this);
        model.start(model);


        showWelcomeMessage();
        initGui();
        this.setVisible(true);
    }

    private void showWelcomeMessage() {
        String message = "Let's get this game started!";
        String title  = "Let's get this game started!";

        JOptionPane.showMessageDialog(this, message, title,
                JOptionPane.INFORMATION_MESSAGE,null);
    }
    private void initGui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        cardPanel = new UnoCardPanel();
        controller = new UnoGameController(model);
        buttons = new UnoGameButtonPanel(model, controller);
        handPanel = new UnoPlayerHandPanel(model);
        unoGameInfo = new UnoGameInfo(model);


        //add components to the frame initialization
        this.add(cardPanel, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
        this.add(handPanel, BorderLayout.EAST);
        this.add(unoGameInfo, BorderLayout.WEST);
        updateInitialGameState();
    }

    private String[] createPlayers() {
        int playerCount = getPlayerCount();
        String[] playerNames = new String[playerCount];

        for (int i = 0; i < playerCount; i++) {
            playerNames[i] = getPlayerName(i);
        }

        return playerNames;
    }

    private int getPlayerCount() {
        String input = JOptionPane.showInputDialog(null,
                "Enter number of players (2-4):",
                "Player Count",
                JOptionPane.QUESTION_MESSAGE);

        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // If input is not a valid number, default to 2 players
            return 2;
        }

        // Check if the count is within the valid range (2-4)
        if (count >= 2 && count <= 4) {
            return count;
        } else {
            // If count is outside the valid range, default to 2 players
            return 2;
        }
    }


    private String getPlayerName(int playerIndex) {
        String defaultName = "Player " + (playerIndex + 1);
        String message = "Enter name for " + defaultName + ":";

        String name = JOptionPane.showInputDialog(null, message, "Player Name",
                JOptionPane.QUESTION_MESSAGE);

        // If name is not provided (cancel clicked or empty input), use the default name
        if (name == null || name.trim().isEmpty()) {
            name = defaultName;
        }

        return name;
    }

    private void updateInitialGameState() {
        // Update the top card on the pile
        UnoCard topCard = model.getTopCard();
        cardPanel.updateTopCard(topCard);

        // Update the player's hand
        ArrayList<UnoCard> initialHand = model.getPlayerHand(model.getCurrentPlayer());
        handPanel.updatePlayerHand(initialHand);
    }

    @Override
    public void handleGameUpdate(UnoGameEvent e) {
        System.out.println("Recieved update:"+e.getEventType());
        switch (e.getEventType()) {
            case CARD_PLAYED:
                // Update the top card on the pile and the player's hand
                UnoCard topCard = (UnoCard) e.getEventData();
                System.out.println(topCard);
                cardPanel.updateTopCard(topCard);
                handPanel.updatePlayerHand(model.getPlayerHand(model.getCurrentPlayer()));
                unoGameInfo.handleGameUpdate(e);
                unoGameInfo.updateGameInfo();
                break;
            case CARD_DRAWN:
                // Update only the player's hand as a card is drawn
                handPanel.updatePlayerHand(model.getPlayerHand(model.getCurrentPlayer()));
                unoGameInfo.handleGameUpdate(e);
                unoGameInfo.updateGameInfo();
                break;
            case GAME_ENDED:
                // Handle game end scenario, maybe show a dialog with the winner
                String winnerId = (String) e.getEventData();
                showScores();
                JOptionPane.showMessageDialog(this, winnerId + " has won the game!");
                unoGameInfo.handleGameUpdate(e);
                break;
            case WILD_CARD_PLAYED:
                // Prompt user to choose a color for the Wild card
                UnoCard.Color chosenColor = showWildCardColorSelection();
                UnoCard.DarkColor chosenDColor = showWildDarkCardColorSelection();
                model.setWildCardColor(chosenColor);
                model.setWildCardDarkColor(chosenDColor);
        }
        // After handling the event, check if it's AI's turn
        try {
            model.checkAiTurn();
        } catch (InvalidPlayerTurnException | InvalidColorSubmissionException | InvalidValueSubmissionException ex) {
            ex.printStackTrace();
        }

    }
    private UnoCard.Color showWildCardColorSelection() {
        // Array of colors to choose from
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String selectedColor = (String) JOptionPane.showInputDialog(
                this,
                "Choose a color for the Wild card:",
                "Select Color",
                JOptionPane.QUESTION_MESSAGE,
                null,
                colors,
                colors[0]);

        // Convert the selected string to an UnoCard.Color
        return convertStringToColor(selectedColor);
    }
    private UnoCard.DarkColor showWildDarkCardColorSelection() {
        // Array of colors to choose from
        String[] colors = {"Pink", "Orange", "Teal", "Purple"};
        String selectedColor = (String) JOptionPane.showInputDialog(
                this,
                "Choose a color for the Wild card:",
                "Select Color",
                JOptionPane.QUESTION_MESSAGE,
                null,
                colors,
                colors[0]);

        // Convert the selected string to an UnoCard.Color
        return convertStringsToColor(selectedColor);
    }
    private UnoCard.Color convertStringToColor(String colorString) {
        switch (colorString) {
            case "Red":
                return UnoCard.Color.Red;
            case "Green":
                return UnoCard.Color.Green;
            case "Blue":
                return UnoCard.Color.Blue;
            case "Yellow":
                return UnoCard.Color.Yellow;
            default:
                return UnoCard.Color.Red; // Default color in case of null or unexpected input
        }
    }
    private UnoCard.DarkColor convertStringsToColor(String colorString) {
        switch (colorString) {
            case "Pink":
                return UnoCard.DarkColor.Pink;
            case "Orange":
                return UnoCard.DarkColor.Orange;
            case "Blue":
                return UnoCard.DarkColor.Teal;
            case "Yellow":
                return UnoCard.DarkColor.Purple;
            default:
                return UnoCard.DarkColor.Pink; // Default color in case of null or unexpected input
        }
    }

    public void showScores() {
        Map<String, Integer> scores = model.calculateScores();
        StringBuilder scoreMessage = new StringBuilder("Game Over! Final Scores:\n");

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            scoreMessage.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        JOptionPane.showMessageDialog(null, scoreMessage.toString(), "Scores",
                JOptionPane.INFORMATION_MESSAGE);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UnoGameFrame frame = new UnoGameFrame();
            frame.pack(); // Adjusts frame to just fit its subcomponents

        });
    }
}
