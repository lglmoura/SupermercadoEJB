package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Categoria;
import br.iff.pooa20141.supermercado.model.entity.Setor;


@Remote
public interface CategoriaPersistenceRemote {

	public Categoria inserir(String uid,  String descricao, Setor setor);

	public Categoria update(String uid, String descricao, Setor setor);

	public Categoria find(String uid);

	public void delete(String uid);

	@XmlElement(name = "categoria")
	public List<Categoria> findAll();

}