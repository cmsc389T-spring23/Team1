package pacman;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    // Check all 8 adjacent tiles for a ghost
    // Check all 8 adjacent tiles for
    for (int x = myLoc.x - 1; x <= myLoc.x + 1; x++) {
      for (int y = myLoc.y - 1; y <= myLoc.y + 1; y++) {
        if (myMap.getLoc(new Location(x, y)) != null && myMap.getLoc(new Location(x, y)).contains(Map.Type.GHOST)) {
          return true;
        }
      }
    }
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
