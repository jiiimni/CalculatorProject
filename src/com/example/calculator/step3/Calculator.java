package com.example.calculator.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    // 실수도 저장해야 하므로 Double로 변경
    private final List<Double> results = new ArrayList<>();

    // 제네릭 + Enum 적용
    public <T extends Number> double calculate(T num1, T num2, OperatorType operator) {

        double result = 0;

        // 제네릭을 실제 계산 가능한 double로 바꿈
        double a = num1.doubleValue();
        double b = num2.doubleValue();

        switch (operator) {
            case ADD:
                result = a + b;
                break;
            case SUB:
                result = a - b;
                break;
            case MUL:
                result = a * b;
                break;
            case DIV:
                if (b == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

        results.add(result);
        return result;
    }

    // Getter
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    // Setter
    public void setResults(List<Double> newResults) {
        results.clear();
        results.addAll(newResults);
    }

    // 가장 먼저 저장된 값 삭제
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    // 기준값보다 큰 결과만 조회 (Stream + Lambda)
    public List<Double> getResultsGreaterThan(double value) {
        return results.stream()
                .filter(r -> r > value)
                .collect(Collectors.toList());
    }
}

