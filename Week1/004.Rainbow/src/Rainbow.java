import java.awt.*;
import java.awt.geom.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

public class Rainbow extends Application {
    private Canvas canvas;
    @Override
    public void start(Stage primaryStage) throws Exception {
        canvas = new Canvas(1920, 1080);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("Rainbow");
        primaryStage.show();
    }
    
    
    public void draw(FXGraphics2D graphics) {
        graphics.translate(this.canvas.getWidth()/2, this.canvas.getHeight()/2);
        float radiusBinnen=500;
        float radiusBuiten=250;
        double resolution = 0.001;
        double scale = 50.0;

        for(double i = 0; i < 360; i+=0.1) {
            double rad = Math.toRadians( i /2);
            float x1 = (float) -(radiusBinnen * Math.cos(rad));
            float y1 = (float) -(radiusBinnen * Math.sin(rad));
            float x2 = (float) -(radiusBuiten * Math.cos(rad));
            float y2 = (float) -(radiusBuiten * Math.sin(rad));
            graphics.setColor(Color.getHSBColor((float) (i/360.0f), 1, 1));
            graphics.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }
    
    
    
    public static void main(String[] args) {
        launch(Rainbow.class);
    }

}
