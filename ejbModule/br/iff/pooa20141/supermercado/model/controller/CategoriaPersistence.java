package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Categoria;
import br.iff.pooa20141.supermercado.model.entity.Setor;

@Stateless
@LocalBean
public class CategoriaPersistence extends AbstractPersistence implements
		CategoriaPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Categoria inserir(String uid, String descricao, Setor setor) {
		Categoria categoria = new Categoria();
		categoria.setUid(uid);
		categoria.setDescricao(descricao);
		categoria.setSetorBean(setor);
		super.insert(categoria);
		return categoria;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Categoria update(String uid, String descricao, Setor setor) {
		Categoria categoria = super.find(Categoria.class, uid);
		categoria.setUid(uid);
		categoria.setDescricao(descricao);
		categoria.setSetorBean(setor);
		super.update(categoria);
		return categoria;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Categoria find(String uid) {
		return super.find(Categoria.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Categoria.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote#findAll()
	 */
	@XmlElement(name = "categorias")
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Categoria.class);
	}

}
