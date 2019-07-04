package TipoEscalonamento;

import java.util.ArrayList;
import java.util.Arrays;

public class PriorityEscalationTime extends Escalation {

    private int quantum;

    public PriorityEscalationTime (int quantum){
        this.quantum = quantum;
    }

    @Override
    public ArrayList<Process> createProcess(){
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
    public void getAllProcessWorkCharge(){

        ArrayList<Process> process = new ArrayList<Process>(createProcess());
        int[] processPriority = new int[4];
        ArrayList<Process> processArray = new ArrayList<Process>();

        Process lastPositionObject;
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < (4 - i ); j++){
                if(process.get(j-1).getPriority() < process.get(j).getPriority() ){
                    lastPositionObject = process.get(j-1);
                    process.set(j-1, process.get(j));
                    process.set(j,lastPositionObject);
                }
            }
        }

        int position = 0;
        ArrayList<String> values = null;

        for(Process processItem : process){
            values = process.get(position).getworkCharge();
            for(int i = 0; i < 5; i++){
                if(values.get(i).startsWith("C")){
                    vector += Integer.parseInt(values.get(i).replace("C", ""));
                } else if(values.get(i).startsWith("E")){
                    vector += Integer.parseInt(values.get(i).replace("E", ""));
                }
            }
            valueWorkCharge[position] = vector;
            vector = 0;
            position += 1;
        }
    }

    public void executeTasks() {
        getAllProcessWorkCharge();
        System.out.println("Tempo de execução de cada processo " + Arrays.toString(valueWorkCharge));
        System.out.println("Aplicação do Escalonamento por prioridade e tempo "
                + Arrays.toString(valueWorkCharge) + "\n");

        boolean allTasksDoned = valueWorkCharge[0] == 0 && valueWorkCharge[1] == 0
                && valueWorkCharge[2] == 0 && valueWorkCharge[3] == 0;
        boolean quantumBreak = false;

        int time = 0;

        while (!allTasksDoned) {
            for (int i = 0; i < valueWorkCharge.length; i++) {
                for (int j = 0; j < valueWorkCharge[i]; j++) {
                    System.out.println("Iniciando Tarefa " + (i + 1));

                    while (valueWorkCharge[i] > 0) {
                        time++;
                        if (time > this.quantum) {
                            time = 0;
                            quantumBreak = true;
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                            System.out.println("Executando " + (i + 1) + "º tarefa. Falta " + valueWorkCharge[i] +
                                    " segundos para o término");
                            valueWorkCharge[i] -= 1;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (valueWorkCharge[i] == 0) {
                        time = 0;
                        System.out.println("Tarefa " + (i + 1) + " finalizada");
                        System.out.println("\n");
                    }
                    if (quantumBreak) {
                        quantumBreak = false;
                        break;
                    }
                }
            }
            allTasksDoned = valueWorkCharge[0] == 0 && valueWorkCharge[1] == 0
                    && valueWorkCharge[2] == 0 && valueWorkCharge[3] == 0;
        }
        System.out.println("Todas as tarefas foram executadas com exito");
    }
}
