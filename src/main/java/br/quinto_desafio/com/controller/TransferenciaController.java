package br.quinto_desafio.com.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.quinto_desafio.com.entity.Transferencia;
import br.quinto_desafio.com.repository.TransferenciaRepository;


@RestController
@CrossOrigin
public class TransferenciaController {
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	@GetMapping("/transferencia")
    public List<Transferencia> getTransferencia(){
		
		//Retorna a lista
		return transferenciaRepository.findAll();
		
	}
	
	@PostMapping("/transferencia")
	@ResponseStatus(HttpStatus.CREATED)
	public Transferencia salvar(@RequestBody Transferencia transferencia) {
		
		//O metado save grava e retorna o valor 
		//gravado
		return transferenciaRepository.save(transferencia);
		
	}
	
	
	@GetMapping("/transferencia/{id}")
	public Transferencia getTransferencia(@PathVariable Long id) {
		
		return transferenciaRepository.findById(id).get();  
		
	}
		
	
	@GetMapping("/transferencia/datatra")
	public List<Transferencia> getaproximardata_transferencia(@RequestParam Date datatra){
		
		return transferenciaRepository.search(datatra);
		
	} 
	
	
	
	@GetMapping("/transferencia/nome_operador_transacao")
	public ResponseEntity<List<Transferencia>> getTransferenciaBynomeoperador(@RequestParam String nome_operador_transacao){
		
		try {
		      
			return new ResponseEntity<List<Transferencia>>(transferenciaRepository.findByNomeoperadortransacao(nome_operador_transacao), HttpStatus.OK);
			
		    } catch (Exception e) {
		    	
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	} 
	
	
	
	@GetMapping("/transferencia/dataEoperador")
	public List<Transferencia> dataEoperador(@RequestParam Date data_transferencia, String nome_operador_transacao){
		
		return transferenciaRepository.search2(data_transferencia, nome_operador_transacao);
		
	} 
	
	
	@GetMapping("/transferencia/Entredata")
	public List<Transferencia> Entredata(@RequestParam Date data_transferencia1, Date data_transferencia2){
		
		return transferenciaRepository.search3(data_transferencia1, data_transferencia2);
		
	} 
	
	
	@GetMapping("/transferencia/soma")
	public float soma(){
		
		return transferenciaRepository.search4();
		
	}
	
	
	
	
	
	
	
	

}











