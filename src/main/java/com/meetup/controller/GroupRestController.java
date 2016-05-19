package com.meetup.controller;

import com.meetup.domain.Group;
import com.meetup.repositories.GroupRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author mh
 * @since 18.05.16
 */
@RestController
public class GroupRestController {

    @Inject private GroupRepository repo;

    @RequestMapping(value="/groups", method = RequestMethod.GET)
    public Iterable<Group> list() {
        return repo.findAll();
    }
}
