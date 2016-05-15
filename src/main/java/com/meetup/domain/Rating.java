package com.meetup.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author mh
 * @since 13.05.16
 */
@RelationshipEntity(type="RATED")
public class Rating {
    @GraphId
    Long id;

    @StartNode Member member;
    @EndNode Event event;

    int stars;
    String comment;
}
