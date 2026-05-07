import java.io.*;
import java.util.*;

class Kontest14 {
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

    static class Slovo {
        String text;
        int used;

        Slovo(String text) {
            this.text = text;
            this.used = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String nStr = next();
        String kStr = next();
        if (nStr == null || kStr == null) return;

        int n = Integer.parseInt(nStr);
        int k = Integer.parseInt(kStr);

        Comparator<Slovo> cmp = new Comparator<Slovo>() {
            public int compare(Slovo a, Slovo b) {
                if (a.used != b.used) return Integer.compare(a.used, b.used);
                return a.text.compareTo(b.text);
            }
        };
        ArrayList<PriorityQueue<Slovo>> ochered = new ArrayList<>();
        for (int i = 0; i < 26; i++) ochered.add(new PriorityQueue<>(cmp));

        for (int i = 0; i < n; i++) {
            String w = next();
            if (w == null || w.isEmpty()) return;
            int idx = w.charAt(0) - 'a';
            ochered.get(idx).add(new Slovo(w));
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String s = next();
            if (s == null || s.isEmpty()) return;
            int idx = s.charAt(0) - 'a';

            Slovo best = ochered.get(idx).poll();
            ans.append(best.text).append('\n');
            best.used++;
            ochered.get(idx).add(best);
        }

        out.print(ans);
        out.flush();
    }
}