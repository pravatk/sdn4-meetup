package com.meetup.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.session.Utils;
import org.springframework.data.geo.Point;

import java.util.Map;

/**
 * @author mh
 * @since 13.05.16
 */
@NodeEntity
public class Venue {
    @GraphId
    Long id;

    String venueId;
    String name;
    String city;

    Point coords;

    public Venue(org.springframework.social.meetup.api.Venue venue) {
        this.venueId = venue.getId().toString();
        this.name = venue.getName();
        this.city = venue.getCity();
        this.coords = new Point(venue.getLat(),venue.getLon());
    }

    public String getVenueId() {
        return venueId;
    }

    public Map toMap() {
        return Utils.map("name",name,"city",city,"latitude",coords.getX(), "longitude", coords.getY());
    }
}
