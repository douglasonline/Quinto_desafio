package br.quinto_desafio.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.quinto_desafio.com.entity.Conta;
import br.quinto_desafio.com.repository.ContaRepository;


@RestController
public class ContaController {
	
	@Autowired
	ContaRepository contaRepository;

	@GetMapping("/conta")
    public List<Conta> getConta(){
		
		//Retorna a lista
		return contaRepository.findAll();
		
	}
	
	@PostMapping("/conta")
	@ResponseStatus(HttpStatus.CREATED)
	public Conta salvar(@RequestBody Conta conta) {
		
		//O metado save grava e retorna o valor 
		//gravado
		return contaRepository.save(conta);
		
	}
	
	@GetMapping("/conta/{id}")
	public Conta getConta(@PathVariable Long id) {
		
		return contaRepository.findById(id).get();  
		
	}
	
	
	@DeleteMapping("/conta/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long codigo) {
		
		contaRepository.deleteById(codigo);
		
	}

}
