package br.com.tokiomarine.mapper;

import br.com.tokiomarine.domain.Endereco;
import br.com.tokiomarine.domain.ViaCEPResponse;
import org.springframework.http.ResponseEntity;

public class ConsultaCEPMapper {

    public static ViaCEPResponse toEntity(ResponseEntity<ViaCEPResponse> responseEntity) {

        return ViaCEPResponse.builder()
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
