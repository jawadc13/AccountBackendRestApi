package com.jawad.accBackendRestArray;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class ControllerBackend {


//	@Autowired
//	private JAVAStudentDAO studentDAO = new JAVAStudentDAO() ;
	
	@Autowired
	private UserRepository userRepo;
	
	//Get all users from the Arraylist
	@GetMapping(path="/jpa/getAllUsers")
	public List<User> getAllStudents(){
		return userRepo.findAll();		
	}
	
	//Adding a new user into the classroom
	@PostMapping(path="/jpa/addNewUser")
	public ResponseEntity addNewStudent(@RequestBody User newUser){
		userRepo.save(newUser);
		
		return new ResponseEntity<>("Created new student",HttpStatus.CREATED);
	}
	
	
	//Delete a user
	@DeleteMapping(path="/jpa/deleteUser/{id}")
	public ResponseEntity deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
		
		return new ResponseEntity<>("User is successfully deleted: " + id, HttpStatus.ACCEPTED);
	}
	
	
	//Update 
	@PutMapping(path="/jpa/updateEmail/{id}")
	public ResponseEntity updateEmail(String newEmail, @PathVariable Long id) {
	
		Optional<User> user = userRepo.findById(id);
		user.get().setPassword(newEmail);
		return new ResponseEntity<>("Email has been changed",HttpStatus.CREATED);
}
	
}

