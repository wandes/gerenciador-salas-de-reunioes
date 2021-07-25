package br.com.ua.service;

import java.util.List;

import br.com.ua.dto.request.RoomRequestDTO;
import br.com.ua.dto.response.RoomResponseDTO;
import br.com.ua.exception.ResourceNotFoundException;

public interface RoomService {

	List<RoomResponseDTO> listAll() throws ResourceNotFoundException;

	RoomResponseDTO findById(Long Id) throws ResourceNotFoundException;

	RoomResponseDTO create(RoomRequestDTO room) throws ResourceNotFoundException;

	RoomResponseDTO update(RoomRequestDTO room, Long Id) throws ResourceNotFoundException;

	void delete(Long id) throws ResourceNotFoundException;
}
