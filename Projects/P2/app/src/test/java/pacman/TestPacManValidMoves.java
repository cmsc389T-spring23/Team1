package pacman;
import java.io.*;
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
    assertTrue(moves.contains(new Location(11, 12)));
    assertTrue(moves.contains(new Location(13, 12)));
    assertTrue(moves.contains(new Location(12, 11)));
    assertTrue(moves.contains(new Location(12, 13)));

    // pacman with a wall to the left and ghosts
    frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(11, 11));
    Ghost ghost = frame.addGhost(new Location(11, 10), "Sir Noodle", Color.BLUE);
    Ghost ghost = frame.addGhost(new Location(11, 12), "Sir Noodle", Color.BLUE);
    Ghost ghost = frame.addGhost(new Location(12, 11), "Sir Noodle", Color.BLUE);
    assertEquals(3, moves.size());
    assertTrue(moves.contains(new Location(11, 12)));
    assertTrue(moves.contains(new Location(11, 10)));
    assertTrue(moves.contains(new Location(12, 11)));
    
    return;
  }
}
