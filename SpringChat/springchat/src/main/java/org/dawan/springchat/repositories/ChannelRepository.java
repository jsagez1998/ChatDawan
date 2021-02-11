package org.dawan.springchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.dawan.springchat.entities.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

	@Query(value = "FROM Channel c WHERE c.name = :name")
    List<Channel> findChannelByName(@Param("name") String name);
	
	@Query(value = "FROM Channel c WHERE c.id = :id")
    Channel findAllById(@Param("id") long id);
	
	@Query(value="FROM Channel c JOIN FETCH c.chanTheme t WHERE t.id = :themeId")
	List<Channel> findByTheme(@Param("themeId") long themeId);
}
