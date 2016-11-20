package com.wesew.core.repo;

import com.wesew.core.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vladyslav.yemelianov
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
