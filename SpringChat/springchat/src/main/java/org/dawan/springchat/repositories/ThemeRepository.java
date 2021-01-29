package org.dawan.springchat.repositories;

import java.util.List;

import org.dawan.springchat.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

	@Query(value = "FROM theme t WHERE t.name = :name")
    List<Theme> findAllByName(@Param("name") String searchedName);
	
	@Query(value = "FROM theme t WHERE t.id = :id")
    Theme findThemeById(@Param("id") long id);
	
}
