package br.com.xbrain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.xbrain.model.Venda;
import br.com.xbrain.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	private final VendaService vendaService;
	
	public VendaController(final VendaService vendaService) {
		this.vendaService = vendaService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionarVenda(@RequestBody Venda venda) {
		return vendaService.adicionarVenda(venda);
	}
}
