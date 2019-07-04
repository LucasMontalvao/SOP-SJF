package TipoEscalonamento;

import java.util.ArrayList;

public class Escalation {

    protected int vector = 0;
    protected int[] valueWorkCharge = new int[4];

    public ArrayList<Process> createProcess() {
        ArrayList<Process> processArray = new ArrayList<Process>();
        Process p1 = new Process("p1", 2, createWorkCharge("C10","E5","C4","",""));
        Process p2 = new Process("p2", 1, createWorkCharge("C2","E10","C1","",""));
        Process p3 = new Process("p3", 2, createWorkCharge("C16","E1","C10","",""));
        Process p4 = new Process("p4", 0, createWorkCharge("C4","E1","C1","E1","C1"));
        processArray.add(p1);
        processArray.add(p2);
        processArray.add(p3);
        processArray.add(p4);
        return processArray;
    }

    protected String[] createWorkCharge(String t1, String t2, String t3, String t4, String t5) {
        String[] charge = new String[5];
        charge[0] = t1;
        charge[1] = t2;
        charge[2] = t3;
        charge[3] = t4;
        charge[4] = t5;
        return charge;
    }
}
