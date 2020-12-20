package ru.pirozhkov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pirozhkov.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
