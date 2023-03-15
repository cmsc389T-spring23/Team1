package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {

    Map map = new Map(10);
    int scale = 20;

    // PacMan free to move anywhere
    Location loc1 = new Location(5,5);
    PacManComponent pc1 = new PacManComponent(loc1.x, loc1.y, scale);
    PacMan pacman1 = new PacMan("pacman1", loc1, map);
    map.add("pacman1", loc1, pc1, Map.Type.PACMAN);

    // PacMan2 surrounded by walls
    Location loc2 = new Location(1,1);
    PacManComponent pc2 = new PacManComponent(loc2.x, loc2.y, scale);
    PacMan pacman2 = new PacMan("pacman2", loc2, map);
    map.add("pacman2", loc2, pc2, Map.Type.PACMAN);

    Location locWall1 = new Location(2,1);
    WallComponent wall1 = new WallComponent(locWall1.x, locWall1.y, scale);
    map.add("wall1", locWall1, wall1, Map.Type.WALL);
    wall1.setLocation(locWall1.y, locWall1.x);

    Location locWall2 = new Location(0,1);
    WallComponent wall2 = new WallComponent(locWall2.x, locWall2.y, scale);
    map.add("wall2", locWall2, wall2, Map.Type.WALL);
    wall2.setLocation(locWall2.y, locWall2.x);

    Location locWall3 = new Location(1,2);
    WallComponent wall3 = new WallComponent(locWall3.x, locWall3.y, scale);
    map.add("wall3", locWall3, wall3, Map.Type.WALL);
    wall3.setLocation(locWall3.y, locWall3.x);

    Location locWall4 = new Location(1,0);
    WallComponent wall4 = new WallComponent(locWall4.x, locWall4.y, scale);
    map.add("wall4", locWall4, wall4, Map.Type.WALL);
    wall4.setLocation(locWall4.y, locWall4.x);

    assertTrue(pacman1.move());
    assertFalse(pacman2.move());
    
    return;
  }
}
