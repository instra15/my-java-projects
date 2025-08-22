import java.util.*;
//水仙花数辨认
public class demo {

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            try 
            {
                System.out.println("请输入一个三位整数：");
                int n=scanner.nextInt();
                if(n<100||n>999)
                {
                    throw new IllegalArgumentException("请输入一个三位整数。");
                }
                int[] num=new int[3];
                num[0]=n/100;
                num[1]=(n-num[0]*100)/10;
                num[2]=(n-num[0]*100-num[1]*10);
                if(n==Math.pow(num[0], 3)+Math.pow(num[1], 3)+Math.pow(num[2], 3))
                {
                    System.out.println(n+"是水仙花数！");
                }
                else
                {
                    System.out.println(n+"不是水仙花数。");
                }
                for(int i =100;i<=999;i++)
                {
                    int[] arr=new int[3];
                    arr[0]=i/100;
                    arr[1]=(i-arr[0]*100)/10;
                    arr[2]=i-arr[0]*100-arr[1]*10;
                    if(i==Math.pow(arr[0], 3)+Math.pow(arr[1], 3)+Math.pow(arr[2], 3))
                    {
                        System.out.println(i+"是水仙花数！");
                    }
                }






                scanner.close();
                break;
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println("请输入有效的三位整数！");
            }
            catch (InputMismatchException e)
            {
                
                System.out.println("输入错误：必须输入整数！");
                scanner.nextLine();
            }

        
        

            return;
        }
    }
}