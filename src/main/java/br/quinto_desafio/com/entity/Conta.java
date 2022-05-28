package br.quinto_desafio.com.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NonNull;

@Table(name="conta")
@Entity
public class Conta {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long id_conta;
	
	@NonNull
	private String nome_responsavel;
	
	//O OrphanRemoval marca entidades "filhas" 
	//para serem excluídas quando não tem qualquer 
	//outro vinculo com uma entidade pai, por exemplo, 
	//quando você tem um carro em uma lista de carros 
	//relacionados a um concessionária.
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) 
    @JoinColumn(name = "conta_id") 
	private List<Transferencia> transferencia = new ArrayList<>(); 
	
	public Long getId_conta() {
		return id_conta;
	}
	
	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	} 
	
    public List<Transferencia> getTransferencia() {
		return transferencia;
	}
    
    public void setTransferencia(List<Transferencia> transferencia) {
		this.transferencia = transferencia;
	}
	

}
