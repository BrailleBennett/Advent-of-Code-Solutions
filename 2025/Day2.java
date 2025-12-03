public class Day2 {
    public static String inputUnsplit = "";
    public static String[] input = inputUnsplit.split(",");

    public static void main(String[] args) {
        long invalidIdPartOneTotal = 0;
        long invalidIdPartTwoTotal = 0;

        for (String id : input) {
            System.out.println(id);
            int dash = id.indexOf("-");
            long first = Long.parseLong(id.substring(0, dash));
            long second = Long.parseLong(id.substring(dash + 1));

            for (long i = first; i <= second; i++) {
                if (isInvalidForPartOne(i)) {
                    invalidIdPartOneTotal += i;
                }

                if (isInvalidForPartTwo(i)) {
                    invalidIdPartTwoTotal += i;
                }
            }
        }

        System.out.println("Puzzle part one total invalid IDs sum: " + invalidIdPartOneTotal);
        System.out.println("Puzzle part two total invalid IDs sum: " + invalidIdPartTwoTotal);
    }

    public static boolean isInvalidForPartOne(long id) {
        String stringId = String.valueOf(id);
        int midPoint = stringId.length() / 2;
        return stringId.substring(0, midPoint).equals(stringId.substring(midPoint));
    }

    public static boolean isInvalidForPartTwo(long id) {
        String stringId = String.valueOf(id);
        int length = stringId.length();

        for (int i = 1; i <= length / 2; i++) {
            if (length % i == 0) {
                String tempStringId = stringId.substring(0, i);
                boolean isInvalid = true;

                for (int j = i; j < length; j += i) {
                    if (!stringId.substring(j, j + i).equals(tempStringId)) {
                        isInvalid = false;
                        break;
                    }
                }

                if (isInvalid) return true;
            }
        }

        return false;
    }
}
