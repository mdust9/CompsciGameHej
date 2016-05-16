public class Obstacle
{
    private Location myLoc;
    
    public Obstacle(Location loc)
    {
        myLoc = loc;
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public void setLocation(Location l)
    {
        myLoc = l;
    }
}