import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Spiral extends Application {
    private Canvas canvas;
    @Override
    public void start(Stage primaryStage) throws Exception {
        canvas = new Canvas(1920, 1080);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Spiral");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {
        graphics.translate(this.canvas.getWidth()/2, this.canvas.getHeight()/2);
        double x=0;
        double y=0;
        int n=1;
        double resolution = 0.01;
        double scale = 50.0;
        double lastY = 0;
        double lastX = 0;
        for (double Ø=0;Ø<500;Ø+=resolution){
            x=n*Ø*Math.cos(Ø);
            y=n*Ø*Math.sin(Ø);
            graphics.draw(new Line2D.Double(x*scale, y*scale, lastX*scale, lastY*scale));
            lastY = y;
            lastX = x;
        }
    }
    
    
    
    public static void main(String[] args) {
        launch(Spiral.class);
    }

}
