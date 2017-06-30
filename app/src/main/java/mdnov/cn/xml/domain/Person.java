package mdnov.cn.xml.domain;

/**
 * Created by Administrator on 2017/6/25.
 */

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(){

    }


    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        }else{
            this.age = 0;
        }

    }
}
