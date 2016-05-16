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
        myPoly = new Polygon();
        myPoly.addPoint(xCo, yCo);
        myPoly.addPoint(xCo + 2, yCo);
        myPoly.addPoint(xCo, yCo + 2);
        myPoly.addPoint(xCo + 2, yCo + 2);
    }
    
    public void changeX(int x)
    {
        xCo += x;
        myPoly = new Polygon();
        myPoly.addPoint(xCo, yCo);
        myPoly.addPoint(xCo + 2, yCo);
        myPoly.addPoint(xCo, yCo + 2);
        myPoly.addPoint(xCo + 2, yCo + 2);
    }
    
    public void changeY(int y)
    {
        yCo += y;
        myPoly = new Polygon();
        myPoly.addPoint(xCo, yCo);
        myPoly.addPoint(xCo + 2, yCo);
        myPoly.addPoint(xCo, yCo + 2);
        myPoly.addPoint(xCo + 2, yCo + 2);
    }
    
    public void setX(int x)
    {
        xCo = x;
        myPoly = new Polygon();
        myPoly.addPoint(xCo, yCo);
        myPoly.addPoint(xCo + 2, yCo);
        myPoly.addPoint(xCo, yCo + 2);
        myPoly.addPoint(xCo + 2, yCo + 2);
    }
    
    public void setY(int y)
    {
        yCo = y;
        myPoly = new Polygon();
        myPoly.addPoint(xCo, yCo);
        myPoly.addPoint(xCo + 2, yCo);
        myPoly.addPoint(xCo, yCo + 2);
        myPoly.addPoint(xCo + 2, yCo + 2);
    }
    
    public int getX()
    {
        return xCo;
    }
    
    public int getY()
    {
        return yCo;
    }
}