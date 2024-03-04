import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Block {
    private Point2D location;
    private Color color;
    private int size;
    private int id;

    public Block(int id,Point2D location,Color color,int size) {
        this.id = id;
        this.location = location;
        this.color =color;
        this.size = size;
    }

    public Point2D getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }

    public Shape getShape(){
        return new Rectangle2D.Double(location.getX(),location.getY(),size,size);
    }
    public boolean contains(double x,double y){
        return getShape().contains(x,y);
    }

    public int getId() {
        return id;
    }
}
