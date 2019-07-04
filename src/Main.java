import TipoEscalonamento.PriorityEscalation;
import TipoEscalonamento.PriorityEscalationTime;
import TipoEscalonamento.RRS;
import TipoEscalonamento.SJF;

public class Main {

	public static void main(String[] args) {

		SJF shortJobFirst = new SJF();
		System.out.println("\nShortest Job First\n");
		shortJobFirst.executeTasks();

		RRS roundRobinScheduling = new RRS(10);
		System.out.println("Round Robin Scheduling\n");
		roundRobinScheduling.executeTasks();

		PriorityEscalation priorityEscalation = new PriorityEscalation();
		System.out.println("\nEscalonamento por Prioridade\n");
		priorityEscalation.executeTasks();

		PriorityEscalationTime priorityEscalationTime = new PriorityEscalationTime(5);
		System.out.println("\nEscalonamento por Prioridade com Tempo\n");
		priorityEscalationTime.executeTasks();

		System.out.println("-------------------------------------------------------");
	}
}
