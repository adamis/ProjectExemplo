package br.com.adamis.examplo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class IndexMB implements Serializable {

	private static final long serialVersionUID = -2420874718912970882L;

	private String entrada;
	private String result;
	private Map<String, Integer> hashRepetidos = new HashMap<>();
	private Integer qtdPalavras;

	@PostConstruct
	public void init() {    	
		this.entrada = "";
		this.result = "";
		this.hashRepetidos = new HashMap<>();
		this.qtdPalavras = 0;
	}

	/**
	 * Click do Botao
	 */
	public void click() {
		if(entrada.isEmpty()) {
			addMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Informe uma frase!");
			return;
		}else {
			entrada = entrada.trim();
			entrada = entrada.replaceAll("[^a-zA-Z0-9 ]", "");
		}

		qtdPalavras = qtdPalavras(entrada);
		hashRepetidos = contagemDePalavras(entrada);


		PrimeFaces.current().executeScript("PF('dlgAnalise').show();");
	}


	//------------------------------- Funçoes Auxiliares --------------------------------    

	/**
	 * Conta palavras
	 * @param frase
	 * @return quantidade de Palavras
	 */
	public int qtdPalavras(String frase) {
		if(frase == null || frase.isEmpty()) {
			return 0;    		
		}else {
			return frase.toLowerCase().split("\\s+").length;	
		}

	}

	/**
	 * Contagem De Palavras 
	 * @param frase
	 * @return
	 */
	private Map<String, Integer> contagemDePalavras(String frase) {
		Map<String, Integer> contagem = new HashMap<>();
		for (String palavra : frase.toLowerCase().split("\\s+")) {
			contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
		}

		return contagem;
	}

	/**
	 * Convetendo o Map em Lista de Map.Entry
	 * @return List<Map.Entry<String, Integer>>
	 */
	public List<Map.Entry<String, Integer>> getDadosList() {
		return new ArrayList<>(hashRepetidos.entrySet());
	}

	/**
	 * Montagem de Notificacao
	 * @param severity
	 * @param summary
	 * @param detail
	 */
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().
		addMessage(null, new FacesMessage(severity, summary, detail));
	}



	//------------------------------- Get and Set's --------------------------------


	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}


	/**
	 * @return the entrada
	 */
	public String getEntrada() {
		return entrada;
	}


	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the hashRepetidos
	 */
	public Map<String, Integer> getHashRepetidos() {
		return hashRepetidos;
	}

	/**
	 * @param hashRepetidos the hashRepetidos to set
	 */
	public void setHashRepetidos(Map<String, Integer> hashRepetidos) {
		this.hashRepetidos = hashRepetidos;
	}

	/**
	 * @return the qtdPalavras
	 */
	public Integer getQtdPalavras() {
		return qtdPalavras;
	}

	/**
	 * @param qtdPalavras the qtdPalavras to set
	 */
	public void setQtdPalavras(Integer qtdPalavras) {
		this.qtdPalavras = qtdPalavras;
	}


}
