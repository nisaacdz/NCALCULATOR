package maths.ncalculator.listeners.bdms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maths.ncalculator.engine.bdms.Bodmas;
import maths.ncalculator.listeners.Controller;
import maths.ncalculator.lookAndFeel.View;

public class EqualsListener extends Controller implements ActionListener {

	private String answer;
	private double temp1;
	View panel;

	public EqualsListener(View panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		callBodmas();
	}

	private void callBodmas() {
		if (!panel.text.getText().equals("SYNTAX ERROR")) {
			String temp = panel.text.getText();
			if (!temp.equals("")) {
				try {
					answer = Bodmas.getAnswer(panel.text.getText());
					panel.detail.setText("Ans for : " + panel.text.getText());
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
					panel.text.setText(answer);
				} catch (Exception except) {
					panel.text.setForeground(Color.RED);
					panel.text.setText("SYNTAX ERROR");
					panel.detail.setText("Error");
				}
			}
		} else {
			panel.detail.setText("Error");
		}
	}
}
