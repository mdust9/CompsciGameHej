
public class Platform extends Element
{
    private Location myLoc;
    private int orientation;
    
    public Platform(Location loc, int o, int height, int length)
    {
        super(loc);
        myLoc = new Location(loc.getX(), loc.getY(), height, length);
        orientation = o;
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public int getOrientation()
    {
        return orientation;
    }
}