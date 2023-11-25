package com.ilana.userdp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilana.userdp.entities.User;
import com.ilana.userdp.repositoires.UserRepository;

@RestController
@RequestMapping(value = "/User")
public class UserController {
  
	@Autowired
	private UserRepository repository;
	
	@GetMapping()
	public List<User> findALL() {
		List<User> result = repository.findAll();
		return result;
	}
   
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public User Insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Optional<User> UserOptional = repository.findById(id);
		
		if (UserOptional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			
			
			return ResponseEntity.notFound().build();
		}
	}
}
