
public class Platform extends Element
{
    private Location myLoc;
    private int orientation;
    
    public Platform(Location loc, int o)
    {
        super(loc);
        myLoc = loc;
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