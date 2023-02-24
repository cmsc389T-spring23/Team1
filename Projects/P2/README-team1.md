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

<!-- Add other PacMan functions here -->

### **Ghost**

#### `is_pacman_in_range()` --> boolean
Checks all 8 adjacent tiles to the one where the Ghost is currently located by quering the map for the contents of the tile. If a `Map.type.PACMAN` is located on any of the 8 tiles, return `true`, otherwise return `false`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `is_pacman_in_range()` returns `true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `is_pacman_in_range()` returns `false`.

#### `get_valid_moves()` --> ArrayList
This method returns a list of all the valid moves a Ghost can make based on its current position. Other than moving into a wall, all moves are considered valid.

The test for this method places a Ghost in the map and tests a case where it is surrounded by empty spaces and one where there is a wall and PacMan. It asserts that the size of the list returned is appropriate and that the moves contained in the list include all spaces around the Ghost except the space with the wall.

<!-- Add other Ghost functions here -->

### **Map**

#### `attack()` --> boolean
Since this function will only be called in the event that a Ghost is in attack range of PacMan, this function will always update `gameOver = true` and return `true`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `Ghost.attack()` calls `Map.attack()` and that `isGameOver() == true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `Ghost.attack()` does not call `Map.attack()` and that `isGameOver() == false`.

#### `move(String name, Location loc, Type type)` --> boolean
This method takes information about a specific ghost or PacMan and updates the Map data, moving it. The method assumes it is receiving a valid move. Carrying out the move involves updating the data about pieces on the field, updating the hashmap of locations, and updating the location of the GUI component.

The test for this method places a ghost and PacMan into a map and moves them. It asserts that the move is carried out by examining the component's stored location and the map's field structure.

<!-- Add other Map functions here -->
