package sop.SJF;

import java.util.ArrayList;

public class Processo {
	public String name;
	public int prioridade;
	public String[] cargaTrabalho= new String[10];
	
	Processo(String name,int prioridade, String[] cargaTrabalho) {
		this.name = name;
		this.cargaTrabalho = cargaTrabalho;
		this.prioridade = prioridade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	protected ArrayList<String> getCargaTrabalho() {
		ArrayList<String> lista = new ArrayList<String>();
		for(int i = 0; i < cargaTrabalho.length; i++) {
			lista.add(cargaTrabalho[i]);
		}
		return lista;
	}

	public void setCargaTrabalho(String[] cargaTrabalho) {
		this.cargaTrabalho = cargaTrabalho;
	}
	
}
