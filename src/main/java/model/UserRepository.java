package model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> {


    public List<User> findAll ();

    public List<User> findAll (List<Long> ids);
}