package maths.ncalculator.engine;

import java.util.ArrayList;
import java.util.List;

import maths.ncalculator.engine.bdms.Bodmas;

public class Methods {

	/*
	 * Integer begin and Integer end are meant to be used by trimPLocale and
	 * reWriteNVP and reWriteVP
	 */
	private static ArrayList<Double> coefficients;
	private static ArrayList<Double> constants;

	// returns true if the object passed is x, y or z;
	public static boolean isXYZ(Object object) {
		if (object.equals('x') || object.equals('y') || object.equals('z')) {
			return true;
		}
		return false;
	}

	// Returns an arrayList of coefficients in an equation
	public static ArrayList<Double> getCoefficients(ArrayList<Object> arg0) {
		int index = 0;
		coefficients = new ArrayList<Double>();
		for (Object object : arg0) {
			try {
				if (Methods.isDouble(object) && Methods.isXYZ(arg0.get(index + 1))) {
					tryCoefficients(arg0, object, index);
				}
			} catch (IndexOutOfBoundsException e) {
				if (index != arg0.size() - 1) {
					tryCoefficients(arg0, object, index);
				}
				continue;
			}
			index++;
		}
		return coefficients;
	}

	private static void tryCoefficients(ArrayList<Object> arg0, Object object, int index) {
		try {
			if (arg0.get(index - 1).equals('-')) {
				double negativeNumber = -(Double) object;
				coefficients.add(negativeNumber);
			} else if (arg0.get(index - 1).equals('+')) {
				double positiveNumber = (Double) object;
				coefficients.add(positiveNumber);
			}
		} catch (IndexOutOfBoundsException e) {
			double positiveNumber = (Double) object;
			coefficients.add(positiveNumber);
			index++;
		}
	}

	private static void tryConstants(ArrayList<Object> arg, Object object, int index) {
		try {
			if (arg.get(index - 1).equals('-')) {
				double negativeNumber = -(Double) object;
				constants.add(negativeNumber);
			} else if (arg.get(index - 1).equals('+')) {
				constants.add((Double) object);
			}
		} catch (IndexOutOfBoundsException e) {
			constants.add((Double) object);
			index++;
		}
	}

	// Returns an arrayList of constants in an equation
	public static ArrayList<Double> getConstants(ArrayList<Object> arg1) {
		int index = 0;
		constants = new ArrayList<Double>();
		for (Object object : arg1) {
			try {
				if (Methods.isDouble(object) && !Methods.isXYZ(arg1.get(index + 1))) {
					tryConstants(arg1, object, index);
				}
			} catch (IndexOutOfBoundsException e) {
				tryConstants(arg1, object, index);
				continue;
			}
			index++;
		}
		return constants;
	}

	// Takes a String and Solves the Exponents within it
	public static String clearExponents(String args) {
		while (args.contains("^")) {
			int lastIndexOfIt = args.lastIndexOf("^");

			String exponent = args.substring(lastIndexOfIt + 1);
			exponent = exponent.substring(0, exponent.indexOf(")") + 1);

			exponent = Bodmas.getAnswer(exponent);

			ArrayList<Object> Nans = NumGetter.getPieces(args);
			int lastIndex = Nans.lastIndexOf('^');
			double Base = (double) Nans.get(lastIndex - 1);
			Base = Math.pow(Base, Double.parseDouble(exponent));
			String first = ToString(Nans.subList(0, lastIndex - 1));
			String last = args.substring(lastIndexOfIt + 1);
			last = getExpressionsAfterExponent(NumGetter.getPieces(last));
			args = first + String.valueOf(Base) + last;
		}
		return args;
	}

	// Returns the string after the index of the last exponent
	public static String getExpressionsAfterExponent(List<Object> args) {
		int count = 0;
		int indexing = 0;
		for (Object object : args) {
			indexing++;
			if (object.equals('(')) {
				count++;
			} else if (object.equals(')')) {
				count--;
			}
			if (count == 0) {
				break;
			}
		}
		for (int i = 0; i < indexing; i++) {
			args.remove(0);
		}
		return ToString(args);
	}

	// Converts the List<Object> that is passed in the argument to String
	public static String ToString(List<Object> args) {
		String temp = "";
		for (Object object : args) {
			temp += object.toString();
		}
		return temp;
	}

	// Obviously does the obvious functions to its argument
	public static String clearM(String args) {
		String[] here = { "--", "++", "-+", "+-" };

		while (args.contains(here[0])) {
			args = args.replace(here[0], "+");
		}
		while (args.contains(here[2])) {
			args = args.replace(here[2], "-");
		}
		while (args.contains(here[3])) {
			args = args.replace(here[3], "-");
		}
		while (args.contains(here[0])) {
			args = args.replace(here[0], "+");
		}
		while (args.contains(here[1])) {
			args = args.replace(here[1], "+");
		}
		return args;
	}

	// Adds the values of the elements of the ArrayList of Double
	public static double addAll(ArrayList<Double> arg2) {
		double sum = 0;
		for (double eachDouble : arg2) {
			sum += eachDouble;
		}
		return sum;
	}

	// Adds the relevant number of closeBrackets to a parenthetical expression
	public static String validateBrace(String args) {
		int obrace = 0;
		int cbrace = 0;
		for (char chars : args.toCharArray()) {
			if (chars == '(') {
				obrace++;
			} else if (chars == ')') {
				cbrace++;
			}
		}

		if (obrace > cbrace) {
			int toDo = obrace - cbrace;
			for (int i = 0; i < toDo; i++) {
				args += ")";
			}
		}
		return args;
	}

	// Returns true when the argument is a double or integer or float
	public static boolean isDouble(Object object) {
		boolean returnValue = false;
		try {
			String temp = object.toString();
			Double.parseDouble(temp);
			returnValue = true;
		} catch (Exception e) {
			return false;
		}
		return returnValue;
	}

	// Returns true when the argument contains parenthesis
	public static boolean containsParenthesis(ArrayList<Object> arg3) {
		if (arg3.contains('(')) {
			return true;
		}
		return false;
	}

	// Returns the region of the BODMAS expression
	public static ArrayList<Object> trimPLocale(ArrayList<Object> arg6) {
		int begin;
		int end;
		ArrayList<Object> R91 = arg6;
		ArrayList<Object> returnValue = null;
		;
		try {
			begin = R91.lastIndexOf('(');
			if (begin >= 1) {
				String test = String.valueOf(R91.get(begin - 1));
				if (isDouble(test) || isXYZ(test)) {
					begin--;
				} else if (isXYZ(test)) {
					begin--;
				}
			}
			List<Object> beginToFinishL = R91.subList(begin, R91.size());
			ArrayList<Object> beginToFinishAL = new ArrayList<Object>(beginToFinishL);
			end = begin + beginToFinishAL.indexOf(')');

			List<Object> beginToEndL = R91.subList(begin, end + 1);
			ArrayList<Object> beginToEndAL = new ArrayList<Object>(beginToEndL);

			returnValue = beginToEndAL;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	// Returns true if the argument contains x, y, or z;
	public static boolean containsVariable(ArrayList<Object> arg4) {
		if (arg4.contains('x') || arg4.contains('y') || arg4.contains('z')) {
			return true;
		}
		return false;
	}

	// Solves the BODMAS part of a parenthesis
	public static double callBodmasForNVP(ArrayList<Object> arg5) {
		String temp = Bodmas.getAnswer(ToString(arg5));
		double returnValue = Double.parseDouble(temp);
		return returnValue;
	}

	// Returns the expanded expression of the variable parenthesis
	public static String simplifyVP(ArrayList<Object> arg6) {
		String returnValue = ExpandVP.getAnswer(ToString(arg6));
		return returnValue;
	}

	public static ArrayList<Object> reWriteListNVP(ArrayList<Object> arg, ArrayList<Object> arg1, double arg2) {
		ArrayList<Object> returnValue;
		String main = ToString(arg);
		String expression = ToString(arg1);
		String replacement = String.valueOf(arg2);
		while (main.contains(expression)) {
			main = main.replace(expression, replacement);
		}
		returnValue = EqnProcessor.getPieces(main);
		return returnValue;
	}

	public static ArrayList<Object> reWriteListVP(ArrayList<Object> arg, ArrayList<Object> arg1, String arg2) {
		ArrayList<Object> returnValue;
		String main = ToString(arg);
		String expression = ToString(arg1);
		String replacement = arg2;
		while (main.contains(expression)) {
			main = main.replace(expression, replacement);
		}
		returnValue = EqnProcessor.getPieces(main);
		return returnValue;
	}

	// Returns true if the object is a relevant character
	public static boolean isMyChar(Object obj) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add('-');
		list.add('+');
		list.add('÷');
		list.add('×');
		list.add('/');
		list.add('=');
		list.add('^');
		list.add('(');
		list.add(')');
		list.add('x');
		list.add('y');
		list.add('z');

		if (list.contains(obj)) {
			return true;
		}
		return false;
	}

}
