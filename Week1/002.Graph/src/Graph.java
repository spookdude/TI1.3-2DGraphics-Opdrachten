import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Graph extends Application {
    private Canvas canvas;
    @Override
    public void start(Stage primaryStage) throws Exception {
        canvas = new Canvas(1920, 1000);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Graph");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {
        graphics.translate(this.canvas.getWidth()/2, this.canvas.getHeight()/2);
        graphics.scale( 1, -1);
        graphics.setColor(Color.red);
        graphics.draw(new Line2D.Double(-(this.canvas.getWidth()),0,this.canvas.getWidth(),0));
        graphics.setColor(Color.green);
        graphics.draw(new Line2D.Double(0,-(this.canvas.getHeight()),0,this.canvas.getHeight()));
        graphics.setColor(Color.black);
        double resolution=0.1;
        double scale=10;
        double lastY=Math.pow(-500,3);

        for (double x =-(this.canvas.getWidth());x<this.canvas.getWidth();x+=resolution){
            float y = (float) Math.pow(x,3);
            graphics.draw(new Line2D.Double(x*scale, y*scale, (x-resolution)*scale, lastY*scale));
            lastY = y;
        }
    }
    
    
    
    public static void main(String[] args) {
        launch(Graph.class);
    }

}
