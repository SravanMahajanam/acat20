package sort;

public class MergeSort {
    public void sort(int[] in) {
        int l = 0;
        int r = in.length - 1;

        int[] aux = new int[r];
        auxSort(in, l, r, aux);
    }

    private void auxSort(int[] in, int l, int r, int[] aux) {
        if (l >= r) {
            return;
        }

        int m = r - (r - l) / 2;
        int ls = l, le = m, rs = m + 1, re = r;
        auxSort(in, ls, le, aux);
        auxSort(in, rs, re, aux);
        checkAndMerge(in, ls, le, rs, re, aux);
    }

    private void checkAndMerge(int[] in, int ls, int le, int rs, int re, int[] aux) {
        int i = 0;
        while (ls <= le && rs <= re) {
            if (ls < rs) {
                aux[i++] = in[ls++];
            }
            else {
                aux[i++] = in[rs++];
            }
        }
        while (ls <= le) {
            aux[i++] = in[ls++];
        }

        while (rs <= re) {
            aux[i++] = in[re++];
        }

        for (int j = 0; j<= i; ++j) {
            in[j] = aux[i];
        }
    }
}
