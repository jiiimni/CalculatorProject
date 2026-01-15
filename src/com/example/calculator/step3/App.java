package com.example.calculator.step3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Calculator 인스턴스 생성
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);

        // 반복문 시작
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);


            try {
                OperatorType opType = OperatorType.fromSymbol(operator);  // enum 변환
                double result = calculator.calculate(num1, num2, opType);  // calculate 호출
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue; // 오류났으면 기준값/삭제/exit 안 묻고 다음 반복으로
            }

            // getter
            System.out.println("저장된 결과 목록: " + calculator.getResults());

            System.out.print("기준값을 입력하세요: ");
            double value = sc.nextDouble();

            System.out.println("기준값보다 큰 결과: " + calculator.getResultsGreaterThan(value));

            // removeResult 활용해보기
            System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String cmd = sc.next();
            if (cmd.equalsIgnoreCase("remove")) {
                calculator.removeResult();
                System.out.println("삭제 후 결과 목록: " + calculator.getResults());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();

            if (answer.equals("exit")) break;
        }
        // 반복문 종료

        sc.close();
    }
}
