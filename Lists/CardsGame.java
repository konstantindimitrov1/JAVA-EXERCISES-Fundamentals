import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOneCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwoCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        while (!playerOneCards.isEmpty() && !playerTwoCards.isEmpty()) {
            int firstPlayerCard = playerOneCards.get(0);
            int secondPlayerCard = playerTwoCards.get(0);
            if (firstPlayerCard > secondPlayerCard) {
                addWinnersCardsAndRemoveLosersCards(playerOneCards, playerTwoCards);
            } else if (secondPlayerCard > firstPlayerCard) {
                addWinnersCardsAndRemoveLosersCards(playerTwoCards, playerOneCards);
            } else {
                playerOneCards.remove(0);
                playerTwoCards.remove(0);
            }
        }

        int sum;

        if (playerOneCards.isEmpty()) {
            sum = calculateWinnersCards(playerTwoCards);
            System.out.println("Second player wins! Sum: " + sum);
        } else {
            sum = calculateWinnersCards(playerOneCards);
            System.out.println("First player wins! Sum: " + sum);
        }
    }

    private static void addWinnersCardsAndRemoveLosersCards(List<Integer> winner, List<Integer> loser) {
        winner.add(winner.get(0));
        winner.add(loser.get(0));
        winner.remove(0);
        loser.remove(0);
    }

    static int calculateWinnersCards(List<Integer> winnersCards) {
        int sum = 0;
        for (Integer winnersCard : winnersCards) {
            sum += winnersCard;
        }
        return sum;
    }
}
