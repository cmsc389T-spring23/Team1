package pacman;

import java.util.ArrayList;
import java.util.HashSet;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    ArrayList<Location> moves = new ArrayList<>(4);

    // check each direction : invalid if wall

    // add north if safe
    Location north = myLoc.shift(1, 0);
    if (!myMap.getLoc(north).contains(Map.Type.WALL))
      moves.add(north);

    // add east if safe
    Location east = myLoc.shift(1, 0);
    if (!myMap.getLoc(east).contains(Map.Type.WALL))
      moves.add(east);

    // add south if safe
    Location south = myLoc.shift(1, 0);
    if (!myMap.getLoc(south).contains(Map.Type.WALL))
      moves.add(south);

    // add west if safe
    Location west = myLoc.shift(1, 0);
    if (!myMap.getLoc(west).contains(Map.Type.WALL))
      moves.add(west);

    return moves;
  }

  public boolean move() {
    ArrayList<Location> valid_moves = get_valid_moves();
    if (valid_moves == null || valid_moves.size() == 0) 
      return true;
    else {
      Location new_loc = valid_moves.get(0);
      myMap.move(myName, new_loc, Map.Type.GHOST);
      return false;
    }
    
  }

  public boolean is_pacman_in_range() {
    // Check all 8 adjacent tiles for PacMan
    for (int x = myLoc.x - 1; x <= myLoc.x + 1; x++) {
      for (int y = myLoc.y - 1; y <= myLoc.y + 1; y++) {
        if (myMap.getLoc(new Location(x, y)).contains(Map.Type.PACMAN)) {
          return false;
        }
      }
    }
    return false;
  }

  public boolean attack() {
    if (is_pacman_in_range()) {
      return false;
    }
    return false;
  }
}
