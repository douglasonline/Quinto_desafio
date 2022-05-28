package br.quinto_desafio.com.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.quinto_desafio.com.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	
	
	
	 @Query(value = "Select * from transferencia where data_transferencia like %:data_transferencia%", nativeQuery = true)
	 public List<Transferencia> search(Date data_transferencia);
	
	 //List<Transferencia> findByNomeoperadortransacaoContainingIgnoreCase(String nomeoperadortransacao);
	
	 List<Transferencia> findByNomeoperadortransacao(String nomeoperadortransacao);
	 
	 @Query(value = "Select * from transferencia where data_transferencia like %:data_transferencia% AND nome_operador_transacao= :nomeoperadortransacao", nativeQuery = true)
	 public List<Transferencia> search2(Date data_transferencia, String nomeoperadortransacao);
	  
	 @Query(value = "SELECT * FROM transferencia WHERE TRUNC(data_transferencia) BETWEEN :data_transferencia1 AND :data_transferencia2", nativeQuery = true)
	 public List<Transferencia> search3(Date data_transferencia1, Date data_transferencia2);
	 
	 @Query(value = "SELECT SUM(valor) FROM transferencia WHERE tipo='DEPOSITO'", nativeQuery = true)
	 public float search4();
	 
	 
	

	 
	 
}



















