package model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shashank on 28/5/16.
 */
@Repository
public interface RelationshipRepository extends CrudRepository<Relationship, Long> {


    public static final String GET_ALL_RELATIONSHIPS = "select  edgeid from " +
            "relationships";


    public static final String GET_ALL_OUTGOING_RELATIONS = "select * from " +
            "relationships r where " + "r.fromuserid=:fromuseridVal";


    @Query(value = GET_ALL_RELATIONSHIPS, nativeQuery = true)
    public List<Long> getAllRelationships();


    public List<Relationship> findAll();


    @Query(value = GET_ALL_OUTGOING_RELATIONS, nativeQuery = true)
    public List<Relationship> getAllOutGoingRelations(@Param("fromuseridVal") Long fromuseridVal);


}
