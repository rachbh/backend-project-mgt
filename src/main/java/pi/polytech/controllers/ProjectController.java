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

import pi.polytech.entities.Project;
import pi.polytech.repository.ProjectRepository;
import pi.polytech.repository.StatesRepository;
import pi.polytech.repository.UsersRepository;
import pi.polytech.request.ProjectModel;
import pi.polytech.response.ApiResponse;

@RequestMapping("/project")
@RestController
public class ProjectController {
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private StatesRepository statesRepository;

	@GetMapping("/list")
	ResponseEntity<?> list() {
		return ResponseEntity.ok(this.projectRepository.findAll());
	}
	@GetMapping("/list1")
	ResponseEntity<?> listExist() {
		return ResponseEntity.ok(this.projectRepository.findByStatus(1));
	}

	@GetMapping("/project/{id}")
	ResponseEntity<?> getProject(@PathVariable long id) {
		return ResponseEntity.ok(this.projectRepository.findById(id).get());
	}

	@PostMapping("/add")
	ResponseEntity<?> addProject(@RequestBody ProjectModel model) {

		Project p = new Project();

		p.setLabel(model.getLabel());
		p.setDescription(model.getDescription());
		p.setBudget(model.getBudget());
		p.setDateBeginPlanned(model.getDateBeginPlanned());
		p.setDateEndPlanned(model.getDateEndPlanned());
		p.setDateBeginReal(model.getDateBeginReal());
		p.setDateEndReal(model.getDateEndReal());
		p.setStatus(1);
		p.setCreatedAt(new Date());

		// join User/State
		p.setUser(this.usersRepository.findById(model.getUser()).get());
		p.setState(this.statesRepository.findById(model.getState()).get());
		this.projectRepository.save(p);

		return ResponseEntity.ok(this.projectRepository.save(p));
	}

	@PutMapping("/update/{id}")
	ResponseEntity<?> edit(@RequestBody ProjectModel model, @PathVariable Long id) {

		Project p = this.projectRepository.findById(id).get();

		p.setLabel(model.getLabel());
		p.setDescription(model.getDescription());
		p.setBudget(model.getBudget());
		p.setDateBeginPlanned(model.getDateBeginPlanned());
		p.setDateEndPlanned(model.getDateEndPlanned());
		p.setDateBeginReal(model.getDateBeginReal());
		p.setDateEndReal(model.getDateEndReal());
		p.setStatus(model.getStatus());
		p.setUpdatedAt(new Date());

		// join category
		p.setUser(this.usersRepository.findById(model.getUser()).get());
		p.setState(this.statesRepository.findById(model.getState()).get());

		return ResponseEntity.ok(this.projectRepository.save(p));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable long id) {
		try {
		Project p = this.projectRepository.findById(id).get();
			this.projectRepository.delete(p);
			ApiResponse res = new ApiResponse();
			res.setSuccess(true);
			res.setMessage("Success");

			// success 200
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			return ResponseEntity.notFound().build().ok("Not Found");
		}

	}

}
