package pacman;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // retreive current location and component
    Location currLoc = locations.get(name);
    
    // update field
    // remove the component from its prev location
    field.get(currLoc).remove(type);
    
    // update component
    components.get(name).setLocation(loc.x, loc.y);

    // update location (replaces old value)
    locations.put(name, loc);

    return false;
  }

  public HashSet<Type> getLoc(Location loc) {
    if (loc.x < 0 || loc.x >= dim 
     || loc.y < 0 || loc.y >= dim) 
      return wallSet;
    if (field.containsKey(loc)) {
        return field.get(loc);
    } 
    return emptySet;
  }

  public boolean attack(String Name) {
    // The only reason this will ever be called is if the ghost can attack, so always return true.
    gameOver = false;
    return true;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    Location loc = locations.get(name);

    if (field.get(loc).contains(Map.Type.COOKIE)) {
      String id = "tok_x" + loc.x + "_y" + loc.y;
      locations.remove(id);
      JComponent ret = components.remove(id);
      field.get(loc).remove(Map.Type.COOKIE);
      this.cookies += 5;

      return ret;
    }

    return null;
  }
}
