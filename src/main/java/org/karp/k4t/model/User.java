package org.karp.k4t.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

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

    @Getter
    @NotNull
    @URL
    private String thumbnailPicture;

    public User(Long id,
                String firstName,
                String lastName,
                String thumbnailPicture) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.thumbnailPicture = thumbnailPicture;
    }

    public User(String firstName,
                String lastName,
                String thumbnailPicture) {
        this(null, firstName, lastName, thumbnailPicture);
    }
}
