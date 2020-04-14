import java.util.Random;
import java.util.Scanner;

public class Main {
    static int rNumber;
    static int countTry;
    static String rWord;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameRandom(); //Задание 1
        //GameWord(); //Задание 2
    }

    static void GameWord() {
        startNewGameWord();
        GameWordProcess();
    }

    static void GameRandom() {
        while (true) {
            startNewGameRandom();
            GameRandomProcess();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int answer = scanner.nextInt();
            if (answer == 0) {
                break;
            }
        }
    }

    static void startNewGameWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        rNumber = rand.nextInt(words.length-1);
        rWord = words[rNumber];
    }

    static void GameWordProcess() {
        String userWord;
        System.out.println("Введите загаданое слово. Или exit для выхода");
        while (true) {
            userWord = scanner.nextLine();
            if(userWord.toLowerCase().equals(rWord)) {
                System.out.printf("Поздравляю вы угадали верно. Загаданое слово %s\n",rWord);
                break;
            } else if(userWord.toLowerCase().equals("exit")) {
                System.out.printf("Вы досрочно завершили игру. Загаданое слово %s\n",rWord);
                break;
            } else {
                System.out.printf("Неверно. Загаданое слово %s\n",GameWordEq(userWord,rWord));
            }
        }
    }

    static String GameWordEq(String word1, String word2) {
        int countW = 0;
        StringBuilder newWord = new StringBuilder();
        if(word1.length()>word2.length()) {
            countW = word2.length();
        } else {
            countW = word1.length();
        }
        for (int i = 0; i < countW-1; i++) {
            if(word1.charAt(i)!=word2.charAt(i)) {
                newWord.append("#");
            } else {
                newWord.append(word1.charAt(i));
            }
        }
        for (int i = 0; i <= 15-countW; i++) {
            newWord.append("#");
        }
        return newWord.toString();
    }

    static void startNewGameRandom() {
        Random rand = new Random();
        rNumber = rand.nextInt(10);
        countTry = 3;
        System.out.println("Начата новая игра.");
    }

    static void GameRandomProcess() {
        int userNumber;
        System.out.printf("Введите число от 0 до 9. У вас %d попытки.\n",countTry);
        while (true) {
            userNumber = scanner.nextInt();
            if (userNumber>rNumber) {
                countTry--;
                System.out.printf("Ваше число %d больше загадоного. Осталось %d попытки.\n",userNumber,countTry);
            } else if (userNumber<rNumber) {
                countTry--;
                System.out.printf("Ваше число %d меньше загадоного. Осталось %d попытки.\n",userNumber,countTry);
            } else if (userNumber==rNumber) {
                System.out.printf("Поздравляю вы угадали верно. Загаданое число %d\n",rNumber);
                break;
            }
            if(countTry==0) {
                System.out.printf("К сожалению вы не угадали. Загаданое число %d\n",rNumber);
                break;
            }
        }
    }
}
