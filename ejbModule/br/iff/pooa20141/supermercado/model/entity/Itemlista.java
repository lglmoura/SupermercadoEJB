package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itemlista database table.
 * 
 */
@Entity
@NamedQuery(name="Itemlista.findAll", query="SELECT i FROM Itemlista i")
public class Itemlista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Integer quantidade;

	//bi-directional many-to-one association to Listacompra
	@ManyToOne
	@JoinColumn(name="listacompra")
	private Listacompra listacompraBean;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produto")
	private Produto produtoBean;

	//bi-directional many-to-one association to Pesquisapreco
	@OneToMany(mappedBy="itemlistaBean")
	private List<Pesquisapreco> pesquisaprecos;

	public Itemlista() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Listacompra getListacompraBean() {
		return this.listacompraBean;
	}

	public void setListacompraBean(Listacompra listacompraBean) {
		this.listacompraBean = listacompraBean;
	}

	public Produto getProdutoBean() {
		return this.produtoBean;
	}

	public void setProdutoBean(Produto produtoBean) {
		this.produtoBean = produtoBean;
	}

	public List<Pesquisapreco> getPesquisaprecos() {
		return this.pesquisaprecos;
	}

	public void setPesquisaprecos(List<Pesquisapreco> pesquisaprecos) {
		this.pesquisaprecos = pesquisaprecos;
	}

	public Pesquisapreco addPesquisapreco(Pesquisapreco pesquisapreco) {
		getPesquisaprecos().add(pesquisapreco);
		pesquisapreco.setItemlistaBean(this);

		return pesquisapreco;
	}

	public Pesquisapreco removePesquisapreco(Pesquisapreco pesquisapreco) {
		getPesquisaprecos().remove(pesquisapreco);
		pesquisapreco.setItemlistaBean(null);

		return pesquisapreco;
	}

}