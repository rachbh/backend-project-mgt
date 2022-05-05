package pi.polytech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.polytech.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findByStatus(int status);
}
