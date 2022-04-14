package org.karp.k4t.data.content.provider;

import org.apache.commons.lang3.RandomUtils;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static java.lang.String.format;

@Service
public class UserThumbnailPictureProvider {

    public @NotNull @URL String get() {
        String gender = (RandomUtils.nextBoolean() == true)?"men":"women";
        String index = Integer.toString(RandomUtils.nextInt(1, 100));
        return format("https://randomuser.me/api/portraits/thumb/%s/%s.jpg", gender, index);
    }
}
