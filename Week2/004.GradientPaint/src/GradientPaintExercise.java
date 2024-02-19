import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GradientPaintExercise extends Application {
    private ResizableCanvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g, (float) (canvas.getWidth()/2), (float) (canvas.getHeight()/2)), mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("GradientPaint");
        primaryStage.show();
        canvas.setOnMouseDragged(e ->{
            float x = (float) e.getX();
            float y = (float) e.getY();
            draw(new FXGraphics2D(canvas.getGraphicsContext2D()),x,y);} );
    }


    public void draw(FXGraphics2D graphics,float x, float y)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        //graphics.translate(this.canvas.getWidth()/2, this.canvas.getHeight()/2);
        Rectangle2D rectangle2D = new Rectangle2D.Double(0,0,canvas.getWidth(),canvas.getHeight());
        float radius =100;
        float[]fractions = {0.25F,0.5F,0.75F,1F};
        Color[] colors ={Color.lightGray,Color.red,Color.blue,Color.black};
        RadialGradientPaint paint = new RadialGradientPaint(x,y,radius,fractions,colors,MultipleGradientPaint.CycleMethod.REPEAT);
        graphics.setPaint(paint);
        graphics.fill(rectangle2D);
        graphics.draw(rectangle2D);
    }


    public static void main(String[] args)
    {
        launch(GradientPaintExercise.class);
    }

}
