package engine.eqns;

import java.util.ArrayList;

import engine.Model;

public class Equation2 extends Model {
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public Equation2(ArrayList<String> args) {
		answer = solve(args.get(0), args.get(1));
	}

	private String solve(String eqn1, String eqn2) {
		return eqn1;
	}
}
