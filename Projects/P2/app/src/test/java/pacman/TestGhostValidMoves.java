package pacman;
import java.io.*;
import java.util.ArrayList;
import junit.framework.*;
import java.awt.Color;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    // all valid moves
    NoFrame frame = new NoFrame();

    Map map = frame.getMap();

    // ghost center, all empty around
    Ghost ghost = frame.addGhost(new Location(12, 12), "Señor Spook", Color.BLUE);
    
    ArrayList<Location> moves = ghost.get_valid_moves();
    
    assertEquals(4, moves.size());
    assertTrue(moves.contains(new Location(11, 12)));  // above
    assertTrue(moves.contains(new Location(13, 12)));  // below
    assertTrue(moves.contains(new Location(12, 11)));  // left
    assertTrue(moves.contains(new Location(12, 13)));  // right

    // ghost with a wall to the left and pacman
    frame = new NoFrame();
    ghost = frame.addGhost(new Location(12, 11), "Monsieur Mole", Color.GREEN);
    PacMan pacman = frame.addPacMan(new Location(11, 11));  // put above ghost
    
    moves = ghost.get_valid_moves();

    assertEquals(3, moves.size());
    assertTrue(moves.contains(new Location(12, 12)));  // right
    assertTrue(moves.contains(new Location(11, 11)));  // above
    assertTrue(moves.contains(new Location(13, 11)));  // below


    // ghost with cookie to right
    frame = new NoFrame();
    ghost = frame.addGhost(new Location(12, 13), "Blob", Color.BLUE);
    pacman = frame.addPacMan(new Location(11, 13));  // put above cuz why not

    moves = ghost.get_valid_moves();

    assertEquals(4, moves.size());
    assertTrue(moves.contains(new Location(12, 14)));  // right
    assertTrue(moves.contains(new Location(12, 12)));  // left
    assertTrue(moves.contains(new Location(11, 13)));  // above
    assertTrue(moves.contains(new Location(13, 13)));  // below
  }
}
