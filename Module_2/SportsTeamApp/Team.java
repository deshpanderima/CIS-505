public class Team {
    private String teamName;
    private String[] players;
    private int playerCount;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[20];
        this.playerCount = 0;
    }

    public void addPlayer(String player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        }
    }

    public String[] getPlayers() {
        String[] result = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            result[i] = players[i];
        }
        return result;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }
}
