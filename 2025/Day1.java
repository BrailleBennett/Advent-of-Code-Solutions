public class Day1 {
    public static String inputUnsplit = "";
    public static String[] input = inputUnsplit.split("\n");

    public static void main(String[] args) {
        int currentNum = 50;
        int timesHitZero = 0;

        System.out.println("Inputs");

        for (String line : input) {
            System.out.println(line);

            if (line.startsWith("L")) {
                currentNum = (currentNum - Integer.parseInt(line.substring(1))) % 100;
            } else if (line.startsWith("R")) {
                currentNum = (currentNum + Integer.parseInt(line.substring(1))) % 100;
            }

            if (currentNum < 0) {
                currentNum += 100;
            } else if (currentNum > 99) {
                currentNum -= 100;
            }

            if (currentNum == 0) {
                timesHitZero++;
            }
        }

        System.out.println("Number of times hitting 0 is " + timesHitZero);

        int timesPassingZero = 0;
        currentNum = 50;
        for (String line : input) {
            if (line.startsWith("L")) {
                for (int i = 0; i < Integer.parseInt(line.substring(1)); i++) {
                    currentNum -= 1;
                    if (currentNum == 100) currentNum = 0;
                    if (currentNum == -1) currentNum = 99;
                    if (currentNum == 0) timesPassingZero++;
                }
            } else if (line.startsWith("R")) {
                for (int i = 0; i < Integer.parseInt(line.substring(1)); i++) {
                    currentNum += 1;
                    if (currentNum == 100) currentNum = 0;
                    if (currentNum == -1) currentNum = 99;
                    if (currentNum == 0) timesPassingZero++;
                }
            }
        }
        System.out.println("Number of times passing 0 is " + timesPassingZero);
    }
}
