import java.util.*;
//图书馆管理功能
public class demo5 
{
    static class Book 
    {
        protected String bookname;
        protected String author;
        protected int year;
        protected boolean isborrowed;
        
        public Book(String bookname,String author,int year,boolean isborrowed)
        {
            this.bookname=bookname;
            this.author=author;
            this.year=year;
            this.isborrowed=isborrowed;
        }
        public String getbookname()
        {
            return bookname;
        }
        public String getauthor()
        {
            return author;
        }
        public boolean getcondition()
        {
            return isborrowed;
        }
        public void borrow()
        {
            isborrowed = true;
        }
        public void Return()
        {
            isborrowed = false;
        }
        public void display()
        {
            System.out.println("书名："+bookname+"  作者："+author+"  年份"+year);
        }
    }
    static class PaperBook extends Book
    {
        protected int page;

        public PaperBook(String bookname,String author,int year,boolean isborrowed,int page)
        {
            super(bookname,author,year,isborrowed);
            this.page=page;
        }
        @Override
        public void display()
        {
            System.out.println("书名："+bookname+"  作者："+author+"  年份："+year+"  页数："+page);
        }
    }
    static class EBook extends Book
    {
        protected int size;

        public EBook(String bookname,String author,int year,boolean isborrowed,int size)
        {
            super(bookname, author, year, isborrowed);
            this.size=size;
        }
        @Override
        public void display()
        {
            System.out.println("书名："+bookname+"  作者："+author+"  年份："+year+"  大小："+size);
        }
    }


    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        while (true) 
        {
            try
            {
                System.out.println("\n===== 图书馆管理系统 =====");
                System.out.println("1. 添加书籍");
                System.out.println("2. 借阅图书");
                System.out.println("3. 归还图书");
                System.out.println("4. 显示所有图书");
                System.out.println("5. 搜索图书");
                System.out.println("6. 退出系统");
                System.out.print("请选择操作：");

                int choice = scanner.nextInt();
                scanner.nextLine(); // 清除换行符
                switch (choice) 
                {
                    case 1:
                    {
                        try
                        {
                            System.out.println("请输入书的类型：纸质书请输入1/电子书请输入2");
                            int temp=scanner.nextInt();
                            scanner.nextLine();
                            switch(temp)
                            {
                                case 1:
                                {
                                    System.out.println("请输入书名、作者，出版年份，页数。");
                                    String bookname=scanner.nextLine();
                                    String author=scanner.nextLine();
                                    int year=scanner.nextInt();
                                    int page=scanner.nextInt();
                                    scanner.nextLine();
                                    PaperBook A = new PaperBook(bookname, author, year, false, page);
                                    books.add(A);
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("请输入书名、作者，出版年份，大小。");
                                    String bookname=scanner.nextLine();
                                    String author=scanner.nextLine();
                                    int year=scanner.nextInt();
                                    int size=scanner.nextInt();
                                    scanner.nextLine();
                                    EBook A = new EBook(bookname, author, year, false, size);
                                    books.add(A);
                                    break;
                                }
                                default:
                                {
                                    break;
                                }
                            }
                        }
                        catch(InputMismatchException exception)
                        {
                            System.out.println("请按要求输入。");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 2: 
                    {
                        System.out.print("请输入要借的书名：");
                        String name = scanner.nextLine();
                        int index = -1;
                        for (int i = 0; i < books.size(); i++) 
                        {
                            if (books.get(i).getbookname().equals(name)) 
                            {
                                index = i;
                                break;               // 找到就停
                            }
                        }
                        if (index == -1) 
                        {
                            System.out.println("该书不存在。");
                        } 
                        else 
                        {
                            Book b = books.get(index);                                
                            if (!b.getcondition()) 
                            {
                            b.borrow();
                            System.out.println("借出成功！");
                            } 
                            else 
                            {
                                System.out.println("借出失败，该书正在被借阅。");
                            }
                        }
                        break;
                    }

                    case 3:
                    {
                        System.out.print("请输入要归还的书名：");
                        String name = scanner.nextLine();
                        int index = -1;
                        for (int i = 0; i < books.size(); i++) 
                        {
                            if (books.get(i).getbookname().equals(name)) 
                            {
                                index = i;
                                break;
                            }
                        }
                        if (index == -1) 
                        {
                            System.out.println("该书不存在。");
                        } 
                        else 
                        {
                            books.get(index).Return();
                            System.out.println("还书成功！");
                        }
                        break;
                    }
                    case 4:
                    {
                        for(int i = 0;i<books.size();i++)
                        {
                            books.get(i).display();
                        }
                        break;
                    }
                    case 5:
                    {
                        System.out.println("请输入想找的书名或者作者名：");
                        String temp=scanner.nextLine();
                        int index=-1;
                        for(int i=0;i<books.size();i++)
                        {
                            if(books.get(i).getauthor().equals(temp)||books.get(i).getbookname().equals(temp))
                            {
                                index=i;
                            }
                        }
                        if(index!=-1)
                        {
                            System.out.println("书位于第"+index+"处。");
                        }
                        else
                        {
                            System.out.println("此书不存在。");
                        }
                        break;
                    }
                    case 6:
                    {
                        scanner.close();
                        return;
                    }
                    default:
                    {
                        break;
                    }
                }
            }
            catch(InputMismatchException exception)
            {
                System.out.println("错误。");
                scanner.nextLine();
            }

        }


    }
}
