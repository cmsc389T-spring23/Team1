package pacman;
import junit.framework.*;
import java.io.*;
import java.awt.Color;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    // Ghost in range
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(1,1), "Jared", Color.BLUE);
    PacMan pacman = frame.addPacMan(new Location(2,1));
    assertTrue(ghost.attack());
    assertTrue(frame.getMap().isGameOver());

    // Ghost not in range
    frame = new NoFrame(); // Clear map
    ghost = frame.addGhost(new Location(4,1), "Jared", Color.BLUE);
    pacman = frame.addPacMan(new Location(2,1));
    assertFalse(ghost.attack());
    assertFalse(frame.getMap().isGameOver());
  }
}
