import java.util.Scanner;

public class JobScheduler {
	/*
	 * JobScheduler follow FCFS algorithm calculate completion time,waiting
	 * time,turn around time for each process calculate average waiting time
	 * calculate maximum waiting time
	 */

	public static void main(String[] args) {
		try {
			System.out.print("enter no of process : ");
			Scanner scanner = new Scanner(System.in);
			int noOfProcess = scanner.nextInt(); // number of process in job schedule
			int[][] process = new int[noOfProcess][2];
			for (int i = 0; i < noOfProcess; i++) {

				System.out.print("\narrival time of process " + (i + 1) + " : ");
				process[i][0] = scanner.nextInt();
				System.out.print("burst time of process " + (i + 1) + " : ");
				process[i][1] = scanner.nextInt();

			}
			int[] completionTimeList = completionTime(process, noOfProcess); // completion time of each process
			for (int i = 0; i < noOfProcess; i++)
				System.out.println("completion time of process " + (i + 1)+ " : " + completionTimeList[i]);

			float averageWaitingTime = 0;
			int[] waitingTimeList = waitingTime(process, noOfProcess);
			int maxWaitingTime = waitingTimeList[0];
			for (int i = 0; i < noOfProcess; i++) {
				if (waitingTimeList[i] > maxWaitingTime)
					maxWaitingTime = waitingTimeList[i];
				averageWaitingTime += waitingTimeList[i];
				System.out.println("waiting time of process " + (i + 1) + " : "+ waitingTimeList[i]);
			}
			averageWaitingTime = averageWaitingTime / noOfProcess; // average waiting time

			int[] turnAroundTimeList = turnAroundTime(process,completionTimeList);
			for (int i = 0; i < noOfProcess; i++)
				System.out.println("turn around time of process " + (i + 1)+ " : " + turnAroundTimeList[i]);

			System.out.println("average waiting time : " + averageWaitingTime+ "\nmaximum waiting time : " + maxWaitingTime);
		} catch (Exception e) {
			System.out.println("please enter a valid number");
		}
	}
        // calculate turn around time of each process
	private static int[] turnAroundTime(int[][] process,int[] completionTimeList) {
		int[] turnATimeList = new int[completionTimeList.length];
		for (int i = 0; i < turnATimeList.length; i++)
			turnATimeList[i] = completionTimeList[i] - process[i][0];
		return turnATimeList;
	}
        // calculate completion time of each process
	private static int[] completionTime(int[][] process, int noOfProcess) {
		int[] compTimeList = new int[noOfProcess];
		compTimeList[0] = process[0][0] + process[0][1];
		for (int i = 1; i < noOfProcess; i++) {
			if (compTimeList[i - 1] < process[i][0])
				compTimeList[i] = process[i][0] + process[i][1];
			else
				compTimeList[i] = compTimeList[0] + process[i][1];
		}
		return compTimeList;
	}
        // calculate waiting time of each process
	private static int[] waitingTime(int[][] process, int noOfProcess) {
		int[] waitTimeList = new int[noOfProcess];
		waitTimeList[0] = 0;
		for (int i = 1; i < noOfProcess; i++) {
			if (process[i - 1][1] > process[i][0])
				waitTimeList[i] = process[i - 1][1] - process[i][0];
			else
				waitTimeList[i] = 0;
		}
		return waitTimeList;
	}

}
