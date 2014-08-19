package br.iff.pooa20141.supermercado.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.supermercado.model.entity.Categoria;
import br.iff.pooa20141.supermercado.model.entity.Fabricante;
import br.iff.pooa20141.supermercado.model.entity.Produto;
import br.iff.pooa20141.supermercado.model.entity.Setor;
 
@Stateless
@LocalBean
public class ProdutoPersistence extends AbstractPersistence implements
		ProdutoPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Produto inserir(String uid,  String codigobarra, String descricao, String nome, Categoria categoria, Fabricante fabricante) {
		Produto produto = new Produto();
		produto.setUid(uid);
		produto.setCodigobarra(codigobarra);
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setCategoriaBean(categoria);
		produto.setFabricanteBean(fabricante);
		
		super.insert(produto);
		return produto;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Produto update(String uid,  String codigobarra, String descricao, String nome, Categoria categoria, Fabricante fabricante) {
		Produto produto = super.find(Produto.class, uid);
		produto.setUid(uid);
		produto.setCodigobarra(codigobarra);
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setCategoriaBean(categoria);
		produto.setFabricanteBean(fabricante);
		super.update(produto);
		return produto;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Produto find(String uid) {
		return super.find(Produto.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Produto.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote#findAll()
	 */
	@XmlElement(name = "produtos")
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Produto.class);
	}

}
