package br.com.ifomeadaf1rst.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ifomeadaf1rst.dto.EntregadorDTO;
import br.com.ifomeadaf1rst.service.EntregadorService;

@RestController
@Validated
@RequestMapping("/entregador")
public class EntregadorController {
	
	private EntregadorService service;
	
	@PostMapping
	public ResponseEntity<EntregadorDTO> create(@RequestBody @Valid EntregadorDTO entregador){
		
		EntregadorDTO cEntregador = service.create(entregador);
		
		URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cEntregador.getId())
                .toUri();
		return ResponseEntity.created(uri).body(cEntregador);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<EntregadorDTO> get(@PathVariable(name = "id") UUID id) {
		EntregadorDTO rEntregador = service.readById(id);		
        return ResponseEntity.ok(rEntregador);
    }
	
	@GetMapping()
    public ResponseEntity<List<EntregadorDTO>> get() {
		List<EntregadorDTO> rEntregador = service.readAll();		
        return ResponseEntity.ok(rEntregador);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<EntregadorDTO> update(@PathVariable UUID id, @RequestBody EntregadorDTO entregador) {
		EntregadorDTO uEntregador = service.update(entregador, id);
        return ResponseEntity.ok(uEntregador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
    	service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
