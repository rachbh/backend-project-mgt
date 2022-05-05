package pi.polytech.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pi.polytech.entities.Users;
import pi.polytech.repository.UsersRepository;
import pi.polytech.request.UserModel;
import pi.polytech.response.ApiResponse;

@RequestMapping("/users")
@RestController()
public class UsersController {
	@Autowired
	 UsersRepository usersRepository;

	@GetMapping("/list")
	ResponseEntity<?> list() {
		return ResponseEntity.ok(this.usersRepository.findAll());
	}
	@GetMapping("/list1")
	ResponseEntity<?> listExist() {
		return ResponseEntity.ok(this.usersRepository.findByStatus(1));
	}

	@GetMapping("/user/{id}")
	ResponseEntity<?> getUser(@PathVariable long id) {
		return ResponseEntity.ok(this.usersRepository.findById(id).get());
	}

	@PostMapping("/add")
	public ResponseEntity<?> createNewUser(@RequestBody UserModel model) {
		Users u = new Users();
		u.setUsername(model.getUsername());
		u.setPassword(model.getPassword());
		u.setEmail(model.getEmail());
		u.setFirstname(model.getFirstname());
		u.setLastname(model.getLastname());
		u.setAdmin(model.isAdmin());

		u.setStatus(1);
		u.setCreatedAt(new Date());

		// success 200
		return ResponseEntity.ok(this.usersRepository.save(u));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateNewUser(@RequestBody UserModel model, @PathVariable long id) {
		try {
			Users u = this.usersRepository.findById(id).get();
			u.setUsername(model.getUsername());
			u.setPassword(model.getPassword());
			u.setEmail(model.getEmail());
			u.setFirstname(model.getFirstname());
			u.setLastname(model.getLastname());
			u.setAdmin(model.isAdmin());
			u.setStatus(model.getStatus());
			
			u.setStatus(model.getStatus());
			u.setUpdatedAt(new Date());
			// success 200
			return ResponseEntity.ok(this.usersRepository.save(u));
		} catch (Exception e) {
			return ResponseEntity.notFound().build().ok("Not Found");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser( @PathVariable long id) {
		try {
			Users u = this.usersRepository.findById(id).get();
			this.usersRepository.delete(u);
			ApiResponse res =new ApiResponse();
			res.setSuccess(true);
			res.setMessage("Success");		
			
			// success 200
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			return ResponseEntity.notFound().build().ok("Not Found");
		}
		

	}

}
