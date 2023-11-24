import java.util.*;

/***
 * this is the model class for the game that
 * @author Chibuzo Okpara
 * @version v1.0
 */
import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private String[] ids;
    private int selectedCardIndex = -1;
    private UnoDeck deck;
    private ArrayList<UnoCard> pile;
    private ArrayList<ArrayList<UnoCard> > playerHand;
    private UnoCard.Value validValue;
    private UnoCard.Color validColor;
    private UnoCard.DarkValue validDarkValue;
    private UnoCard.DarkColor validDarkColor;
    private int currentPlayer;
    private boolean direction;
    private GameIcons flipped = new GameIcons();
    private List<UnoGameView> views;

    public Game(String[] playerIds) {
        int i;
        ids = playerIds;
        direction = false;
        currentPlayer = 0;
        pile = new ArrayList<UnoCard>();
        deck = new UnoDeck();
        deck.reset();
        deck.shuffle();
        playerHand = new ArrayList<ArrayList<UnoCard> >();

        for (i = 0; i < playerIds.length; i++) {
            ArrayList<UnoCard> newHands = new ArrayList<UnoCard>(List.of(deck.drawCard(7)));
            playerHand.add(newHands);
        }
        this.views = new ArrayList<UnoGameView>();
    }

    public void addView(UnoGameView view){
        this.views.add(view);
    }
    public void removeView(UnoGameView view){
        this.views.remove(view);
    }
    public void start(Game game) {
        UnoCard cards = deck.drawCard();
        validValue = cards.getValue();
        validColor = cards.getColor();
        validDarkValue = cards.getDarkValue();
        validDarkColor = cards.getDarkColor();

        if (cards.getValue() == UnoCard.Value.Wild) {
            start(game);
        }
        if (cards.getValue() == UnoCard.Value.Skip) {
            System.out.println("Skipping this player " + ids[currentPlayer]);
            if (!direction) {
                currentPlayer = (currentPlayer + 1) % ids.length;
            } else {
                currentPlayer = (currentPlayer - 1) % ids.length;
                if (currentPlayer == -1) {
                    currentPlayer = ids.length - 1;
                }
            }
        }
        if (cards.getValue() == UnoCard.Value.Reverse) {
            System.out.println("Game direction has changed from: " + ids[currentPlayer]);
        }
        pile.add(cards);
        updateViews(new UnoGameEvent(this,UnoGameEvent.EventType.GAME_STARTED, cards));
    }

//    public UnoCard getTopCard() {
//        UnoCard top = new UnoCard(validColor, validValue);
//        return top;
//    }
    public UnoCard getTopCard(){
        if (!pile.isEmpty()) {
            return pile.get(0); // Returns the top card
        }
        return null;
    }
    public void setSelectedCardIndex(int index){
        this.selectedCardIndex = index;
    }

    public int getSelectedCardIndex(){
        return this.selectedCardIndex;
    }
    public String getValidColor() {
        return this.validColor.toString();
    }
    public String getValidDarkColor(){return this.validDarkColor.toString();}
    public boolean gameOver() {
        for (String player : this.ids) {
            if (hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer() {
        return this.ids[this.currentPlayer];
    }

    public boolean getDirection(){
        return direction;
    }

    public String getPreviousPlayer(int i) {
        int index = this.currentPlayer - i;
        if (index == -1) {
            index = ids.length - 1;
        }
        return this.ids[index];
    }

    public String[] getPlayerIds() {
        return ids;
    }

    public ArrayList<UnoCard> getPlayerHand(String id) {
        int index = java.util.Arrays.asList(ids).indexOf(id);
        return playerHand.get(index);
    }

    public UnoCard getPlayerCard(String id, int choice) {
        ArrayList<UnoCard> hand = getPlayerHand(id);
        return hand.get(choice);
    }

    public int getPlayerHandSize(String id) {
        return getPlayerHand(id).size();
    }
    public void setWildCardColor(UnoCard.Color color) {
        this.validColor = color;
        if (!pile.isEmpty() && pile.get(0).getColor() == UnoCard.Color.Wild) {
            pile.get(0).setColor(color);
        }
    }
    public void setWildCardDarkColor(UnoCard.DarkColor color) {
        this.validDarkColor = color;
        if (!pile.isEmpty() && pile.get(0).getDarkColor() == UnoCard.DarkColor.Wild) {
            pile.get(0).setDarkColor(color);
        }
    }

    public boolean hasEmptyHand(String id) {
        return getPlayerHand(id).isEmpty();
    }

    public boolean validCardPlay(UnoCard card) {
        return card.getValue() == validValue || card.getColor() == validColor || card.getDarkValue() == validDarkValue || card.getDarkColor() == validDarkColor;
    }
    public boolean isValidColor(UnoCard.Color color){
        return color == UnoCard.Color.Red || color == UnoCard.Color.Green || color == UnoCard.Color.Blue ||
                color == UnoCard.Color.Yellow;
    }

    public void checkPlayersTurn(String id) throws InvalidPlayerTurnException {
        if (!Objects.equals(this.ids[this.currentPlayer], id)) {
            throw new InvalidPlayerTurnException("Not this player's turn");
        }
    }

    public void submitDraw(String id) throws InvalidPlayerTurnException {
        checkPlayersTurn(id);
        if (deck.isEmpty()) {
            deck.replaceDeckWith(pile);
            deck.shuffle();
        }
        UnoCard drawnCard = deck.drawCard();
        getPlayerHand(id).add(drawnCard);
        if (!direction) {
            currentPlayer = (currentPlayer + 1) % ids.length;
        } else {
            currentPlayer = (currentPlayer - 1) % ids.length;
            if (currentPlayer == -1) {
                currentPlayer = ids.length - 1;
            }
        }
        updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.CARD_DRAWN, drawnCard));
    }

    public void setCardColor(UnoCard.Color color) {
        validColor = color;
    }
    public void endGame(){
        System.out.println("The game has been won!");
        System.exit(0);
    }
    public void changeTurn() {
        if (!direction) {
            // Move to the next player in a clockwise direction
            currentPlayer = (currentPlayer + 1) % ids.length;
        } else {
            // Move to the next player in a counter-clockwise direction
            currentPlayer = (currentPlayer - 1 + ids.length) % ids.length;
        }

        // Notify the views about the turn change
        updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.TURN_CHANGED, getCurrentPlayer()));
    }

    public UnoCard pickFromDeck(String id){
        if(deck.isEmpty()){
            deck.replaceDeckWith(pile);
            deck.shuffle();
        }
        UnoCard drawOne = deck.drawCard();
        getPlayerHand(id).add(drawOne);
        return drawOne;
    }

    public void updateViews(UnoGameEvent e){
        System.out.println("updateviews called:" + e.getEventType());
        for(UnoGameView v : views){
            v.handleGameUpdate(e);
        }
    }

    public void submitPlayerCard(String id, UnoCard chosenCard) throws InvalidPlayerTurnException,
            InvalidColorSubmissionException, InvalidValueSubmissionException {
        System.out.println("submitplayercard called with card:"+chosenCard);
        System.out.println("first current player:" +getCurrentPlayer());
        System.out.println("this is the initial player hand:"+getPlayerHand(id));
        checkPlayersTurn(id);

       try{
           if (!validCardPlay(chosenCard) && chosenCard.getColor() != UnoCard.Color.Wild) {
               throw new InvalidValueSubmissionException("Invalid card played, Try again!.");
           }
           if(chosenCard.getColor() == UnoCard.Color.Wild || chosenCard.getDarkColor() == UnoCard.DarkColor.Wild  ){
               updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.WILD_CARD_PLAYED, null));
               ArrayList<UnoCard> playerHand = getPlayerHand(id);
               playerHand.remove(chosenCard);
               pile.add(0, chosenCard);
               validValue = chosenCard.getValue();
               validDarkValue = chosenCard.getDarkValue();
               changeTurn();
               updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.CARD_PLAYED, getTopCard()));
               System.out.println("here is the topcard now when wild is played:"+ getTopCard());
           } else {
               // Handle special card effects
               switch (chosenCard.getValue()) {
                   case Skip:
                       // Skip the next player
                       changeTurn(); // Skip once
                       System.out.println("skip works");
                       break;
                   case DrawTwo:
                       // The next player draws two cards
                       changeTurn();
                       String nextPlayerId = getCurrentPlayer();
                       UnoCard first = deck.drawCard();
                       UnoCard second = deck.drawCard();
                       getPlayerHand(nextPlayerId).add(first);
                       getPlayerHand(nextPlayerId).add(second);
                       updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.CARD_DRAWN,
                               Arrays.asList(first, second)));
                       System.out.println("drawtwo works");
                       break;
                   case Reverse:
                       // Reverse the direction of play
                       direction = !direction;
                       updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.DIRECTION_CHANGED, direction));
                       System.out.println("reverse works");
                       break;
               }switch (chosenCard.getDarkValue()) {
                   case Wild_Draw_Color:
                       changeTurn();
                       String nextPlayerId = getCurrentPlayer();
                       UnoCard first = deck.drawCard();
                       getPlayerHand(nextPlayerId).add(first);
                       updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.CARD_DRAWN,
                               Arrays.asList(first)));
                       System.out.println("draw color works");
                       break;
                   case Reverse:
                       direction = !direction;
                       updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.DIRECTION_CHANGED, direction));
                       System.out.println("reverse works");
                       break;
                   case Flip:
                       flipped.flip();
                       updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.GAME_FLIPPED, direction));
                       System.out.println("flip works");
                       break;
                   case Draw_Five:
                       changeTurn();
                       String nextPlayerIds = getCurrentPlayer();
                       UnoCard firsts = deck.drawCard();
                       UnoCard second = deck.drawCard();
                       UnoCard third = deck.drawCard();
                       UnoCard fourth = deck.drawCard();
                       UnoCard fifth = deck.drawCard();
                       getPlayerHand(nextPlayerIds).add(firsts);
                       getPlayerHand(nextPlayerIds).add(second);
                       getPlayerHand(nextPlayerIds).add(third);
                       getPlayerHand(nextPlayerIds).add(fourth);
                       getPlayerHand(nextPlayerIds).add(fifth);
                       updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.CARD_DRAWN,
                               Arrays.asList(firsts, second, third, fourth, fifth)));
                       System.out.println("drawfive works");
                       break;
                   case Skip_Everyone:
                       for(int i =0; i< 3; i++){
                           changeTurn(); // Skip once
                       }
                       System.out.println("skip everyone works");
                       break;
               }
               // Update game state
               ArrayList<UnoCard> playerHand = getPlayerHand(id);
               playerHand.remove(chosenCard);
               pile.add(0, chosenCard);
               validValue = chosenCard.getValue();
               //validColor = chosenCard.getColor();
               if (chosenCard.getColor() != UnoCard.Color.Wild){
                   validColor = chosenCard.getColor();
               }

               // Check for game end
               if (hasEmptyHand(id)) {
                   updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.GAME_ENDED, id));
                   endGame();
                   return;
               } else {
                   changeTurn();
                   UnoCard topCard = getTopCard();
                   updateViews(new UnoGameEvent(this, UnoGameEvent.EventType.CARD_PLAYED, getTopCard()));
                   System.out.println("here is the topcard now:"+ topCard);
                   System.out.println("this is the new current player:" +getCurrentPlayer());
                   System.out.println("the players current hand now:"+ getPlayerHand(id));
               }System.out.println("Card submitted successfully.");
           }
       }catch(Exception e){
       System.out.println("Exception in submitplayercard" + e.getMessage());}
    }
}
