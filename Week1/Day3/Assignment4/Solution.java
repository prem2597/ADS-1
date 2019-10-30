class Solution{
	public Team[] sort(Team[] teams){
		// your code goes here
		int n = teams.length;
		for(int i = 0; i < n - 1; i++) {
			// int temp = i;
			for (int j = i + 1; j < n; j++) {
				if(teams[i].getname().compareTo(teams[j].getName()) > 1) {
					Team teamName = teams[i];
					teams[i] = teams[j];
					teams[j] = teamName;
				}
			}
		}
		// return null;
		// return arr;
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
		String 
        return "";
    }
}