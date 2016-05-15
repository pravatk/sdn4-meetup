package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.geo.Point;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Venue {
    @GraphId
    Long id;

    String name;

    Point coords;
}
