package pacman;
import java.io.*;

import org.junit.Assert;

import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    PacMan pacmanCookie = frame.addPacMan(new Location(2, 1));

    int cookies = map.getCookies();

    Assert.assertNotNull(map.eatCookie("pacman"));
    assertEquals(cookies + 1, map.getCookies());

    return;
  }
}
