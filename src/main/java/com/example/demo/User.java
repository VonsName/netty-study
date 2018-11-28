package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        User user1 = new User();
        user1.setId(1);
        user1.setNo(2);
        user1.setPassword("12345");
        User user2 = new User();
        user2.setId(2);
        user2.setNo(3);
        user2.setPassword("56789");
        User user3 = new User();
        user2.setId(1);
        user2.setNo(3);
        user2.setPassword("56789");
        List<User> userList=new ArrayList<>();
        userList.add(user2);
        userList.add(user1);
        userList.add(user3);
        userList.sort((t1, t2) -> Comparator.comparing(User::getId).reversed().compare(t1, t2));
        System.out.println(userList);
        Comparator<User> userComparator = Comparator.comparing(User::getId);
        Comparator<User> comparator = Comparator.comparing(User::getNo).reversed();

        Comparator<User> thenComparing = userComparator.thenComparing(comparator);
        userList.sort(thenComparing);
        System.out.println(userList);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", no=" + no +
                '}';
    }
}
