public class Folding extends HashFunction {
    public boolean shift;

    public Folding(int n, boolean s) {
        num = n;
        shift = s;
    }

    @Override
    public int hash(String input) {
        String h = stringToNum(input);
        while (h.length() % num != 0) {
            h = h + "0";
        }

        int index = 0;
        boolean rev = false;
        int total = 0;
        while (index < h.length()) {
            String strhash = "";
            for (int i = 0, j = index; i < num && j < h.length(); i++, j++) {
                if (shift) {
                    strhash += h.charAt(j);
                } else if (rev) {
                    strhash = h.charAt(j) + strhash;
                } else {
                    strhash += h.charAt(j);
                }
            }
            total = total + Integer.parseInt(strhash);
            rev = !rev;
            index += num;
        }
        return total;
    }
}
