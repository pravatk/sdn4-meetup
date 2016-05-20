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
public interface MemberRepository extends GraphRepository<Member> {

    @Query("MATCH (member:Member)-[:RSVPD]->(event)<-[:RSVPD]-(other) " +
            "RETURN other, count(*) as score " +
            "ORDER BY score DESC LIMIT 5")
    List<Member> recommendPeers(@Param("member") Member member);

    Member findByName(String name);
}
