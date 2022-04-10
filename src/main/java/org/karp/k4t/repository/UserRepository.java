package org.karp.k4t.repository;

import org.karp.k4t.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    Boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
