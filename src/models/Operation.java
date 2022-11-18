package models;

import java.util.Arrays;

public enum Operation {

    ADICAO("+"),
    SUBTRACAO("-"),
    DIVISAO("/"),
    MULTIPLICACAO("*");

    private String operationSymbol;

    Operation(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return this.operationSymbol;
    }

    public static Operation findByOperationSymbol(String operationSymbol) {
        try {
            Operation operation = Arrays.stream(Operation.values())
                    .filter(operationValue -> operationValue.operationSymbol.equals(operationSymbol))
                    .findFirst().get();
            return operation;
        } catch (Exception exception) {
            return null;
        }
    }
}
