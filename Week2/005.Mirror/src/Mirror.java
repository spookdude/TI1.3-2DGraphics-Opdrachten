import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Mirror extends Application {
    ResizableCanvas canvas;
    Point2D position;
    float rotation;
    float scale;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Mirror");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        AffineTransform fx = new AffineTransform();
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        graphics.translate(this.canvas.getWidth()/2, this.canvas.getHeight()/2);
        graphics.draw(new Line2D.Double(-canvas.getWidth()/2,0,canvas.getWidth()/2,0));
        graphics.draw(new Line2D.Double(0,-canvas.getHeight()/2,0,canvas.getHeight()/2));
        Rectangle2D rectangle2D = new Rectangle2D.Double(0,150,100,100);
        graphics.draw(rectangle2D);
        double resolution=0.1;
        double scale=10;
        double lastY = 2.5 * -500;
        for (double x =-(this.canvas.getWidth());x<this.canvas.getWidth();x+=resolution){
            double y = 2.5 * x;
            graphics.draw(new Line2D.Double(x*scale, y*scale, (x-resolution)*scale,lastY*scale));
            lastY = y;
        }

        graphics.draw(getTransform().createTransformedShape(rectangle2D));
    }
    public AffineTransform getTransform()
    {
        AffineTransform tx = new AffineTransform(((2/(1+Math.pow(2.5,2)))-1),
                (5/(1+Math.pow(2.5,2))),
                (5/(1+Math.pow(2.5,2))),
                ((2*Math.pow(2.5,2))/(1+Math.pow(2.5,2))-1),
                0,0);
        return tx;
    }


    public static void main(String[] args)
    {
        launch(Mirror.class);
    }

}
