package zup.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zup.com.domain.Vacina;
import zup.com.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository vacinaRepository;
	
	public List<Vacina> listarVacina(){
		return vacinaRepository.findAll();
	}
	
	public Optional<Vacina> listarVacina(Long id){
		return vacinaRepository.findById(id);
	}
	
	public Vacina salvar(Vacina vacina) {
		return vacinaRepository.save(vacina);
	}
	
	public Vacina atualizar(Vacina vacina) {
		return vacinaRepository.save(vacina);
	}
	
	public void excluir(Long id) {
		vacinaRepository.deleteById(id);
	}
	
}
