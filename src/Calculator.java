import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calculator {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            String[] s = str.split(" ");

            int firstValue = 0;
            int secondValue = 0;
            String operator = "";
            if (opValid(s[1])) {
                operator = s[1];

                if (isDigit(s[0]) && isDigit(s[2])) {
                    firstValue = Integer.parseInt(s[0]);
                    secondValue = Integer.parseInt(s[2]);

                    if (firstValue >= 1 && firstValue <= 10 && secondValue >= 1 && secondValue <= 10) {
                        System.out.println(calculate(firstValue, secondValue, operator));
                    } else {
                        throw new WrongExpressionExeption("Одно или оба числа больше 10 или меньше 1");
                    }

                } else if (RomanNumbers.isRoman(s[0]) && RomanNumbers.isRoman(s[2])) {
                    s[0] = s[0].toUpperCase();
                    s[2] = s[2].toUpperCase();
                    firstValue = RomanNumbers.convertRomanToInteger(s[0]);
                    secondValue = RomanNumbers.convertRomanToInteger(s[2]);

                    if (firstValue >= 1 && firstValue <= 10 && secondValue >= 1 && secondValue <= 10) {
                        int result = calculate(firstValue, secondValue, operator);

                        if (result == 0) {
                            throw new WrongExpressionExeption("В эпоху римских цифр ноль не был изобретен");
                        } else if (result < 0) {
                            throw new WrongExpressionExeption("Римские числа не могут быть отрицательными");
                        } else {
                            System.out.println(RomanNumbers.convertIntegerToRoman(result));
                        }

                    } else {
                        throw new WrongExpressionExeption("Одно или оба числа больше 10 или меньше 1");
                    }

                } else {
                    throw new NumberFormatException("Оба числа должны быть римскими либо арабскими");
                }
            } else {
                throw new IllegalArgumentException("Неверный арифметический оператор");
            }


        } catch (IOException | WrongExpressionExeption e) {
            e.printStackTrace();
        }
    }

    private static boolean opValid(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") ||
                operator.equals("/");
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int calculate(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}


