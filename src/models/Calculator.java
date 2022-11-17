package models;

public class Calculator {
    
    private static final Operation DEFAULT_OPERATION = Operation.ADICAO;
    private double firstOperator;
    private double secondOperator;
    private Operation operation;

    public Calculator() {
        this.secondOperator = 0.0;
        this.firstOperator = 0.0;
        this.operation = Calculator.DEFAULT_OPERATION;
    }

    public void setOperation(Operation Operation) {
        this.operation = Operation;
    }

    public void setFirstOperator(double firstOperator) {
        this.firstOperator = firstOperator;
    }

    public void setSecondOperator(double secondOperator) {
        this.secondOperator = secondOperator;
    }

    public double execute() {
        double result = 0.0;

        validateExecute();

        switch (this.operation) {
            case ADICAO:
                result = firstOperator + secondOperator;
                break;
            case SUBTRACAO:
                result = firstOperator - secondOperator;
                break;
            case MULTIPLICACAO:
                result = firstOperator * secondOperator;
                break;
            case DIVISAO:
                result = firstOperator / secondOperator;
                break;
        }
        return result;
    }

    private void validateExecute() {
        if (this.operation == null) throw new RuntimeException("O tipo da operação é obrigatório!");
    }
}