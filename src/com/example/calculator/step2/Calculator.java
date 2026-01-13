package com.example.calculator.step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private final List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {

        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

        //연산 결과를 컬렉션에 저장
        results.add(result);

        //return 연산 결과
        return result;
    }

    // Getter 메서드 구현
    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    // Setter 메서드 구현
    public void setResults(List<Integer> newResults) {
        results.clear();
        results.addAll(newResults);
    }

    public void removeResult() {
        // 구현
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}
