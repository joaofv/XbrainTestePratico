package br.com.xbrain.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.xbrain.model.Venda;
import br.com.xbrain.repository.VendaRepository;

@Service
public class VendaService {

	private final VendaRepository vendaRepository;
	
	public VendaService (final VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}
	
	public String adicionarVenda(Venda venda) {
		vendaRepository.save(venda);
		return "Venda realizada com sucesso!";
	}
	

    public List<Object[]> findBetweenDates(Date initialDate, Date finalDate){
        return (vendaRepository.findBetweenDates(initialDate, finalDate));
    }
}
