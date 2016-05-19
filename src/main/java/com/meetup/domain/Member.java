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
public class Member {
    @GraphId Long id;
    String name;

    @Relationship(type = "MEMBER_OF")
    Set<Group> groups;

    @Relationship(type = "RSVPD")
    Set<Event> events;

    @Relationship(type = "INTERESTED_IN")
    Set<Topic> topics;
}
