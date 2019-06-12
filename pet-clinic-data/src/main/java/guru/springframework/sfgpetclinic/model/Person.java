package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Ricardo Vargas on 6/08/19.
 */

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name") // Hibernate by default looks for snake_case
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
