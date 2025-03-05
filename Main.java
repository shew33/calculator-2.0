import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression)); // throws Exception дает завершить программу если произойдёт исключение
    }

    public static String parse(String expression) throws Exception {    // метод Parse разбирает строку, находит числа и оператор, затем вычисляет результат
        int a;
        int b;
        String oper;
        String result;
        String[] operands = expression.split("[+\\-*/]"); // через квадратные скобки можем выбрать любой знак который выбрал пользователь (те не всегда только через +, а программа сама считает и выберет нужный знак
        // перед минусом поставили // - так как в другом случае программа воспринимает его как синтаксический знак, то есть мы даем понять программе, что минус это именно текстовый знак как и все остальные
        if (operands.length != 2) throw new Exception("Должно быть два числа");
        oper = detectOper(expression);
        if (oper == null) throw new Exception("Ошибка при вводде операции"); // проверяем был ли введен какой-то другой знак кроме указанных (пр %,>)

        a = Integer.parseInt(operands[0]); // преобразуем строку в число с помощью метода parse
        b = Integer.parseInt(operands[1]);

        if (a > 10 || b > 10) {
            throw new Exception("Введено число больше 10"); // проверка диапазона чисел
        }


        int x = calculator(a, b, oper);  // метод выполняет вычисление

        if (a < 0 || b < 0) {
            throw new Exception("Числа должны быть больше 0");
        } else {
            result = String.valueOf(x);  // преобразует число в строку и возвращает результат
        }
        return result;

    }

    public static String detectOper(String expression) { //проверяем наличие оператора в строке
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    public static int calculator(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;

    }
}