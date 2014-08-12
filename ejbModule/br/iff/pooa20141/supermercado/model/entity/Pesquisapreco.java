package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pesquisapreco database table.
 * 
 */
@Entity
@NamedQuery(name="Pesquisapreco.findAll", query="SELECT p FROM Pesquisapreco p")
public class Pesquisapreco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Boolean comprou;

	@Temporal(TemporalType.DATE)
	private Date data;

	private float valor;

	//bi-directional many-to-one association to Itemlista
	@ManyToOne
	@JoinColumn(name="itemlista")
	private Itemlista itemlistaBean;

	//bi-directional many-to-one association to Supermercado
	@ManyToOne
	@JoinColumn(name="supermercado")
	private Supermercado supermercadoBean;

	public Pesquisapreco() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Boolean getComprou() {
		return this.comprou;
	}

	public void setComprou(Boolean comprou) {
		this.comprou = comprou;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Itemlista getItemlistaBean() {
		return this.itemlistaBean;
	}

	public void setItemlistaBean(Itemlista itemlistaBean) {
		this.itemlistaBean = itemlistaBean;
	}

	public Supermercado getSupermercadoBean() {
		return this.supermercadoBean;
	}

	public void setSupermercadoBean(Supermercado supermercadoBean) {
		this.supermercadoBean = supermercadoBean;
	}

}