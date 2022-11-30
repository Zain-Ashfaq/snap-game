# snap-game

Deck of 52 cards. Randomly assembled suits,symbol and values.

Default is set to a multiplayer game. If you want a singleplayer game change argument snap.StartGame(true) to false in Snap class.

For multiplayer when two card symbols match in a row, press enter then type in snap under 2 seconds to win the game. Otherwise you will lose.

In Main class there is deck.sortDeckInNumberOrder(); method that sorts deck of cards by suits then by value of cards.

IMPROVEMENTS:

Add scanner to determine if user wants to play multiplayer. All needed is y or n (n defaults game to singleplayer)

Give option to decide deck size and timer to enter snap. Can be done when Deck and Snap is intialised using scanner.
