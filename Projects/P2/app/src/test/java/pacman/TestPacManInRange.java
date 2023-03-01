package pacman;
import java.io.*;
import junit.framework.*;
//import pacman.frames.NoFrame; // This line has been giving gradle build issues
import java.awt.Color;

public class TestPacManInRange extends TestCase {

  public void testPacManInRange() throws FileNotFoundException {
    // Ghost in range
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(1,1), "Jared", Color.BLUE);
    PacMan pacman = frame.addPacMan(new Location(2,1));
    assertTrue(pacman.is_ghost_in_range());

    // Ghost not in range
    frame = new NoFrame(); // Clear map
    ghost = frame.addGhost(new Location(4,1), "Jared", Color.BLUE);
    pacman = frame.addPacMan(new Location(2,1));
    assertFalse(pacman.is_ghost_in_range());
  }
}
