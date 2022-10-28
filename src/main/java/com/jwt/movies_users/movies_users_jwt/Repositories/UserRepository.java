package com.jwt.movies_users.movies_users_jwt.Repositories;


import com.jwt.movies_users.movies_users_jwt.Models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}
