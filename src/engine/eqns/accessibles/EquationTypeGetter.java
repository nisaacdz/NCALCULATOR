package engine.eqns.accessibles;

import java.util.ArrayList;

import engine.Methods;

public class EquationTypeGetter {
	private static int type = 0;
	private static int n;

	public static int getType(ArrayList<Object> arg) {
		if (isNoEquation(arg)) {
			type = 0;
		} else if (isPolynomial(arg)) {
			type = 13;
		} else {
			type = linearGetType(arg);
		}
		return type;
	}

	private static boolean isNoEquation(ArrayList<Object> arg) {
		if (!arg.contains('x') && !arg.contains('y') && !arg.contains('z')) {
			return true;
		}
		return false;
	}

	private static int linearGetType(ArrayList<Object> arg) {
		if (arg.contains('x') && arg.contains('y') && arg.contains('z')) {
			n = 3;
		} else if ((arg.contains('x') && !arg.contains('y') && !arg.contains('z'))
				|| (arg.contains('y') && !arg.contains('x') && !arg.contains('z'))
				|| (arg.contains('z') && !arg.contains('x') && !arg.contains('y'))) {
			n = 1;
		}
		return n;
	}

	private static boolean isPolynomial(ArrayList<Object> arg) {
		String temp = Methods.ToString(arg);
		if (temp.contains("x^(") || temp.contains("y^(") || temp.contains("z^(")) {
			return true;
		}
		return false;
	}
}