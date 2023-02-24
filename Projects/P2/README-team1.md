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

<!-- Add other PacMan functions here -->

### **Ghost**

#### `is_pacman_in_range()` --> boolean
Checks all 8 adjacent tiles to the one where the Ghost is currently located by quering the map for the contents of the tile. If a `Map.type.PACMAN` is located on any of the 8 tiles, return `true`, otherwise return `false`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `is_pacman_in_range()` returns `true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `is_pacman_in_range()` returns `false`.

<!-- Add other Ghost functions here -->

### **Map**

#### `attack()` --> boolean
Since this function will only be called in the event that a Ghost is in attack range of PacMan, this function will always update `gameOver = true` and return `true`.

The test for this function defines two frames, each with a Ghost and PacMan object. In one frame, the ghost is in an adjacent tile and the test asserts that `Ghost.attack()` calls `Map.attack()` and that `isGameOver() == true`. In the other frame, the ghost is not in an adjacent tile and the test asserts that `Ghost.attack()` does not call `Map.attack()` and that `isGameOver() == false`.

<!-- Add other Map functions here -->