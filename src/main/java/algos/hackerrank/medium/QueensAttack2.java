package algos.hackerrank.medium;

public class QueensAttack2 {

    static int queensAttack(int n, int r_q, int c_q, int[][] obstacles) {
        int res = 0;


        int minUpx = Integer.MAX_VALUE;
        int uCount = 0;
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[0] == r_q && obstacle[1] < c_q) {
                    if (minUpx > Math.abs(c_q - obstacle[1])) {
                        minUpx = Math.abs(c_q - obstacle[1]);
                        uCount = obstacle[1];
                    }
                }
            }
        }

        int[][] up = new int[c_q - 1][2];
        for (int i = 0; i < up.length; i++) {
            if (uCount == c_q - 1 - i || c_q - 1 - i == 0) {
                break;
            } else {
                up[i] = new int[]{r_q, c_q - 1 - i};
                res++;
            }
        }


        int minDownx = Integer.MAX_VALUE;
        int dCount = 0;
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[0] == r_q && obstacle[1] > c_q) {
                    if (minDownx > Math.abs(c_q - obstacle[1])) {
                        minDownx = Math.abs(c_q - obstacle[1]);
                        dCount = obstacle[1];
                    }
                }
            }
        }
        int[][] down = new int[n - c_q][2];
        for (int i = 0; i < down.length; i++) {
            if (dCount == c_q + 1 + i) {
                break;
            } else {
                down[i] = new int[]{r_q, c_q + 1 + i};
                res++;
            }
        }


        int minLeftx = Integer.MAX_VALUE;
        int lCount = 0;
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[1] == c_q && obstacle[0] < r_q) {
                    if (minLeftx > Math.abs(r_q - obstacle[0])) {
                        minLeftx = Math.abs(r_q - obstacle[0]);
                        lCount = obstacle[0];
                    }
                }
            }
        }
        int[][] left = new int[r_q - 1][2];
        for (int i = 0; i < left.length; i++) {
            if (lCount == r_q - 1 - i || r_q - 1 - i == 0) {
                break;
            } else {
                left[i] = new int[]{r_q - 1 - i, c_q};
                res++;
            }
        }


        int minRightx = Integer.MAX_VALUE;
        int rCount = 0;
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[1] == c_q && obstacle[0] > r_q) {
                    if (minRightx > Math.abs(r_q - obstacle[0])) {
                        minRightx = Math.abs(r_q - obstacle[0]);
                        rCount = obstacle[0];
                    }
                }
            }
        }
        int[][] right = new int[n - r_q][2];
        for (int i = 0; i < right.length; i++) {
            if (rCount == r_q + 1 + i) {
                break;
            } else {
                right[i] = new int[]{r_q + 1 + i, c_q};
                res++;
            }
        }


        int minLeftxy = Integer.MAX_VALUE;
        int[] lxyCount = new int[2];
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[1] - c_q == obstacle[0] - r_q && obstacle[0] < r_q && obstacle[1] < c_q) {
                    if (minLeftxy > Math.abs(r_q - obstacle[0])) {
                        minLeftxy = Math.abs(r_q - obstacle[0]);
                        lxyCount[0] = obstacle[0];
                        lxyCount[1] = obstacle[1];
                    }
                }
            }
        }

        int[][] leftUp = new int[Integer.min(c_q, r_q)][2];
        for (int i = 0; i < leftUp.length; i++) {
            if ((lxyCount[0] == r_q - 1 - i && lxyCount[1] == c_q - 1 - i) || c_q - 1 - i == 0 || r_q - 1 - i == 0) {
                break;
            } else {
                leftUp[i] = new int[]{r_q - 1 - i, c_q - 1 - i};
                res++;
            }
        }


        int minRighUptxy = Integer.MAX_VALUE;
        int[] ruxyCount = new int[2];
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (c_q - obstacle[1] == obstacle[0] - r_q && obstacle[0] > r_q && obstacle[1] < c_q) {
                    if (minRighUptxy > Math.abs(r_q - obstacle[0])) {
                        minRighUptxy = Math.abs(r_q - obstacle[0]);
                        ruxyCount[0] = obstacle[0];
                        ruxyCount[1] = obstacle[1];
                    }
                }
            }
        }
        int[][] rightUp = new int[Integer.min(c_q, n - r_q)][2];
        for (int i = 0; i < rightUp.length; i++) {
            if (ruxyCount[0] == r_q + 1 + i && ruxyCount[1] == c_q - 1 - i || c_q - 1 - i == 0 || r_q + 1 + i == 0) {
                break;
            } else {
                rightUp[i] = new int[]{r_q + 1 + i, c_q - 1 - i};
                ++res;
            }

        }


        int minRightDownxy = Integer.MAX_VALUE;
        int[] rdxyCount = new int[2];
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[1] - c_q == obstacle[0] - r_q && obstacle[0] > r_q && obstacle[1] > c_q) {
                    if (minRightDownxy > Math.abs(r_q - obstacle[0])) {
                        minRightDownxy = Math.abs(r_q - obstacle[0]);
                        rdxyCount[0] = obstacle[0];
                        rdxyCount[1] = obstacle[1];
                    }
                }
            }
        }
        int[][] rightDown = new int[Integer.min(n - c_q, n - r_q)][2];
        for (int i = 0; i < rightDown.length; i++) {
            if (rdxyCount[0] == r_q + 1 + i && rdxyCount[1] == c_q + 1 + i) {
                break;
            } else {
                rightDown[i] = new int[]{r_q + 1 + i, c_q + 1 + i};
                ++res;
            }
        }


        int minLeftDownxy = Integer.MAX_VALUE;
        int[] ldxyCount = new int[2];
        if (obstacles != null) {
            for (int[] obstacle : obstacles) {
                if (obstacle[1] - c_q == r_q - obstacle[0] && obstacle[0] < r_q && obstacle[1] > c_q) {
                    if (minLeftDownxy > Math.abs(r_q - obstacle[0])) {
                        minLeftDownxy = Math.abs(r_q - obstacle[0]);
                        ldxyCount[0] = obstacle[0];
                        ldxyCount[1] = obstacle[1];
                    }
                }
            }
        }
        int[][] leftDown = new int[Integer.min(n - c_q, r_q - 1)][2];
        for (int i = 0; i < leftDown.length; i++) {
            if (ldxyCount[0] == r_q - 1 - i && ldxyCount[1] == c_q + 1 + i || r_q - 1 - i == 0) {
                break;
            } else {
                leftDown[i] = new int[]{r_q - 1 - i, c_q + 1 + i};
                res++;
            }
        }
        return res;

    }
}
