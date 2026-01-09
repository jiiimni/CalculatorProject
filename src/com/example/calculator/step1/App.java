package com.example.calculator.step1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Scanner: 콘솔로부터 입력을 받기 위한 도구
        Scanner sc = new Scanner(System.in);

        // while(true): 무한 반복(계산을 계속 진행하기 위해)
        // 사용자가 "exit"을 입력하면 break로 반복을 끝낸다.
        while (true) {

            // 1) 첫 번째 숫자 입력 받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt(); // 사용자가 입력한 정수를 num1에 저장

            // 2) 두 번째 숫자 입력 받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt(); // 사용자가 입력한 정수를 num2에 저장

            // 3) 사칙연산 기호 입력 받기
            // sc.next()는 문자열(String)로 입력을 받음
            // charAt(0)은 그 문자열의 첫 번째 글자를 char로 가져옴
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            // 결과를 담을 변수, 초기값 0
            int result = 0;

            // 정상 연산 여부를 표시하는 변수
            // 0으로 나누기 / 지원하지 않는 연산자 등의 상황에서 false로 바꿈
            boolean isValid = true;

            // 4) 연산자에 따라 다른 계산을 수행하기 위해 switch 사용
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
                    // 나눗셈은 두 번째 숫자가 0이면 오류가 발생하므로 예외 처리
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다.");
                        isValid = false; // 정상 연산이 아니므로 결과를 출력하지 않게함
                    } else {
                        result = num1 / num2; // int 나눗셈이므로 소수점은 버려짐
                    }
                    break;

                default:
                    // + - * / 가 아닌 다른 문자를 입력한 경우
                    System.out.println("지원하지 않는 연산자입니다.");
                    isValid = false;
            }

            // 5) 정상 연산일 때만 결과 출력
            if (isValid) {
                System.out.println("결과: " + result);
            }

            // 6) 계속 계산할지 종료할지 입력 받기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next(); // exit 입력 여부 확인

            // 7) exit이면 반복문 종료
            if (answer.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            // exit이 아니면 while문이 다시 반복되면서 다음 계산을 진행
        }

        // Scanner 닫기: 프로그램 종료 직전에 닫아주면 좋음
        sc.close();
    }
}
