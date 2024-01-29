import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class House extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(500, 500);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.setTitle("House");
        primaryStage.show();
    }


    public void draw(FXGraphics2D graphics) {
        graphics.draw(new Line2D.Double(100,200,250,10));
        graphics.draw(new Line2D.Double(250,10,400,200));
        graphics.draw(new Line2D.Double(100,200,100,400));
        graphics.draw(new Line2D.Double(400,200,400,400));
        graphics.draw(new Line2D.Double(100,400,400,400));
        graphics.draw(new Rectangle2D.Double(125,300,50,100));
        graphics.draw(new Rectangle2D.Double(225,250,150,100));
    }



    public static void main(String[] args) {
        launch(House.class);
    }

}
