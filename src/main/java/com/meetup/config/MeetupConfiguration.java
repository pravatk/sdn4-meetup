package com.meetup.config;

import com.meetup.domain.Topic;
import com.meetup.repositories.TopicRepository;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.social.meetup.api.impl.MeetupTemplate;

import javax.inject.Inject;

/**
 * @author mh
 * @since 13.05.16
 */
@Configuration
@EnableNeo4jRepositories(basePackageClasses = TopicRepository.class)
public class MeetupConfiguration extends Neo4jConfiguration {

    @Inject
    Environment env;
    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory(Topic.class.getPackage().getName());
    }

    @Bean
    public MeetupTemplate meetupTemplate() {
        return new MeetupTemplate(env.getProperty("meetup.api.key"));
    }
}
