package model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public static final String GET_ALL = "select  * from " + "users";

    @Query(value = GET_ALL, nativeQuery = true)
    public List<User> findAllUsers();

    public List<User> findAll();
}