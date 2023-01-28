package xiaozhang;

public class student {
    private int id;
    private int age;
    private String sex;
    private String name;

    public student(int id1) {
        this.id = id1;
    }

    public student(int id1, int age1) {
        id = id1;
        age = age1;
    }

    public student(int id1, int age1, String sex1) {
        id = id1;
        age = age1;
        sex = sex1;
    }

    public student(int id1, int age1, String sex1, String name1) {
        id = id1;
        age = age1;
        sex = sex1;
        name = name1;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", age=" + age + ", sex='" + sex + '\'' + ", name='" + name + '\'' + '}';
    }
}
