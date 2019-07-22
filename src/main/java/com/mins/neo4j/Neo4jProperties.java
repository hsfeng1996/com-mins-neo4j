package com.mins.neo4j;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

/*
 *  @Author hsfeng
 *  @Create 2019/7/17 0:36
 * */
//@Component
@ConfigurationProperties(prefix = "com.mins.neo4j")
public class Neo4jProperties {

    @Value("URI")
    public String URI;
    @Value("username")
    public String username;
    @Value("password")
    public String password;

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties properties(){
        Properties properties = new Properties();
        properties.put("URI", getURI());
        properties.put("username", getUsername());
        properties.put("password", getPassword());
        return properties;
    }

}
