package Seminar_4;

import java.util.Deque;
import java.util.LinkedList;

public class dz {
    public static LinkedList<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        LinkedList<Integer> result = new LinkedList<>();

        if (num1.isEmpty() || num2.isEmpty()) {
            return result;
        }

        int num1Size = num1.size();
        int num2Size = num2.size();
        int[] digits = new int[num1Size + num2Size];

        for (int i = 0; i < num1Size; i++) {
            int digit1 = num1.removeLast();

            int carry = 0;
            int digit2Index = 0;

            for (int j = 0; j < num2Size; j++) {
                int digit2 = num2.removeLast();

                int product = digit1 * digit2 + digits[i + digit2Index] + carry;
                digits[i + digit2Index] = product % 10;
                carry = product / 10;

                digit2Index++;
                num2.addFirst(digit2);
            }

            if (carry > 0) {
                digits[i + digit2Index] += carry;
            }

            num1.addFirst(digit1);
        }

        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 0) {
            i--;
        }

        if (i == -1) {
            result.add(0);
        } else {
            while (i >= 0) {
                result.add(digits[i]);
                i--;
            }
        }

        return result;
    }

    public static LinkedList<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        LinkedList<Integer> result = new LinkedList<>();

        if (num1.isEmpty() && num2.isEmpty()) {
            return result;
        }

        int carry = 0;

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digitSum = carry;

            if (!num1.isEmpty()) {
                digitSum += num1.removeLast();
            }

            if (!num2.isEmpty()) {
                digitSum += num2.removeLast();
            }

            result.addFirst(digitSum % 10);
            carry = digitSum / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        Deque<Integer> num2 = new LinkedList<>();

        // Пример чисел: 123 и 445
        num1.add(3);
        num1.add(2);
        num1.add(1);

        num2.add(5);
        num2.add(4);
        num2.add(4);

        LinkedList<Integer> multiplicationResult = multiply(num1, num2);
        LinkedList<Integer> additionResult = add(num1, num2);

        System.out.println("Результат умножения: " + multiplicationResult);
        System.out.println("Результат сложения: " + additionResult);
    }
}
