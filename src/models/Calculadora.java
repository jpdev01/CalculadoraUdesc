package models;

public class Calculadora {
    
    private static final Operation DEFAULT_OPERATION = Operation.ADICAO;
    private double operador1;
    private double operador2;
    private Operation operation;

    public Calculadora() {
        operador2 = 0.0;
        operador1 = 0.0;
        operation = Calculadora.DEFAULT_OPERATION;
    }

    public void setOperation(Operation Operation) {
        this.operation = Operation;
    }

    public void setOperador1(double operador1) {
        this.operador1 = operador1;
    }

    public void setOperador2(double operador2) {
        this.operador2 = operador2;
    }

    public double calcular() {
        double resposta = 0.0;
        switch(operation) {
            case ADICAO:
                resposta = operador1+operador2;
                break;
            case SUBTRACAO:
                resposta = operador1-operador2;
                break;
            case MULTIPLICACAO:
                resposta = operador1*operador2;
                break;
            case DIVISAO:
                resposta = operador1/operador2;
                break;
        }
        return resposta;
    }
}