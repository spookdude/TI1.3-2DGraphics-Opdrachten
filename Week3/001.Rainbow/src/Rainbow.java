import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

public class Rainbow extends Application {
    private ResizableCanvas canvas;
    private ArrayList<String> rainbow = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        setArray();
        setColors();
        canvas = new ResizableCanvas(this::draw, mainPane);
        mainPane.setCenter(canvas);
        stage.setScene(new Scene(mainPane));
        stage.setTitle("Rainbow");
        stage.show();
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        graphics.translate(this.canvas.getWidth()/2, this.canvas.getHeight()/2);
        Font font = new Font("Arial",Font.PLAIN,50);
        int rotation= (180/ rainbow.size());
        for (int i =0;i< rainbow.size();i++){
            double rad = Math.toRadians(rotation*i-90);
            Shape shape = font.createGlyphVector(graphics.getFontRenderContext(),rainbow.get(i)).getOutline();
            AffineTransform tx = new AffineTransform();
            tx.rotate(rad);
            tx.translate(0,-100);
            graphics.draw(tx.createTransformedShape(shape));
            graphics.setColor(colors.get(i));
            graphics.fill(tx.createTransformedShape(shape));
        }
    }
    public void setArray(){
        rainbow.add("R");
        rainbow.add("E");
        rainbow.add("G");
        rainbow.add("E");
        rainbow.add("N");
        rainbow.add("B");
        rainbow.add("O");
        rainbow.add("O");
        rainbow.add("G");
    }
    public void setColors(){
        colors.add(Color.red);
        colors.add(Color.orange);
        colors.add(Color.yellow);
        colors.add(Color.green);
        colors.add(Color.cyan);
        colors.add(Color.blue);
        colors.add(Color.magenta);
        colors.add(Color.pink);
        colors.add(Color.red);
    }


    public static void main(String[] args)
    {
        launch(Rainbow.class);
    }

}
