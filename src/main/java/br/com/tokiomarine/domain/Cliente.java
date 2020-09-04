package br.com.tokiomarine.domain;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import java.util.Set;


@Entity
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotEmpty
	private String nome;

	@Column(nullable = false)
	@NotEmpty
	@Email
	private String email;

	@Column
	@OneToMany(mappedBy = "cliente")
	private Set<Endereco> enderecos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() { return id; }

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}
}