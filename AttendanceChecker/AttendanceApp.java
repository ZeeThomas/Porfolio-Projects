import javafx.application.Application;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.Scene;
public class AttendanceApp extends Application
{
    
    private TextField AttendanceRecord = new TextField();
    private TextField AttendanceReport = new TextField();
    private Button btgetAttendance = new Button("Get Attendance Report");
    @Override
    public void start(Stage primaryStage)
    {
        GridPane form = new GridPane();
        form.setHgap(5);

        Label lblRecord = new Label("Attendance Record: ");
        Label lblReport = new Label("Attendance Report");
        form.add(lblReport, 0, 0);
        form.add(AttendanceReport, 1,0);
        form.add(lblRecord, 0,1);
        form.add(AttendanceRecord, 1, 1);
        
        form.add(btgetAttendance,1,2);
        AttendanceReport.setAlignment(Pos.BOTTOM_RIGHT);
        AttendanceRecord.setAlignment(Pos.BOTTOM_RIGHT);
        AttendanceRecord.setEditable(false);
        GridPane.setHalignment(btgetAttendance,HPos.RIGHT);
        btgetAttendance.setOnAction(e->createReport());
        Scene scene = new Scene(form, 400,150);
        primaryStage.setTitle("Attendance App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void createReport()
    {
        String attendance = (AttendanceReport.getText());
        Attendance atdobj = new Attendance(attendance);
        AttendanceRecord.setText(atdobj.checkAttendance());
    }
    public static void main(String[] args)
    {
      launch(args);
    }
}

class Attendance
{
   private String atd;
    Attendance(String attendance)
    {
        atd = attendance;
    }
    String getAttendance()
    {
        return atd;
    }
    boolean isAbsent()
    {
        if (find('A') >= 2)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    boolean isLate()
    {
        int val;
        if(find('L') >=3)
        {
           val = atd.indexOf('L');
           if(atd.charAt(val+1) == 'L' && atd.charAt(val+2) == 'L')
           {
                return true;
           }
        
        }
       return false;
    }
    String checkAttendance()
    {
        if (isAbsent() == false && isLate() == false)
        {
            return "Passed";
        }
        else 
        {
            return "Failed";
        }
    }
    int find(char l)
    {
        int num = 0;
        for(int i = 0; i < atd.length(); i++)
        {
            if (atd.charAt(i) == l)
            {
                num++;
            }
        }
        //System.out.println(l + ":"+ num);
        return num;
    }
    
}


