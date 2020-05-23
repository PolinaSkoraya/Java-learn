package service;

import entity.Operator;

import java.util.concurrent.BlockingQueue;

public class Center {
    private final BlockingQueue<Operator> operators;

    public Center(BlockingQueue<Operator> operators) {
        this.operators = operators;
    }

    public Operator getOperator() {
        try {
            return operators.take();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public boolean setOperator(Operator operator) {
        return operators.offer(operator);
    }
}
