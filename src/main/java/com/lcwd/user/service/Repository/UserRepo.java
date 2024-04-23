package com.lcwd.user.service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lcwd.user.service.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
