import java.util.List;
import java.util.*;
class HighScores {

    List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
    }

    List<Integer> scores() {
        return this.scores;
    }

    Integer latest() {
        return this.scores.get(this.scores.size() - 1);
    }

    Integer personalBest() {
        List<Integer> sortedScores= new ArrayList<>(this.scores);
        Collections.sort(sortedScores, Collections.reverseOrder());
        return sortedScores.get(0);
    }

    List<Integer> personalTopThree() {
        List<Integer> sortedScores= new ArrayList<>(this.scores);
        Collections.sort(sortedScores, Collections.reverseOrder());
        if(sortedScores.size() < 3) {
            return sortedScores.subList(0,sortedScores.size());
        }
        return sortedScores.subList(0, 3);
    }

}
