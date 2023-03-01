package pacman;
import java.io.*;

import org.junit.Assert;

import junit.framework.*;
import java.awt.Color;

public class TestGhostAttack extends TestCase {

  public void testGhostAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(14, 16));
    Ghost redGhost = frame.addGhost(new Location(13, 16), "attack", Color.red);
    Ghost blueGhost = frame.addGhost(new Location(11, 16), "attack", Color.blue);

    Assert.assertFalse(blueGhost.attack());
    Assert.assertTrue(redGhost.attack());

    return;
  }
}
