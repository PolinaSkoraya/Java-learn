import entity.Caller;
import entity.Operator;
import entity.PhoneCall;
import service.Center;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    private static Queue<Caller> callerQueue = new ArrayDeque<>();
    private static final int COUNT_OPERATOR = 3;

    public static void main(String[] args) {
        System.out.println("Напишите 'call' для того что бы позвонить в сервис.");
        System.out.println("Напишите 'end' для того что бы завершить программу.");
        int countCaller = 1;

        Center callCenter = initCallCenter();

        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();

        while (!"end".equals(inputString)) {
            if ("call".equals(inputString)) {
                addCaller(callerQueue, countCaller++);
            }

            PhoneCall phoneCall = new PhoneCall(callerQueue.poll(), callCenter);
            new Thread(phoneCall).start();                                                                          //

            inputString = scanner. nextLine();
        }
    }

    private static void addCaller(Queue<Caller> callerQueue, int countCaller) {
        callerQueue.offer(new Caller("Caller", String.valueOf(countCaller)));
    }

    private static Center initCallCenter() {
        Center callCenter = new Center(new ArrayBlockingQueue<>(COUNT_OPERATOR));

        for (int i = 1; i <= COUNT_OPERATOR; i++) {
            callCenter.setOperator(new Operator("Operator", String.valueOf(i)));
        }

        return callCenter;
    }
}
