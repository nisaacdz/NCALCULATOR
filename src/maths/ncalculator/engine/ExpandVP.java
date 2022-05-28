package maths.ncalculator.engine;

import java.util.ArrayList;

public class ExpandVP {

	private static String temp;
	private static ArrayList<Object> tempL;
	private static String returnValue;
	private static char xyz;

	public static String getAnswer(String args) {
		tryChar(args);
		ExpandVP.temp = args;
		tempL = EqnProcessor.getPieces(temp);
		Object test = tempL.get(0);
		if (Methods.isDouble(test)) {
			returnValue = expandDouble(tempL);
		} else if (Methods.isXYZ(test)) {
			returnValue = expandVariable();
		} else if (test.equals('(')) {
			returnValue = removeBrace(tempL);
		}
		return returnValue;
	}

	private static void tryChar(String args) {
		if (args.contains("x") && !args.contains("y") && !args.contains("z")) {
			xyz = 'x';
		} else if (args.contains("y") && !args.contains("x") && !args.contains("z")) {
			xyz = 'y';
		} else if (args.contains("z") && !args.contains("x") && !args.contains("y")) {
			xyz = 'z';
		}
	}

	private static String removeBrace(ArrayList<Object> argR) {
		String returnValue;
		argR.remove(argR.size() - 1);
		argR.remove(0);
		returnValue = Methods.ToString(argR);
		return returnValue;
	}

	private static String expandDouble(ArrayList<Object> argE) {
		ArrayList<Object> result = new ArrayList<Object>();
		String returnValue;
		ArrayList<Object> temp = argE;
		double value = (Double) temp.remove(0);
		temp = EqnProcessor.getPieces(removeBrace(temp));
		ArrayList<Double> constants = Methods.getConstants(temp);
		ArrayList<Double> coefficients = Methods.getCoefficients(temp);
		for (double dValue : constants) {
			double product = dValue * value;
			result.add('+');
			result.add(product);
		}
		for (double dValue : coefficients) {
			double product = dValue * value;
			result.add('+');
			result.add(product);
			result.add(xyz);
		}
		returnValue = Methods.ToString(result);
		returnValue = Methods.clearM(returnValue);
		return returnValue;
	}

	private static String expandVariable() {
		return null;
	}
}
