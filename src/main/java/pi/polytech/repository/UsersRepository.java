package pi.polytech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.polytech.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	List<Users> findByStatus(int status);
}
