package com.devsuperior.dsclient.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsclient.dto.ClientDTO;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {	
		List<ClientDTO> list = new ArrayList<>();
		return ResponseEntity.ok().body(list);
	}

}
