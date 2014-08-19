package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Setor;


@Remote
public interface SetorPersistenceRemote {

	public Setor inserir(String uid,  String descricao);

	public Setor update(String uid, String descricao);

	public Setor find(String uid);

	public void delete(String uid);

	@XmlElement(name = "setor")
	public List<Setor> findAll();

}