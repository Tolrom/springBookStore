package com.tolrom.springlibrary.repository;

import com.tolrom.springlibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserById(Integer id);
}
