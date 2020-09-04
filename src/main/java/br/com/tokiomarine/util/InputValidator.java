package br.com.tokiomarine.util;

import br.com.tokiomarine.domain.Cliente;
import br.com.tokiomarine.domain.Endereco;
import br.com.tokiomarine.domain.exception.ClienteInputInvalidoException;

public class InputValidator {

    public static boolean isValidCliente(Cliente cliente) {

        if (cliente.getEnderecos() == null || cliente.getEnderecos().isEmpty()) {
            throw new ClienteInputInvalidoException("Novo cliente deve ter um endereco com CEP e numero, no minimo.");
        }

        for (Endereco endereco : cliente.getEnderecos()) {
            if (!isValidEndereco(endereco))
                throw new ClienteInputInvalidoException("Endereco fornecido para criacao de Cliente deve conter no minimo um CEP e numero");
        }

        if ((cliente.getNome().isEmpty() || cliente.getNome() == null) ||
                cliente.getEmail().isEmpty() || cliente.getEmail() == null) {
            throw new ClienteInputInvalidoException("Cliente deve ter um nome e endereco de email.");
        }

        return true;
    }

    public static boolean isValidEndereco(Endereco endereco) {

        if ((endereco.getCep() == null || endereco.getCep().isEmpty()) ||
                endereco.getNumero() == null || endereco.getNumero().isEmpty()) {
            return false;
        }

        return true;
    }
}
