public class Division extends HashFunction {

    public Division(int n) {
        num = n;
    }

    @Override
    public int hash(String input) {
        String n = stringToNum(input);
        return (int) (Long.parseLong(n) % num);
    }
}
