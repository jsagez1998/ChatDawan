package org.dawan.springchat.repositories;

import java.util.List;

import org.dawan.springchat.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "FROM user u WHERE u.name = :name")
    List<User> findAllByName(@Param("name") String searchedName);
	
	@Query(value = "FROM user u WHERE u.id = :id")
    User findUserById(@Param("id") long id);
	
	@Query(value = "FROM user u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);
}