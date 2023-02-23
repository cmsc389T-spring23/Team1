package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    // all valid moves
    NoFrame frame = new NoFrame();

    // ghost center, all empty around
    Ghost ghost = frame.addGhost(new Location(12, 12), "Señor Spook", Color.BLUE);
    ArrayList<Location> moves = ghost.get_valid_moves();
    assertEquals(4, moves.size());
    assertTrue(moves.contains(new Location(11, 12)));
    assertTrue(moves.contains(new Location(13, 12)));
    assertTrue(moves.contains(new Location(12, 11)));
    assertTrue(moves.contains(new Location(12, 13)));

    // ghost with a wall to the left and pacman
    frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(11, 11), "Monsieur Mole", Color.GREEN);
    PacMan pacman = frame.addPacMan(new Location(11, 12));
    assertEquals(3, moves.size());
    assertTrue(moves.contains(new Location(11, 12)));
    assertTrue(moves.contains(new Location(11, 10)));
    assertTrue(moves.contains(new Location(12, 11)));
  }
}
