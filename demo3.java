import java.util.*;
//平均数最大数最小数
public class demo3 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String[] score = new String[100];
        String[] name = new String[100];
        String[] mark = new String[100];
        String[] grade = new String[100];
        int index = 0;
        while(true)
        {
            String temp = scanner.nextLine();
            if(temp.equals("end"))
            {
                break;
            }
            score[index++] = temp;
        }
        
        int index2 = 0;
        for(int i = 0;i<index;i++)
        {
            String[] temp = new String[5];
            temp=score[i].split(",");
            name[index2]=temp[0];
            mark[index2]=temp[1];
            index2++;
        }
        int total = 0;
        double average = 0.0;
        
        int[] mark_int = new int[index];
        for(int i = 0;i<index;i++)
        {
            mark_int[i] = Integer.parseInt(mark[i]);
        }
        for(int i = 0;i<index;i++)
        {
            total+=mark_int[i];
        }
        average = (double)total/index;
        for(int i = 0;i<index;i++)
        {
            if(mark_int[i]>90&&mark_int[i]<=100)
            {
                grade[i]="A";
            }
            else if(mark_int[i]>80&&mark_int[i]<=89)
            {
                grade[i]="B";
            }
            else if(mark_int[i]>70&&mark_int[i]<=79)
            {
                grade[i]="C";
            }
            else if(mark_int[i]>60&&mark_int[i]<=69)
            {
                grade[i]="D";
            }
            else
            {
                grade[i]="E";
            }
        }
        for(int i = 0;i<index;i++)
        {
            System.out.println(name[i]+","+mark[i]+","+grade[i]);
        }
        System.out.println("Average score:"+average);
        System.out.println("Highest score:"+Highestscore(mark_int,index));
        System.out.println("Lowest score:"+Lowestscore(mark_int,index));
        int n = 0;
        for(int i = 0 ;i<grade.length;i++)
        {
            if(grade[i].equals("E"))
            {
                n++;
            }
        }
        System.out.println("Unquanlified number:"+n);
        scanner.close();
    }
    public static int Highestscore(int[] x,int n)
    {
        int highest =x[0];
        for(int i = 0;i<n;i++)
        {
            if(x[i]>highest)
            {
                highest=x[i];
            }
        }
        return highest;
    }
    public static int Lowestscore(int[] x,int n)
    {
        int lowest = x[0];
        for(int i = 0;i<n;i++)
        {
            if(x[i]<lowest)
            {
                lowest=x[i];
            }
        }
        return lowest;
    }
}
