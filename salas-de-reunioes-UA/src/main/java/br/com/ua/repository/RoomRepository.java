package br.com.ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ua.model.Room;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
