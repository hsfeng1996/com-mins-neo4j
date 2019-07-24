package com.mins.neo4j.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Map;
import java.util.Objects;

/*
 *  @Author hsfeng
 *  @Create 2019/7/18 20:04
 * */
@NodeEntity
public class NodeObject {

    @Id @GeneratedValue
    private Long id;
    @Property
    private Long groupId = 0L;
    @Property
    private String label;
    @Properties
    private Map<String, Object> properties;

    public NodeObject(){
        this(null, null, null);
    }

    public NodeObject(Long groupId, String label, Map<String, Object> properties){
        this(null, groupId, label, properties);
    }

    public NodeObject(Long id, Long groupId, String label, Map<String, Object> properties) {
        this.id = id;
        this.groupId = (groupId==null || groupId<0)?0L:groupId;
        this.label = label;
        this.properties = properties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeObject that = (NodeObject) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(label, that.label) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, label, properties);
    }

    @Override
    public String toString() {
        return "NodeObject{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", label='" + label + '\'' +
                ", properties=" + properties +
                '}';
    }
}
