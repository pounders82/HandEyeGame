import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;
import java.util.Random;
import java.util.Timer;



//Created by Pounders82
// Brief Description: This program displays a circle of radius 10 pixels filled with a random color at a random
// location on a pane. When you click the circle, it disappears and a new random- color
// circle is displayed at another random location. After 5 circles are clicked, the time spent is displayed in the pane

public class EyeHand extends Application {
    final long startTime = System.currentTimeMillis();
    private CirclePane a = new CirclePane();

    @Override
    public void start(Stage primaryStage) {

        Random random = new Random();
        final int[] count = {1};
        Text b = new Text();

        //sets the location of where the text is located on the pane
        b.setX(200);
        b.setY(200);

        //Creates a pane and adds a CirclePane with location.
        Pane pane = new Pane();
        pane.getChildren().add(a);
        a.setLayoutX(200);
        a.setLayoutY(200);

        //Creates an event for when the circle is clicked on
        a.setOnMouseClicked(e -> {
           if (count[0] < 5) {
               //randomly selects a new location for the circle on the pane
               a.setLayoutX(random.nextInt(400));
               a.setLayoutY(random.nextInt(400));
               //randomly changes the color of the circle.
               a.changeColor();
               count[0]++;
           }
            else {
               //once the circle is clicked 5 times it removes it and displays the total time spent.
               pane.getChildren().remove(a);
               final long endTime = System.currentTimeMillis();
               double time = (endTime-startTime)/1000.0;
               System.out.println(time);
               b.setText(time + " seconds");
               pane.getChildren().add(b);

        }
        });



        //Creates scene and displays the application.
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Eye-Hand Coordination"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }
}
