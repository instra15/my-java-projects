import java.util.*;
//银行系统
public class demo4 
{
    public static class Account 
    {
        private String id;
        private String name;
        private int balance;

        public Account(String id,String name,int balance)
        {
            this.id=id;
            this.name=name;
            this.balance=balance;
            System.out.println("Account created.");
        }
         
        
        public void deposit(int n)
        {
            balance+=n;
            System.out.println("Deposit success.");
        }
        public void withdraw(int n)
        {
            if(balance>=n)
            {   
                balance-=n;
                System.out.println("Withdraw success.");
            }
            else
            {
                System.out.println("Account is limited.");
            }
        }
        public void inspect()
        {
            System.out.println("id:"+id);
            System.out.println("name:"+name);
            System.out.println("account:"+balance);
        }
        public void transfer(Account a,int num)
        {
            if(num<balance)
            {
                a.deposit(num);
                balance-=num;
            }
            else
            {
                System.out.println("Account is limited.");
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        while (true) 
        {
            try
            {
                
                System.out.println("\n===== 银行账户管理系统 =====");
                System.out.println("1. 创建账户");
                System.out.println("2. 存款");
                System.out.println("3. 取款");
                System.out.println("4. 转账");
                System.out.println("5. 查询余额");
                System.out.println("6. 退出系统");
                System.out.print("请选择操作：");
                System.out.print("Please create your account:");
                boolean isaccount = false;
                Account accountcondition = new Account(null, null, 0);
                int choice = scanner.nextInt();
                scanner.nextLine();//使用nextInt后要清除换行符
                if(choice!=1)
                {
                    if(isaccount==false)
                    {
                        System.out.print("Please create your account first.");
                        continue;
                    }
                }
                if(choice==1)
                {
                    try
                    {
                        System.out.println("Please input your id,name and money.");
                        String id = scanner.nextLine();
                        String name = scanner.nextLine();
                        int account = scanner.nextInt();
                        Account A = new Account(id, name, account);
                        accountcondition = A;
                        isaccount = true;
                    }
                    catch (InputMismatchException exception)
                    {
                        System.out.println("error.");
                        continue;
                    }
                }
                else if (choice==2) 
                {
                    System.out.println("Please input number:");
                    int num = scanner.nextInt();
                    accountcondition.deposit(num); 
                }
                else if(choice==3)
                {
                    System.out.println("Please input number:");
                    int num = scanner.nextInt();
                    accountcondition.withdraw(num);
                }
                else if(choice==4)
                {
                    System.out.println("Please input target and number:");

                    
                }
                else if(choice==5)
                {
                    accountcondition.inspect();
                }
                else if(choice==6)
                {
                    break;
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("error.");
                scanner.nextLine(); // 清除无效输入
                continue;
            }

        }
        

        scanner.close();
    }




}

