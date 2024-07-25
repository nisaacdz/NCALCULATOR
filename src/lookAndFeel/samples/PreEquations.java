package lookAndFeel.samples;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import listeners.eqn.AnsListener;
import listeners.eqn.EqnListener;
import lookAndFeel.View;

public class PreEquations extends View {

	protected String answer;
	protected double temp1;
	Color color = Color.ORANGE;

	private static final long serialVersionUID = 1L;

	public PreEquations() {
		detail = new JTextField();
		detail.setBorder(BorderFactory.createLineBorder(detail.getBackground(), 0));
		detail.setBackground(Color.BLACK);
		detail.setBounds(0, 0, 300, 30);
		this.add(detail);
		detail.setForeground(Color.RED);
		detail.setHorizontalAlignment(SwingConstants.RIGHT);
		detail.setText("Enter the Equation");
		detail.setFont(new Font("Lucida Bright", Font.BOLD, 10));
		detail.setEditable(false);

		text = new JTextField();
		text.setBorder(BorderFactory.createLineBorder(text.getBackground(), 0));
		text.setBackground(Color.BLACK);
		text.setBounds(0, 30, 300, 30);
		this.add(text);
		text.setForeground(Color.YELLOW);
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		text.setEditable(false);
		text.setCaretColor(Color.RED);
		text.getCaret().setVisible(true);
		text.getCaret().setBlinkRate(400);

		text.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if (!text.getCaret().isVisible()) {
					text.getCaret().setVisible(true);
				}
			}

		});

		JButton backward = new JButton("<");
		backward.addActionListener(new EqnListener(this));
		backward.setBounds(0, 65, 150, 40);
		backward.setBackground(Color.DARK_GRAY);
		backward.setForeground(color);
		backward.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		this.add(backward);

		JButton forward = new JButton(">");
		forward.addActionListener(new EqnListener(this));
		forward.setBounds(155, 65, 150, 40);
		forward.setBackground(Color.DARK_GRAY);
		forward.setForeground(color);
		forward.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		this.add(forward);

		final JButton times = new JButton("×");
		times.addActionListener(new EqnListener(this));
		times.setBounds(0, 115, 50, 45);
		times.setBackground(Color.DARK_GRAY);
		times.setForeground(color);
		times.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		this.add(times);

		final JButton divide = new JButton("/");
		divide.addActionListener(new EqnListener(this));
		divide.setBounds(60, 115, 50, 45);
		divide.setBackground(Color.DARK_GRAY);
		divide.setForeground(color);
		divide.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		this.add(divide);

		final JButton plus = new JButton("+");
		plus.addActionListener(new EqnListener(this));
		plus.setBounds(120, 115, 50, 45);
		plus.setBackground(Color.DARK_GRAY);
		plus.setForeground(color);
		plus.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		this.add(plus);

		final JButton minus = new JButton("-");
		minus.addActionListener(new EqnListener(this));
		minus.setBounds(180, 115, 50, 45);
		minus.setBackground(Color.DARK_GRAY);
		minus.setForeground(color);
		minus.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.add(minus);

		JButton solve = new JButton("ANS");
		solve.addActionListener(new AnsListener(this));
		solve.setBounds(240, 115, 65, 45);
		solve.setBackground(Color.DARK_GRAY);
		solve.setForeground(Color.ORANGE);
		solve.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		this.add(solve);

		final JButton varX = new JButton("x");
		varX.addActionListener(new EqnListener(this));
		varX.setBounds(0, 170, 50, 45);
		varX.setBackground(Color.GRAY);
		varX.setForeground(Color.GREEN);
		varX.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(varX);

		final JButton varY = new JButton("y");
		varY.addActionListener(new EqnListener(this));
		varY.setBounds(60, 170, 50, 45);
		varY.setBackground(Color.GRAY);
		varY.setForeground(Color.GREEN);
		varY.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(varY);

		final JButton varZ = new JButton("z");
		varZ.addActionListener(new EqnListener(this));
		varZ.setBounds(120, 170, 50, 45);
		varZ.setBackground(Color.GRAY);
		varZ.setForeground(Color.GREEN);
		varZ.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.add(varZ);

		final JButton backspace = new JButton("←");
		backspace.addActionListener(new EqnListener(this));
		backspace.setBounds(180, 170, 60, 45);
		backspace.setBackground(Color.DARK_GRAY);
		backspace.setForeground(Color.RED);
		backspace.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		this.add(backspace);

		final JButton clear = new JButton("CE");
		clear.addActionListener(new EqnListener(this));
		clear.setBounds(245, 170, 60, 45);
		clear.setBackground(Color.DARK_GRAY);
		clear.setForeground(Color.RED);
		clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(clear);

		JButton zero = new JButton("0");
		init(zero);

		JButton one = new JButton("1");
		init(one);

		JButton two = new JButton("2");
		init(two);

		JButton three = new JButton("3");
		init(three);

		JButton four = new JButton("4");
		init(four);

		JButton five = new JButton("5");
		init(five);

		JButton six = new JButton("6");
		init(six);

		JButton seven = new JButton("7");
		init(seven);

		JButton eight = new JButton("8");
		init(eight);

		JButton nine = new JButton("9");
		init(nine);

		final JButton open = new JButton("(");
		open.addActionListener(new EqnListener(this));
		open.setBounds(180, 225, 60, 45);
		open.setBackground(Color.DARK_GRAY);
		open.setForeground(color);
		open.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		this.add(open);

		final JButton close = new JButton(")");
		close.addActionListener(new EqnListener(this));
		close.setBounds(245, 225, 60, 45);
		close.setBackground(Color.DARK_GRAY);
		close.setForeground(color);
		close.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		this.add(close);

		JButton exponent = new JButton("^");
		exponent.addActionListener(new EqnListener(this));
		exponent.setBounds(180, 280, 60, 45);
		exponent.setBackground(Color.DARK_GRAY);
		exponent.setForeground(color);
		exponent.setFont(new Font("Tahoma", Font.PLAIN, 21));
		this.add(exponent);

		final JButton equal = new JButton("=");
		equal.addActionListener(new EqnListener(this));
		equal.setBounds(245, 280, 60, 45);
		equal.setBackground(Color.DARK_GRAY);
		equal.setForeground(color);
		equal.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		this.add(equal);

		final JButton period = new JButton(".");
		period.addActionListener(new EqnListener(this));
		period.setBounds(180, 335, 60, 45);
		period.setBackground(Color.DARK_GRAY);
		period.setForeground(color);
		period.setFont(new Font("Modern No. 20", Font.BOLD, 27));
		this.add(period);
	}

	private void init(final JButton button) {
		int x = 0, y = 0, width = 50, height = 45;
		if (button.getText().equals("0")) {
			x = 245;
			y = 335;
			width = 60;
		}
		if (button.getText().equals("1") || button.getText().equals("2") || button.getText().equals("3")) {
			y = 335;
		}
		if (button.getText().equals("4") || button.getText().equals("5") || button.getText().equals("6")) {
			y = 280;
		}
		if (button.getText().equals("7") || button.getText().equals("8") || button.getText().equals("9")) {
			y = 225;
		}
		if (button.getText().equals("1") || button.getText().equals("4") || button.getText().equals("7")) {
			x = 0;
		}
		if (button.getText().equals("2") || button.getText().equals("5") || button.getText().equals("8")) {
			x = 60;
		}
		if (button.getText().equals("3") || button.getText().equals("6") || button.getText().equals("9")) {
			x = 120;
		}
		button.setBounds(x, y, width, height);
		button.setBackground(Color.PINK);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		button.addActionListener(new EqnListener(this));
		this.add(button);
	}

}