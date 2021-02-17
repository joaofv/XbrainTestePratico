package br.com.xbrain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.xbrain.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository <Venda, Long> {

	 @Query(value = "SELECT CONCAT('Nome: ', VENDEDOR_NOME),"
	 					+ "	CONCAT('Total Vendas: ', COUNT(VENDA_VENDEDOR)),"
	 					+ "	CONCAT('Soma Total Vendas: R$', SUM(VENDA_VALOR)),"
	 					+ "	CONCAT('Media Vendas Diária(Quantidade): ', COUNT(VENDA_VENDEDOR)/DATEDIFF(day,:initialDate,:finalDate)),"
	 					+ " CONCAT('Media Vendas Diária(Valor): R$', SUM(VENDA_VALOR)/COUNT(VENDA_VENDEDOR)),"
	 					+ " FROM VENDA, VENDEDOR WHERE VENDA_DATA BETWEEN :initialDate AND :finalDate AND VENDEDOR_ID = VENDA_VENDEDOR GROUP BY VENDEDOR_ID", nativeQuery = true)
	 List<Object[]> findBetweenDates(@PathVariable(value = "initialDate") Date initialDate, @PathVariable(value = "finalDate") Date finalDate);
}
