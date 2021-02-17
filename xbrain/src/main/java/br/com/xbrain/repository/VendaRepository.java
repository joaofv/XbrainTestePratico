package br.com.xbrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xbrain.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository <Venda, Long> {

}
