package maths.ncalculator.lookAndFeel.samples;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import maths.ncalculator.lookAndFeel.View;

public class PreComplex extends View {

	private int pos;
	ArrayList<String> eqns = new ArrayList<String>();
	private boolean SHIFT_STATUS = false;

	private static final long serialVersionUID = 1L;

	public PreComplex() {
		detail = new JTextField();
		detail.setBorder(BorderFactory.createLineBorder(detail.getBackground(), 0));
		detail.setBackground(Color.BLUE);
		detail.setBounds(0, 0, 365, 31);
		this.add(detail);
		detail.setForeground(Color.RED);
		detail.setHorizontalAlignment(SwingConstants.RIGHT);
		detail.setText("Enter the Equation");
		detail.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));
		detail.setEditable(false);

		text = new JTextField();
		text.setBorder(BorderFactory.createLineBorder(text.getBackground(), 0));
		text.setBackground(Color.BLUE);
		text.setBounds(0, 30, 365, 45);
		this.add(text);
		text.setForeground(Color.YELLOW);
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("Microsoft JhengHei", Font.BOLD, 23));
		text.setEditable(false);
		text.setCaretColor(Color.MAGENTA);
		text.getCaret().setVisible(true);
		text.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if (!text.getCaret().isVisible()) {
					text.getCaret().setVisible(true);
				}
			}

		});

		JButton ln = new JButton("ln()");
		ln.setBounds(0, 85, 85, 45);
		ln.setForeground(Color.BLACK);
		ln.setBackground(Color.GRAY);
		this.add(ln);

		JButton modulo = new JButton("MOD");
		modulo.setBounds(90, 85, 85, 45);
		modulo.setForeground(Color.BLACK);
		modulo.setBackground(Color.GRAY);
		this.add(modulo);

		JButton btnShift = new JButton("SHIFT");
		btnShift.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SHIFT_STATUS = !SHIFT_STATUS;
				if (SHIFT_STATUS) {
					SHIFT_ON();
				} else {
					SHIFT_OFF();
				}
			}
		});
		btnShift.setBounds(180, 85, 85, 45);
		btnShift.setForeground(Color.BLACK);
		btnShift.setBackground(Color.GRAY);
		this.add(btnShift);

		JButton mode = new JButton("MODE");
		mode.setBounds(180, 135, 85, 45);
		mode.setForeground(Color.BLACK);
		mode.setBackground(Color.GRAY);
		this.add(mode);

		JButton varX = new JButton("x");
		varX.setBounds(270, 85, 45, 45);
		varX.setForeground(Color.BLACK);
		varX.setBackground(Color.GRAY);
		this.add(varX);

		JButton btnE = new JButton("e");
		btnE.setBounds(320, 85, 45, 45);
		btnE.setForeground(Color.BLACK);
		btnE.setBackground(Color.GRAY);
		this.add(btnE);

		JButton zero = new JButton("0");
		_init(zero);

		JButton btnOne = new JButton("1");
		_init(btnOne);

		JButton btnTwo = new JButton("2");
		_init(btnTwo);

		JButton btnThree = new JButton("3");
		_init(btnThree);

		JButton btnFour = new JButton("4");
		_init(btnFour);

		JButton btnFive = new JButton("5");
		_init(btnFive);

		JButton btnSix = new JButton("6");
		_init(btnSix);

		JButton btnSeven = new JButton("7");
		_init(btnSeven);

		JButton btnEight = new JButton("8");
		_init(btnEight);

		JButton btnNine = new JButton("9");
		_init(btnNine);

		JButton binDec = new JButton("BIN");
		binDec.setBounds(0, 135, 85, 45);
		binDec.setForeground(Color.BLACK);
		binDec.setBackground(Color.GRAY);
		this.add(binDec);

		JButton hexDec = new JButton("HEX");
		hexDec.setBounds(90, 135, 85, 45);
		hexDec.setForeground(Color.BLACK);
		hexDec.setBackground(Color.GRAY);
		this.add(hexDec);

		JButton decBin = new JButton("DEC");
		decBin.setBounds(0, 185, 85, 45);
		decBin.setForeground(Color.BLACK);
		decBin.setBackground(Color.GRAY);
		this.add(decBin);

		JButton cbackward = new JButton("<");
		cbackward.setBounds(90, 185, 75, 45);
		cbackward.setForeground(Color.BLACK);
		cbackward.setBackground(Color.GRAY);
		this.add(cbackward);

		JButton cforward = new JButton(">");
		cforward.setBounds(170, 185, 75, 45);
		cforward.setForeground(Color.BLACK);
		cforward.setBackground(Color.GRAY);
		this.add(cforward);

		JButton varY = new JButton("y");
		varY.setBounds(270, 135, 45, 45);
		varY.setForeground(Color.BLACK);
		varY.setBackground(Color.GRAY);
		this.add(varY);

		JButton btnPi = new JButton("π");
		btnPi.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 11));
		btnPi.setBounds(320, 135, 45, 45);
		btnPi.setForeground(Color.BLACK);
		btnPi.setBackground(Color.GRAY);
		this.add(btnPi);

		JButton decimal_point = new JButton(".");
		_cont(decimal_point);

		JButton directInverse = new JButton("√()");
		_cont(directInverse);

		JButton btnTan = new JButton("tan()");
		_cont(btnTan);

		JButton btnCos = new JButton("cos()");
		_cont(btnCos);

		JButton btnSin = new JButton("sin()");
		_cont(btnSin);

		JButton equal = new JButton("=");
		_cont(equal);
		equal.setBackground(Color.GREEN);

		JButton signSum = new JButton("+");
		_cont(signSum);

		JButton signSubstract = new JButton("-");
		_cont(signSubstract);

		JButton signProduct = new JButton("×");
		_cont(signProduct);

		JButton signQuotient = new JButton("÷");
		_cont(signQuotient);

		JButton openbrace = new JButton("(");
		_cont(openbrace);

		JButton closebrace = new JButton(")");
		_cont(closebrace);

		JButton clear = new JButton("AC");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eqns = new ArrayList<String>();
				if (!text.getText().equals("SYNTAX ERROR")) {
					detail.setText("Enter the Equation");
					text.setText("");
				}
			}
		});
		clear.setBounds(300, 285, 65, 45);
		clear.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		clear.setForeground(Color.RED);
		clear.setBackground(Color.GRAY);
		this.add(clear);

		JButton backspace = new JButton("←");
		backspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = text.getText();
				if (temp.equals("SYNTAX ERROR")) {
					text.setForeground(Color.YELLOW);
					text.setText("");
					detail.setText("Enter the Expression");

					// TODO a backspace action for sine, cosine and
					// tangent(UNDERSTOOD)
				} else if (temp.length() > 0 && text.getCaretPosition() > 0) {
					StringBuffer temp4 = new StringBuffer(temp);
					pos = text.getCaretPosition() - 1;
					StringBuffer cha = temp4.deleteCharAt(pos);
					text.setText(temp4.toString());
					if (text.getCaretPosition() > 1) {
						text.setCaretPosition(pos);
					}
					if (text.getText().equals("")) {
						detail.setText("Enter the Expression");
					} else {
						detail.setText(cha + " filtered");
					}
				}
			}
		});
		backspace.setBounds(300, 235, 65, 45);
		backspace.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		backspace.setForeground(Color.RED);
		backspace.setBackground(Color.GRAY);
		this.add(backspace);

		JButton answer = new JButton("ANSWER");
		answer.setBounds(250, 185, 115, 45);
		answer.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		answer.setForeground(Color.BLACK);
		answer.setBackground(Color.GREEN);
		this.add(answer);

	}

	private void _init(final JButton button) {
		int x = 0, y = 0, width = 45, height = 45;

		if (button.getText().equals("1") || button.getText().equals("2") || button.getText().equals("3")) {
			y = 335;
		}
		if (button.getText().equals("4") || button.getText().equals("5") || button.getText().equals("6")) {
			y = 285;
		}
		if (button.getText().equals("7") || button.getText().equals("8") || button.getText().equals("9")) {
			y = 235;
		}
		if (button.getText().equals("1") || button.getText().equals("4") || button.getText().equals("7")) {
			x = 0;
		}
		if (button.getText().equals("2") || button.getText().equals("5") || button.getText().equals("8")) {
			x = 50;
		}
		if (button.getText().equals("3") || button.getText().equals("6") || button.getText().equals("9")) {
			x = 100;
		}
		if (button.getText().equals("0")) {
			x = 0;
			y = 385;
			width = 95;
			height = 40;
		}
		button.setBounds(x, y, width, height);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		button.setBackground(Color.PINK);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(text.getText() + button.getText());
			}

		});
		this.add(button);
	}

	public void _cont(final JButton button) {
		int x = 0, y = 0, width = 45, height = 45;

		if (button.getText().equals("tan()") || button.getText().equals("√()")) {
			y = 380;
		}
		if (button.getText().equals("=") || button.getText().equals("sin()") || button.getText().equals("cos()")) {
			y = 335;
		}
		if (button.getText().equals("×") || button.getText().equals("÷") || button.getText().equals(")")) {
			y = 285;
		}
		if (button.getText().equals("+") || button.getText().equals("-") || button.getText().equals("(")) {
			y = 235;
		}
		if (button.getText().equals("=") || button.getText().equals("×") || button.getText().equals("+")) {
			x = 150;
		}
		if (button.getText().equals("tan()") || button.getText().equals("sin()") || button.getText().equals("÷")
				|| button.getText().equals("-")) {
			x = 200;
		}
		if (button.getText().equals("(") || button.getText().equals(")")) {
			x = 250;
		}
		if (button.getText().equals("cos()") || button.getText().equals("√()")) {
			x = 285;
		}
		if (button.getText().equals("sin()") || button.getText().equals("cos()")) {
			width = 80;
			height = 40;
		}
		if (button.getText().equals("tan()") || button.getText().equals("√()")) {
			width = 80;
			height = 45;
		}
		if (button.getText().equals("=")) {
			height = 90;
		}
		if (button.getText().equals(".")) {
			x = 100;
			y = 385;
			height = 40;
		}

		button.setBounds(x, y, width, height);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(text.getText() + button.getText());
			}
		});
		this.add(button);
	}

	private static void SHIFT_ON() {
		
	}

	private static void SHIFT_OFF() {

	}
}