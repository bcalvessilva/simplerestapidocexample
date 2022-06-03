package br.com.curtaocodigo.simplerestapidocexample.model;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @Column(name="group_user")
    private String group;

    @Column(name="status_user")
    private String status;

    public User(){
        //default constructor for JPARepository
    }

    /**
     *
     * @param name
     * @param age
     * @param group
     * @param status
     */
    public User(String name, Integer age, String group, String status) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
