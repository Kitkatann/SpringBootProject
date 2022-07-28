package com.software.institute.kathb.springbootdemo;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.actor.ActorRepository;
import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.category.CategoryRepository;
import com.software.institute.kathb.springbootdemo.film.Film;
import com.software.institute.kathb.springbootdemo.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
@RequestMapping("/Sakila")
public class SpringbootdemoApplication {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	public SpringbootdemoApplication(ActorRepository actorRepository, FilmRepository filmRepository){
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
	}


	//@ResponseBody
	@PostMapping("/Add_New_Actor")
	public @ResponseBody String addNewActor(@RequestParam String firstName, @RequestParam String lastName){
		Actor a = new Actor(firstName, lastName);
		System.out.println(firstName + " " + lastName);
		actorRepository.save(a);
		return "saved";
	}

	//Get request / read function
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/Get_Actor_By_Names")
	public @ResponseBody
	Iterable<Actor> getActorByFirstAndLastName(@RequestParam String firstName, @RequestParam String lastName)
	{
		return actorRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@GetMapping("/Get_Film_By_Title")
	public @ResponseBody
	Iterable<Film> getFilmByTitle(@RequestParam String title)
	{
		return filmRepository.findByTitle(title);
	}

	@GetMapping("/Get_Films_By_Category")
	public @ResponseBody
	List<Film> getFilmsByCategory(@RequestParam String categoryName)
	{
		return filmRepository.findByFilmCategoriesName(categoryName);
	}

	@GetMapping("/Get_Films_By_Actor")
	public @ResponseBody
	List<Film> getFilmsByActor(@RequestParam String firstName, @RequestParam String lastName)
	{
		return filmRepository.findByFilmActorsFirstNameAndFilmActorsLastName(firstName, lastName);
	}

	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	@GetMapping("/Get_Category")
	public @ResponseBody
	Category getCategoryByName(@RequestParam String categoryName)
	{
		return categoryRepository.findByName(categoryName);
	}


	@DeleteMapping("/Delete_Actor_By_Id")
	public @ResponseBody
	void deleteActorById(@RequestParam int id){
		actorRepository.deleteById(id);
	}

}
