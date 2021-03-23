package co.mz.ibi.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import co.mz.ibi.challenge.model.Pais;
import co.mz.ibi.challenge.repository.PaisRepository;
import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/api")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
		
	@PostMapping(value="/create", headers = "Accept=application/json")
    	public ResponseEntity<?> Save(@Valid @RequestBody Pais pais) throws Exception{
		paisRepository.save(pais);
		return new ResponseEntity<>("Criado com sucesso", HttpStatus.OK);	
	}
	
	@PostMapping(value="/update", headers = "Accept=application/json")
    	public ResponseEntity<?> Update(@Valid @RequestBody Pais pais) throws Exception{
		paisRepository.updatePais(pais.getNome(),pais.getCapital(),pais.getRegiao(),pais.getSubRegiao() , pais.getArea(), pais.getIdentificador());
		return new ResponseEntity<>("Criado com sucesso", HttpStatus.OK);	
	}
	
	@GetMapping("/find/{identificador}")
	public Pais find(@PathVariable Long identificador) {
		return paisRepository.findByIdentificador(identificador);
	}
	
	@RequestMapping(value = "/delete/{identificador}")
	public ResponseEntity<?> delete(@PathVariable Long identificador) throws Exception {
		paisRepository.deletePais(identificador);
		return new ResponseEntity<>("Eliminado com Sucesso", HttpStatus.OK);
	}	
	
	@GetMapping("/all")
	public List<Pais> findAll(){	
		return paisRepository.findAll();		
	}
	
	@GetMapping("/allOrderBy/{sort}")
	public List<Pais> findAllOrderBy(@PathVariable String sort){
		return paisRepository.findAllSortBy(Sort.by(Sort.Direction.ASC, sort));		
	}

}
