package br.com.xbrain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.xbrain.model.Vendedor;
import br.com.xbrain.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	private final VendedorService vendedorService;
	
	public VendedorController (final VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor adicionarVendedor(@RequestBody Vendedor vendedor) {
		return vendedorService.adicionarVendedor(vendedor);
	}
}
