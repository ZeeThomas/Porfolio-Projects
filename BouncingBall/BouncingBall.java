package BouncingBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.animation.TranslateTransition;
import javafx.animation.Timeline;
import javafx.animation.*;
import java.lang.Object;
import java.util.ArrayList;
public class BouncingBall extends Application 
{
    Circle ball1 = new Circle(200,120,50);
    int moveAmountX = 1;
    int moveAmountY = 1;
    //public int numOfBalls = 4;
    Pane pane = new Pane();
    @Override
   public void start(Stage primaryStage)
   {
        //Circle ball1 =  new Circle(200, 120, 50);
        EventHandler<ActionEvent> eventHandler = e -> {
            if (ball1.getCenterX()>= 50 && ball1.getCenterX()<=pane.getWidth()-50 && ball1.getCenterY() >= 50 && ball1.getCenterY() <=pane.getHeight()-50) 
            {
                move();
            } 
            else if (ball1.getCenterX() > pane.getWidth()-50)
            {
                //System.out.println("Left the field");
                moveAmountX *=-1;
                //System.out.println(moveAmount);
                move();
            }
            else if (ball1.getCenterY() > pane.getHeight()-50)
            {
                moveAmountY *=-1;
                move();
            }
            else if (ball1.getCenterY() < 50)
            {
                moveAmountY *=-1;
                move();
            }
            else if (ball1.getCenterX() < 50)
            {
                moveAmountX *=-1;
                move();
            }
        };
        pane.getChildren().add(ball1);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Scene scene = new Scene(pane, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
   }
   public void move()
   {     
        double X = ball1.getCenterX();
        double Y = ball1.getCenterY();
        ball1.setCenterX(X+moveAmountX);
        ball1.setCenterY(Y+moveAmountY);
   }
   public static void main(String[] args)
   {
        launch(args);
   }
 
}
