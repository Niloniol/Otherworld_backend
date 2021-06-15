package ru.other_world.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.other_world.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
