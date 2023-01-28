package xiaozhang;

public class person {
    private int age;
    private String sex;

    public person(int age1,String sex1) {
        age = age1;
        sex = sex1;
    }

    public void shout() {
        System.out.println("我今年 "+age+" 岁了！");
        System.out.println("我是一名 "+sex+"生！");
    }

    public void setAge(int age1) {
        if (age1 < 0 || age1 > 130) {
            System.out.println("输入的年龄有误，请重新输入");
        } else {
            age = age1;
        }
    }
    public int getAge() {
        return age;
    }
    public void setSex(String sex1) {
        sex = sex1;
    }
    public String getSex() {
        return sex;
    }
}
