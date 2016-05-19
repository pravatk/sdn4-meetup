package com.meetup.repositories;

import com.meetup.domain.Topic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * @author mh
 * @since 13.05.16
 */
public interface TopicRepository extends GraphRepository<Topic> {

    class TopicRating {
        Topic topic;
        int hits;
    }

    @Query("MATCH(topic:Topic)<-[:INTERESTED_IN]-(m:Member) " +
           "RETURN topic, count(*) AS hits ORDER BY hits DESC")
    List<TopicRating> topicsByPopularity();
}
