package com.meetup.controller;

import com.meetup.domain.Group;
import com.meetup.domain.Member;
import com.meetup.repositories.GroupRepository;
import com.meetup.repositories.MemberRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author mh
 * @since 18.05.16
 */
@RestController
public class GroupRestController {

    @Inject private GroupRepository groups;
    @Inject private MemberRepository members;

    @RequestMapping(value="/groups", method = RequestMethod.GET)
    public Iterable<Group> list() {
        return groups.findAll();
    }

    @RequestMapping(value="/recommend", method = RequestMethod.GET)
    public Iterable<GroupRepository.GroupRecommendation> recommend(@RequestParam("member") String memberName) {
        Member member = members.findByName(memberName);
        return groups.recommendGroupsByTopic(member);
    }
}
