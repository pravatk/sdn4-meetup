package com.meetup.repositories;

import com.meetup.domain.Group;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author mh
 * @since 13.05.16
 */
public interface GroupRepository extends GraphRepository<Group> {
}
