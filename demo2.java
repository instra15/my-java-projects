import java.util.*;
//矩阵转置
public class demo2 {
    public static void main(String[] args) 
    {
        System.out.println("请输入矩阵的行数和列数：");
        Scanner scanner = new Scanner(System.in);
        try 
        {
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            if(m<=0||n<=0)
            {
                throw new IllegalArgumentException("请输入有效数字。");
            }
            int[][] sourse=new int[m][n];
            int[][] result=new int[n][m];
            System.out.println("原始矩阵：");
            for(int i =0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    try
                    {
                        sourse[i][j]=scanner.nextInt();
                    }
                    catch(InputMismatchException exception)
                    {
                        System.out.println("请输入数字。");
                        scanner.nextLine();
                    }
                }
            }
            System.out.println("转置矩阵：");
            for(int i =0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    result[i][j]=sourse[j][i];
                }
            }
            for(int i =0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(j!=m-1)
                    {
                        System.out.print(result[i][j]+" ");
                    }
                    else
                    {
                        System.out.println(result[i][j]);
                    }
                }
            }
            



        } 
        catch (InputMismatchException e) 
        {
            System.out.println("请输入数字。");
            scanner.close();
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println("请输入有效数字。");
            scanner.close();
        }

        



        scanner.close();
    }
}
