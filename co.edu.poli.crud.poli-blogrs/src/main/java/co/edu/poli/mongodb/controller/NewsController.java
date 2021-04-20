package co.edu.poli.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.poli.mongodb.model.News;
import co.edu.poli.mongodb.repository.NewsRepository;
import co.edu.poli.mongodb.model.User;
import co.edu.poli.mongodb.repository.UserRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/PB/")
public class NewsController {

	@Autowired
	NewsRepository newsRepository;
	UserRepository userRepository;
	
	@GetMapping("/View")
	public List<News> getAllNews(){
		return newsRepository.findAll();
	}
	
	@GetMapping("/View/{id}")
	public News getNewsByID(@PathVariable String id) {
		return newsRepository.findById(id).get();
	}
	
	@PostMapping("/Create")
	public News saveNews(@RequestBody News news){
		return newsRepository.save(news);
	}
	
	/*@PostMapping("/CountriesList")
	public List<News> saveListCountries(@RequestBody List<News> countries) {
		return newsRepository.saveAll(countries);
	}*/
	
	@PutMapping("/Edit/{id}")
	public News updateNews(@PathVariable String id, @RequestBody News news) {
		
		News _news = newsRepository.findById(id).get();
		
		_news.setAuthor(news.getAuthor());
		_news.setDate(news.getDate());
		_news.setTitle(news.getTitle());
		_news.setBody(news.getBody());		
		
		newsRepository.save(_news);
		
		return _news;
	}
	
	
	@DeleteMapping("/Delete/{id}")
	public News deleteNewsById(@PathVariable String id) {
		News _news = newsRepository.findById(id).get();
		newsRepository.deleteById(id);
		return _news;
	}
	
	/*@DeleteMapping("/CountriesList")
	public void deleteAll() {
		newsRepository.deleteAll();
	}*/
	
	
	//									//
	//			QUERY'S ACT-MONGO		//
	//									//
	
	//Query	CHECK FIRST
	@GetMapping("/CountriesQ1/{name}/{capital}")
	public List<News> findCountriesQ1(@PathVariable String name, @PathVariable String capital){
		return newsRepository.findCountriesQ1(name, capital);
	}
	
	//Query  CHECK SECOND
	@GetMapping("/CountriesQ2")
	public List<News> findCountriesQ2(){
		return newsRepository.findCountriesQ2();
	}
	
	//Query	CHECK THIRD
	@GetMapping("/CountriesQ3/{timezones}")
	public List<News> findCountriesQ3(@PathVariable String timezones){
		return newsRepository.findCountriesQ3(timezones);
	}

}