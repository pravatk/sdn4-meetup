package com.meetup.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author mh
 * @since 13.05.16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetupApiServiceTest {

    @Inject MeetupApiService service;

    @Test
    public void testImportGroups() throws Exception {
        int count = service.importGroups("ES", "Barcelona");
        System.out.println("count = " + count);
        assertTrue(count > 10);
    }
    @Test
    public void testImportEvents() throws Exception {
        service.importGroups("ES", "Barcelona");
        int events = service.importEvents();
        System.out.println("events = " + events);
        assertTrue(events > 10);
    }
}
