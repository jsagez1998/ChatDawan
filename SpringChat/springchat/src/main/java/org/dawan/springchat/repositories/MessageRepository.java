package org.dawan.springchat.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.dawan.springchat.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query(value = "FROM message m WHERE m.date = :date")
    List<Message> findByDate(@Param("date") LocalDateTime date);
	
	@Query(value = "FROM message m WHERE m.id = :id")
    Optional<Message> findById(@Param("id") long id);
	
	@Query(value = "FROM message m WHERE m.channel_id = :channelId")
	List<Message> findByChannel(@Param("channelId") long channelId);
	
	@Query(value = "FROM message m WHERE m.user_id = :userId")
	List<Message> findByUser(@Param("userId") long userId);
}