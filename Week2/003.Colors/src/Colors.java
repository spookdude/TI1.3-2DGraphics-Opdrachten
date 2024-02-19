import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Colors extends Application {
    private ResizableCanvas canvas;
    private ArrayList<Color> colors = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        setColors();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Colors");
        primaryStage.show();
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.black);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        int x = 0;
        int y = 0;
        for (int i=0;i<13;i++){
            graphics.setColor(colors.get(i));

            graphics.fill(new Rectangle2D.Double(x*100,y*100,100,100));
            x +=1;
            if (x >=6){y += 1;x=0;}
        }
    }
    private void setColors(){
        colors.add(Color.black);
        colors.add(Color.blue);
        colors.add(Color.cyan);
        colors.add(Color.darkGray);
        colors.add(Color.gray);
        colors.add(Color.green);
        colors.add(Color.lightGray);
        colors.add(Color.magenta);
        colors.add(Color.orange);
        colors.add(Color.pink);
        colors.add(Color.red);
        colors.add(Color.white);
        colors.add(Color.yellow);
    }


    public static void main(String[] args)
    {
        launch(Colors.class);
    }

}
