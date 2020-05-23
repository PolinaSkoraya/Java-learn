package entity;

import service.Center;

public class PhoneCall implements Runnable {
    private Caller caller;
    private Center serviceCenter;

    public PhoneCall(Caller caller, Center serviceCenter) {
        this.caller = caller;
        this.serviceCenter = serviceCenter;
    }

    @Override
    public void run() {
        Operator operator = serviceCenter.getOperator();

        System.out.println(operator.getName() + " " + operator.getSurName() + " принял звонок от " + caller.getName() + " " + caller.getSurName());

        int callDuration = (int) (Math.random() * 15000) + 3000;
        try {
            Thread.sleep(callDuration);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(operator.getName() + " " + operator.getSurName() + " завершил звонок продолжительностью " + callDuration + " от " + caller.getName() + " " + caller.getSurName());

        serviceCenter.setOperator(operator);
    }
}
