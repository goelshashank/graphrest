package config.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.crypto.Data;

import model.DataOut;
import model.ExecuteSQLScript;
import model.JPAUtil;
import model.Relationship;
import model.RelationshipRepository;
import model.ShortestPath;
import model.User;
import model.UserRepository;

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

        List<User> userList = userRepository.findAllUsers();


        int listInt[][] = new int[userList.size()][];
       // Arrays.fill(listInt, Integer.MAX_VALUE.);
        for (int i = 0; i < listInt.length; i++) {
            listInt[i][0] = 0;
        }
        List<Long> userIdList=new ArrayList<>();
        for (User user : userList) {
            userIdList.add(user.getUserid());
            List<Relationship> relationshipList = relationshipRepository.getAllOutGoingRelations(
                    user.getUserid());
            for (Relationship relationship : relationshipList) {
                listInt[user.getUserid().intValue()][relationship.getFromuserid().intValue()] = 1;
            }
        }
        ShortestPath shortestPath= new ShortestPath();
        DataOut dataOut= shortestPath.findShortest(listInt, userIdList.indexOf(fromuserid
                .intValue()));
        List<User> userList1 = new ArrayList<>();
      /*  for (Long userId : userIds) {
            userList1.add(userRepository.findOne(userId));
        }*/
        System.out.println(dataOut.getDist());
        return userList1;

    }


    @RequestMapping(value = "/deleteAndRecreateSQLTestData", method = RequestMethod.GET)
    public String deleteAndRecreateSQLTestData() {

        ExecuteSQLScript.executeScript();
        return "success";
    }
/*


    private int[][] toArray(Integer[][] integersList) {
        int intArray[][] = new int[integersList.length][];
        int i = 0, j;
        for (Integer[] integrList : integersList) {
            j = 0;
            for (Integer integer : integrList) {
                intArray[i][j] = integer.intValue();
                j++;
            }
            i++;
        }
        return intArray;
    }
*/


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


}