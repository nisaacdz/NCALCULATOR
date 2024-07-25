package engine.eqns;

import java.util.ArrayList;

import engine.EqnProcessor;
import engine.Methods;
import engine.Model;

public class Equations extends Model {

	static int begin;
	static int end;

	public static String linearOneVar(String args) {
		args = Methods.validateBrace(args);
		args = Methods.clearExponents(args);
		args = simplifyP(args);

		String start = args.substring(0, args.indexOf('='));
		String end = args.substring(args.indexOf('=') + 1);
		ArrayList<Object> left = EqnProcessor.getPieces(start);
		ArrayList<Object> right = EqnProcessor.getPieces(end);

		ArrayList<Double> coefficientsL = Methods.getCoefficients(left);
		ArrayList<Double> coefficientsR = Methods.getCoefficients(right);

		double VsumL = Methods.addAll(coefficientsL);
		double VsumR = Methods.addAll(coefficientsR);

		double sumOfCoefficients = VsumL - VsumR;

		ArrayList<Double> constantsL = Methods.getConstants(left);
		ArrayList<Double> constantsR = Methods.getConstants(right);

		double CsumR = Methods.addAll(constantsR);
		double CsumL = Methods.addAll(constantsL);

		double sumOfConstants = CsumR - CsumL;

		double result = sumOfConstants / sumOfCoefficients;
		return String.valueOf(result);
	}

	private static String simplifyP(String arg7) {
		ArrayList<Object> temp001 = EqnProcessor.getPieces(arg7);
		String returnValue;
		while (Methods.containsParenthesis(temp001)) {
			ArrayList<Object> pExpression = Methods.trimPLocale(temp001);
			if (!Methods.containsVariable(pExpression)) {
				double ansForNVP = Methods.callBodmasForNVP(pExpression);
				temp001 = Methods.reWriteListNVP(temp001, pExpression, ansForNVP);
			} else {
				String ansForVP = Methods.simplifyVP(pExpression);
				temp001 = Methods.reWriteListVP(temp001, pExpression, ansForVP);
			}
		}
		returnValue = Methods.ToString(temp001);
		return returnValue;
	}
}