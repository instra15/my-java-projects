import java.util.*;
//斐波那契数列
public class demo1 {
    public static void main(String[] args) 
    {
        Scanner scanner=new Scanner(System.in);
        while (true) 
        {
            try 
            {
                System.out.println("请输入正整数n：");
                int n=scanner.nextInt();
                if(n<=0)
                {
                    throw new IllegalArgumentException("请输入有效的值。");
                }
                
                long[] arr=new long[n];
                arr[0]=0;
                if(n>=2)
                {
                    arr[1]=1;
                    for(int i = 2;i<n;i++)
                    {
                        arr[i]=arr[i-1]+arr[i-2];
                    }
                     for(int i = 0;i<n;i++)
                    {
                        if(i!=n-1)
                        {
                            System.out.print(arr[i]+", ");
                        }
                        else
                        {
                            System.out.print(arr[i]+"\n");
                        }
                    }
                }                
                else if(n==1)
                {
                    System.out.println("0");
                }
                
                
                


                
                break;
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("输入错误：必须输入正整数！");
                scanner.nextLine();
            }
            catch (IllegalArgumentException exception)
            {
                System.out.println("请输入有效的值。");
                scanner.nextLine();
            }



        }




        scanner.close();
        return;
    }
}
