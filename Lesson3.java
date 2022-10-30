package ru.geekbrains;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {


    public static void game1() {
        System.out.println("Ваша задача угадать с трех попыток загаданное число от 0 до 9");

        Random rand = new Random();
        int numRand = rand.nextInt(10); // случайное число от 0 до 9
        int attempts = 3; // кол-во попыток
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Введите число: ");

            int inputNumber = sc.nextInt();
            if (inputNumber == numRand) {
                System.out.println("Вы угадали!");
                return;

            } else if (inputNumber > numRand) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }
            attempts--;
        } while (attempts > 0);
        System.out.println("Вы не угадали число. Было загадано: " + numRand);

        System.out.println("Еще раз сыграть если ДА, то нажмите 1, если НЕТ то нажмите 2");
        int yes = 1;
        int replay = sc.nextInt();
        if (replay == yes) {
            game1();
        } else {
            System.out.println("Вы вышли в основное меню!\n");
        }
    }

    public static void game2() {
        // Объявляем массив из слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        // Объявляем вспомогательный класс Random (для генерации случайного числа, сопоставление случайного числа индексу элементов массива слов)
        Random random = new Random();
        // Получаем случайное число
        Scanner sc = new Scanner(System.in);
        int num = random.ints(0, 25).findFirst().getAsInt();
        // Выводим подсказку (загаданное слово на экран)
        System.out.format("Компьютер загадал слово, попробуйте его угадать (подсказка: \"%s\").\n", words[num]);

        // Создаем вечный цикл
        while (true) {
            String word; // Переменная будет хранить слово, которое вводит пользователь
            int counter = 0; // Счетчик, который будет хранить кол-во совпавших символов слов
            System.out.print("Введите слово: ");
            word = sc.next();
            System.out.println();

            // Проходим по массиву из 15 индексов (как от нас требует задание, что бы составить маску из 15 знаков #)
            for (int i = 0; i < 15; i++) {
                // Если текущий индекс "i" попадает в размерность длинны искомого слова и слова, которое мы ввели с консоли,
                // сравним символы двух слов по индексу "i"
                if (word.length() - 1 >= i && words[num].length() - 1 >= i && word.charAt(i) == words[num].charAt(i)) {
                    // Символы слов равны, печатаем символ
                    System.out.print(word.charAt(i));
                    // Увеличиваем счетчик совпавших символов слов
                    counter++;
                    // Если все символы искомого слова и введенного совпали, мы, фактически, угадали слово, выходим из цикла
                    if (counter == words[num].length())
                        break;
                } else {
                    // Если символы слов не совпали, печатаем символ #
                    System.out.print("#");
                }
            }

            // Выводим результат сравнения двух слов:

            // Еще раз проверим, если все символы искомого слова и введенного совпали, мы, фактически, угадали слово.
            // Печатаем соответствующее сообщение и выходим из вечного цикла (завершаем работу метода)
            if (counter == words[num].length()) {
                System.out.println("\n\nВы успешно угадали слово.");
                System.out.println("Завершение работы подпрограммы.");
                return;
            } else {
                // Если мы не угадали слово, предложим пользователю сыграть еще раз.
                System.out.format("\n\nВы не угадали слово.\n");
                while (true) {
                    System.out.print("Повторить игру еще раз? (1 – да / 0 – нет): ");
                    if (sc.hasNextInt()) {
                        counter = sc.nextInt();
                        if (counter == 0) {
                            System.out.println("Завершение работы подпрограммы.");
                            return;
                        } else if (counter == 1) {
                            break;
                        } else {
                            System.out.println("Номер пункта меню не найден. Пожалуйста, повторите попытку ввода.");
                            sc.next();
                        }
                    } else {
                        System.out.println("Вы ввели некорректное число. Пожалуйста, повторите попытку ввода.");
                        sc.next();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        boolean tr = true;

        while (tr) {

            System.out.println("\nМЕНЮ ПРОГРАММЫ");
            System.out.println("*************************");
            System.out.println("1 - игра Угадай число");
            System.out.println("2 - игра Угадай слово");
            System.out.println("0 - Завершение программы");
            System.out.println("*************************\n");
            System.out.print("Введите значение интересующего раздела: ");

            Scanner sc = new Scanner(System.in);


            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                switch (num) {

                    case 1:
                        game1();
                        break;

                    case 2:
                        game2();
                        break;

                    case 0:
                        System.out.println("Вы вышли из приложения!\nЖдем Вас снова!");
                        tr = false;
                        break;


                    default:
                        System.out.println("Вы ввели неверное значение, попробуйте еще раз ввести новое значение");
                        break;

                }
            } else {
                System.out.println("Вы ввели неверное значение, попробуйте еще раз ввести новое значение");
            }
        }
    }
}



