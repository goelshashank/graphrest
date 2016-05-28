package config.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.validation.Valid;

/**
 * Created by prashant on 2/5/16.
 */


@org.springframework.web.bind.annotation.RestController
@ComponentScan(basePackages = "model")
public class RestAPIController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    @Autowired
    private JPAUtil jpaUtil;

    private static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);

    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public Long createUser(@RequestParam(value = "name") String name, @RequestParam(value =
            "age") String age, @RequestParam(value =
            "sex") String sex, @RequestParam(value =
            "location") String location) {

        User user = new User(name, age, sex, location);
        user = userRepository.save(user);

        logger.info("user saved , id-", user.getUserid());

        return user.getUserid();
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getAllRelationships", method = RequestMethod.GET)
    public List<Relationship> getAllRelationships() {
        return relationshipRepository.findAll();
    }

    @RequestMapping(value = "/createrelationship", method = RequestMethod.GET)
    public Long createRelationship(@RequestParam(value = "fromuserid") Long fromuserid,
                                   @RequestParam(value = "touserid") Long touserid,
                                   @RequestParam(value = "relation") String relation) {

        Relationship relationship = new Relationship(fromuserid, touserid, relation);
        relationship = relationshipRepository.save(relationship);

        logger.info("relationship saved , id-", relationship.getEdgeid());

        return relationship.getEdgeid();
    }


    @RequestMapping(value = "/findShortestPathOfRelationship", method = RequestMethod.GET)
    public List<User> findShortestPathOfRelationship(@RequestParam(value = "fromuserid") Long
                                                             fromuserid, @RequestParam(value = "touserid") Long touserid) {


        //  toArray();
    /*    int graph[][] = new int[][]{{0, 4, Integer.MAX_VALUE, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        */

        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            user.getUserid()
        }


        List<List<Integer>> list = new ArrayList<>();


        List<Relationship> relationshipList = relationshipRepository.getAllOutGoingRelations
                (fromuserid);


        List<Long> userIds = ShortestPath.findShortest(graph);
        return userRepository.findAll(userIds);
    }

    private Integer[][] toArray(List<List<Integer>> list) {
        Integer[][] matrix = new Integer[list.size()][];
        return (Integer[][]) list.toArray();

    }


}