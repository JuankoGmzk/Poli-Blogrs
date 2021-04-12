package co.edu.poli.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.poli.mongodb.model.News;

public interface NewsRepository extends MongoRepository<News, String>{

	@Query(value ="{'name' : /.*?0.*/ ,  'capital' : /.*?1.*/ }")
	List<News> findCountriesQ1(String name, String capital);
		
	@Query("{ 'capital' : /.*?0.*/ }")
	List<News> findCountriesQT(String capital);
	
	@Query("{ 'latlng': { $in: [ 20, 40, 60 ] } }")  //CHECK SECOND
	List<News> findCountriesQ2();
	
	@Query(value ="{ 'timezones' : /.*?0.*/}", fields="{'capital' : 1,  'id' : 0}")
	List<News> findCountriesQ3(String timezones);

	//fields="{'capital' : 1, 'timezones' : 1, 'id' : 0}")
}