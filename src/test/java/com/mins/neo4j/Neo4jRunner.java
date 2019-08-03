package com.mins.neo4j;

import com.mins.neo4j.annotation.Neo4jTransactional;
import com.mins.neo4j.domain.GraphObject;
import com.mins.neo4j.domain.NodeObject;
import com.mins.neo4j.domain.RelationshipObject;
import com.mins.neo4j.repository.Neo4jRepository;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  @Author hsfeng
 *  @Create 2019/7/17 0:36
 * */
@SuppressWarnings("unchecked")
@Component
public class Neo4jRunner implements CommandLineRunner {

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    Neo4jRepository neo4jRepository;

    private Logger neo4jLogger;

    public Neo4jRunner(){
        this.neo4jLogger = LoggerFactory.getLogger(Neo4jRunner.class);
    }

    @Override
    public void run(String... args){

//        RelationshipObject.type("RELATIONSHIP");

       /* String label = "人物";
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "hsfeng");
        properties.put("uuid", 15L);
        NodeObject startNodeObject = new NodeObject(label, properties);
//        startNodeObject.setId(53L);
        String label1 = label.toString();
        Map<String, Object> properties1 = new HashMap<>();
        properties1.put("name", "heshaofeng");
        properties1.put("uuid", 13L);
        NodeObject endNodeObject = new NodeObject(label1,properties1);
//        endNodeObject.setId(52L);

        RelationshipObject relationshipObject = new RelationshipObject();
//        relationshipObject.setId(0L);
        Map<String, Object> properties2 = new HashMap<>();
        properties2.put("name", "hello");
        properties2.put("uuid", 13L);
        relationshipObject.setType("hello");
        relationshipObject.setProperties(properties2);
        relationshipObject.setSourceNode(startNodeObject);
        relationshipObject.setTargetNode(endNodeObject);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
//            session.save(startNodeObject);
//            session.save(endNodeObject);
//            session.save(relationshipObject);
            Map<String, Object> map = new HashMap<>();
            map.put("name", "hsf");
            Result result= session.query("match (n) where n.`properties.name`=$name return n", map);
            System.out.println(result.iterator().next().toString());
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            neo4jLogger.info("create nodes and relationships successfully");
            transaction.close();
        }*/
        save();
//        getNodeObject();
//        getRelationshipObject();
//        getSystemInfo();

        /*while(true){
            System.out.println("success");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }*/
    }

    /*@Neo4jTransactional   // Transactional
    public void save(){
        String label = "人物";
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "heshaofeng");
        properties.put("uuid", 15L);
        NodeObject startNodeObject = new NodeObject(-1L, label, properties);
        neo4jRepository.save(startNodeObject);
    }*/

    @Neo4jTransactional   // Transactional
    public void save(){
        String label = "人物";
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "heshaofeng");
        NodeObject nodeObject = new NodeObject(1L, label, properties);
//        graphRepository.save(nodeObject);
        Map<String, Object> properties1 = new HashMap<>();
        properties1.put("name", "hsfeng");
        NodeObject nodeObject1 = new NodeObject(1L, label, properties1);
        String type = "同类";
        Map<String, Object> properties2 = new HashMap<>();
        properties2.put("type", "归类");
        RelationshipObject relationshipObject = new RelationshipObject(1L, type, properties2,nodeObject, nodeObject1);
        List<NodeObject> nodeObjects = new ArrayList<>();
        List<RelationshipObject> relationshipObjects = new ArrayList<>();
        nodeObjects.add(nodeObject);
        nodeObjects.add(nodeObject1);
        relationshipObjects.add(relationshipObject);
//        graphRepository.saveNodeObjects(nodeObjects);
        GraphObject graphObject = new GraphObject(1L, nodeObjects, relationshipObjects);
        neo4jRepository.saveGroupObject(graphObject);
    }

    @Neo4jTransactional   // Transactional
    public void getNodeObject(){
        Iterable<NodeObject> iterable = neo4jRepository.findNodeObjects("人物");
        for(NodeObject nodeObject: iterable){
            System.out.println(nodeObject.toString());
        }

    }

    @Neo4jTransactional   // Transactional
    public void getRelationshipObject(){
        Iterable<RelationshipObject> iterable = neo4jRepository.findRelationshipObjects("hello");
        for(RelationshipObject relationshipObject: iterable){
            System.out.println(relationshipObject.toString());
        }
    }
}
