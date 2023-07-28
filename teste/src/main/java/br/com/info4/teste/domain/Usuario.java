package br.com.info4.teste.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_cd_id", nullable = false)
	private Long id;

	@Column(name = "usu_tx_nome", nullable = false)
	private String nome;

	@Column(name = "usu_tx_sobrenome", nullable = false)
	private String sobrenome;

	@Column(name = "usu_tx_email", nullable = false)
	private String email;

	@Column(name = "usu_tx_senha", nullable = false)
	private String senha;

	@Column(name = "usu_bl_status")
	private Boolean status;

	public Usuario() {
	}

	public Usuario(Long id, String nome, String sobrenome, String email, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
