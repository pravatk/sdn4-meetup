package com.meetup.domain;

import com.meetup.repositories.TopicRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicRepositoryTest {

    @Inject
    TopicRepository repository;

    @Test
    public void testSaveTopic() {
        Topic topic = new Topic("Neo4j");
        Topic saved = repository.save(topic);
        Assert.assertNotNull(saved.id);
        Assert.assertEquals("Neo4j", saved.getName());
        Topic found = repository.findOne(saved.id);
        Assert.assertEquals("Neo4j", found.getName());
    }

}
