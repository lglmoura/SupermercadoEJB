package br.iff.pooa20141.supermercado.model.test;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote;
import br.iff.pooa20141.supermercado.model.entity.Setor;

public class SetorTest {

	private SetorPersistenceRemote setorPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		setorPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			setorPR = (SetorPersistenceRemote) context
					.lookup("ejb:SupermercadoEAR/SupermercadoEJB/SetorPersistence!br.iff.pooa20141.supermercado.model.controller.SetorPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Setor setor = setorPR.inserir(uid,"Descricao");
		assertEquals(setor.getUid(), uid);
		setorPR.delete(uid);
	}

	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		setorPR.inserir(uid, "Descricao");

		Setor setorUp = setorPR.update(uid, "Descricao1");

		assertEquals(setorUp.getDescricao(), "Descricao1");
		setorPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		setorPR.inserir(uid, "Descricao");

		Setor setorUp = setorPR.find(uid);

		assertEquals(setorUp.getDescricao(), "Descricao");
		setorPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		setorPR.inserir(uid,"Descricao");

		setorPR.delete(uid);
		assertEquals(setorPR.find(uid),null);
	}


}
