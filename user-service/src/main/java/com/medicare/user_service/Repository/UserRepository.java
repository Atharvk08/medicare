package com.medicare.user_service.Repository;

import com.medicare.user_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    String findByEmail(String email);
}
