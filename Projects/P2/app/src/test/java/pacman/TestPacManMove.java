package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    Map map = new Map(10);
    map.add("pacman1", new Location(5,5), null, Map.Type.PACMAN);
    map.add("pacman2", new Location(1,1), null, Map.Type.PACMAN);
    map.add("Wall1", new Location(1,2), null, Map.Type.WALL);
    map.add("Wall2", new Location(2,1), null, Map.Type.WALL);
    map.add("Wall3", new Location(2,2), null, Map.Type.WALL);
    PacMan pacman1 = new PacMan("pacman1", new Location(5,5), map);
    PacMan pacman2 = new PacMan("pacman2", new Location(1,1), map);
    assertTrue(pacman1.move());
    assertFalse(pacman2.move());
    
    return;
  }
}
