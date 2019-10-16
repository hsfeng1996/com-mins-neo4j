package com.mins.neo4j.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 *
 *  @Author hsfeng
 *  @Create 2019/7/18 23:41
 */
@RelationshipEntity(type = "RelationshipObject")
public class RelationshipObject {

    @Id @GeneratedValue
    private Long id;
    @Property
    private Long groupId = 0L;
    @Property
    private String type;
    @Properties
    private Map<String, Object> properties;
    @StartNode
    private NodeObject sourceNode;
    @EndNode
    private NodeObject targetNode;

    public RelationshipObject(){
        this(null, null, null, null, null);
    }

    public RelationshipObject(Long groupId, String type, Map<String, Object> properties, NodeObject startNodeObject, NodeObject endNodeObject){
        this(null, groupId, type, properties, startNodeObject, endNodeObject);
    }

    public RelationshipObject(Long id, Long groupId, String type, Map<String, Object> properties, NodeObject startNodeObject, NodeObject endNodeObject) {
        this.id = id;
        this.groupId = (groupId==null || groupId<0)?0L:groupId;
        this.type = type;
        this.properties = properties;
        this.sourceNode = startNodeObject;
        this.targetNode = endNodeObject;
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

    public NodeObject getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(NodeObject sourceNode) {
        this.sourceNode = sourceNode;
    }

    public NodeObject getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(NodeObject targetNode) {
        this.targetNode = targetNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        RelationshipObject that = (RelationshipObject) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(sourceNode, that.sourceNode) &&
                Objects.equals(targetNode, that.targetNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, type, properties, sourceNode, targetNode);
    }

    @Override
    public String toString() {
        return "RelationshipObject{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                ", sourceNode=" + sourceNode +
                ", targetNode=" + targetNode +
                '}';
    }
}
