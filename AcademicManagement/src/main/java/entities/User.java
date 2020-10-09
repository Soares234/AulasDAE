package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "USERS")
public class User {

    @Id
    public String username;
    @NotNull
    public String password;
    @NotNull
    @Email
    public String email;
    @NotNull
    public String name;

    public User(String username, @NotNull String password, @NotNull @Email String email, @NotNull String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
