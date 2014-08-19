package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Setor;

@Stateless
@LocalBean
public class SetorPersistence extends AbstractPersistence implements
		SetorPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Setor inserir(String uid, String descricao) {
		Setor setor = new Setor();
		setor.setUid(uid);
		setor.setDescricao(descricao);
		super.insert(setor);
		return setor;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Setor update(String uid, String descricao) {
		Setor setor = super.find(Setor.class, uid);
		setor.setUid(uid);
		setor.setDescricao(descricao);
		super.update(setor);
		return setor;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Setor find(String uid) {
		return super.find(Setor.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Setor.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote#findAll()
	 */
	@XmlElement(name = "setores")
	public List<Setor> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Setor.class);
	}

}
