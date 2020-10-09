package entities;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Administrator extends User {
    public Administrator() {
        super();
    }

    public Administrator(String username, @NotNull String password, @NotNull @Email String email, @NotNull String name) {
        super(username, password, email, name);
    }
}
