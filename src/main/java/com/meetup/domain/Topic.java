package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Topic {
    @GraphId Long id;
    String name;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
