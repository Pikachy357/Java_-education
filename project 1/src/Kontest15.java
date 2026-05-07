import java.io.*;
import java.util.*;

class Kontest15 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int proekciya(int packed, int mask, int m) {
        int key = 0;
        for (int i = 0; i < m; i++) {
            if ((mask & (1 << i)) != 0) {
                int bukva = (packed >> (i * 5)) & 31;
                key = key * 27 + (bukva + 1);
            }
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String nStr = next();
        String mStr = next();
        if (nStr == null || mStr == null) return;

        int n = Integer.parseInt(nStr);
        int m = Integer.parseInt(mStr);

        int vseMaski = 1 << m;
        ArrayList<Integer>[] gruppy = new ArrayList[vseMaski];
        for (int i = 0; i < vseMaski; i++) gruppy[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = next();
            if (s == null) return;

            int mask = 0;
            int packed = 0;
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c != '?') {
                    mask |= (1 << j);
                    int val = c - 'a';
                    packed |= (val << (j * 5));
                }
            }
            gruppy[mask].add(packed);
        }

        long otvet = 0;

        for (int a = 0; a < vseMaski; a++) {
            if (gruppy[a].isEmpty()) continue;

            HashMap<Integer, Integer> cntSame = new HashMap<>();
            ArrayList<Integer> tek = gruppy[a];
            for (int i = 0; i < tek.size(); i++) {
                int packed = tek.get(i);
                int key = proekciya(packed, a, m);
                cntSame.put(key, cntSame.getOrDefault(key, 0) + 1);
            }
            Iterator<Integer> it = cntSame.values().iterator();
            while (it.hasNext()) {
                int c = it.next();
                otvet += (long) c * (c - 1) / 2;
            }

            for (int b = a + 1; b < vseMaski; b++) {
                if (gruppy[b].isEmpty()) continue;
                int peresechenie = a & b;

                ArrayList<Integer> g1 = gruppy[a];
                ArrayList<Integer> g2 = gruppy[b];
                if (g1.size() > g2.size()) {
                    ArrayList<Integer> tmp = g1;
                    g1 = g2;
                    g2 = tmp;
                }

                HashMap<Integer, Integer> cnt = new HashMap<>();
                for (int i = 0; i < g1.size(); i++) {
                    int packed = g1.get(i);
                    int key = proekciya(packed, peresechenie, m);
                    cnt.put(key, cnt.getOrDefault(key, 0) + 1);
                }
                for (int i = 0; i < g2.size(); i++) {
                    int packed = g2.get(i);
                    int key = proekciya(packed, peresechenie, m);
                    otvet += cnt.getOrDefault(key, 0);
                }
            }
        }

        out.println(otvet);
        out.flush();
    }
}