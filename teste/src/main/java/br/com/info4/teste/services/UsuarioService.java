package br.com.info4.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.info4.teste.domain.Usuario;
import br.com.info4.teste.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
		if(usuarioOpt.isEmpty()) {
			return null;
		}else {
			return usuarioOpt.get();
		}
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		if(usuario != null) {
			return usuario;
		}else {
			return null;
		}
	}

	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente != null) {
			usuarioExistente.setNome(usuario.getNome());
			usuarioExistente.setSobrenome(usuario.getSobrenome());
			usuarioExistente.setEmail(usuario.getEmail());
			usuarioExistente.setSenha(usuario.getSenha());
			return usuarioRepository.save(usuarioExistente);
		} else {
			return null;
		}

	}

	public boolean excluirUsuario(Long id) {
	    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
	    if (usuarioOptional.isPresent()) {
	        usuarioRepository.deleteById(id);
	        return true;
	    } else {
	        return false;
	    }
	}

}
