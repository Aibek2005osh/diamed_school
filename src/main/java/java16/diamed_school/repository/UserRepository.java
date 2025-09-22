package java16.diamed_school.repository;

import java16.diamed_school.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    default User findByEmailException(String email) {
        return findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

    }
}
