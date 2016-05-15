package com.meetup.repositories;

import com.meetup.domain.Topic;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author mh
 * @since 13.05.16
 */
public interface TopicRepository extends GraphRepository<Topic> {
}
