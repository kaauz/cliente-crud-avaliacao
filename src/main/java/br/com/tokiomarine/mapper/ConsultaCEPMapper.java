package br.com.tokiomarine.mapper;

import br.com.tokiomarine.domain.Endereco;
import org.springframework.http.ResponseEntity;

public class ConsultaCEPMapper {

    public static Endereco toEntity(ResponseEntity<Endereco> responseEntity) {

        return Endereco.builder()
                .bairro(responseEntity.getBody().getBairro())
                .ddd(responseEntity.getBody().getDdd())
                .gia(responseEntity.getBody().getGia())
                .ibge(responseEntity.getBody().getIbge())
                .localidade(responseEntity.getBody().getLocalidade())
                .logradouro(responseEntity.getBody().getLogradouro())
                .siafi(responseEntity.getBody().getSiafi())
                .build();
    }
}
