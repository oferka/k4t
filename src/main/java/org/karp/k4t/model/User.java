package org.karp.k4t.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.time.ZonedDateTime;

import static java.lang.String.format;

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

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Getter
    @NotNull
    @Past
    private ZonedDateTime dateOfRegistration;

    @Getter
    @NotNull
    @Size(min = 2, max = 512)
    @NotBlank
    private String summary;

    @Getter
    @PositiveOrZero
    private Long likes;

    @Getter
    @PositiveOrZero
    private Long comments;

    @Getter
    @PositiveOrZero
    private Long shares;

    public User(Long id,
                String firstName,
                String lastName,
                String thumbnailPicture,
                ZonedDateTime dateOfRegistration,
                String summary,
                long likes,
                long comments,
                long shares) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.thumbnailPicture = thumbnailPicture;
        this.dateOfRegistration = dateOfRegistration;
        this.summary = summary;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
    }

    public User(String firstName,
                String lastName,
                String thumbnailPicture,
                ZonedDateTime dateOfRegistration,
                String summary,
                long likes,
                long comments,
                long shares) {
        this(null, firstName, lastName, thumbnailPicture, dateOfRegistration, summary, likes, comments, shares);
    }

    public @NotNull String getName() {
        return format("%s %s", firstName, lastName);
    }
}
