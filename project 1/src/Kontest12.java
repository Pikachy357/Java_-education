import java.io.*;
import java.util.*;

public class Kontest12 {
    static HashMap<String, String> p = new HashMap<>();
    static HashMap<String, String> num = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());

        String[] a = readArr(reader, n);
        String[] b = readArr(reader, n);

        boolean ok = true;

        for (int i = 0; i < n; i++) {
            String x = a[i];
            String y = b[i];

            if (isNum(x)) {
                x = "$" + x;
            }

            if (isNum(y)) {
                y = "$" + y;
            }

            add(x);
            add(y);

            String rx = root(x);
            String ry = root(y);

            if (!rx.equals(ry)) {
                String nx = num.get(rx);
                String ny = num.get(ry);

                if (nx != null && ny != null && !nx.equals(ny)) {
                    ok = false;
                    break;
                }

                p.put(rx, ry);

                if (nx != null) {
                    num.put(ry, nx);
                } else if (ny != null) {
                    num.put(ry, ny);
                }
            }
        }

        if (ok) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }

        writer.flush();
    }

    static void add(String s) {
        if (!p.containsKey(s)) {
            p.put(s, s);

            if (s.charAt(0) == '$') {
                num.put(s, s);
            }
        }
    }

    static String root(String s) {
        String r = p.get(s);

        if (r.equals(s)) {
            return s;
        }

        r = root(r);
        p.put(s, r);

        return r;
    }

    static boolean isNum(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    static String[] readArr(BufferedReader br, int n) throws IOException {
        String[] arr = new String[n];
        int k = 0;
        while (k < n) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && k < n) arr[k++] = st.nextToken();
        }
        return arr;
    }
}