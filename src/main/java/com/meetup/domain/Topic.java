package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Topic {
    @GraphId Long id;
    String name;

    @Relationship(type="HAS_TOPIC", direction = Relationship.INCOMING)
    Set<Group> groups;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
