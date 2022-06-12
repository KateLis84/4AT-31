package itstep_aqa.Framework.DB;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String Lastname;
    private String email;
    private Integer age;

    public Long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\"name\": \""+name+"\", \"LastName\": \""+Lastname+"\", \"email\": \""+email+"\", \"age\": "+age+"}";
    }
}
