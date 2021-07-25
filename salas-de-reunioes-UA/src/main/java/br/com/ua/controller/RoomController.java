package br.com.ua.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ua.dto.request.RoomRequestDTO;
import br.com.ua.dto.response.RoomResponseDTO;
import br.com.ua.exception.ResourceNotFoundException;
import br.com.ua.service.RoomServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1/room")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Room Controller")
@Log4j2
public class RoomController {

	private RoomServiceImpl roomService;

	@ApiOperation(value = "Cria uma sala")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sala criado com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<RoomResponseDTO> create(@RequestBody @Valid RoomRequestDTO roomRequest) {

		RoomResponseDTO response = roomService.create(roomRequest);

		URI locationResource = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(response.getId()).toUri();

		log.info("Sucesso ao criar sala com ID " + response.getId());

		return ResponseEntity.created(locationResource).body(response);

	}

	@ApiOperation(value = "Retorna uma lista de salas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista retornada com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })

	// @RequestMapping(method = RequestMethod.GET, produces="application/json",
	// consumes="application/json")
	@GetMapping
	public ResponseEntity<List<RoomResponseDTO>> listAll() {

		log.info("Listando salas");

		return ResponseEntity.ok(roomService.listAll());
	}

	@ApiOperation(value = "Pesquisa uma sala")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sala retornado com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ResponseEntity<RoomResponseDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {
		log.info("Localizando sala por Id" + id);
		return ResponseEntity.ok().body(roomService.findById(id));

	}

	@ApiOperation(value = "Exclui uma sala")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Solicitação de exclusão processada pelo servidor mas sem resposta"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })

	//@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) throws ResourceNotFoundException {

		roomService.delete(id);
		log.info("Sucesso em excluir sala de Id" + id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza os dados de uma sala")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sala atualizada com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ResponseEntity<RoomResponseDTO> update(@PathVariable String id, @RequestBody @Valid RoomRequestDTO roomDTO)
			throws ResourceNotFoundException {

		RoomResponseDTO heroUpdate = roomService.update(roomDTO, Long.parseLong(id));
		log.info("Sucesso em atualizar sala de Id" + id);
		return ResponseEntity.ok(heroUpdate);
	}

}
