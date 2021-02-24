package org.dawan.springchat.repositories;

import java.util.List;

import org.dawan.springchat.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(value = "FROM Users u WHERE u.username = :name")
    List<Users> findByName(@Param("name") String searchedName);
	
	@Query(value = "FROM Users u WHERE u.id = :id")
    Users findUserById(@Param("id") long id);
	
	@Query(value = "FROM Users u WHERE u.email = :email")
    Users findUserByEmail(@Param("email") String email);
	
	@Query(value = "FROM Users u JOIN FETCH u.themes t WHERE t.name = :themeName")
	List<Users> findByTheme(@Param("themeName") String theme);

	@Query(value = "FROM Users u WHERE u.departement = :place")
	List<Users> findByPlace(@Param("place") String place);
	
	@Query(value = "FROM Users u WHERE u.username = :name")
    Users getUserByUsername(@Param("name") String name);
}