package maths.ncalculator.listeners.eqn;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import maths.ncalculator.engine.Methods;
import maths.ncalculator.listeners.Controller;
import maths.ncalculator.lookAndFeel.View;

public class EqnListener extends Controller implements ActionListener {

	private static JButton btn;
	private View panel;
	private static JTextField detail;
	private static JTextField text;
	private static int caretPosition;

	public EqnListener(View panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		btn = (JButton) arg0.getSource();
		text = panel.text;
		detail = panel.detail;
		if (Methods.isDouble(btn.getText())) {
			NumberClicked();
		} else if (btn.getText().equals("x")) {
			VariableClicked();
		} else if (btn.getText().equals("y")) {
			VariableClicked();
		} else if (btn.getText().equals("z")) {
			VariableClicked();
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
		} else if (btn.getText().equals("×")) {
			TimesClicked();
		} else if (btn.getText().equals("/")) {
			DivideClicked();
		} else if (btn.getText().equals("^")) {
			ExponentClicked();
		} else if (btn.getText().equals("(")) {
			OpenBraceClicked();
		} else if (btn.getText().equals(")")) {
			CloseBraceClicked();
		} else if (btn.getText().equals("<")) {
			BackwardClicked();
		} else if (btn.getText().equals(">")) {
			ForwardClicked();
		} else if (btn.getText().equals("=")) {
			EqualSignClicked();
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

	private static void VariableClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Variable " + btn.getText());
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void PeriodClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Decimal point");
			String temp = text.getText();
			if (temp.length() == 0) {
				text.setText("0" + btn.getText());
			} else if (temp.charAt(text.getCaretPosition() - 1) >= '0'
					&& temp.charAt(text.getCaretPosition() - 1) <= '9') {
				try {
					text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					text.getDocument().insertString(text.getCaretPosition(), ("0" + btn.getText()), null);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private static void ExponentClicked() {
		try {
			int pos = text.getCaretPosition();
			text.getDocument().insertString(pos, "^()", null);
			text.setCaretPosition(pos + 2);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	private static void DivideClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Quotient sign");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void TimesClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Product sign");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void PlusClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Summation sign");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void MinusClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Substraction sign");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void BackSpaceClicked() {
		String temp = text.getText();
		if (temp.equals("SYNTAX ERROR")) {
			text.setForeground(Color.YELLOW);
			text.setText("");
			detail.setText("Enter the Equation");
		} else if (temp.length() > 0 && text.getCaretPosition() > 0) {
			StringBuffer temp4 = new StringBuffer(temp);
			caretPosition = text.getCaretPosition() - 1;
			StringBuffer cha = temp4.deleteCharAt(caretPosition);
			text.setText(temp4.toString());
			if (text.getCaretPosition() > 1) {
				text.setCaretPosition(caretPosition);
			}
			if (text.getText().equals("")) {
				detail.setText("Enter the Equation");
			} else {
				detail.setText(cha + " filtered");
			}
		}
	}

	private static void ClearClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Enter the Equation");
			text.setText("");
		}
	}

	private static void EqualSignClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Equality sign");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void ForwardClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			if (text.getCaretPosition() < text.getText().length())
				text.setCaretPosition(text.getCaretPosition() + 1);
		}
	}

	private static void BackwardClicked() {
		if (!text.getText().equals("SYNTAX ERROR") && text.getCaretPosition() > 0) {
			text.setCaretPosition(text.getCaretPosition() - 1);
		}

	}

	private static void CloseBraceClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Exit Bracket");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void OpenBraceClicked() {
		if (!text.getText().equals("SYNTAX ERROR")) {
			detail.setText("Entrance Bracket");
			try {
				text.getDocument().insertString(text.getCaretPosition(), btn.getText(), null);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}

	}
}
