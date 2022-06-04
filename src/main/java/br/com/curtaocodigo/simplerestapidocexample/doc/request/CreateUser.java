package br.com.curtaocodigo.simplerestapidocexample.doc.request;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * CreateUser
 */
@Validated
public class CreateUser   {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("age")
    private Integer age = null;

    @JsonProperty("group")
    private GroupEnum group = null;

    @JsonProperty("status")
    private StatusEnum status = null;

    public CreateUser name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @ApiModelProperty(example = "John", required = true, value = "")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateUser age(Integer age) {
        this.age = age;
        return this;
    }

    /**
     * Get age
     * @return age
     **/
    @ApiModelProperty(example = "18", value = "")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CreateUser group(GroupEnum group) {
        this.group = group;
        return this;
    }

    /**
     * grupo do usuário
     * @return group
     **/
    @ApiModelProperty(value = "grupo do usuário")
    public GroupEnum getGroup() {
        return group;
    }

    public void setGroup(GroupEnum group) {
        this.group = group;
    }

    public CreateUser status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * status do usuário
     * @return status
     **/
    @ApiModelProperty(value = "status do usuário")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUser that = (CreateUser) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age) && group == that.group && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, group, status);
    }
}


