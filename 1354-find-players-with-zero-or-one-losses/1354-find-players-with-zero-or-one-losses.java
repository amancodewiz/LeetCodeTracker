import java.util.*;

/**
 * Problem:
 *  matches[i] = {winner, loser}
 *  Return two sorted lists:
 *   1) players who never lost
 *   2) players who lost exactly once
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        // Count of losses for each player
        Map<Integer, Integer> lossCount = new HashMap<>();

        // Keep track of everyone who appears (winners or losers)
        Set<Integer> allPlayers = new HashSet<>();

        // ----- Pass 1: build loss counts and the set of all players -----
        for (int[] m : matches) {
            int winner = m[0];
            int loser  = m[1];

            allPlayers.add(winner);
            allPlayers.add(loser);

            // increment this loser's loss count
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        // ----- Pass 2: split players by their loss count -----
        List<Integer> zeroLoss  = new ArrayList<>();
        List<Integer> oneLoss   = new ArrayList<>();

        for (int player : allPlayers) {
            int cnt = lossCount.getOrDefault(player, 0);
            if (cnt == 0) {
                zeroLoss.add(player);       // players who never lost
            } else if (cnt == 1) {
                oneLoss.add(player);        // players who lost exactly once
            }
        }

        // Sort as required
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        // Build answer
        List<List<Integer>> ans = new ArrayList<>(2);
        ans.add(zeroLoss);
        ans.add(oneLoss);
        return ans;
    }
}
