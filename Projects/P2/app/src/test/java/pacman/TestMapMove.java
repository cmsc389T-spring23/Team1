package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
    // test with pacman
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();

    PacMan pacman = frame.addPacMan(new Location(12, 12));

    map.move(pacman.myName, new Location(12, 13), Map.Type.PACMAN);

    assertEquals(new Location(12, 13), pacman.myLoc);
    assertFalse(map.getLoc(new Location(12, 12)).contains(Map.Type.PACMAN));
    assertTrue(map.getLoc(new Location(12, 13)).contains(Map.Type.PACMAN));
    
    // test with ghost
    frame = new NoFrame();
    map = frame.getMap();
    Ghost ghost = frame.addGhost(new Location(12, 12), "Ser lemon", Color.BLUE);

    map.move(ghost.myName, new Location(12, 13), Map.Type.GHOST);

    assertEquals(new Location(12, 13), ghost.myLoc);
    assertFalse(map.getLoc(new Location(12, 12)).contains(Map.Type.GHOST));
    assertTrue(map.getLoc(new Location(12, 13)).contains(Map.Type.GHOST));
  }
}
