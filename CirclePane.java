import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * Created by Pounders82 o
 */
public class CirclePane extends Pane {
    private Circle circle = new Circle(10);

    public void setColor(Circle circle) {
        this.circle.setFill(Color.hsb(a.nextInt(360),Math.random(),Math.random()));
    }

    Random a = new Random();

    public CirclePane() {
        getChildren().add(circle);
        circle.setFill(Color.hsb(a.nextInt(360),Math.random(),Math.random()));
    }
    
    public void changeColor() {
        circle.setFill(Color.hsb(a.nextInt(360), Math.random(), Math.random()));
    }

}
