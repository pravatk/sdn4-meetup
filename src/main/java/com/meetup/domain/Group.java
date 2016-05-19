package com.meetup.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Group {
    @GraphId Long id;

    String groupId;
    String name;
    String slug;

    @Relationship(type = "HOSTED_EVENT")
    Set<Event> events;

    @Relationship(type = "MEMBER_OF", direction = Relationship.INCOMING)
    Set<Member> members;

    @Relationship(type = "HAS_TOPIC")
    Set<Topic> topics;

    public Group(org.springframework.social.meetup.api.Group group) {
        this.groupId = group.getId().toString();
        this.name = group.getName();
        this.slug = group.getUrlname();
    }

    public String getGroupId() {
        return groupId;
    }
}
