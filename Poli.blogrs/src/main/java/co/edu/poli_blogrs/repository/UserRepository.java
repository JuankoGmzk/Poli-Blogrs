package co.edu.poli.blogrs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.blogrs.models.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
	
	UserModel findByUsername(String instcode);

}
