package br.com.tokiomarine.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Column(nullable = false)
    @NotEmpty
    private String cep;

    @Column(nullable = false)
    @NotEmpty
    private String logradouro;

    @Column(nullable = false)
    @NotEmpty
    private String numero;

    @Column(nullable = false)
    @NotEmpty
    private String complemento;

    @Column(nullable = false)
    @NotEmpty
    private String bairro;

    @Column(nullable = false)
    @NotEmpty
    private String localidade;

    @Column(nullable = false)
    @NotEmpty
    private String uniaoFederativa;

    @Column
    @NotEmpty
    private String ibge;

    @Column
    @NotEmpty
    private String gia;

    @Column
    @NotEmpty
    private String ddd;

    @Column
    @NotEmpty
    private String siafi;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUniaoFederativa() {
        return uniaoFederativa;
    }

    public void setUniaoFederativa(String uniaoFederativa) {
        this.uniaoFederativa = uniaoFederativa;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
