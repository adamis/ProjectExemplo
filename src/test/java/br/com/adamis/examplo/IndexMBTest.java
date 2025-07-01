// File: src/test/java/br/com/adamis/examplo/IndexMBTest.java
package br.com.adamis.examplo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.primefaces.PrimeFaces;

class IndexMBTest {

	private IndexMB indexMB;
	private String frase = "um dois dois tres tres tres";

	@BeforeEach
	void setUp() {
		indexMB = new IndexMB();
		indexMB.init();
	}

	@Test
	void testQtdPalavras() {
		assertEquals(3, indexMB.qtdPalavras("um dois tres"));
		assertEquals(1, indexMB.qtdPalavras("palavra"));
		assertEquals(0, indexMB.qtdPalavras(""));
	}

	@Test
	void testPalavrasRepetidas() {
		indexMB.setEntrada(frase);
		try (MockedStatic<PrimeFaces> pf = mockStatic(PrimeFaces.class)) {
			PrimeFaces primeFaces = mock(PrimeFaces.class);
			pf.when(PrimeFaces::current).thenReturn(primeFaces);
			indexMB.click();

			Map<String, Integer> contagem = indexMB.getHashRepetidos();
			assertNotNull(contagem);
			assertEquals(3, contagem.size());
			assertEquals(1, contagem.get("um"));
			assertEquals(2, contagem.get("dois"));
			assertEquals(3, contagem.get("tres"));
		}
	}

	@Test
	void testContagemDePalavras() {    	
		int qtd = indexMB.qtdPalavras(frase);
		assertEquals(6, qtd);
	}   

	@Test
	void testClickEntradaVazia() {
		indexMB.setEntrada("");
		FacesContext facesContext = mock(FacesContext.class);
		try (MockedStatic<FacesContext> fc = mockStatic(FacesContext.class)) {
			fc.when(FacesContext::getCurrentInstance).thenReturn(facesContext);
			indexMB.click();
			verify(facesContext).addMessage(any(), any(FacesMessage.class));
		}
	}

	@Test
	void testClickEntradaValida() {
		indexMB.setEntrada("um dois dois");
		try (MockedStatic<PrimeFaces> pf = mockStatic(PrimeFaces.class)) {
			PrimeFaces primeFaces = mock(PrimeFaces.class);
			pf.when(PrimeFaces::current).thenReturn(primeFaces);
			indexMB.click();
			assertEquals(3, indexMB.getQtdPalavras());
			assertEquals(2, indexMB.getHashRepetidos().size());
			verify(primeFaces).executeScript(anyString());
		}
	}
}
