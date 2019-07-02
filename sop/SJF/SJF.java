package sop.SJF;

import java.util.ArrayList;
import java.util.Arrays;

public class SJF {
	private int vetor = 0;
	private int[] valoresCargaTrabalho = new int[4];
	
	ArrayList<Processo> createProcess() {
		ArrayList<Processo> processos = new ArrayList<Processo>();
		Processo p1 = new Processo("p1", 2, createCargaTrabalho("C10","E5","C4","",""));
		Processo p2 = new Processo("p2", 1, createCargaTrabalho("C2","E10","C1","",""));
		Processo p3 = new Processo("p3", 2, createCargaTrabalho("C16","E1","C10","",""));
		Processo p4 = new Processo("p4", 0, createCargaTrabalho("C4","E1","C1","E1","C1"));
		processos.add(p1);
		processos.add(p2);
		processos.add(p3);
		processos.add(p4);
		return processos;
	}
	
	private String[] createCargaTrabalho(String d0, String d1, String d2, String d3, String d4) {
		String[] carga = new String[5];
		carga[0] = d0; 
		carga[1] = d1;
		carga[2] = d2; 
		carga[3] = d3; 
		carga[4] = d4;
		return carga;
	}
	
	void getAllProcessosCargaTrabalho() {
		ArrayList<Processo> processos = new ArrayList<Processo>(createProcess());
		int j = 0;
		ArrayList<String> valores = null;
		for(Processo p : processos) {
			valores = processos.get(j).getCargaTrabalho();
			for(int i = 0; i < 5; i++) {
				//System.out.println(valores.get(i));
				if(valores.get(i).startsWith("C")) { 
					vetor += Integer.parseInt(valores.get(i).replace("C", ""));
				}else if(valores.get(i).startsWith("E")) {
					vetor += Integer.parseInt(valores.get(i).replace("E", ""));
				}
			}
			valoresCargaTrabalho[j] = vetor;
			vetor = 0;
			j+=1;	
		}
	}
	
	void executeTasks() {
		getAllProcessosCargaTrabalho();
		System.out.println("Tempo de execução de cada processo " + Arrays.toString(valoresCargaTrabalho));
		Arrays.sort(valoresCargaTrabalho);
		System.out.println("Aplicação do SJF "+ Arrays.toString(valoresCargaTrabalho) + "\n");
		for(int i = 0; i < valoresCargaTrabalho.length; i++) {
			for(int j = 0; j <valoresCargaTrabalho[i]; j++) {
				System.out.println("Iniciando Tarefa " + (i+1));
				while(valoresCargaTrabalho[i] > 0) {
					try {
						Thread.sleep(1000);
						System.out.println("Executando " + (i+1)  + "° tarefa. Falta " + valoresCargaTrabalho[i] + " segundos para o término");
						valoresCargaTrabalho[i] -= 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Tarefa " + (i+1) + " finalizada");
				System.out.println("\n");
			}
		}
		System.out.println("Todas as tarefas foram executadas com exito");
	}
}
