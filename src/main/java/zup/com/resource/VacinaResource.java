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

import zup.com.service.VacinaService;
import zup.com.domain.Vacina;

@RestController
@RequestMapping("/vacinas")
public class VacinaResource {
	
	@Autowired
	private VacinaService vacinaService;
	
	@GetMapping
	public List<Vacina> getVacina(){
		return vacinaService.listarVacina();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vacina> getVacina(@PathVariable Long id){
		Optional<Vacina> vacina = vacinaService.listarVacina(id);
		
		if(vacina.isPresent())
			return ResponseEntity.ok(vacina.get()); // 200 OK
		
		return ResponseEntity.notFound().build(); // 404 NOT FOUND
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vacina setVacina(@RequestBody Vacina vacina) {
		return vacinaService.salvar(vacina);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vacina> updateVacina(@PathVariable Long id,
			@RequestBody Vacina vacina) {
		
		if(vacinaService.listarVacina(id).isPresent()) {
			vacina.setId(id);
			return ResponseEntity.ok(vacinaService.atualizar(vacina)); // 200 OK
		}
		
		return ResponseEntity.notFound().build(); // 404 NOT FOUND
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVacina(@PathVariable Long id){
		if(vacinaService.listarVacina(id).isPresent()) {
			vacinaService.excluir(id);
			return ResponseEntity.noContent().build(); // 204 NO CONTENT
		}
		
		return ResponseEntity.notFound().build(); // 404 NOT FOUND
	}
}
