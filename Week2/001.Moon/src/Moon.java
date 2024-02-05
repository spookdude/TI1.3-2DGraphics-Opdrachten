import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Moon extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Moon");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        GeneralPath myShape = new GeneralPath();
        myShape.moveTo(100f,100f);
        myShape.curveTo(170,100,170,200,100,200);
        myShape.lineTo(100,100);
        myShape.closePath();
//        graphics.draw(myShape);
        GeneralPath path = new GeneralPath();
        path.moveTo(75f,75f);
        path.curveTo(170-25,100-25,170-25,200-25,100,200);
        myShape.lineTo(75,75);
        path.closePath();
//        graphics.draw(path);
        Area a = new Area(myShape);
        Area b = new Area(path);
        graphics.setColor(Color.black);
        Area sub = new Area(a);
        sub.subtract(b);
        graphics.draw(sub);
        graphics.fill(sub);
    }


    public static void main(String[] args)
    {
        launch(Moon.class);
    }

}
