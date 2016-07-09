public class TestMain {
	public static void main(String[] args) {

		Card a1 = new Card(1, "clubs");
		Card a2 = new Card(2, "diamonds");
		Card a3 = new Card(3, "spades");
		Card a4 = new Card(4, "clubs");
		Card a5 = new Card(5, "hearts");

		Card b1 = new Card(6, "clubs");
		Card b2 = new Card(7, "diamonds");
		Card b3 = new Card(8, "spades");
		Card b4 = new Card(9, "clubs");
		Card b5 = new Card(10, "hearts");

		PokerGame p1 = new PokerGame();

		System.out.println(p1.checkRank(a1, a2, a3, a4, a5));
		System.out.println(p1.checkRank(b1, b2, b3, b4, b5));
		System.out.println(p1.compareHands(a1, a2, a3, a4, a5, b1, b2, b3, b4,
				b5));
	}
}
