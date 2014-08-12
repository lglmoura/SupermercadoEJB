package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the listacompra database table.
 * 
 */
@Entity
@NamedQuery(name="Listacompra.findAll", query="SELECT l FROM Listacompra l")
public class Listacompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Integer mes;

	//bi-directional many-to-one association to Itemlista
	@OneToMany(mappedBy="listacompraBean")
	private List<Itemlista> itemlistas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Listacompra() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public List<Itemlista> getItemlistas() {
		return this.itemlistas;
	}

	public void setItemlistas(List<Itemlista> itemlistas) {
		this.itemlistas = itemlistas;
	}

	public Itemlista addItemlista(Itemlista itemlista) {
		getItemlistas().add(itemlista);
		itemlista.setListacompraBean(this);

		return itemlista;
	}

	public Itemlista removeItemlista(Itemlista itemlista) {
		getItemlistas().remove(itemlista);
		itemlista.setListacompraBean(null);

		return itemlista;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}