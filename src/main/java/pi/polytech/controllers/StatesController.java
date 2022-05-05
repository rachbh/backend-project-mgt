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

import pi.polytech.entities.States;
import pi.polytech.repository.StatesRepository;
import pi.polytech.request.StateModel;
import pi.polytech.response.ApiResponse;

@RequestMapping("/states")
@RestController()
public class StatesController {

	@Autowired
	private StatesRepository statesRepository;

	@GetMapping("/list")
	ResponseEntity<?> list() {
		return ResponseEntity.ok(this.statesRepository.findAll());
	}
	@GetMapping("/list1")
	ResponseEntity<?> listExist() {
		return ResponseEntity.ok(this.statesRepository.findByStatus(1));
	}
	@GetMapping("/state/{id}")
	ResponseEntity<?> getState( @PathVariable long id) {
		return ResponseEntity.ok(this.statesRepository.findById(id).get());
	}

	@PostMapping("/add")
	public ResponseEntity<?> createNewState(@RequestBody StateModel model) {
		States s = new States();
		s.setName(model.getName());
		s.setDescription(model.getDescription());
		s.setStatus(1);
		s.setCreatedAt(new Date());

		// success 200
		return ResponseEntity.ok(this.statesRepository.save(s));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateNewState(@RequestBody StateModel model, @PathVariable long id) {
		try {
			States s = this.statesRepository.findById(id).get();
			s.setName(model.getName());
			s.setDescription(model.getDescription());
			s.setUpdatedAt(new Date());
			s.setStatus(model.getStatus());
			// success 200
			return ResponseEntity.ok(this.statesRepository.save(s));
		} catch (Exception e) {
			return ResponseEntity.notFound().build().ok("Not Found");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteState( @PathVariable long id) {
		try {
			States s = this.statesRepository.findById(id).get();
			this.statesRepository.delete(s);
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
