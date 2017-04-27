package model;

import java.sql.Date;

/**
 * @description: app user class
 * @author: youyinnn
 * @date: 2017/2/11
 */
public class User {

    private int id;
    private int age;
    private int care;
    private int beCare;
    private long phone_number;
    private String name;
    private String career;
    private String gender;
    private String address;
    private String username;
    private String password;
    private String friend_list;
    private String portrait_url;
    private Date birthday;


    public User() {
    }

    public User(int id, int age, int care, int beCare, long phone_number,
                String name, String career, String gender, String address,
                String username, String password, String friend_list,
                String portrait_url, Date birthday) {

        this.id = id;
        this.age = age;
        this.care = care;
        this.beCare = beCare;
        this.phone_number = phone_number;
        this.name = name;
        this.career = career;
        this.gender = gender;
        this.address = address;
        this.username = username;
        this.password = password;
        this.friend_list = friend_list;
        this.portrait_url = portrait_url;
        this.birthday = birthday;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCare() {
        return care;
    }

    public void setCare(int care) {
        this.care = care;
    }

    public int getBeCare() {
        return beCare;
    }

    public void setBeCare(int beCare) {
        this.beCare = beCare;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getFriend_list() {
        return friend_list;
    }

    public void setFriend_list(String friend_list) {
        this.friend_list = friend_list;
    }

    public String getPortrait_url() {
        return portrait_url;
    }

    public void setPortrait_url(String portrait_url) {
        this.portrait_url = portrait_url;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", care=" + care +
                ", beCare=" + beCare +
                ", phone_number=" + phone_number +
                ", name='" + name + '\'' +
                ", career='" + career + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", friend_list='" + friend_list + '\'' +
                ", portrait_url='" + portrait_url + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
