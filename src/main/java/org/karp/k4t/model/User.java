package org.karp.k4t.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class User extends BaseEntity {

    @Getter
    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String firstName;

    @Getter
    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String lastName;

    public User(Long id,
                String firstName,
                String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName,
                String lastName) {
        this(null, firstName, lastName);
    }
}
