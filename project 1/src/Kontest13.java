import java.io.*;
import java.util.*;

public class Kontest13 {
    static class T {
        long x, y;

        T(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FS {
        private final InputStream in = System.in;
        private final byte[] b = new byte[1 << 16];
        private int p = 0, l = 0;

        int r() throws IOException {
            if (p >= l) {
                l = in.read(b);
                p = 0;
                if (l < 0)
                    return -1;
            }
            return b[p++];
        }

        Long nl() throws IOException {
            int c;
            do {
                c = r();
                if (c == -1)
                    return null;
            } while (c <= 32);
            int s = 1;
            if (c == '-') {
                s = -1;
                c = r();
            }
            long v = 0;
            while (c >= '0' && c <= '9') {
                v = v * 10 + c - '0';
                c = r();
            }
            return v * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FS fs = new FS();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Long n0 = fs.nl();
        if (n0 == null)
            return;
        int n = n0.intValue();
        T[] a = new T[n];
        for (int i = 0; i < n; i++)
            a[i] = new T(Math.abs(fs.nl()), Math.abs(fs.nl()));
        Arrays.sort(a, (u, v) -> u.x == v.x ? Long.compare(u.y, v.y) : Long.compare(u.x, v.x));

        ArrayList<T> uniq = new ArrayList<>();
        for (T t : a) {
            if (uniq.isEmpty() || uniq.get(uniq.size() - 1).x != t.x)
                uniq.add(new T(t.x, t.y));
            else if (t.y > uniq.get(uniq.size() - 1).y)
                uniq.get(uniq.size() - 1).y = t.y;
        }

        ArrayList<T> gran = new ArrayList<>();
        long maksY = 0;
        for (int i = uniq.size() - 1; i >= 0; i--) {
            T t = uniq.get(i);
            if (t.y > maksY) {
                gran.add(t);
                maksY = t.y;
            }
        }
        Collections.reverse(gran);

        int m = gran.size();
        long[] x = new long[m + 1], y = new long[m + 1], dp = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            x[i] = gran.get(i - 1).x;
            y[i] = gran.get(i - 1).y;
        }
        Arrays.fill(dp, Long.MAX_VALUE / 4);
        dp[0] = 0;

        for (int prav = 1; prav <= m; prav++) {
            for (int lev = 1; lev <= prav; lev++) {
                long var = dp[lev - 1] + 4L * x[prav] * y[lev];
                if (var < dp[prav])
                    dp[prav] = var;
            }
        }
        out.println(dp[m]);
        out.flush();
    }
}