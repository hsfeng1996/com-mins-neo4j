package com.mins.neo4j.repository;

import com.mins.neo4j.domain.GraphObject;
import com.mins.neo4j.domain.NodeObject;
import com.mins.neo4j.domain.RelationshipObject;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Map;

/*
 *  @Author hsfeng
 *  @Create 2019/7/21 17:12
 * */
@SuppressWarnings("unchecked")
@Repository
public interface Neo4jRepository extends org.springframework.data.neo4j.repository.Neo4jRepository{

    Iterable<NodeObject> findByLabel(String label);

    Iterable<RelationshipObject> findByType(String type);

    @Query("MATCH (n:NodeObject) WHERE n.label={label} RETURN n")
    Iterable<NodeObject> findNodeObjects(@Param("label") String label);

    @Query("MATCH p=()-[r:RelationshipObject]->() WHERE r.type={type} RETURN p")
    Iterable<RelationshipObject> findRelationshipObjects(@Param("type") String type);

    @Query("MATCH (n:NodeObject) WHERE n.groupId={groupId} RETURN n")
    Iterable<NodeObject> findNodeObjects(@Param("groupId") Long groupId);

    @Query("MATCH p=()-[r:RelationshipObject]->() WHERE r.groupId={groupId} RETURN p")
    Iterable<RelationshipObject> findRelationshipObjects(@Param("groupId") Long groupId);

    default void saveNodeObjects(Iterable<NodeObject> iterable){
        saveAll(iterable);
    }

    default void saveRelationshipObjects(Iterable<RelationshipObject> iterable){
        saveAll(iterable);
    }

    @Query("MATCH (n:NodeObject) WHERE n.label={label} DELETE n")
    void deleteByLabel(@Param("label") String label);

    @Query("MATCH p=()-[r:RelationshipObject]->() WHERE r.type={type} DELETE p")
    void deleteByType(@Param("type") String type);

    default void deleteNodeObjects(Iterable<NodeObject> iterable){
        deleteAll(iterable);
    }

    default void deleteRelationshipObjects(Iterable<RelationshipObject> iterable){
        deleteAll(iterable);
    }

    @Query("MATCH (n:NodeObject) WHERE n.groupId={groupId} DELETE n")
    void deleteNodeObjects(@Param("groupId") Long groupId);

    @Query("MATCH p=()-[r:RelationshipObject]->() WHERE r.groupId={groupId} DELETE p")
    void deleteRelationshipObjects(@Param("groupId") Long groupId);

    default GraphObject findGraphObject(Long groupId){
        return new GraphObject(groupId, findNodeObjects(groupId), findRelationshipObjects(groupId));
    }

    default void saveGroupObject(GraphObject graphObject){
        saveNodeObjects(graphObject.getNodeObjects());
        saveRelationshipObjects(graphObject.getRelationshipObjects());
    }

    default void deleteGroupObject(GraphObject graphObject){
        deleteNodeObjects(graphObject.getGroupId());
        deleteRelationshipObjects(graphObject.getGroupId());
    }

    /*
    @Query("MATCH (n) WHERE n.`properties.name`={0} return n")
    Iterable<NodeObject> getNodeObject(String string);

    @Query("MATCH (n) WHERE n.label={0} AND n.`properties.name`={2} RETURN n")
    Result getNodeObject(String label, String key, String value);

    @Query("MATCH p=()-[r:RelationshipObject]->() RETURN p")
    Iterable<RelationshipObject> getRelationshipObject();
    */
}
