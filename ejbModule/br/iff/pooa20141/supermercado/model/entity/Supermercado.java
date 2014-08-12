package br.iff.pooa20141.supermercado.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the supermercado database table.
 * 
 */
@Entity
@NamedQuery(name="Supermercado.findAll", query="SELECT s FROM Supermercado s")
public class Supermercado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String endereco;

	private float latitude;

	private float longitude;

	private String nome;

	//bi-directional many-to-one association to Pesquisapreco
	@OneToMany(mappedBy="supermercadoBean")
	private List<Pesquisapreco> pesquisaprecos;

	public Supermercado() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pesquisapreco> getPesquisaprecos() {
		return this.pesquisaprecos;
	}

	public void setPesquisaprecos(List<Pesquisapreco> pesquisaprecos) {
		this.pesquisaprecos = pesquisaprecos;
	}

	public Pesquisapreco addPesquisapreco(Pesquisapreco pesquisapreco) {
		getPesquisaprecos().add(pesquisapreco);
		pesquisapreco.setSupermercadoBean(this);

		return pesquisapreco;
	}

	public Pesquisapreco removePesquisapreco(Pesquisapreco pesquisapreco) {
		getPesquisaprecos().remove(pesquisapreco);
		pesquisapreco.setSupermercadoBean(null);

		return pesquisapreco;
	}

}