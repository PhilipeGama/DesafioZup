package zup.com.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zup.com.domain.Usuario;
import zup.com.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

		@Autowired
		UsuarioService usuarioService;
		
		@GetMapping
		public List<Usuario> getUsuarios(){
			return usuarioService.listarUsuario();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
			Optional<Usuario> usuario = usuarioService.listarUsuario(id);
			
			if(usuario.isPresent())
				return ResponseEntity.ok(usuario.get()); // 200 OK
			
			return ResponseEntity.notFound().build(); // 404 NOT FOUND
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Usuario setUsuario(@RequestBody Usuario usuario) {
			return usuarioService.salvar(usuario);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,
				@RequestBody Usuario usuario) {
			
			if(usuarioService.listarUsuario(id).isPresent()) {
				usuario.setId(id);
				return ResponseEntity.ok(usuarioService.atualizar(usuario)); // 200 OK
			}
			
			return ResponseEntity.notFound().build(); // 404 NOT FOUND
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
			if(usuarioService.listarUsuario(id).isPresent()) {
				usuarioService.excluir(id);
				return ResponseEntity.noContent().build(); // 204 NO CONTENT
			}
			
			return ResponseEntity.notFound().build(); // 404 NOT FOUND
		}
		
	}


