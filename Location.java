import java.awt.*;
public class Location
{
    private int xCo;
    private int yCo;
    private Polygon myPoly;
    
    public Location()
    {
        xCo = 0;
        yCo = 0;
    }
    
    public Location(int x, int y)
    {
        xCo = x;
        yCo = y;
    }
    
    public void changeX(int x)
    {
        xCo += x;
    }
    
    public void changeY(int y)
    {
        yCo += y;
    }
    
    public void setX(int x)
    {
        xCo = x;
    }
    
    public void setY(int y)
    {
        yCo = y;
    }
    
    public int getX()
    {
        return xCo;
    }
    
    public int getY()
    {
        return yCo;
    }
    
    public boolean equals(Location otherLoc)
    {
        if (xCo == otherLoc.getX() && yCo == otherLoc.getY())
            return true;
        else
            return false;
    }
    
    public int compareTo(Location otherLoc)
    {
        if (yCo == otherLoc.getY())
            return xCo = otherLoc.getX();
        else
            return yCo - otherLoc.getY();
    }
}
