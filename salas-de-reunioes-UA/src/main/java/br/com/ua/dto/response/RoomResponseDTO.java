package br.com.ua.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponseDTO {

	private Long id;

	private String name;

	private String data;

	private String starHour;

	private String endHour;
	
	private String description;
	
}
