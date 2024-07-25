package engine;

import java.util.ArrayList;

public class EqnProcessor {
	static ArrayList<Integer> preList;
	static ArrayList<Object> list;

	public static ArrayList<Object> getPieces(String args) throws NumberFormatException {
		args = Methods.clearM(args);
		args = Methods.clearExponents(args);
		preList = new ArrayList<>();
		list = new ArrayList<>();
		int min = 0;
		int next = 0;
		if (args == null) {
			args = "";
		}
		if (args.length() == 0) {
			return list;
		} else {
			args = fixForVariable(args);
		}
		try {
			int condition = 0;
			for (char chars : args.toCharArray()) {
				if (Methods.isMyChar(chars)) {
					if (chars == '-' || chars == '+') {
						if (condition == 0 && !(args.charAt(condition + 1) == 'x' || args.charAt(condition + 1) == 'y'
								|| args.charAt(condition + 1) == 'z')) {
							condition++;
							continue;
						} else if (condition > 0) {
							if (args.charAt(condition - 1) == '-' || args.charAt(condition - 1) == '+'
									|| args.charAt(condition - 1) == '(' || args.charAt(condition - 1) == '�'
									|| args.charAt(condition - 1) == '/') {
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
					if (local.length() == 0) {

					} else {
						list.add(Double.parseDouble(local));
					}
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
						|| args.charAt(args.length() - 1) == '/' || args.charAt(args.length() - 1) == '�'
						|| args.charAt(args.length() - 1) == 'x' || args.charAt(args.length() - 1) == 'y'
						|| args.charAt(args.length() - 1) == 'z' || args.charAt(args.length() - 1) == '=') {
					list.add(args.charAt(args.length() - 1));
				}

			} else {
				list.add(Double.parseDouble(args));
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return list;
	}

	private static String fixForVariable(String arg0) {
		String temp = arg0;
		while (temp.contains("+x")) {
			temp = temp.replace("+x", "+1x");
		}
		while (temp.contains("-x")) {
			temp = temp.replace("-x", "-1x");
		}
		while (temp.contains("+y")) {
			temp = temp.replace("+y", "+1y");
		}
		while (temp.contains("-y")) {
			temp = temp.replace("-y", "-1y");
		}
		while (temp.contains("+z")) {
			temp = temp.replace("+z", "+1z");
		}
		while (temp.contains("-z")) {
			temp = temp.replace("-z", "-1z");
		}
		if (temp.charAt(0) == 'x') {
			StringBuffer buffer = new StringBuffer(temp);
			buffer.insert(0, "1");
			temp = buffer.toString();
		}
		if (temp.charAt(0) == 'y') {
			StringBuffer buffer = new StringBuffer(temp);
			buffer.insert(0, "1");
			temp = buffer.toString();
		}
		if (temp.charAt(0) == 'z') {
			StringBuffer buffer = new StringBuffer(temp);
			buffer.insert(0, "1");
			temp = buffer.toString();
		}
		return temp;
	}
}