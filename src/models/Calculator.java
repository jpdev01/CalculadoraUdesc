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
        double resposta = 0.0;

        validateExecute();

        switch (this.operation) {
            case ADICAO:
                resposta = firstOperator + secondOperator;
                break;
            case SUBTRACAO:
                resposta = firstOperator - secondOperator;
                break;
            case MULTIPLICACAO:
                resposta = firstOperator * secondOperator;
                break;
            case DIVISAO:
                resposta = firstOperator / secondOperator;
                break;
        }
        return resposta;
    }

    private void validateExecute() {
        if (this.operation == null) throw new RuntimeException("O tipo da operação é obrigatório!");
    }
}