package org.karp.k4t.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class SearchTerm extends BaseEntity {

    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 64)
    @NotBlank
    private String text;

    public SearchTerm(Long id, String text) {
        super(id);
        this.text = text;
    }

    public SearchTerm(String text) {
        this.text = text;
    }
}
