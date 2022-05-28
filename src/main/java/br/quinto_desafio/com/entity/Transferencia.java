package br.quinto_desafio.com.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.NonNull;

@Table(name="transferencia")
@Entity
public class Transferencia {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//@CreationTimestamp
	//@DateTimeFormat(pattern = "dd/MM/YYYY HH:mm:ss")
	@NonNull
	@Column(name="data_transferencia")
	private Timestamp  datatransferencia;
	
	@NonNull
	private BigDecimal valor; 
	
	@NonNull
	private String tipo;
	
	@Column(name="nome_operador_transacao")
	@NonNull
	private String nomeoperadortransacao;
	
	@NonNull
	private Integer conta_id; 
	
    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
	
	public Timestamp getDatatransferencia() {
		return datatransferencia;
	}
	
	public void setDatatransferencia(Timestamp datatransferencia) {
		this.datatransferencia = datatransferencia;
	}

	
	//A anotação @PrePersist é usada para especificar 
	//um método de retorno de chamada que é acionado 
	//antes que uma entidade seja persistida.
	
	//@PreUpdate: executa método anotado 
	//antes da entidade ser atualizada;
	
	@PrePersist
	@PreUpdate
	    public void pricePrecisionConvertion() {
	        // converta sua escala decimal grande para 2 aqui
	        this.valor.setScale(2, RoundingMode.HALF_UP);
	} 

	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNomeoperadortransacao() {
		return nomeoperadortransacao;
	}


	public void setNomeoperadortransacao(String nomeoperadortransacao) {
		this.nomeoperadortransacao = nomeoperadortransacao;
	}


	public Integer getConta_id() {
		return conta_id;
	}


	public void setConta_id(Integer conta_id) {
		this.conta_id = conta_id;
	}
 

    
	

}
