import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AiPlayer {
    private final Game game;
    private ArrayList<UnoCard> hand;
    private final String playerId;

    public AiPlayer(Game game) {
        this.game = game;
        this.hand = new ArrayList<>();
        this.playerId ="AI";
    }
    public String getPlayerId(){
        return this.playerId;
    }

    // Called to make a move
    public UnoCard makeMove() {
        UnoCard topCard = game.getTopCard();
        boolean isLightSide = game.isLightSideActive();

        List<UnoCard> legalMoves = getLegalMoves(topCard, isLightSide);
        if (!legalMoves.isEmpty()) {
            System.out.println("AI just played");
            return selectBestMove(legalMoves);
        }

        // Draw a card if no legal moves
        UnoCard drawnCard = game.pickFromDeck(game.getCurrentPlayer());
        addCardToHand(drawnCard);
        return null; // Return null to indicate a card was drawn
    }

    private UnoCard selectBestMove(List<UnoCard> legalMoves) {
        // Selecting a random card for simplicity
        Random random = new Random();
        return legalMoves.get(random.nextInt(legalMoves.size()));
    }

    private List<UnoCard> getLegalMoves(UnoCard topCard, boolean isLightSide) {
        List<UnoCard> legalMoves = new ArrayList<>();
        for (UnoCard card : hand) {
            if (isLegalMove(card, topCard, isLightSide)) {
                legalMoves.add(card);
            }
        }
        return legalMoves;
    }
    private boolean isLegalMove(UnoCard card, UnoCard topCard, boolean isLightSide) {
        if (isLightSide) {
                // Check for matching color or value or Wild card (for light side)
                return card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue()
                        || card.getColor() == UnoCard.Color.Wild;
            } else {
                // Check for matching dark color or dark value or Wild card (for dark side)
                return card.getDarkColor() == topCard.getDarkColor() || card.getDarkValue() == topCard.getDarkValue()
                        || card.getDarkColor() == UnoCard.DarkColor.Wild;
            }
    }

    public void addCardToHand(UnoCard card) {
        this.hand.add(card);
    }

    public void removeCardFromHand(UnoCard card) {
        this.hand.remove(card);
    }

    public ArrayList<UnoCard> getHand() {
        return this.hand;
    }
}
