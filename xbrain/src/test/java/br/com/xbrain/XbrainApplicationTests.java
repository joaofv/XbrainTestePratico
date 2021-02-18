package br.com.xbrain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.xbrain.model.Venda;
import br.com.xbrain.model.Vendedor;
import br.com.xbrain.repository.VendaRepository;
import br.com.xbrain.repository.VendedorRepository;
import br.com.xbrain.service.VendaService;
import br.com.xbrain.service.VendedorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XbrainApplicationTests {

	@MockBean
	private VendaRepository vendaRepository;
	
	@Test
	public void adicionarVendaTest() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
		Date dataFormatada = format.parse("03-10-2020");
		VendaService vendaService = new VendaService(vendaRepository);
		Venda venda = new Venda(1L, 400.00, dataFormatada, new Vendedor(1L, "João"));
		
		when(vendaRepository.save(venda)).thenReturn(venda);
		assertEquals(venda,vendaService.adicionarVenda(venda));
	}
	
	@MockBean
	private VendedorRepository vendedorRepository;
	
	@Test
	public void adicionarVendedorTest() throws ParseException {
		VendedorService vendedorService = new VendedorService(vendedorRepository);
		Vendedor vendedor = new Vendedor(1L, "João");
		
		when(vendedorRepository.save(vendedor)).thenReturn(vendedor);
		assertEquals(vendedor,vendedorService.adicionarVendedor(vendedor));
	}
}
