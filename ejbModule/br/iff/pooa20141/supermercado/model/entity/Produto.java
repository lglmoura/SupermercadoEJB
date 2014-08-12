package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String codigobarra;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoriaBean;

	//bi-directional many-to-one association to Fabricante
	@ManyToOne
	@JoinColumn(name="fabricante")
	private Fabricante fabricanteBean;

	//bi-directional many-to-one association to Itemlista
	@OneToMany(mappedBy="produtoBean")
	private List<Itemlista> itemlistas;

	public Produto() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCodigobarra() {
		return this.codigobarra;
	}

	public void setCodigobarra(String codigobarra) {
		this.codigobarra = codigobarra;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

	public Fabricante getFabricanteBean() {
		return this.fabricanteBean;
	}

	public void setFabricanteBean(Fabricante fabricanteBean) {
		this.fabricanteBean = fabricanteBean;
	}

	public List<Itemlista> getItemlistas() {
		return this.itemlistas;
	}

	public void setItemlistas(List<Itemlista> itemlistas) {
		this.itemlistas = itemlistas;
	}

	public Itemlista addItemlista(Itemlista itemlista) {
		getItemlistas().add(itemlista);
		itemlista.setProdutoBean(this);

		return itemlista;
	}

	public Itemlista removeItemlista(Itemlista itemlista) {
		getItemlistas().remove(itemlista);
		itemlista.setProdutoBean(null);

		return itemlista;
	}

}