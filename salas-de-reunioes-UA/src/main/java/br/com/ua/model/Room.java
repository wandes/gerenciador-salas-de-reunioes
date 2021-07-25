package br.com.ua.model;

import java.util.Comparator;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meetingroom")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room implements Comparator<Room>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 100, min = 2)
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String data;

	@Column(nullable = false)
	private String starHour;

	@Column(nullable = false)
	private String endHour;

	@Column(nullable = false)
	private String description;

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", data=" + data + ", starHour=" + starHour + ", endHour="
				+ endHour + ", description=" + description + "]";
	}

	@Override
	public int compare(Room o1, Room o2) {
		//int compare =		
		return o1.data.compareTo(o2.data);
	}	
	
}
