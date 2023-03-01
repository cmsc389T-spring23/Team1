package pacman;
import java.io.*;

import org.junit.Assert;

import junit.framework.*;
import java.awt.Color;

public class TestPacManConsume extends TestCase {

  public void testPacManConsume() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacmanCookie = frame.addPacMan(new Location(2, 1));

    Assert.assertNull(pacmanCookie.consume());

    return;
  } 

  public void testPacManNoConsume() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacmanNoCookie = frame.addPacMan(new Location(13, 9));

    Assert.assertNull(pacmanCookie.consume());

    return;
  } 
}
