package br.iff.pooa20141.supermercado.model.test;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote;
import br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote;
import br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote;
import br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote;
import br.iff.pooa20141.supermercado.model.entity.Categoria;
import br.iff.pooa20141.supermercado.model.entity.Fabricante;
import br.iff.pooa20141.supermercado.model.entity.Produto;
import br.iff.pooa20141.supermercado.model.entity.Setor;
 
public class ProdutoTest {

	private CategoriaPersistenceRemote categoriaPR;
	private SetorPersistenceRemote setorPR;
	private FabricantePersistenceRemote fabricantePR;
	private ProdutoPersistenceRemote produtoPR;
	
	Setor setor;
	String uidSetor = UUID.randomUUID().toString();
	
	Fabricante fabricante;
	String uidFabricante = UUID.randomUUID().toString();
	
	Categoria categoria;
	String uidCategoria = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;
		categoriaPR = null;
		setorPR = null;
		produtoPR = null;
		fabricantePR= null;
		
		try {

			context = JNDILookupClass.getInitialContext();

			setorPR = (SetorPersistenceRemote) context
					.lookup("ejb:SupermercadoEAR/SupermercadoEJB/SetorPersistence!br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			categoriaPR = (CategoriaPersistenceRemote) context
					.lookup("ejb:SupermercadoEAR/SupermercadoEJB/CategoriaPersistence!br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		try {

			context = JNDILookupClass.getInitialContext();

			fabricantePR = (FabricantePersistenceRemote) context
					.lookup("ejb:SupermercadoEAR/SupermercadoEJB/FabricantePersistence!br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			produtoPR = (ProdutoPersistenceRemote) context
					.lookup("ejb:SupermercadoEAR/SupermercadoEJB/ProdutoPersistence!br.iff.pooa20141.supermercado.model.controller.ProdutoPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		uidSetor = UUID.randomUUID().toString();
		setor = setorPR.inserir(uidSetor,"Descricao");
		
		uidCategoria = UUID.randomUUID().toString();
		categoria = categoriaPR.inserir(uidCategoria, "descricao", setor);
		
		uidFabricante = UUID.randomUUID().toString();
		fabricante = fabricantePR.inserir(uidFabricante, "nome");
		
	}

	@After
	public void tearDown() throws Exception {
		
		fabricantePR.delete(uidFabricante);
		categoriaPR.delete(uidCategoria);
		setorPR.delete(uidSetor);
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Produto produto = produtoPR.inserir(uid, "codigobarra", "descricao", "nome", categoria, fabricante);
		assertEquals(produto.getUid(), uid);
		produtoPR.delete(uid);
	}

	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		produtoPR.inserir(uid, "codigobarra", "descricao", "nome", categoria, fabricante);

		Produto produtoUp = produtoPR.update(uid, "codigobarra", "descricao1", "nome", categoria, fabricante);

		assertEquals(produtoUp.getDescricao(), "descricao1");
		produtoPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		produtoPR.inserir(uid, "codigobarra", "descricao", "nome", categoria, fabricante);

		Produto produtoUp = produtoPR.find(uid);

		assertEquals(produtoUp.getDescricao(), "descricao");
		produtoPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		produtoPR.inserir(uid, "codigobarra", "descricao", "nome", categoria, fabricante);

		produtoPR.delete(uid);
		assertEquals(produtoPR.find(uid),null);
	}


}
