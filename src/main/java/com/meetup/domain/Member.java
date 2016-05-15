package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Member {
    @GraphId Long id;
    String name;
    Set<Group> groups;
    Set<Event> events;
    Set<Topic> topics;
}
