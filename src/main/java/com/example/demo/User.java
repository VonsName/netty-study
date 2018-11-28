package com.example.demo;

/**
 * @author ： fjl
 * @date ： 2018/11/28/028 8:33
 */
public class User {

    static {
        System.out.println("static");
    }

    {
        System.out.println("common");
    }

    public String username;
    public String password = "123";
    public int id = 2;
    public Integer no = 3;
    public static int say = get();

    public User() {
        System.out.println("constructor");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    private static int get() {
        System.out.println("static field");
        return 5;
    }

    public static void main(String[] args) {
        System.out.println(User.say);
        User user = new User();
    }
}
