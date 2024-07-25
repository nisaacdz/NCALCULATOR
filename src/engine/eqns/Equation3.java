package engine.eqns;

import java.util.ArrayList;

import engine.Model;

public class Equation3 extends Model {
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public Equation3(ArrayList<String> args) {
		answer = solve(args.get(0), args.get(1), args.get(2));
	}

	private String solve(String eqn1, String eqn2, String eqn3) {
		return eqn1;
	}
}
