package org.dawan.springchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.dawan.springchat.entities.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
