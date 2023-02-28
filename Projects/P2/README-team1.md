# **Project 2: PacMan**
Team #1 Members: 
 - Nathan Bezualem
 - Ayhan Eyikan 
 - Itai Iloni 
 - Samuel Kosaih

<!-- Image of our code running PacMan -->

## **Running PacMan from the Command Line**



## **Functions**
### **PacMan**

#### `is_ghost_in_range()` --> boolean
Checks all 8 adjacent tiles to the one where PacMan is currently located by quering the map for the contents of the tile. If a `Map.type.GHOST` is located on any of the 8 tiles, return `true`, otherwise return `false`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `is_ghost_in_range()` returns `true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `is_ghost_in_range()` returns `false`.

#### `get_valid_moves()` --> ArrayList
This method returns a list of all the valid moves PacMan can make based on his current position. Other than moving into a wall, all moves are considered valid even if it would end the game.

The test for this method places PacMan in the map and tests a case where PacMan is surrounded by empty spaces and one where there is a wall and a couple ghosts. It asserts that the size of the list returned is appropriate and that the moves contained in the list include all spaces around PacMan except the space with the wall.

#### `consume()` --> JComponent
This method allows PacMan to consume a `COOKIE` if the component types that it is sharing its location with includes one. If it does, it calls the associated `Map.eatCookie()` function to make the necessary updates. Note that `Map.eatCookie()` will also check whether PacMan's location includes a `COOKIE`, but we make the check within this method first to save time when PacMan is not able to eat a cookie, assuming that this method will be called upon quite frequently.

The two tests for this method places a PacMan able to consume, and a PacMan not able to consume. It calls the `consume()` method respectively on each PacMan and checks for the appropriate return types. Note that it does not check for modified map details as that is not the duty of this method.

<!-- Add other PacMan functions here -->

### **Ghost**

#### `is_pacman_in_range()` --> boolean
Checks all 8 adjacent tiles to the one where the Ghost is currently located by quering the map for the contents of the tile. If a `Map.type.PACMAN` is located on any of the 8 tiles, return `true`, otherwise return `false`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `is_pacman_in_range()` returns `true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `is_pacman_in_range()` returns `false`.

#### `get_valid_moves()` --> ArrayList
This method returns a list of all the valid moves a Ghost can make based on its current position. Other than moving into a wall, all moves are considered valid.

The test for this method places a Ghost in the map and tests a case where it is surrounded by empty spaces and one where there is a wall and PacMan. It asserts that the size of the list returned is appropriate and that the moves contained in the list include all spaces around the Ghost except the space with the wall.

#### `attack()` --> boolean
This method checks whether a Ghost is capable of attacking PacMan by comparing its location to PacMan's. If it does, then it should call the `Map.attack()` function to make the necessary modifications to the map. It uses the sibling `Ghost.is_pacman_in_range()` method to determine its range.

The tests for this method simply places two Ghosts on a map, where one is right next to PacMan and the other is not. Calling `attack()` on the latter case is expected to return `false`, since PacMan is not in range. The other case is expected to return `true`, and based on the implementation of `Map.attack()`, it should also end the game.

<!-- Add other Ghost functions here -->

### **Map**

#### `attack()` --> boolean
Since this function will only be called in the event that a Ghost is in attack range of PacMan, this function will always update `gameOver = true` and return `true`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `Ghost.attack()` calls `Map.attack()` and that `isGameOver() == true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `Ghost.attack()` does not call `Map.attack()` and that `isGameOver() == false`.

#### `move(String name, Location loc, Type type)` --> boolean
This method takes information about a specific ghost or PacMan and updates the Map data, moving it. The method assumes it is receiving a valid move. Carrying out the move involves updating the data about pieces on the field, updating the hashmap of locations, and updating the location of the GUI component.

The test for this method places a ghost and PacMan into a map and moves them. It asserts that the move is carried out by examining the component's stored location and the map's field structure.

#### `eatCookie(String name)` --> JComponent
This method takes in a name of a specific player (either PacMan or a ghost), retrieves the location of the player, and consumes a cookie if applicable. The method checks if the current location of the player shares its componenet with a `COOKIE` component. If it does, then it updates the map details to remove the cookie eaten and return the `JComponent` associated to it.

The method is tested by placing two players into the map, where one player is sharing its location with a `COOKIE` and the other is not. In the former case, we assert that the method returns a JComponent associated to the `COOKIE` at the player's current location and ensure the cookie count increases. In the latter case, we assert that the method retuns `null` and that the cookie count remains the same.

<!-- Add other Map functions here -->
