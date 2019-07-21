package com.mins.neo4j.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.annotation.Transactional;

public @interface Neo4jTransactional {
    @AliasFor(annotation = Transactional.class)
    String value() default "";
}
