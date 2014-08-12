package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String descricao;

	//bi-directional many-to-one association to Setor
	@ManyToOne
	@JoinColumn(name="setor")
	private Setor setorBean;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="categoriaBean")
	private List<Produto> produtos;

	public Categoria() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Setor getSetorBean() {
		return this.setorBean;
	}

	public void setSetorBean(Setor setorBean) {
		this.setorBean = setorBean;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setCategoriaBean(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setCategoriaBean(null);

		return produto;
	}

}