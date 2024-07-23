public class MidSquare extends HashFunction {

    public MidSquare(int n) {
        num = n;
    }

    public int hash(String input) {
        String sqLong = Long.toString(Long.parseLong(stringToNum(input)) * Long.parseLong(stringToNum(input)));
        if (sqLong.length() <= num)
            return Integer.parseInt(sqLong);
        int leftPlusRight = (sqLong.length() - num);
        if (leftPlusRight % 2 != 0) {
            sqLong = sqLong + "0";
        }
        sqLong = sqLong.substring(0, sqLong.length() - (leftPlusRight / 2));
        return Integer.parseInt(sqLong.substring((leftPlusRight / 2)));
    }

}
