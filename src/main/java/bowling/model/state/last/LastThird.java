package bowling.model.state.last;

import bowling.model.state.EndState;

public class LastThird extends EndState {
	private int firstScore;
	private int secondScore;
	private int thirdScore;

	public LastThird(int firstScore, int secondScore, int thirdScore) {
		if (firstScore + secondScore < 10) {
			throw new IllegalArgumentException();
		}
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
	}

	@Override
	public String getScore() {
		return checkStrike(firstScore) + "|" + checkSecond() + "|" + checkThird();
	}

	private String checkSecond() {
		if (firstScore + secondScore == 10) {
			return "/";
		}
		return checkStrike(secondScore);
	}

	private String checkThird() {
		if (firstScore + secondScore != 10 && secondScore + thirdScore== 10) {
			return "/";
		}
		return checkStrike(thirdScore);
	}

	private String checkStrike(int score) {
		if (score == 10) {
			return "X";
		}
		return Integer.toString(score);
	}
}
