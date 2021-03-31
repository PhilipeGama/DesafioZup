package zup.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zup.com.domain.Usuario;
import zup.com.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public List<Usuario> listarUsuario(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> listarUsuario(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Usuario salvar(Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}
	
	public Usuario atualizar(Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}
	
	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
	

	
	
}