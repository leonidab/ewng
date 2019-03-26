package com.leonid.eurowings.repository;

import com.leonid.eurowings.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

    public List<User> getUserByUserid(Long userid);

    public List<User> getUserByUsername(String username);

    public List<User> findAll();

    public void deleteUserByUserid(Long userid);

    public void deleteUserByUsername(String username);


}
