package com.mins.neo4j.domain;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/*
 *  @Author hsfeng
 *  @Create 2019/7/20 20:31
 * */
public class GraphObject {

    private Iterable<NodeObject> nodeObjects;
    private Iterable<RelationshipObject> relationshipObjects;

    public GraphObject(){
        this(null, null);
    }

    public GraphObject(Iterable<NodeObject> nodeObjects, Iterable<RelationshipObject> relationshipObjects) {
        this.nodeObjects = nodeObjects;
        this.relationshipObjects = relationshipObjects;
    }

    public Iterable<NodeObject> getNodeObjects() {
        return nodeObjects;
    }

    public void setNodeObjects(Iterable<NodeObject> nodeObjects) {
        this.nodeObjects = nodeObjects;
    }

    public Iterable<RelationshipObject> getRelationshipObjects() {
        return relationshipObjects;
    }

    public void setRelationshipObjects(Iterable<RelationshipObject> relationshipObjects) {
        this.relationshipObjects = relationshipObjects;
    }

    public List<NodeObject> getNodeObjectsList(){
        return Lists.newArrayList(this.nodeObjects);
    }

    public List<RelationshipObject> getRelationshipObjectsList(){
        return Lists.newArrayList(this.relationshipObjects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphObject that = (GraphObject) o;
        return Objects.equals(nodeObjects, that.nodeObjects) &&
                Objects.equals(relationshipObjects, that.relationshipObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeObjects, relationshipObjects);
    }

    @Override
    public String toString() {
        return "GraphObject{" +
                "nodeObjects=" + nodeObjects +
                ", relationshipObjects=" + relationshipObjects +
                '}';
    }
}
