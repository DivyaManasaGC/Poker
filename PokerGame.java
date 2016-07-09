import java.util.*;

public class PokerGame {
	

	public boolean isStraightFlush(int[] pips, int[] suits) {
		return ((suits[0] == suits[4] )&& (pips[4] - pips[0] == 4));
	}

	public boolean isFlush(int[] pips, int[] suits) {
		return (suits[0] == suits[4] );
	}

	public boolean isStraight(int[] pips, int[] suits) {
		return (pips[4] - pips[0] == 4);
	}

	public boolean isTwoPair(int[] pips, int[] suits) {
		int c = 0;
		for (int i = 0; i < pips.length - 1; i++) {
			if (pips[i] == pips[i + 1]) {
				c++;
			}
		}
		return c == 2;
	}

	public boolean isPair(int[] pips, int[] suits) {

		return (pips[0] == pips[1] || pips[1] == pips[2] || pips[2] == pips[3] || pips[3] == pips[4]);

	}

	public boolean isThreeOfAKind(int[] pips, int[] suits) {
		return (pips[0] == pips[2] || pips[1] == pips[3] || pips[2] == pips[4]);

	}

	public boolean isFourOfAKind(int[] pips, int[] suits) {
		return (pips[0] == pips[3] || pips[1] == pips[4]);

	}

	public boolean isFullHouse(int[] pips, int[] suits) {
		return ((pips[0] == pips[1] && pips[2] == pips[4]) || (pips[0] == pips[2] && pips[3] == pips[4]));

	}

	public int highCard(int[] pips, int[] suits) {
		return pips[pips.length - 1];
	}

	public boolean isRoyalFlush(int[] pips, int[] suits) {
		return (suits[0] == suits[4] && pips[0] == 1 && pips[1] == 10 && pips[4]
				- pips[1] == 3);
	}

	public String checkRank(Card a, Card b, Card c, Card d, Card e) {
		int[] pipValues = { a.pip, b.pip, c.pip, d.pip, e.pip };
		int[] suits = { a.suit, b.suit, c.suit, d.suit, e.suit };
		Arrays.sort(pipValues);
		Arrays.sort(suits);
		String rank = "";
		if (isRoyalFlush(pipValues, suits)) {
			rank = "RoyalFlush";
		} else if (isStraightFlush(pipValues, suits)) {
			rank = "straightFlush";
		} else if (isFourOfAKind(pipValues, suits)) {
			rank = "FourOfAKind";
		} else if (isFullHouse(pipValues, suits)) {
			rank = "FullHouse";
		} else if (isFlush(pipValues, suits)) {
			rank = "Flush";
		} else if (isStraight(pipValues, suits)) {
			rank = "Straight";
		} else if (isThreeOfAKind(pipValues, suits)) {
			rank = "ThreeOfAKind";
		} else if (isTwoPair(pipValues, suits)) {
			rank = "TwoPair";
		} else if (isPair(pipValues, suits)) {
			rank = "Pair";
		} else {
			rank = "HighCard";
		}
		return rank;
	}

	public String compareHands(Card a1, Card a2, Card a3, Card a4, Card a5,
			Card b1, Card b2, Card b3, Card b4, Card b5) {
		Map<String, Integer> rankMap = new HashMap<String, Integer>();
		rankMap.put("HighCard", 1);
		rankMap.put("Pair", 2);
		rankMap.put("TwoPair", 3);
		rankMap.put("ThreeOfAKind", 4);
		rankMap.put("Straight", 5);
		rankMap.put("Flush", 6);
		rankMap.put("FullHouse", 7);
		rankMap.put("FourOfAKind", 8);
		rankMap.put("straightFlush", 9);
		rankMap.put("RoyalFlush", 10);
		String rankA;
		String rankB;
		rankA = checkRank(a1, a2, a3, a4, a5);
		rankB = checkRank(b1, b2, b3, b4, b5);
		if (rankMap.get(rankA) == rankMap.get(rankB)) {
			return "both have equal ranks";
		} else {
			return rankMap.get(rankA) > rankMap.get(rankB) ? "A is the winner"
					: "B is the winner";
		}
	}
}

