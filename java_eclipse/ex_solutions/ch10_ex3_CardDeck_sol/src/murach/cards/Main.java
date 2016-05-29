package murach.cards;

public class Main {

    private static String[] suits = {"H", "C", "D", "S"};
    private static String[] cards = new String[52];
    private static String[][] hands = new String[4][5];

    public static void main(String[] args) {
        loadCardArray();
        printCardArray();
        shuffleCards();
        printCardArray();
        dealCards();
        showCards();
    }

    private static void loadCardArray() {
        int i = 0;
        for (String suite : suits) {
            for (int cardNumber = 1; cardNumber < 14; cardNumber++) {
                cards[i] = suite + cardNumber;
                i++;
            }
        }
    }

    private static void printCardArray() {
        int i = 0;
        for (int row = 0; row < 4; row++) {
            for (int card = 0; card < 13; card++) {
                System.out.print(cards[i] + " ");
                i++;
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void shuffleCards() {
        for (int i = 0; i < cards.length; i++) {
            // get random index
            int randomIndex = (int) (Math.random() * 51);
            
            // swap cards
            String card = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = card;
        }        
    }

    private static void dealCards() {
        int i = 0;
        for (int card = 0; card < 5; card++) {
            for (int hand = 0; hand < 4; hand++) {
                hands[hand][card] = cards[i];
                i++;
            }
        }
    }

    private static void showCards() {
        for (String[] hand : hands) {
            for (String card : hand) {
                System.out.print(card + " ");
            }
            System.out.println();
        }
    }
}