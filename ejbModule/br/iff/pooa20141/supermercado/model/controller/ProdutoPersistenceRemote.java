package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Categoria;
import br.iff.pooa20141.supermercado.model.entity.Fabricante;
import br.iff.pooa20141.supermercado.model.entity.Produto;


 
@Remote
public interface ProdutoPersistenceRemote {

	public Produto inserir(String uid,  String codigobarra, String descricao, String nome, Categoria Categoria, Fabricante fabricante);

	public Produto update(String uid,  String codigobarra, String descricao, String nome, Categoria Categoria, Fabricante fabricante);

	public Produto find(String uid);

	public void delete(String uid);

	@XmlElement(name = "produto")
	public List<Produto> findAll();

}