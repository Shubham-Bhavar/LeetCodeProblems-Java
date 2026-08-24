    /*
     * Question:
     * Match the maximum number of players with trainers.
     *
     * A player can match with a trainer if:
     * player ability <= trainer capacity
     *
     * Each player and trainer can be used only once.
     */
import java.util.Arrays;

class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        // Sort both arrays in ascending order
        Arrays.sort(players);
        Arrays.sort(trainers);

        int player = 0;
        int trainer = 0;
        int matches = 0;

        // Match the smallest possible player with a suitable trainer
        while (player < players.length && trainer < trainers.length) {

            if (players[player] <= trainers[trainer]) {
                // Valid match found
                matches++;
                player++;
            }

            // This trainer cannot be used again
            trainer++;
        }

        return matches;
    }
}
