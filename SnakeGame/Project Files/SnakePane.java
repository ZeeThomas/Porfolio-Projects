import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.ArrayList;

public class SnakePane extends Pane
{
    int length; 
    Circle head;
    String direction = "UP";
    double pastX = 0; 
    double pastY = 0;
    int space = 10; //the spacing between balls
    ArrayList<Circle> body = new ArrayList<Circle>(); 
    private Timeline animation;
    public SnakePane(int x, int y)
    {
       
        length = 0;
        head = new Circle(x, y, 10);
        head.setStroke(Color.RED);
        body.add(head);
        getChildren().add(head);
        animation = new Timeline(new KeyFrame(Duration.millis(190), e -> moveSnake()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    public void play()
    {
        animation.play();
    }
    public void pause()
    {
        animation.pause();
    }
    Circle getHead()
    {
        return head;
    }
    //void check()
    String getDirection()
    {
        return direction;
    }
    void moveSnake(String dir)
    {
        direction = dir;
        switch (direction) 
        {
            case "DOWN": this.moveDown();break;
            case "UP": this.moveUp(); break;
            case "LEFT":this.moveLeft(); break;
            case "RIGHT": this.moveRight(); break;
                //text.setText(e.getText());
        } 
    }
    void moveSnake()
    {
        switch (direction) 
        {
            case "DOWN": this.moveDown();break;
            case "UP": this.moveUp(); break;
            case "LEFT":this.moveLeft(); break;
            case "RIGHT": this.moveRight(); break;
                //text.s
        }
    }
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
                        newY = 500;
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
                    if (newY > 500)
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
                        newX = 500;
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
                    if (newX >500)
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
        getChildren().add(getBody(length));
    }
    Circle getBody(int i)
    {
        Circle h = body.get(i);
        return h;
    }
}
