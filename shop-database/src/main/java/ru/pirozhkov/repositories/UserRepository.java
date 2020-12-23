package ru.pirozhkov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pirozhkov.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
