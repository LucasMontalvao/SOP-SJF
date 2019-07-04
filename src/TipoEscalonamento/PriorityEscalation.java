package TipoEscalonamento;

import java.util.ArrayList;
import java.util.Arrays;

public class PriorityEscalation extends Escalation{

    public void getAllProcessWorkCharge(){

        ArrayList<Process> process = new ArrayList<Process>(createProcess());

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

    public void executeTasks(){
        getAllProcessWorkCharge();
        System.out.println("Tempo de execução de cada processo " + Arrays.toString(valueWorkCharge));
        System.out.println("Aplicação do Escalonamento por prioridade "+ Arrays.toString(valueWorkCharge) + "\n");

        for(int i = 0; i < valueWorkCharge.length; i++) {
            for(int j = 0; j <valueWorkCharge[i]; j++) {
                System.out.println("Iniciando Tarefa " + (i+1));
                while(valueWorkCharge[i] > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Executando " + (i+1)  + "º tarefa. Falta " + valueWorkCharge[i] +
                                " segundos para o término");
                        valueWorkCharge[i] -= 1;
                    } catch (InterruptedException e) {
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
