package org.karp.k4t.data.content.provider;

import com.github.javafaker.Faker;
import org.karp.k4t.model.User;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service
public class UserLastNameProvider {

    public @NotNull @Size(min = 2, max = 64) @NotBlank String get(@NotNull User user) {
        return new Faker().name().lastName();
    }
}
