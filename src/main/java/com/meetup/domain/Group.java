package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Group {
    @GraphId Long id;

    long groupId;
    String name;
    String slug;

    Set<Event> events;
    Set<Member> members;

    public Group(org.springframework.social.meetup.api.Group group) {
        this.groupId = group.getId().longValue();
        this.name = group.getName();
        this.slug = group.getUrlname();
    }
}
