package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");

        }

        public int nextInt()   {

            return Integer.parseInt(next());
        }


        public String next()  {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            } else {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return next();
        }
    }