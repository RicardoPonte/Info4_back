package br.com.info4.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.info4.teste.domain.Usuario;
import br.com.info4.teste.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping(value = "/criar")
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuario));
	}
	
	@GetMapping(value = "/todos")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuarios());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarUsuarioPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarUsuarioPorEmail(email));
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(id, usuario));
	}

	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<String> deleteLogico(@PathVariable Long id) {
		boolean delete = usuarioService.excluirUsuario(id);
		if(delete) {
			return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado!");
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
