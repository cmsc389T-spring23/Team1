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
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
