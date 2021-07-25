package br.com.ua.dto.mapper;

import org.mapstruct.Mapper;

import br.com.ua.dto.request.RoomRequestDTO;
import br.com.ua.dto.response.RoomResponseDTO;
import br.com.ua.model.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
	
	//@Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
	Room toModel(RoomRequestDTO roomRequestDTO);

	//@Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
	RoomResponseDTO toDTO(Room roomDTO);

}
