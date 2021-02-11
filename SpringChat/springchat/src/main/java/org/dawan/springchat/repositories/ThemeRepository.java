package org.dawan.springchat.repositories;

import java.util.Optional;

import org.dawan.springchat.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

	@Query(value = "FROM theme t WHERE t.name = :name")
	Optional<Theme> findByName(@Param("name") String name);
	
	@Query(value = "FROM theme t WHERE t.id = :id")
	Optional<Theme> findById(@Param("id") long id);
	
}
