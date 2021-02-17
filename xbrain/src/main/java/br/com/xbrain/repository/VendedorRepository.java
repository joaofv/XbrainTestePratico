package br.com.xbrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xbrain.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository <Vendedor, Long> {

}
