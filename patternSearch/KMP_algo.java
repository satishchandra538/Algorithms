package patternSearch;

class KMP_algo {
    void generatelps(String patt, int m, int arr[]) {
        arr[0] = 0;
        int len = 0;
        for (int i = 1; i < m; i++) {
            if (patt.charAt(i) == patt.charAt(len)) {
                arr[i] = ++len;
            } else {
                if (len != 0) {
                    len = arr[len - 1];
                } else {
                    arr[i] = len;
                    i++;
                }
            }
        }
        printarray(arr);
    }

    void find(String str, String patt) {
        int i = 0, j = 0, n = str.length(), m = patt.length();
        int lps[] = new int[m];
        generatelps(patt, m, lps);
        while (i < n) {
            if (str.charAt(i) == patt.charAt(j)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];
            }

            else if (i < n && patt.charAt(j) != str.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
    void printarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        KMP_algo kmp = new KMP_algo();
        String str = "abbabcaaababababababbaaaaaacccccababacabaccabacbacbacbacbabacbacbabbab";
        String patt = "baaababbbbaabaababbaaccccbab";
        kmp.find(str, patt);
    }
}