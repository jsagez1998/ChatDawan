package org.dawan.springchat.repositories;

import java.util.List;

import org.dawan.springchat.entities.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

	@Query(value = "FROM friends f WHERE f.user_id_id = :id")
    List<Friends> findByUserId(@Param("id") long id);
}
