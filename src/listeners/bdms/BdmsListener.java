package listeners.bdms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import engine.Methods;
import listeners.Controller;
import lookAndFeel.View;

public class BdmsListener extends Controller implements ActionListener {

	private static JButton btn;
	private View panel;
	private static JTextField detail;
	private static JTextField text;

	public BdmsListener(View panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		btn = (JButton) arg.getSource();
		text = panel.text;
		detail = panel.detail;
		if (Methods.isDouble(btn.getText())) {
			NumberClicked();
		} else if (btn.getText().equals(".")) {
			PeriodClicked();
		} else if (btn.getText().equals("CE")) {
			ClearClicked();
		} else if (btn.getText().equals("←")) {
			BackSpaceClicked();
		} else if (btn.getText().equals("-")) {
			MinusClicked();
		} else if (btn.getText().equals("+")) {
			PlusClicked();
		} else if (btn.getText().equals("÷")) {
			DivideClicked();
		} else if (btn.getText().equals("×")) {
			TimesClicked();
		} else if (btn.getText().equals("(")) {
			OpenBraceClicked();
		} else if (btn.getText().equals(")")) {
			CloseBraceClicked();
		}
	}

	private static void CloseBraceClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Exit Bracket");
			text.setText(text.getText() + btn.getText());
		}
	}

	private static void OpenBraceClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Entrance Bracket");
			text.setText(text.getText() + btn.getText());
		}
	}

	private static void TimesClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			text.setText(text.getText() + btn.getText());
			detail.setText("Product sign");
		} else {
			detail.setText("CE or ← to clear error");
		}
	}

	private static void DivideClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			text.setText(text.getText() + btn.getText());
			detail.setText("Quotient sign");
		} else {
			detail.setText("CE or ← to clear error");
		}
	}

	private static void PlusClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			text.setText(text.getText() + btn.getText());
			detail.setText("Summation sign");
		} else {
			detail.setText("CE or ← to clear error");
		}
	}

	private static void BackSpaceClicked() {
		String temp = text.getText();
		if (temp.equals("SYNTAX ERROR")) {
			text.setForeground(Color.YELLOW);
			text.setText("");
			detail.setText("Enter the Expression");
		} else {
			if (temp.length() > 0) {
				text.setText(temp.substring(0, temp.length() - 1));
				detail.setText("backspace");
				if (text.getText().length() == 0) {
					detail.setText("Enter the Expression");
				}
			}
		}
	}

	private static void MinusClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			text.setText(text.getText() + btn.getText());
			detail.setText("Substraction sign");
		} else {
			detail.setText("CE or ← to clear error");
		}
	}

	private static void ClearClicked() {
		text.setForeground(Color.YELLOW);
		detail.setText("Enter the Expression");
		text.setText("");
	}

	private static void PeriodClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Decimal point");
			String temp = text.getText();
			if (temp.length() == 0) {
				text.setText("0" + btn.getText());
			} else if (temp.charAt(temp.length() - 1) >= '0' && temp.charAt(temp.length() - 1) <= '9') {
				text.setText(temp + btn.getText());
			} else {
				text.setText(text.getText() + "0" + btn.getText());
			}
		}
	}

	private static void NumberClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText(btn.getText());
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}
}