package br.com.curtaocodigo.simplerestapidocexample.doc.request;

import java.util.Objects;

public class PatchUser {
    private String name;
    private Integer age;

    public PatchUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatchUser patchUser = (PatchUser) o;
        return Objects.equals(name, patchUser.name) && Objects.equals(age, patchUser.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
}
