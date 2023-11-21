import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * this class has the method calls for the buttons of the game and calls the update methods in the panel classes in
 * its method calls
 * @author chibuzo okpara
 */
public class UnoGameController implements ActionListener {
    private final Game model;

    public UnoGameController(Game model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action perforemd: "+ e.getActionCommand());
        UnoGameEvent.EventType eventType = UnoGameEvent.EventType.valueOf(e.getActionCommand());

        switch (eventType){
            case CARD_PLAYED -> {
                System.out.println("card played");
                handleCardPlayed();
            }
            case CARD_DRAWN -> {
                System.out.println("card drawn");
                handleCardDrawn();
            }
            case DIRECTION_CHANGED -> model.getDirection();

        }
    }
    private void handleCardPlayed() {
        int selectedIndex = model.getSelectedCardIndex();
        System.out.println("Selected card index: " + selectedIndex);
        ArrayList<UnoCard> hand = model.getPlayerHand(model.getCurrentPlayer());

        if (selectedIndex >= 0 && selectedIndex < hand.size()) {
            try {
                UnoCard selectedCard = model.getPlayerCard(model.getCurrentPlayer(),selectedIndex);
                System.out.println("Attempting to play card: " + selectedCard);
//                if(selectedCard.getColor() == UnoCard.Color.Wild){
//                    UnoCard.Color chosenColor = UnoCard.Color.Red;
//                    model.setWildCardColor(chosenColor);
//                }
                model.submitPlayerCard(model.getCurrentPlayer(), selectedCard);
                model.setSelectedCardIndex(-1);
            } catch (InvalidPlayerTurnException | InvalidColorSubmissionException | InvalidValueSubmissionException e) {
                System.out.println("Error handling card played: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid card index selected: " + selectedIndex);
        }
    }

    private void handleCardDrawn() {
        try {
            String currentPlayerId = model.getCurrentPlayer();
            model.submitDraw(currentPlayerId);
        } catch (InvalidPlayerTurnException e) {
            System.out.println("Something wrong with card draw");
        }
    }


    private UnoCard getSelectedCardFromUI() { return null;
    }
}

    