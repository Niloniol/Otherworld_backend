package ru.other_world.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.other_world.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
