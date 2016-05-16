public class Ladder extends Element
{
    private Location myLoc;
    private int myHeight;
    
    public Ladder(Location l, int h)
    {
        super(l);
        myLoc = l;
        myHeight = h;
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public int getHeight()
    {
        return myHeight;
    }
    
    public void setLocation(Location loc)
    {
        myLoc = loc;
    }
    
    public void setHeight(int height)
    {
        myHeight = height;
    }
}