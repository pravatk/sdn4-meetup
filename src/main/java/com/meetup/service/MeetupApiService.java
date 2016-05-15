package com.meetup.service;

import com.meetup.domain.Group;
import com.meetup.repositories.GroupRepository;
import org.springframework.social.meetup.api.impl.MeetupTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author mh
 * @since 13.05.16
 */
@Service
public class MeetupApiService {
    @Inject
    MeetupTemplate template;

    @Inject
    GroupRepository groupRepository;

    @Transactional
    public int importGroups(String country, String city) {
        List<Group> groups = template.groupOperations().findByRadius(country, city)
                .stream().map(Group::new).collect(toList());
        groupRepository.save(groups);
        return groups.size();
    }
}
