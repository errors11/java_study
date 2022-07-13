package Students_Course;

public class Students {
    private int id;
    private String sname;
    private String sex;
    private int age;
    private String password;
    public  Students(){}
    public Students(int id)
    {
        setId(id);
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getId() {
        return id;
    }
    public String getSname() {
        return sname;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
