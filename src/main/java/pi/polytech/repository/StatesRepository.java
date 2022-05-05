package pi.polytech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.polytech.entities.States;

public interface StatesRepository extends JpaRepository<States, Long> {
	List<States> findByStatus(int status);

}
