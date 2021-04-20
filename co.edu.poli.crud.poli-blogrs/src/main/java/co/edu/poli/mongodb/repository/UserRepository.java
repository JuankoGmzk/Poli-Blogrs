package co.edu.poli.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.mongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUserName(String userName);
}