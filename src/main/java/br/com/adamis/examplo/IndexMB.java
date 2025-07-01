package br.com.adamis.examplo;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexMB implements Serializable {
	
	private static final long serialVersionUID = -2420874718912970882L;
	
	private String entrada;
	private String result;
	
    @PostConstruct
	public void init() {
    	this.entrada = "";
    	this.result = "";
	}

    public void click() {
    	System.err.println(""+entrada);
	}

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
	
	
}
