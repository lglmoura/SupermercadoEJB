package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Fabricante;


@Remote
public interface FabricantePersistenceRemote {

	public Fabricante inserir(String uid,  String nome);

	public Fabricante update(String uid, String nome);

	public Fabricante find(String uid);

	public void delete(String uid);

	@XmlElement(name = "fabricante")
	public List<Fabricante> findAll();

}