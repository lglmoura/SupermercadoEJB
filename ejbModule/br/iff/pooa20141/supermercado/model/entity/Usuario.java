package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String login;

	private String nome;

	private String senha;

	//bi-directional many-to-one association to Listacompra
	@OneToMany(mappedBy="usuarioBean")
	private List<Listacompra> listacompras;

	public Usuario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Listacompra> getListacompras() {
		return this.listacompras;
	}

	public void setListacompras(List<Listacompra> listacompras) {
		this.listacompras = listacompras;
	}

	public Listacompra addListacompra(Listacompra listacompra) {
		getListacompras().add(listacompra);
		listacompra.setUsuarioBean(this);

		return listacompra;
	}

	public Listacompra removeListacompra(Listacompra listacompra) {
		getListacompras().remove(listacompra);
		listacompra.setUsuarioBean(null);

		return listacompra;
	}

}