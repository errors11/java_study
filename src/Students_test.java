import Students_Course.*;
import java.util.*;
import java.lang.Exception;

public class Students_test {
    public static  ArrayList Students_list = new ArrayList<Students>();
    public static  HashMap<Integer, Students> hashmap = new HashMap<Integer, Students>();

    public void SignUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("************注册学生信息管理系统*************");
        int id=0;
            while(true) {
                    System.out.print("请输入学生的学号(输入0退出): ");
                    try {
                        id = sc.nextInt();
                    }
                    catch (Exception e)
                    {
                        String error = sc.next();
                        System.out.println("输入的学号"+error+"不合法");
                        continue;
                    }
                    if (hashmap.containsKey(id)) {
                        System.out.println("id:" + id + " 已经存在");
                        continue;
                    }
                    if (id == 0) {
                        return;
                    }
                    break;
        }
        Students s = new Students(id);
        System.out.print("请输入注册密码:");
        String password1 = sc.next();
        System.out.print("请再次输入密码:");
        String password2 = sc.next();
        if(password1.equals(password2))
        {
            s.setPassword(password1);
            hashmap.put(id,s);
            System.out.println("学号 "+id+" 注册成功");
        }
        else
        {
            System.out.println("两次密码不一致，请重新注册");
        }


    }

    public void SignIn() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while(true) {
            System.out.print("输入学号(输入0退出登录)：");
            try {
                id = scanner.nextInt();
                if(id==0)
                    return;
               break;
            } catch (Exception e) {
                String error = scanner.next();
                System.out.println("输入" + error + "不合法");
            }
        }
        System.out.print("输入登录密码:");
        String password = scanner.next();
        if(hashmap.containsKey(id))
        {
        Students s = hashmap.get(id);
        if(password.equals(s.getPassword()))
        {
                System.out.println("登陆成功");
                while (true)
                {
                    SignIn_meau();
                    System.out.print("输入需要操作的选项:");
                    try
                    {
                        int choose = scanner.nextInt();
                        switch (choose) {
                            case 1:
                                add_info(id);
                                break;
                            case 2:
                                show_info(id);
                                break;
                            case 3:
                                hashmap.remove(id);
                                break;
                            case 4:
                                return;
                            default:
                                System.out.println("请输入1-4的整数");
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("输入1-4的整数");
                        String error =  scanner.next();
                        System.out.println("输入" + error + "不合法");
                    }
                }
            }
            else
            {
                System.out.println("学号不存在或者密码输入错误");
                return;
            }
        }
        else
        {
            System.out.println("学号不存在或者密码输入错误");
            return;
        }


    }
    public void add_info(int id)
    {
            Students s = hashmap.get(id);
            Scanner sc = new Scanner(System.in);
            System.out.println("************************************************");
            System.out.print("请输入姓名: ");
            String sname = sc.next();
            s.setSname(sname);
            System.out.print("请输入性别(男\\y，女\\x): ");
            String sex = sc.next();
            while (true) {
                if (sex.equals("y") || sex.equals("x")) {
                    s.setSex(sex);
                    break;
                } else {
                    System.out.print("请重新输入性别(男\\y，女\\x): ");
                    sex = sc.next();
                }
            }
            System.out.print("请输入年龄(1-100): ");
            try {
                int age = sc.nextInt();
                while (true) {
                    if (age < 1 || age > 100) {
                        System.out.print("请重新输入年龄(1-100): ");
                        age = sc.nextInt();
                    } else {
                        s.setAge(age);
                        break;
                    }
                }
            }
            catch (InputMismatchException e)
        {
            System.out.println("输入年龄为数字");
        }

    }
    public  void show_info(int id)
    {
        Students  s = hashmap.get(id);
        System.out.println("***************个人信息****************");
        String sex;
        if(s.getSname()!=null)
            sex = s.getSex()=="y"?"男":"女";
        else
            sex=null;
        System.out.println("学号:"+s.getId()+'\t'+"姓名:"+s.getSname()+'\t'+"性别:"+sex+'\t'+"年龄:"+s.getAge());
    }

    public void SignIn_meau() {
        System.out.println("############################################");
        System.out.println("1.更改学生信息");
        System.out.println("2.查看个人学生的信息");
        System.out.println("3.注销账号");
        System.out.println("4.退出登录");
        System.out.println("############################################");
    }
    public void start_meau() {
        System.out.println("############################################");
        System.out.println("1.学生注册");
        System.out.println("2.学生登录");
        System.out.println("3.退出登录");
        System.out.println("############################################");
    }

    public static void main(String[] args) {
        Students_test t = new Students_test();
        while (true) {
            t.start_meau();
            System.out.print("输入需要操作的选项:");
            Scanner scanner = new Scanner(System.in);
            try {
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        t.SignUp();
                        break;
                    case 2:
                        t.SignIn();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("请输入1-3的整数");
                }
            } catch (Exception e) {
                System.out.print("输入1-3的整数,");
                String error =  scanner.next();
                System.out.println("输入" + error + "不合法");
            }
        }
    }
}
