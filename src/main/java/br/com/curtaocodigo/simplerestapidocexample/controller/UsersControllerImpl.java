package br.com.curtaocodigo.simplerestapidocexample.controller;

import br.com.curtaocodigo.simplerestapidocexample.doc.request.CreateUser;
import br.com.curtaocodigo.simplerestapidocexample.doc.request.PatchUser;
import br.com.curtaocodigo.simplerestapidocexample.model.User;
import br.com.curtaocodigo.simplerestapidocexample.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/users")
public class UsersControllerImpl implements UserController{

	UserRepository userRepository;

	public UsersControllerImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UsersControllerImpl.class, args);
	}

	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.of(userRepository.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long addUser(@RequestBody CreateUser user) {
		return userRepository.save(convertToModel(user)).getId();
	}
	private User convertToModel(CreateUser userCreate) {
		User user = new User(userCreate.getName(),userCreate.getAge(),userCreate.getGroup().toString(),userCreate.getStatus().toString());
		return user;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable( "id" ) Long id, @RequestBody User user) {
		return userRepository.findById(id).map(
				value -> updateUser(value, user))
				.orElseGet(() -> ResponseEntity.of(Optional.empty()));
	}

	@Override
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Void> updateUserInfo(@PathVariable( "id" ) Long id, @RequestBody PatchUser user) {
		return userRepository.findById(id).map(
						value -> updateUserInfo(value, user))
				.orElseGet(() -> ResponseEntity.of(Optional.empty()));
	}

	private ResponseEntity<Void> updateUser(User user, User newUser){
		newUser.setId(user.getId());
		userRepository.save(newUser);
		return ResponseEntity.ok().build();
	}

	private ResponseEntity<Void> updateUserInfo(User user, PatchUser newUser){
		user.setName(newUser.getName());
		user.setAge(newUser.getAge());
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		try{
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (EmptyResultDataAccessException ex){
			return ResponseEntity.notFound().build();
		}
	}

}