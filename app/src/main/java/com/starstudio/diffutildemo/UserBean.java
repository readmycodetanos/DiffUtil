package com.starstudio.diffutildemo;

public class UserBean {

    private String name;
    private String age;
    private String intro;

    public UserBean(String name, String age, String intro) {
        this.name = name;
        this.age = age;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
