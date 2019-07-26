package vn.com.minori.repository.user;

import org.springframework.stereotype.Repository;
import vn.com.minori.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
