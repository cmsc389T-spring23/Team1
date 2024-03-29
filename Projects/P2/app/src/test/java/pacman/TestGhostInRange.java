package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
    // PacMan in range
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(1,1), "Jared", Color.BLUE);
    PacMan pacman = frame.addPacMan(new Location(2,1));
    assertTrue(ghost.is_pacman_in_range());

    // PacMan not in range
    frame = new NoFrame(); // Clear map
    ghost = frame.addGhost(new Location(4,1), "Jared", Color.BLUE);
    pacman = frame.addPacMan(new Location(2,1));
    assertFalse(ghost.is_pacman_in_range());
  }
}
