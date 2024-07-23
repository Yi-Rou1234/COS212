public class Extraction extends HashFunction {
    public Extraction(int n) {
        num = n;
    }

    @Override
    public int hash(String input) {
        if (stringToNum(input).length() <= num) {
            return Integer.parseInt(stringToNum(input));
        }
        String sub = stringToNum(input).substring(stringToNum(input).length() - num);
        return Integer.parseInt(sub);
    }

}
