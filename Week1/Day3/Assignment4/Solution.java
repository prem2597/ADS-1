/**
 * @author PREM
 */
class Solution {
	/**
	 * sort method to sort the teams.
	 * @param teams team with number of wins,loss.draw.
	 * @return team
	 */
	public Team[] sort(final Team[] teams) {
		// your code goes here
		int n = teams.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (teams[j - 1].compareTo(teams[j]) == -1) {
					Team temp = teams[j - 1];
					teams[j - 1] = teams[j];
					teams[j] = temp;
				} else {
					break;
				}
			}
		}
		return teams;
	}
}
class Team implements Comparable<Team> {
	/**
	 * teamName.
	 */
	private String teamName;
	/**
	 * Number of wins.
	 */
	private int noOfWins;
	/**
	 * Number of losses.
	 */
	private int noOfLosses;
	/**
	 * Number of draws.
	 */
	private int noOfDraws;
	Team(final String name, final int wins,
	final int losses, final int draws) {
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public int compareTo(final Team that) {
        if (this.noOfWins > that.noOfWins) {
			return 1;
		}
		if (this.noOfWins < that.noOfWins) {
			return -1;
		}
		if (this.noOfLosses < that.noOfLosses) {
			return 1;
		}
		if (this.noOfLosses > that.noOfLosses) {
			return -1;
		}
		if (this.noOfDraws > that.noOfDraws) {
			return 1;
		}
		if (this.noOfDraws < that.noOfDraws) {
			return -1;
		}

		if (teamName.compareTo(that.teamName) < 0) {
			return 1;
		}
		return 0;

	}
	public String toString() {
		//retrun all the attributes as a string but appending with ", "
		String teamDetails = new String();
		return this.teamName + "," + this.noOfWins
		+ "," + this.noOfLosses + "," + this.noOfDraws;
    }
}
