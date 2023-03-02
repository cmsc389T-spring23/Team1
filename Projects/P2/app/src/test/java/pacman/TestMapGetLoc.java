package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    Map map = new Map(5);
    map.add("Pacman1", new Location(1,1), null, Map.Type.PACMAN);
    map.add("Cookie1", new Location(2,2), null, Map.Type.COOKIE);

    assertTrue(map.getLoc(new Location(1,1)).contains(Map.Type.PACMAN));
    assertTrue(map.getLoc(new Location(2,2)).contains(Map.Type.COOKIE));
    assertTrue(map.getLoc(new Location(3,3)).contains(Map.Type.EMPTY));
    assertTrue(map.getLoc(new Location(6,6)).contains(Map.Type.WALL));
    
    return;
  }
}
