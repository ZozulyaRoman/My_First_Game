package my_first_game;

public class Logic {

    private static int number = 0;
    private static int winCount;

    public static int random() {
        int prog = (int) (Math.random() * 9 + 1);
        return prog;
    }

    public static String compareInt(int a, int count, int prog) {
        String s;

        int user = a;
        if (user == prog) {
            s = "Поздравляю вы угадали, с " + count + "й попытки";
            if (count <= 3) {
                winCount++;
                ButtonsListener.setWinCount(winCount);
            } else {
                winCount--;
                ButtonsListener.setWinCount(winCount);
            }
        } else {
            s = "Вы не угадали";
            if (user > prog) {
                s += "Мое число меньше";
            } else {
                s += "Мое число больше";
            }
        }
        return s + "\n" + "Ваш текущий счет: " + winCount;
    }

    public static String labelPic(String[] lables) {
        if (winCount == 3) {
            number++;
            winCount = 0;
            ButtonsListener.setWinCount(winCount);
        }
        if (number > lables.length - 1) {
            number = 0;
        }
        return lables[number];
    }

}
