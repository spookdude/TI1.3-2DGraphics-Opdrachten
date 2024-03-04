import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class BlockDrag extends Application {
    ResizableCanvas canvas;
    public Point2D position = new Point2D.Double(100,100);
    private ArrayList<Block> blocks= new ArrayList<>();
    private Block selectedBlock;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(this::draw, mainPane);
        mainPane.setCenter(canvas);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Block Dragging");
        primaryStage.show();

        canvas.setOnMousePressed(this::mousePressed);
        canvas.setOnMouseReleased(this::mouseReleased);
        canvas.setOnMouseDragged(this::mouseDragged);

        makeBlocks();

        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
    }


    public void draw(FXGraphics2D graphics)
    {
        graphics.setTransform(new AffineTransform());
        graphics.setBackground(Color.white);
        graphics.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        for (Block block : blocks) {
            graphics.setColor(Color.black);
            graphics.draw(new Rectangle2D.Double(block.getLocation().getX(),block.getLocation().getY(),block.getSize()+1,block.getSize()+1));
            graphics.setColor(block.getColor());
            graphics.fill(new Rectangle2D.Double(block.getLocation().getX(),block.getLocation().getY(),block.getSize(),block.getSize()));
        }
    }


    public static void main(String[] args)
    {
        launch(BlockDrag.class);
    }

    private void mousePressed(MouseEvent e)
    {
        for (Block block: blocks) {
            if (block.contains(e.getX(),e.getY())){
                selectedBlock = block;
            }
        }
    }

    private void mouseReleased(MouseEvent e)
    {
        selectedBlock = null;
    }

    private void mouseDragged(MouseEvent e)
    {
        position = new Point2D.Double(e.getX(), e.getY());
        if (selectedBlock != null){
        int temp = selectedBlock.getId();
        blocks.get(temp).setLocation(position);
        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));}
    }

    private void makeBlocks(){
        for (int i=0;i<5;i++){
            int size= (int)(Math.random()*100);
            if (size<10){size=10;}
            double X = (Math.random()*5 * (canvas.getWidth()/2));
            double Y = (Math.random()*5 * (canvas.getHeight()/2));
            System.out.println(X + ", " + Y);
            int x = (int) (X);
            int y = (int) (Y);
            System.out.println(x + "," + y);
//            int x =100;
//            int y = 100;
            Point2D location = new Point2D.Double(x,y);
            Color color = Color.getHSBColor((float) ((Math.random()*1000)/360.0f),1,1);

            blocks.add(i,new Block(i,location,color,size));
        }
    }

}
