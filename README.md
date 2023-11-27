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

UnoFlip Implementation(Emmanuel Adekoya):
In the UnoCard class the colour and value parameters are accompanied by a darkColor and darkValue parameter. 
These are then initialized in the UnoDeck class. 
The Game icons Class includes a method to understand when a flip card is played. 
Switching the flipped parameter changes the naming used in developing the icon of each card. 
The flip method is initialized in the Game method. and all other action cards not created in the light side Uno are implimented. 
The wild card method is also implimented in the UnoGameFrame. Also checks for what side of the game it is currently.
All other classes in the game are made to accomodate the updated game.

AI Player Implementation(Chibuzo Okpara):
An AI player class was created to evaluate the topcard of the pile, store every card that matches and play any random card from the list of accepted cards in hand.
An AI object is now added to the game class so as to follow the game state and act accordingly. The change turn method in the game continually checks for the AI's turn, to allow it play.
When the gui is started, include a player's name as,"AI," to include ai capabilities.

Set-up Instructions:
Download the zip file. Open IntelliJ IDE and setup a workspace. To open the zip file inside IntelliJ, from the main menu, click file then select import. Go to General > Existing Projects into Workspace > Next. Click the Select Archive File and browse for the zip file that was downloaded in the previous steps. The new project should now be visible in the Package Explorer. All the files mentioned above should be in that project. Run the main method inside the UnoGameFrame class to play the game.
To run the project, click run in the UnoGameFrame.

Available Commands: 
"-1" - to draw a card from the deck

Test Files(Duabo Dagogo Longjohn):

Test Instructions: 
run the test files

To test individual methods open up Tests.java and run each method individually with junit tests.

Known Issues:
When the AI plays a certain card from its hand , it causes a recursive call issue but the specifics of this issue has not been discovered.

REFERENCE: the original implementation of the models for this game was sourced from here: https://www.youtube.com/@codeclique1416
