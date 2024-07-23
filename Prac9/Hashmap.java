public class Hashmap {
    public HashFunction[] functions;

    public class Node {
        public String key;
        public Node next;
    }

    private Node[] LinkNodesArr;

    public Hashmap(int length, HashFunction[] funcs) {
        LinkNodesArr = new Node[length];
        functions = funcs;
    }

    public int hash(String val) {
        int count = 0;
        int length = functions.length;
        int totalHash = 0;
        while (count < length) {
            totalHash += functions[count++].hash(val);
        }
        length = LinkNodesArr.length;
        return totalHash % length;
    }

    public boolean contains(String val) {
        int count = this.hash(val);
        if (LinkNodesArr[count] != null) {
            Node curr = LinkNodesArr[count];
            while (curr != null) {
                if (curr.key.equals(val)) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    public void insert(String s) {
        int count = hash(s);

        if (LinkNodesArr[count] == null) {
            LinkNodesArr[count] = new Node();
            LinkNodesArr[count].key = s;
            LinkNodesArr[count].next = null;
        } else {
            Node curr = LinkNodesArr[count];
            while (curr.next != null) {
                if (curr.key.equals(s)) {
                    return;
                }
                curr = curr.next;
            }
            if (curr.key.equals(s)) {
                return;
            }
            curr.next = new Node();
            curr.next.key = s;
            curr.next.next = null;
        }
    }

    public void remove(String s) {
        int count = hash(s);
        if (LinkNodesArr[count] != null) {
            Node prev = null;
            Node curr = LinkNodesArr[count];
            while (curr != null && !curr.key.equals(s)) {
                prev = curr;
                curr = curr.next;
            }
            if (prev == null) {
                LinkNodesArr[count] = curr.next;
            } else if (curr != null) {
                prev.next = curr.next;
            }
        }
    }

    public String toString() {
        String returString = "[";
        for (Node curr : LinkNodesArr) {
            String hashKeywithcomma = "";
            while (curr != null) {
                hashKeywithcomma += curr.key + ",";
                curr = curr.next;
            }

            if (hashKeywithcomma.length() == 0) {
                returString += ";";
                continue;
            }
            hashKeywithcomma = hashKeywithcomma.substring(0, hashKeywithcomma.length() - 1);
            returString += hashKeywithcomma + ";";
        }
        returString = returString.substring(0, returString.length() - 1);
        return returString + "]";
    }
};
