package com.meetup.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * @author mh
 * @since 13.05.16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class MeetupApiServiceTest {

    @Inject MeetupApiService service;

    @Test
    public void testImportGroups() throws Exception {
        int count = service.importGroups("ES", "Barcelona");
        System.out.println("count = " + count);
        assertTrue(count > 10);
    }
}
