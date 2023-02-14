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

    // check each direction for wall, every other move is valid

    Location north = myLoc.shift(1, 0);
    // ensure this location is not a wall
    if (!myMap.getLoc(north).contains(Map.Type.WALL))
      moves.add(north);  // add north if safe
    
    Location east = myLoc.shift(0, 1);
    // ensure this location is not a wall
    if (!myMap.getLoc(east).contains(Map.Type.WALL))
      moves.add(east);  // add east if safe
    
    Location south = myLoc.shift(-1, 0);
    // ensure this location is not a wall
    if (!myMap.getLoc(south).contains(Map.Type.WALL))
      moves.add(south);  // add south if safe
    
    Location west = myLoc.shift(0, -1);
    // ensure this location is not a wall
    if (!myMap.getLoc(west).contains(Map.Type.WALL))
      moves.add(west);  // add west if safe
    
    return moves;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
