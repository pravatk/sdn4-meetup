package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.Instant;
import java.util.Set;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Event {
    @GraphId Long id;

    String title;
    String description;
    Instant time;

    Venue venue;
    Set<Member> rsvps;

    Set<Rating> ratings;
}
