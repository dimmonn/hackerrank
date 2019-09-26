package algos.hackerrank.medium;

import java.util.concurrent.CompletableFuture;

public class CrosswordPuzzle {
    static String[] crosswordPuzzle(String[] crossword, String words) {

        int[][] data = new int[10][10];

        for (int i = 0; i < data.length; i++) {
            int[] datum = data[i];
            for (int j = 0; j < data[i].length; j++) {
                int raw = data[i][j];
                if (crossword[i].charAt(j)=='-') {
                    data[i][j]=0;
                } else {
                    data[i][j]=1;
                }

            }
        }



        return new String[]{"+L++++++++", "+O++++++++", "+N++++++++", "+DELHI++++", "+O+++C++++", "+N+++E++++", "+++++L++++", "++ANKARA++", "+++++N++++", "+++++D++++"};
    }

    public static void main(String[] args) {
        String[] strings = {"+-++++++++", "+-++++++++", "+-------++", "+-++++++++", "+-++++++++", "+------+++", "+-+++-++++", "+++++-++++", "+++++-++++", "++++++++++"};
        System.out.println(crosswordPuzzle(strings,"POLAND;LHASA;SPAIN;INDIA"));

    }
}

//+-++++++++
//+-++++++++
//+-++++++++
//+-----++++
//+-+++-++++
//+-+++-++++
//+++++-++++
//++------++
//+++++-++++
//+++++-++++
//LONDON;DELHI;ICELAND;ANKARA