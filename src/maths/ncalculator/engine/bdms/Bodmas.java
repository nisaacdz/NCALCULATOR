package maths.ncalculator.engine.bdms;

import java.util.ArrayList;

import maths.ncalculator.engine.Methods;
import maths.ncalculator.engine.Model;
import maths.ncalculator.engine.NumGetter;

public class Bodmas extends Model {
	private static ArrayList<Object> temporary;
	private static String answer = "";
	private static String temp;
	private static ArrayList<Object> another;

	public static String getAnswer(String args) {

		args = "(" + args + ")";

		String e = args;

		args = Methods.validateBrace(args);

		e = args;

		int count = 0;
		String creating = "";
		for (char chars : e.toCharArray()) {
			try {
				creating += chars;

				if (args.charAt(count + 1) == '(') {
					if (args.charAt(count) >= '0' && args.charAt(count) <= '9') {
						creating += "×";
					}
				}
				if (chars == ')') {
					if (args.charAt(count + 1) == '(') {
						creating += "×";
					}
				}
				count++;
			} catch (Exception exp) {
				continue;

			}
		}
		args = creating;
		args = Methods.clearExponents(args);
		answer = doBrace(args);
		return answer;
	}

	private static String doBrace(String args) {
		if (args.length() == 0) {
			return "0";
		}
		temp = args;
		double tempor;
		another = NumGetter.getPieces(temp);
		if (another.contains('(') || another.contains(')') || another.contains('×') || another.contains('÷')
				|| another.contains('/') || another.contains('+') || another.contains('-')) {
			int lastIndexOfOB = args.lastIndexOf('(');
			String fromThere = args.substring(lastIndexOfOB);
			int firstCBAfterLastCB = fromThere.indexOf(')');
			String pLocale = args.substring(lastIndexOfOB, lastIndexOfOB + firstCBAfterLastCB + 1);
			temporary = NumGetter.getPieces(pLocale);
			int iterate = temporary.size();
			tempor = (Double) decide(temporary).get(0);
			int iter = another.lastIndexOf('(');
			if (another.size() > 1) {
				for (int i = 0; i < iterate; i++) {
					another.remove(iter);
				}

				another.add(iter, tempor);
				temp = "";
				for (Object object : another) {
					temp += String.valueOf(object);
				}
				if (another.size() == 1) {
					return String.valueOf(temp);
				}
				answer = doBrace(temp);
			}
		}
		return String.valueOf(temp);
	}

	private static ArrayList<Object> removeBrace(ArrayList<Object> args) {
		args.remove(0);
		args.remove(args.size() - 1);
		return args;
	}

	double tempAns;

	double forDecide;

	private static ArrayList<Object> decide(ArrayList<Object> args) {
		if (args.contains('÷') || args.contains('/')) {
			args = divide(args);
			args = decide(args);
		} else if (args.contains('×')) {
			args = multiply(args);
			args = decide(args);
		} else if (args.contains('+')) {
			args = add(args);
			args = decide(args);
		} else if (args.contains('-')) {
			args = substract(args);
			args = decide(args);
		} else {
			args = removeBrace(args);
		}
		return args;
	}

	private static ArrayList<Object> divide(ArrayList<Object> args) {
		int index = 0;
		if (args.contains('/')) {
			index = args.indexOf('/');
		}
		if (args.contains('÷')) {
			index = args.indexOf('÷');
		}
		double num = (Double) args.get(index - 1);
		double deno = (Double) args.get(index + 1);
		double result = num / deno;
		args.remove(index - 1);
		args.remove(index - 1);
		args.remove(index - 1);
		args.add(index - 1, result);
		return args;
	}

	private static ArrayList<Object> multiply(ArrayList<Object> args) {
		int index = args.indexOf('×');
		double first = (Double) args.get(index - 1);
		double second = (Double) args.get(index + 1);
		double result = first * second;
		args.remove(index - 1);
		args.remove(index - 1);
		args.remove(index - 1);
		args.add(index - 1, result);
		return args;
	}

	private static ArrayList<Object> add(ArrayList<Object> args) {
		int index = args.indexOf('+');
		double one = (Double) args.get(index - 1);
		double two = (Double) args.get(index + 1);
		char beforeSign = (char) args.get(index - 2);
		double result;
		if (beforeSign == '-') {
			result = one - two;
		} else {
			result = one + two;
		}
		args.remove(index - 1);
		args.remove(index - 1);
		args.remove(index - 1);
		args.add(index - 1, result);
		return args;
	}

	private static ArrayList<Object> substract(ArrayList<Object> args) {
		int index = args.indexOf('-');
		double first = (Double) args.get(index - 1);
		double second = (Double) args.get(index + 1);
		char beforeSign = (char) args.get(index - 2);
		double result;
		if (beforeSign == '-') {
			result = first + second;
		} else {
			result = first - second;
		}
		args.remove(index - 1);
		args.remove(index - 1);
		args.remove(index - 1);
		args.add(index - 1, result);
		return args;
	}
}