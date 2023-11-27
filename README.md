README

Authors: Chibuzo Okpara Emmanuel Adekoya ,Duabo Dagogo Longjohn

Files Included: Game, GameTest, GameIcons, UnoCard, UnoDeck, UnoDeckTest, UnoCardTest, UnoCardPanel, UnoGameButtonPanel, UnoGameController, UnoGameEvent, UnoGameFrame, UnoGameInfo, UnoGameView, UnoPlayerHandPanel

Game Class: Drive the whole game including creating the game environment and the players.
UnoCard Class: Defines card color and value.
UnoDeck class: Initializes the entire deck
UnoCardPanel: Creates the panel containing all of the players hand and the top card
UnoGameButtonPanel: Initializes the function behind draw card and play card
UnoGameController: Impliments the methods behind actions performed, card drawn and card played
UnoGameEvent: Handles game events
UnoGameFrame: Creates the initializing of other panels and the game
UnoGameInfo: Handles showing of different game events
UnoGameview: Interface to handle updating game view
UnoPlayerHandPanel: Updates player hand as card is played or drawn
AiPlayer: Plays the Uno game automatically as a player

AI Player Implementation:
An AI player class was created to evaluate the topcard of the pile, store every card that matches and play any random card from the list of accepted cards in hand.
An AI object is now added to the game class so as to follow the game state and act accordingly. The change turn method in the game continually checks for the AI's turn, to allow it play.

Set-up Instructions:
Download the zip file. Open IntelliJ IDE and setup a workspace. To open the zip file inside IntelliJ, from the main menu, click file then select import. Go to General > Existing Projects into Workspace > Next. Click the Select Archive File and browse for the zip file that was downloaded in the previous steps. The new project should now be visible in the Package Explorer. All the files mentioned above should be in that project. Run the main method inside the UnoGameFrame class to play the game.
To run the project, click run in the UnoGameFrame.

Available Commands: 
"-1" - to draw a card from the deck

Test Instructions: run the test files

To test individual methods open up Tests.java and run each method individually with junit tests.

Known Issues: When a player draws one from deck, the game does not advance to the next player till the current player plays

REFERENCE: the original implementation of the models for this game was sourced from here: https://www.youtube.com/@codeclique1416
