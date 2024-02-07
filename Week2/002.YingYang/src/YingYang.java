import java.awt.*;
import java.awt.geom.*;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

public class YingYang extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Ying Yang");
        primaryStage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        GeneralPath path = new GeneralPath();
        path.moveTo(100,200);
        path.curveTo(30,200,30,100,100,100);
        path.moveTo(100,100);
        path.curveTo(140,100,140,150,100,150);
        path.curveTo(60,150,60,200,100,200);
        path.moveTo(105,170);
        path.curveTo(110,170,110,180,105,180);
        path.curveTo(100,180,100,170,105,170);
        path.closePath();
        GeneralPath myShape = new GeneralPath();
        myShape.moveTo(100,100);
        myShape.curveTo(170,100,170,200,100,200);
        myShape.moveTo(100,100);
        myShape.curveTo(140,100,140,150,100,150);
        myShape.curveTo(60,150,60,200,100,200);
        myShape.closePath();
        Area a = new Area(path);
        Area b = new Area(myShape);
        Area c = new Area(new Ellipse2D.Double(100,120,10,10));
        Area d = new Area(new Ellipse2D.Double(52,100,100,100));
        Area sub = new Area(b);
        sub.subtract(a);
        graphics.setColor(Color.black);
        graphics.draw(sub);
        graphics.fill(sub);
        graphics.fill(c);
        graphics.draw(d);
    }


    public static void main(String[] args)
    {
        launch(YingYang.class);
    }

}
