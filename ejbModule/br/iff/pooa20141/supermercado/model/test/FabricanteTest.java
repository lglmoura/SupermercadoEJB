package br.iff.pooa20141.supermercado.model.test;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote;
import br.iff.pooa20141.supermercado.model.entity.Fabricante;

public class FabricanteTest {

	private FabricantePersistenceRemote fabricantePR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		fabricantePR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			fabricantePR = (FabricantePersistenceRemote) context
					.lookup("ejb:SupermercadoEAR/SupermercadoEJB/FabricantePersistence!br.iff.pooa20141.supermercado.model.controller.FabricantePersistenceRemote");

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
		Fabricante fabricante = fabricantePR.inserir(uid,"Nome");
		assertEquals(fabricante.getUid(), uid);
		fabricantePR.delete(uid);
	}

	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		fabricantePR.inserir(uid, "Nome");

		Fabricante fabricanteUp = fabricantePR.update(uid, "Descricao1");

		assertEquals(fabricanteUp.getNome(), "Descricao1");
		fabricantePR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		fabricantePR.inserir(uid, "Nome");

		Fabricante fabricanteUp = fabricantePR.find(uid);

		assertEquals(fabricanteUp.getNome(), "Nome");
		fabricantePR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		fabricantePR.inserir(uid,"Nome");

		fabricantePR.delete(uid);
		assertEquals(fabricantePR.find(uid),null);
	}


}
