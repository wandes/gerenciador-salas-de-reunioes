package br.com.ua.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ua.dto.mapper.RoomMapper;
import br.com.ua.dto.request.RoomRequestDTO;
import br.com.ua.dto.response.RoomResponseDTO;
import br.com.ua.exception.ResourceNotFoundException;
import br.com.ua.model.Room;
import br.com.ua.repository.RoomRepository;
import br.com.ua.service.impl.RoomService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomServiceImpl implements RoomService {

	private RoomRepository roomRepository;

	private RoomMapper roomMapper;

	public List<RoomResponseDTO> listAll() {

		List<Room> rooms = roomRepository.findAll();

		Collections.sort(rooms, new Comparator<Room>() {
			@Override
			public int compare(Room o1, Room o2) {
				return o2.getData().compareTo(o1.getData());
			}
		});

		// Comparator<Room> rooms = (Room o1, Room o2)->o2.getData().compareTo(o1.getData());

		return rooms.stream().map(roomMapper::toDTO).collect(Collectors.toList());

	}

	public RoomResponseDTO findById(Long id) throws ResourceNotFoundException {

		Room room = verifyIfExists(id);
		RoomResponseDTO response = roomMapper.toDTO(room);
		return response;
	}

	@Override
	public RoomResponseDTO create(RoomRequestDTO room) {

		Room roomToSave = roomMapper.toModel(room);

		return roomMapper.toDTO(roomRepository.save(roomToSave));
	}

	@Override
	public RoomResponseDTO update(RoomRequestDTO room, Long id) throws ResourceNotFoundException {

		verifyIfExists(id);

		Room roomToUpdate = roomMapper.toModel(room);
		System.out.println(roomToUpdate);
		return roomMapper.toDTO(roomRepository.save(roomToUpdate));
	}

	public void delete(Long id) throws ResourceNotFoundException {

		verifyIfExists(id);

		roomRepository.deleteById(id);
	}

	private Room verifyIfExists(Long id) throws ResourceNotFoundException {

		return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
