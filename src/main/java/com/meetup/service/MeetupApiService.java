package com.meetup.service;

import javax.inject.Inject;

import com.meetup.domain.Event;
import com.meetup.domain.Group;
import com.meetup.domain.Venue;
import com.meetup.repositories.GroupRepository;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.social.meetup.api.impl.MeetupTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.neo4j.ogm.session.Utils.map;

/**
 * @author mh
 * @since 13.05.16
 */
@Service
public class MeetupApiService {
    @Inject Neo4jOperations neo4j;


    @Inject MeetupTemplate meetups;

    @Inject GroupRepository groupRepository;

    @Transactional
    public int importGroups(String country, String city) {
        List<Group> groups = meetups.groupOperations().findByRadius(country, city)
                .stream().map(Group::new).collect(toList());
        groupRepository.save(groups);
        return groups.size();
    }
    @Transactional
    public int importEvents() {
        int count = 0;
        for (Group group : groupRepository.findAll()) {
            count += meetups.eventOperations().findByGroup(group.getGroupId()).stream().map(e -> {
                Venue v = new Venue(e.getVenue());
                Venue venue = neo4j.queryForObject(Venue.class,
                        "MERGE (v:Venue {id:{id}}) ON CREATE SET v += {props} RETURN v",
                        map("id", v.getVenueId(),"props",v.toMap()));
                return neo4j.save(new Event(e.getId(), group, e.getName(), venue, e.getTime()));
            }).count();
        }
        return count;
    }
}
