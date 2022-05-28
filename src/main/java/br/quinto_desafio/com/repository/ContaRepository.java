package br.quinto_desafio.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.quinto_desafio.com.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
