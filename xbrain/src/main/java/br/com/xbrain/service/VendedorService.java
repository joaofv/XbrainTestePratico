package br.com.xbrain.service;

import org.springframework.stereotype.Service;

import br.com.xbrain.model.Vendedor;
import br.com.xbrain.repository.VendedorRepository;

@Service
public class VendedorService {

	private final VendedorRepository vendedorRepository;
	
	public VendedorService(final VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	public Vendedor adicionarVendedor(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
}
