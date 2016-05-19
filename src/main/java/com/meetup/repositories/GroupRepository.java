package com.meetup.repositories;

import com.meetup.domain.Group;
import com.meetup.domain.Member;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * @author mh
 * @since 13.05.16
 */
@RepositoryRestController
public interface GroupRepository extends GraphRepository<Group> {

    @Query("MATCH (member:Member)-[:INTERESTED_IN]->(topic), (member)-[:MEMBER_OF]->(group)-[:HAS_TOPIC]->(topic) " +
            "WHERE id(member) = {member} " +
            "WITH member, topic, COUNT(*) AS score " +
            "MATCH (topic)<-[:HAS_TOPIC]-(otherGroup) WHERE NOT (member)-[:MEMBER_OF]->(otherGroup) " +
            "RETURN otherGroup, COLLECT(topic.name) as topics, SUM(score) as score " +
            "ORDER BY score DESC")
    List<GroupRecommendation> recommendGroupsByTopic(@Param("member") Member member);

    class GroupRecommendation {
        Group group;
        List<String> topics;
        long score;
    }
}
