import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;


public class SnakeApp  extends Application
{
   
    @Override
    public void start(Stage primaryStage)
    {
       SnakePane s1 = new SnakePane(250,250);
       s1.setOnKeyPressed(e->{
        if(e.getCode() == KeyCode.UP)
        {
            s1.moveUp();
        }
        else if (e.getCode() == KeyCode.DOWN)
        {
            s1.moveDown();
        }
        else if (e.getCode() == KeyCode.LEFT)
        {
            s1.moveLeft();
        }
        else if (e.getCode() == KeyCode.RIGHT)
        {
            s1.moveRight();
        }
       });
       Scene scene = new Scene(s1, 500, 500);
       primaryStage.setTitle("Snake Game");
       primaryStage.setScene(scene);
       primaryStage.show();
       s1.requestFocus();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

    public void makeApple()
    {

    }
}
