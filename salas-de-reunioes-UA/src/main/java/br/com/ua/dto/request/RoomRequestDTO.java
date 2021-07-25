package br.com.ua.dto.request;

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
public class RoomRequestDTO {
	
	private Long id;
	
	private String name;
	
	private String data;
	
	private String starHour;

	private String endHour;
	
	private String description;
	
}
