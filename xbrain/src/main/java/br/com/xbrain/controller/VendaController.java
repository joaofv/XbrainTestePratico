package br.com.xbrain.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Venda adicionarVenda(@RequestBody Venda venda) {
		return vendaService.adicionarVenda(venda);
	}
	
	@GetMapping
	public List<Object[]> findBetweenDates(@RequestParam String initialDate, @RequestParam  String finalDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		Date initalDateFormat = format.parse(initialDate);
	    Date finalDateFormat = format.parse(finalDate);

	    return (vendaService.findBetweenDates(initalDateFormat, finalDateFormat));
	 }
}
