import java.util.Scanner;

/**
 * Програма
 */
public class Program {
    /**
     * Головна функція програми
     */
    public static void main() {
        int N = setN();
        task(N);
    }

    /**
     * Бере у користувача, скільки потрібно чисел Люка.
     * @return Скільки потрібно чисел Люка.
     */
    public static int setN() {
        System.out.print("Введіть значення N: ");
        Scanner scanner = new Scanner(System.in);
        int N;
        while(true) {
            N = scanner.nextInt();
            if (N <= 0)
                System.out.println("Повторіть введення.");
            else break;
        }
        scanner.close();
        return N;
    }

    /**
     * Розраховує числа Люка, виводить їх, та перевіряє умову завдання.
     */
    public static void task(int N) {
        Lucas_number First = new Lucas_number(1, 2);
        printLuke(First);
        System.out.println();

        Lucas_number Second = new Lucas_number(2, 1);
        printLuke(Second);
        System.out.println();

        for (int i = 2; i != N; i++) {
            long third = Second.getValue() + First.getValue();
            First.setValue(Second.getValue());
            Second.setValue(third);
            First.setPosition(i);
            Second.setPosition(i+1);

            printLuke(Second);

            if (isForm(Second.getValue()))
                System.out.print(" - це число Люка відповідає умові завдання.");

            System.out.println();
        }
    }

    /**
     * Виводить число Люка і його позицію.
     * @param temp екземпляр класу Lucas_number.
     */
    public static void printLuke (Lucas_number temp) {
        System.out.print(temp.getPosition() + ". ");
        System.out.print(temp.getValue());
    }

    /**
     * Перевіряє чи дане число Люка відповідає умові.
     * @param value значення яке треба перевірити.
     * @return true якщо число відповідає умові; false якщо число не відповідає умові.
     */
    public static boolean isForm(long value) {
        double sqrt = Math.sqrt(value + 1);
        if (sqrt == Math.floor(sqrt))
            return true;
        return false;
    }

}

/**
 * Клас "Число Люка"
 */
class Lucas_number {
    int pos;
    long val;

    /**
     * Число Люка
     * @param p позиція числа в ряді Люка.
     * @param v значення Люка.
     */
    public Lucas_number(int p, long v) {
        this.pos = p;
        this.val = v;
    }

    /**
     * Повертає значення числа Люка.
     * @return число Люка.
     */
    public long getValue() {
        return val;
    }

    /**
     * Повертає позицію числа Люка.
     * @return позицію числа Люка.
     */
    public int getPosition() {
        return pos;
    }

    /**
     * Записує v в число Люка.
     * @param v значення числа Люка.
     */
    public void setValue(long v) {
        this.val = v;
    }

    /**
     * Записує p в число Люка.
     * @param p позиція цього числа в ряді Люка.
     */
    public void setPosition(int p) {
        this.pos = p;
    }
}
