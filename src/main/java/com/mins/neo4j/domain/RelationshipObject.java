package com.mins.neo4j.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Map;
import java.util.Objects;

/*
 *  @Author hsfeng
 *  @Create 2019/7/18 23:41
 * */
@RelationshipEntity(type = "RelationshipObject")
public class RelationshipObject {

    @Id @GeneratedValue
    private Long id;
    @Property
    private String type;
    @Properties
    private Map<String, Object> properties;
    @StartNode
    private NodeObject startNodeObject;
    @EndNode
    private NodeObject endNodeObject;

    public RelationshipObject(){
        this(null, null, null, null);
    }

    public RelationshipObject(String type, Map<String, Object> properties, NodeObject startNodeObject, NodeObject endNodeObject){
        this(null, type, properties, startNodeObject, endNodeObject);
    }

    public RelationshipObject(Long id, String type, Map<String, Object> properties, NodeObject startNodeObject, NodeObject endNodeObject) {
        this.id = id;
        this.type = type;
        this.properties = properties;
        this.startNodeObject = startNodeObject;
        this.endNodeObject = endNodeObject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public NodeObject getStartNodeObject() {
        return startNodeObject;
    }

    public void setStartNodeObject(NodeObject startNodeObject) {
        this.startNodeObject = startNodeObject;
    }

    public NodeObject getEndNodeObject() {
        return endNodeObject;
    }

    public void setEndNodeObject(NodeObject endNodeObject) {
        this.endNodeObject = endNodeObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipObject that = (RelationshipObject) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(startNodeObject, that.startNodeObject) &&
                Objects.equals(endNodeObject, that.endNodeObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, properties, startNodeObject, endNodeObject);
    }

    @Override
    public String toString() {
        return "RelationshipObject{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                ", startNodeObject=" + startNodeObject +
                ", endNodeObject=" + endNodeObject +
                '}';
    }
/*public static boolean type(String type) {
        boolean flag = true;
        try {
            RelationshipEntity relationshipEntity = RelationshipObject.class.getAnnotation(RelationshipEntity.class);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(relationshipEntity);
            Field field = invocationHandler.getClass().getDeclaredField("memberValues");
            field.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>)field.get(invocationHandler);
            memberValues.put("value", type);
        }catch (Exception e){
            flag = false;
            e.printStackTrace();
        }finally {
            return flag;
        }
    }*/
}
