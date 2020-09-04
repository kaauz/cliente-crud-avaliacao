package br.com.tokiomarine.controller;

import br.com.tokiomarine.service.ClienteTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.tokiomarine.domain.Cliente;
import br.com.tokiomarine.repository.ClienteRepository;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteTransactionService clienteTransactionService;

	@GetMapping()
	public Iterable<Cliente> listarClientes() {
		return clienteTransactionService.listaClientes();
	}

	@PostMapping(path = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente adicionaCliente(@RequestBody final Cliente cliente) {
		return clienteTransactionService.salvaOuAtualizaCliente(cliente);
	}

	@DeleteMapping(path = "delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deletaCliente(@PathVariable final Long id) {
		if (clienteTransactionService.deletaClientePorId(id)) {
			return "Cliente com id " + id + " deletado com sucesso";
		}

		return "";
	}

}
