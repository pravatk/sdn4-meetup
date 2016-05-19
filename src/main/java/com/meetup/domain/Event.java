package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Event {
    @GraphId Long id;

    String eventId;
    String title;
    Instant time;

    @Relationship(type = "RSVPD", direction = INCOMING)       Venue venue;
    @Relationship(type = "HOSTS_EVENT", direction = INCOMING) Group group;

    @Relationship(type = "RSVPD", direction = INCOMING)  Set<Member> rsvps;

    @Relationship(type = "RATED", direction = INCOMING)  Set<Rating> ratings;

    public Event(String id, Group group, String name, Venue venue, Number time) {
        this.title = name;
        this.time = Instant.ofEpochMilli(time.longValue());
        this.eventId = id;
        this.venue = venue;
        this.group = group;
    }
}
