package org.karp.k4t.ui.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersViewPresentationModeChangeEvent {

    private UsersViewPresentationMode oldUserViewPresentationMode;

    private UsersViewPresentationMode newUserViewPresentationMode;
}
