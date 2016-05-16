package com.meetup.service;

import javax.inject.Inject;

import com.meetup.repositories.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mh
 * @since 13.05.16
 */
@Service
public class MeetupApiService {
//    @Inject
//    MeetupTemplate template;

    @Inject
    GroupRepository groupRepository;

    @Transactional
    public int importGroups(String country, String city) {
//        List<Group> groups = template.groupOperations().findByRadius(country, city)
//                .stream().map(Group::new).collect(toList());
//        groupRepository.save(groups);
        //return groups.size();
        return 11;
    }
}
