package pacman;
import java.io.*;
import java.util.ArrayList;
import junit.framework.*;
import java.awt.Color;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    // all valid moves
    NoFrame frame = new NoFrame();

    // pacman center, all empty around
    PacMan pacman = frame.addPacMan(new Location(12, 12));
    
    ArrayList<Location> moves = pacman.get_valid_moves();

    assertEquals(4, moves.size());
    assertTrue(moves.contains(new Location(11, 12)));  // above
    assertTrue(moves.contains(new Location(13, 12)));  // below
    assertTrue(moves.contains(new Location(12, 11)));  // left
    assertTrue(moves.contains(new Location(12, 13)));  // right

    // pacman with a wall to the left and ghosts
    frame = new NoFrame();
    pacman = frame.addPacMan(new Location(12, 11));

    Ghost ghost = frame.addGhost(new Location(11, 11), "Sir Noodle", Color.BLUE);  // above
    ghost = frame.addGhost(new Location(12, 12), "Sir Noodle", Color.BLUE);  // right
    ghost = frame.addGhost(new Location(13, 11), "Sir Noodle", Color.BLUE);  // below

    moves = pacman.get_valid_moves();
    
    assertEquals(3, moves.size());
    assertTrue(moves.contains(new Location(11, 11)));  // above
    assertTrue(moves.contains(new Location(13, 11)));  // below
    assertTrue(moves.contains(new Location(12, 12)));  // right


    // pacman with cookie to right
    frame = new NoFrame();
    pacman = frame.addPacMan(new Location(12, 13)); 

    ghost = frame.addGhost(new Location(12, 12), "Gronk", Color.PINK);  // left

    moves = pacman.get_valid_moves();

    assertEquals(4, moves.size());
    assertTrue(moves.contains(new Location(12, 14)));  // right
    assertTrue(moves.contains(new Location(12, 12)));  // left
    assertTrue(moves.contains(new Location(11, 13)));  // above
    assertTrue(moves.contains(new Location(13, 13)));  // below
  }
}
