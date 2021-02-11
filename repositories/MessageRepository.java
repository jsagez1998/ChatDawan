package org.dawan.springchat.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.dawan.springchat.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query(value = "FROM message m WHERE m.date = :date")
    List<Message> findMessageByDate(@Param("date") LocalDateTime date);
	
	@Query(value = "FROM message m WHERE m.id = :id")
    Message findMessageById(@Param("id") long id);
}