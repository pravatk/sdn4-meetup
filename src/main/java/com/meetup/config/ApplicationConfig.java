package com.meetup.config;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.neo4j.NodeEntityScan;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import org.springframework.social.meetup.api.impl.MeetupTemplate;

/**
 * @author mh
 * @since 13.05.16
 */
@SpringBootApplication
@EnableTransactionManagement
@NodeEntityScan(basePackages = "com.meetup.domain")
public class ApplicationConfig {

    @Inject
    Environment env;

//    @Bean
//    public MeetupTemplate meetupTemplate() {
//        return new MeetupTemplate(env.getProperty("meetup.api.key"));
//    }

}
