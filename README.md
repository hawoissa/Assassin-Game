# Assassin-Game
ASSASSIN MAIN reads a list of names from a file, shuffles them, and creates an AssassinManager object. The user is then asked for the names of each victim to assassinate until only one player remains alive (at which point the game is over and the last remaining player wins). To carry out the activities required in administering the game, AssassinMain calls methods of the AssassinManager class.



ASSASSIN MANAGER keeps track of who is stalking whom and the history of who killed whom in games of Assassin. This program manages the two key linked lists. As people are assassinated, altering links between nodes will shift them from the death ring to the graveyard. When only one node remains in the kill ring, the game is over, and the winner is declared.
