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
    ArrayList<Location> valid_moves = get_valid_moves();
    if (valid_moves == null || valid_moves.size() == 0) 
      return false;
    else {
      Location new_loc = valid_moves.get(0);
      myMap.move(myName, new_loc, Map.Type.PACMAN);
      return true;
    }
  }

  public boolean is_ghost_in_range() {
    // Check all 8 adjacent tiles for a ghost 
    for (int x = myLoc.x - 1; x <= myLoc.x + 1; x++) {
      for (int y = myLoc.y - 1; y <= myLoc.y + 1; y++) {
        if (myMap.getLoc(new Location(x, y)).contains(Map.Type.GHOST)) {
          return true;
        }
      }
    }
    return false;
  }

  public JComponent consume() {
    if (myMap.getLoc(this.myLoc).contains(Map.Type.COOKIE)) {
      JComponent ret = myMap.eatCookie(myName);
      return ret;
    }
    return null;
  }
}
