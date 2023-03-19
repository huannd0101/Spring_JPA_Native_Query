package com.hit.demojpa.repository;

import com.hit.demojpa.dto.UserDto;
import com.hit.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(nativeQuery = true)
  UserDto findByUsername(String username);

}
