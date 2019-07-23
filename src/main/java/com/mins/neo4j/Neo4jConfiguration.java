package com.mins.neo4j;

import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

import javax.swing.*;
import java.util.Properties;

/*
 *  @Author hsfeng
 *  @Create 2019/7/17 0:36
 * */
@Configuration
@Import(Neo4jProperties.class)
public class Neo4jConfiguration {

    @Autowired
    private Neo4jProperties neo4jProperties;

    @Bean
    public SessionFactory sessionFactory(){
        return new SessionFactory(configuration(), "com.mins.neo4j.domain");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration(){
        ConfigurationSource properties = new ConfigurationSource() {
            @Override
            public Properties properties() {
                return neo4jProperties.properties();
            }
        };
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties).build();
        /*ConfigurationSource properties = new ClasspathConfigurationSource("");
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://127.0.0.1:7687")
                .credentials("neo4j", "hsfeng")
                .build();*/
        return configuration;
    }

    @Bean(name = "transactionManager")
    public Neo4jTransactionManager neo4jTransactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }

    @Bean(name = "neo4jLogger")
    public Logger logger(){
        return LoggerFactory.getLogger("com.mins.neo4j");
    }
}
