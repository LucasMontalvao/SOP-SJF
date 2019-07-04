package TipoEscalonamento;

import java.util.ArrayList;

public class Process {

	private String name;
	public int priority;
	private String[] workCharge;

	public Process(String name, int priority, String[] workCharge) {
		this.name = name;
		this.workCharge = workCharge;
		this.priority = priority;
	}

	public int getPriority() {
		return this.priority;
	}

	public ArrayList<String> getworkCharge(){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < workCharge.length; i++) {
			list.add(workCharge[i]);
		}
		return list;
	}
}
