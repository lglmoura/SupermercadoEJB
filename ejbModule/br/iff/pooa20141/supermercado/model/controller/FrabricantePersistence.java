package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Fabricante;

@Stateless
@LocalBean
public class FrabricantePersistence extends AbstractPersistence implements
		FabricantePersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Fabricante inserir(String uid, String nome) {
		Fabricante fabricante = new Fabricante();
		fabricante.setUid(uid);
		fabricante.setNome(nome);
		super.insert(fabricante);
		return fabricante;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Fabricante update(String uid, String nome) {
		Fabricante fabricante = super.find(Fabricante.class, uid);
		fabricante.setUid(uid);
		fabricante.setNome(nome);
		super.update(fabricante);
		return fabricante;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Fabricante find(String uid) {
		return super.find(Fabricante.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Fabricante.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote#findAll()
	 */
	@XmlElement(name = "fabricantes")
	public List<Fabricante> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Fabricante.class);
	}

}
