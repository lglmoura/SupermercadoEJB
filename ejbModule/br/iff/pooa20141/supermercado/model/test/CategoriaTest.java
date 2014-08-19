package br.iff.pooa20141.supermercado.model.test;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.supermercado.model.controller.CategoriaPersistenceRemote;
import br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote;
import br.iff.pooa20141.supermercado.model.entity.Categoria;
import br.iff.pooa20141.supermercado.model.entity.Setor;

public class CategoriaTest {

	private CategoriaPersistenceRemote categoriaPR;
	private SetorPersistenceRemote setorPR;
	Setor setor;
	String uidSetor = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;
		categoriaPR = null;
		setorPR = null;
		
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
		uidSetor = UUID.randomUUID().toString();
		setor = setorPR.inserir(uidSetor,"Descricao");
	}

	@After
	public void tearDown() throws Exception {
		setorPR.delete(uidSetor);
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Categoria categoria = categoriaPR.inserir(uid,"Descricao",setor);
		assertEquals(categoria.getUid(), uid);
		categoriaPR.delete(uid);
	}

	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		categoriaPR.inserir(uid, "Descricao",setor);

		Categoria categoriaUp = categoriaPR.update(uid, "Descricao1",setor);

		assertEquals(categoriaUp.getDescricao(), "Descricao1");
		categoriaPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		categoriaPR.inserir(uid, "Descricao",setor);

		Categoria categoriaUp = categoriaPR.find(uid);

		assertEquals(categoriaUp.getDescricao(), "Descricao");
		categoriaPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		categoriaPR.inserir(uid,"Descricao",setor);

		categoriaPR.delete(uid);
		assertEquals(categoriaPR.find(uid),null);
	}


}
