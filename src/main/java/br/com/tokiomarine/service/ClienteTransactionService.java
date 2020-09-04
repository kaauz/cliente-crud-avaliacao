package br.com.tokiomarine.service;

import br.com.tokiomarine.domain.Cliente;
import br.com.tokiomarine.domain.Endereco;
import br.com.tokiomarine.domain.exception.ClienteNaoEncontradoException;
import br.com.tokiomarine.mapper.ConsultaCEPMapper;
import br.com.tokiomarine.repository.ClienteRepository;
import br.com.tokiomarine.util.InputValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Slf4j
@Service
public class ClienteTransactionService {

    private final String URL_VIA_CEP = "https://viacep.com.br/ws/";

    @Autowired
    ClienteRepository clienteRepository;

    public Iterable<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente salvaOuAtualizaCliente(Cliente cliente) {

        Cliente clienteAtualizado = null;

        if (cliente.getId() != null) {
            Optional<Cliente> clienteTrn = clienteRepository.findById(cliente.getId());

            if(clienteTrn.isPresent()) {
                clienteAtualizado = clienteTrn.get();

                if(!cliente.getNome().isEmpty()) {
                    clienteAtualizado.setNome(cliente.getNome());
                }

                if(!cliente.getEmail().isEmpty()) {
                    clienteAtualizado.setEmail(cliente.getEmail());
                }

                return clienteRepository.save(clienteAtualizado);
            }
        } else {
            return salvaCliente(cliente);
        }

        return clienteAtualizado;
    }

    public Cliente salvaCliente(Cliente cliente) {

        InputValidator.isValidCliente(cliente);

        for (Endereco endereco : cliente.getEnderecos()) {
            Endereco enderecoCompleto = buscaDadosEndereco(endereco.getCep());
            endereco.setBairro(enderecoCompleto.getBairro());
            endereco.setDdd(enderecoCompleto.getDdd());

        }

        return clienteRepository.save(cliente);
    }

    public Endereco buscaDadosEndereco(String cep) {

        String uriBuilder = UriComponentsBuilder
                .fromHttpUrl(URL_VIA_CEP)
                .path(cep)
                .path("/json")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Endereco> entity = new HttpEntity<>(headers);

        Endereco response = new Endereco();
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Endereco> responseEntity = restTemplate
                    .exchange(uriBuilder, HttpMethod.GET, entity, Endereco.class);

            if (responseEntity != null && responseEntity.getBody() != null) {
                response = ConsultaCEPMapper.toEntity(responseEntity);
            }

        } catch (HttpClientErrorException ex) {

        }

        return response;
    }

    public boolean deletaClientePorId(Long id) {

        Optional<Cliente> clienteTrn = clienteRepository.findById(id);

        if (clienteTrn.isPresent()) {
            clienteRepository.deleteById(id);
        } else {
            throw new ClienteNaoEncontradoException("Id fornecido nao pertence a um cliente cadastrado.");
        }

        return true;
    }
}
