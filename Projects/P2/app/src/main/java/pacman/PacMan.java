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
    ArrayList<Location> moves = new ArrayList<>(4);

    // check each direction : invalid if it is a wall

    // add north if safe
    Location north = myLoc.shift(1, 0);
    if (!myMap.getLoc(north).contains(Map.Type.WALL))
      moves.add(north);

    // add east if safe
    Location east = myLoc.shift(0, 1);
    if (!myMap.getLoc(east).contains(Map.Type.WALL))
      moves.add(east);
    
    // add south if safe
    Location south = myLoc.shift(-1, 0);
    if (!myMap.getLoc(south).contains(Map.Type.WALL))
      moves.add(south);

    // add west if safe
    Location west = myLoc.shift(0, -1);
    if (!myMap.getLoc(west).contains(Map.Type.WALL))
      moves.add(west);

    return moves;
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
