package engine;

import java.util.ArrayList;

public class NumGetter {
	static String expression;
	static ArrayList<Integer> preList;
	static ArrayList<Object> list;

	public static ArrayList<Object> getPieces(String args) throws NumberFormatException {
		args = clearM(args);
		preList = new ArrayList<>();
		list = new ArrayList<>();
		NumGetter.expression = args;
		int min = 0;
		int next = 0;
		try {
			if (args == null) {
				args = "";
			}
			if (args.length() == 0) {
				return list;
			}
			int condition = 0;
			for (char chars : args.toCharArray()) {
				if (chars == '-' || chars == '+' || (chars == '÷' || chars == '/') || chars == '×' || chars == '='
						|| Methods.isXYZ(chars)) {

					if (chars == '-' || chars == '+') {
						if (condition == 0) {
							condition++;
							continue;
						} else if (condition > 0) {
							if (args.charAt(condition - 1) == '-' || args.charAt(condition - 1) == '+'
									|| args.charAt(condition - 1) == '(' || args.charAt(condition - 1) == '×'
									|| args.charAt(condition - 1) == '^' || args.charAt(condition - 1) == '÷'
									|| args.charAt(condition - 1) == '/' || args.charAt(condition - 1) == '='
									|| Methods.isXYZ(args.charAt(condition - 1))) {
								condition++;
								continue;
							}
						}
					}
					preList.add(condition);
				}
				condition++;
			}

			if (preList.size() != 0) {
				if ((args.charAt(0) >= '0' && args.charAt(0) <= '9') || args.charAt(0) == '+'
						|| args.charAt(0) == '-') {
					String local = args.substring(0, preList.get(0));
					list.add(Double.parseDouble(local));
				}

				for (int i = 0; i < (preList.size() - 1); i++) {
					min = preList.get(i);
					next = preList.get(i + 1);
					String local = args.substring(min + 1, next);
					if (local.length() == 0) {
						list.add(args.charAt(min));
					} else {
						double temp = Double.parseDouble(local);
						list.add(args.charAt(min));
						list.add(temp);
					}
				}
				if (args.charAt(args.length() - 1) >= '0' && args.charAt(args.length() - 1) <= '9') {
					condition = preList.get(preList.size() - 1);
					String local = args.substring(condition + 1);
					list.add(args.charAt(condition));
					list.add(Double.parseDouble(local));
				}
				if (args.charAt(args.length() - 1) == '(' || args.charAt(args.length() - 1) == ')'
						|| args.charAt(args.length() - 1) == '+' || args.charAt(args.length() - 1) == '-'
						|| (args.charAt(args.length() - 1) == '÷' || args.charAt(args.length() - 1) == '/')
						|| args.charAt(args.length() - 1) == '×' || args.charAt(args.length() - 1) == '^'
						|| args.charAt(args.length() - 1) == '=' || Methods.isXYZ(args.charAt(args.length() - 1))) {
					list.add(args.charAt(args.length() - 1));
				}

			} else {
				list.add(Double.parseDouble(args));
			}
		} catch (

		IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return list;
	}

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

}