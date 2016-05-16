import java.util.*;
import java.awt.*;
public class Player
{
    private int myLives;
    private Location myLoc;
    private Platform myPlatform;
    
    public Player(int lives, Platform p)
    {
        myLives = 5;
        myLoc = new Location();
        myPlatform = p;
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public Platform getPlatform()
    {
        return myPlatform;
    }
    
    public void setLocation(Location l)
    {
        myLoc = l;
    }
    
    public void setPlatform(Platform p)
    {
        myPlatform = p;
    }
    
    public void jump()
    {
        myLoc.changeY(10);
    }
    
    public void fall()
    {
        myLoc.changeY(-5);
    }
    
    public void moveLeft()
    {
        if (myPlatform.getOrientation() == 1)
        {
            myLoc.changeX(-10);
        }
        else if (myPlatform.getOrientation() == 0)
        {
            myLoc.changeX(-10);
            myLoc.changeY((int)(10 / Math.sqrt(3)));
        }
        else
        {
            myLoc.changeX(-10);
            myLoc.changeY((int)(-10 / Math.sqrt(3)));
        }
    }
    
    public void moveRight()
    {
        if (myPlatform.getOrientation() == 1)
        {
            myLoc.changeX(10);
        }
        else if (myPlatform.getOrientation() == 0)
        {
            myLoc.changeX(10);
            myLoc.changeY((int)(-10 / Math.sqrt(3)));
        }
        else
        {
            myLoc.changeX(10);
            myLoc.changeY((int)(10 / Math.sqrt(3)));
        }
    }
    
    public void climb()
    {
        myLoc.changeY(5);
    }
}