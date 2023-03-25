import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine();

            Team team = new Team(teamName);

            System.out.print("Enter player names separated by commas (without spaces): ");
            String playerNames = scanner.nextLine();

            String[] players = playerNames.split(",");
            for (String player : players) {
                team.addPlayer(player.trim());
            }

            System.out.println("Number of players in team " + team.getPlayerCount());
            System.out.println("Players on team: " + String.join(", ", team.getPlayers()));

            System.out.print("Do you want to enter another team? (y/n) ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
    }
}
