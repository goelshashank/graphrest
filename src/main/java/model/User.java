package model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userId;


    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "location")
    private String location;

    public User() {
    }

    public User(String name, String age, String sex, String location) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userid) {
        this.userId = userid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}