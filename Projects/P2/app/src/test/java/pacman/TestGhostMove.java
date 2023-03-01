package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    Map map = new Map(10);
    map.add("Ghost1", new Location(5,5), null, Map.Type.GHOST);
    map.add("Ghost2", new Location(1,1), null, Map.Type.GHOST);
    map.add("Wall1", new Location(1,2), null, Map.Type.WALL);
    map.add("Wall2", new Location(2,1), null, Map.Type.WALL);
    map.add("Wall3", new Location(2,2), null, Map.Type.WALL);
    Ghost ghost = new Ghost("Ghost1", new Location(5,5), map);
    Ghost ghost2 = new Ghost("Ghost2", new Location(1,1), map);
    assertTrue(ghost.move());
    assertFalse(ghost.move());
  }
}
