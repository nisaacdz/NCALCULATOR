package maths.ncalculator.listeners.eqn;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maths.ncalculator.engine.EqnProcessor;
import maths.ncalculator.engine.bdms.Bodmas;
import maths.ncalculator.engine.eqns.Equations;
import maths.ncalculator.engine.eqns.accessibles.EquationTypeGetter;
import maths.ncalculator.listeners.Controller;
import maths.ncalculator.lookAndFeel.View;

public class AnsListener extends Controller implements ActionListener {

	private String textFromPanel = "";
	private static String answer;
	private static double temp1;
	private int type;
	private View panel;

	public AnsListener(View panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		textFromPanel = panel.text.getText();
		perform();
	}

	private void callVariousEquations(int arg) {
		if (arg == 0) {
			answer = Bodmas.getAnswer(textFromPanel);
		} else if (arg == 1) {
			answer = Equations.linearOneVar(textFromPanel);
		}
	}

	private void perform() {
		if (panel.text.getText().equals("")) {
			return;
		}
		if (!panel.text.getText().equals("SYNTAX ERROR")) {
			try {
				type = EquationTypeGetter.getType(EqnProcessor.getPieces(textFromPanel));
				callVariousEquations(type);
				if (answer.endsWith(".99999999999999")) {
					temp1 = Double.parseDouble(answer);
					temp1 += 0.00000000000001;
					answer = String.valueOf(temp1);
				}
				if (answer.endsWith(".0")) {
					answer = answer.substring(0, answer.indexOf('.'));
				}
				if (answer.equals("-0")) {
					answer = "0";
				}
				panel.detail.setText("answer for " + textFromPanel + " : ");
				panel.text.setText(answer);
			} catch (ArrayIndexOutOfBoundsException except) {
				panel.text.setForeground(Color.RED);
				panel.text.setText("SYNTAX ERROR");
				panel.detail.setText("Error");
			}
		} else {
			panel.detail.setText("Error");
		}
	}
}
