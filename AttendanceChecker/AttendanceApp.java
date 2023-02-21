
public class AttendanceApp
{
   private String atd;
    AttendanceApp(String attendance)
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
    boolean checkAttendance()
    {
        if (isAbsent() == false && isLate() == false)
        {
            return true;
        }
        else 
        {
            return false;
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
    public static void main(String[] args)
    {
        AttendanceApp atd1 = new AttendanceApp("PPALLP");
        AttendanceApp atd2 = new AttendanceApp("PPALLL");
       if (atd1.checkAttendance() == true)
        {
            System.out.println("Passed");
        }
        else 
        {
            System.out.println("Failed");
        }
        
        //System.out.println("Late " + atd2.isLate());
        if (atd2.checkAttendance() == true)
        {
            System.out.println("Passed");
        }
        else 
        {
            System.out.println("Failed");
        }
    }
}


