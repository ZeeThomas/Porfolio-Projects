package SnakeGame;
import javafx.application.*;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.geometry.*;
import java.util.ArrayList;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;

public class SnakeApp  extends Application
{
    Pane pane = new Pane();
    public Snake s1 = new Snake(250,250);
    @Override
    public void start(Stage primaryStage)
    {
       Button apple = new Button("Apple");
       pane.getChildren().add(apple);
       for(int p = 0; p <= s1.getLength(); p++)
       {
        pane.getChildren().add(s1.getBody(p));
       }
       apple.setOnAction(e->s1.gotApple());
     
       Scene scene = new Scene(pane, 500, 500);
       primaryStage.setTitle("Snake Game");
       primaryStage.setScene(scene);
       primaryStage.show();
       apple.setOnKeyPressed(e -> { 
        //System.out.println(e.getCode() + ":" + e.getText());       
        switch (e.getCode()) 
        {
            case DOWN: s1.moveDown();break;
            case UP:  s1.moveUp(); break;
            case LEFT: s1.moveLeft(); break;
            case RIGHT: s1.moveRight(); break;
         //default: 
           //if (e.getText().length() > 0)
             //text.setText(e.getText());
        }    
    });
    apple.requestFocus();

      
    }
    public static void main(String[] args)
    {
        launch(args);
    }
    class Snake extends Pane
{
    int length; 
    Circle head;
    String direction;
    double pastX = 0; 
    double pastY = 0;
    int space = 10; //the spacing between balls
    ArrayList<Circle> body = new ArrayList<Circle>(); 
    Snake(int x, int y)
    {
        length = 0;
        head = new Circle(x, y, 10);
        head.setStroke(Color.RED);
        body.add(head);

    }
    Circle getHead()
    {
        return head;
    }
    //void check()
    void moveUp()
    {
        if (direction == "DOWN")
        {
            //can't go down
        }
        else 
        {
            direction = "UP";
            //while ()
            for(int i = 0; i <= length; i++)
            {
                Circle b = body.get(i);
                if (i == 0)
                {
                    
                    double newX = b.getCenterX();// + space;
                    double newY = b.getCenterY()-(10+space);
                    if (newY < 0)
                    {
                        newY = pane.getHeight();
                    }
                    pastX = b.getCenterX();
                    pastY = b.getCenterY();
                    b.setCenterX(newX);
                    b.setCenterY(newY);
                }
                else
                {
                     
                    double tempX = b.getCenterX();
                    double tempY = b.getCenterY();
                    b.setCenterX(pastX);
                    b.setCenterY(pastY);
                    pastX = tempX;
                    pastY = tempY;
                }
            }
        }
        
    }
    void moveDown()
    {
        if (direction == "UP")
        {
            //can't go down
        }
        else 
        {
            direction = "DOWN";
        
            for(int i = 0; i <= length; i++)
            {
                Circle b = body.get(i);
                if (i == 0)
                {
                    
                    double newX = b.getCenterX();// + space;
                    double newY = b.getCenterY()+(10+space);
                    if (newY > pane.getHeight())
                    {
                        newY = 0;
                    }
                    pastX = b.getCenterX();
                    pastY = b.getCenterY();
                    b.setCenterX(newX);
                    b.setCenterY(newY);
                }
                else
                {
                     
                    double tempX = b.getCenterX();
                    double tempY = b.getCenterY();
                    b.setCenterX(pastX);
                    b.setCenterY(pastY);
                    pastX = tempX;
                    pastY = tempY;
                }
            }
        }
    }
    void moveLeft()
    {
      
        if (direction == "RIGHT")
        {
            //can't go down
        }
        else 
        {
            direction = "LEFT";
        
            for(int i = 0; i <= length; i++)
            {
                Circle b = body.get(i);
                if (i == 0)
                {
                    
                    double newX = b.getCenterX() - (10+space);// + space;
                    if (newX < 0)
                    {
                        newX = pane.getWidth();
                    }
                    double newY = b.getCenterY();
                    pastX = b.getCenterX();
                    pastY = b.getCenterY();
                    b.setCenterX(newX);
                    b.setCenterY(newY);
                }
                else
                {
                     
                    double tempX = b.getCenterX();
                    double tempY = b.getCenterY();
                    b.setCenterX(pastX);
                    b.setCenterY(pastY);
                    pastX = tempX;
                    pastY = tempY;
                }
                
            }
        }
    }
    void moveRight()
    {
      
        if (direction == "LEFT")
        {
            //can't go down
        }
        else 
        {
            direction = "RIGHT";
        
            for(int i = 0; i <= length; i++)
            {
                Circle b = body.get(i);
                if (i == 0)
                {
                    
                    double newX = b.getCenterX() + (10+space);// + space;
                    if (newX > pane.getWidth())
                    {
                        newX = 0+ (10+ space);
                    }
                    double newY = b.getCenterY();
                    pastX = b.getCenterX();
                    pastY = b.getCenterY();
                    b.setCenterX(newX);
                    b.setCenterY(newY);
                }
                else
                {
                     
                    double tempX = b.getCenterX();
                    double tempY = b.getCenterY();
                    b.setCenterX(pastX);
                    b.setCenterY(pastY);
                    pastX = tempX;
                    pastY = tempY;
                }
                
            }
        }
    }
    int getLength()
    {
        return length;
    }
    void gotApple()
    {
        System.out.println("Got apple");
        length++;
        Circle inFront = body.get(length-1);
        double X = inFront.getCenterX();
        double Y = inFront.getCenterY() + 10+space;
        Circle c1 = new Circle(X,Y, 10);
        c1.setStroke(Color.RED);
        body.add(c1);
        pane.getChildren().add(getBody(length));
    }
    Circle getBody(int i)
    {
        Circle h = body.get(i);
        return h;
    }
}
}
