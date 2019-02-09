package algos.hackerrank.medium;

import java.util.Comparator;

public class ComparatorPlayer implements Comparator<ComparatorPlayer.Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score > b.score) {
            return -1;
        } else if (a.score < b.score) {
            return 1;
        }

        return a.name.compareTo(b.name);
    }

    class Player {
        String name;
        int score;
    }
}
