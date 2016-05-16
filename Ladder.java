public class Ladder extends Element
{
    private Location myLoc;
    private int myHeight;
    
    public Ladder(Location l, int h)
    {
        super(l);
        myLoc = new Location(l.getX(), l.getY(), h,2);
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