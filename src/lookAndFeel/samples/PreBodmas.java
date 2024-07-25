package lookAndFeel.samples;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import listeners.bdms.BdmsListener;
import listeners.bdms.EqualsListener;
import lookAndFeel.View;

public class PreBodmas extends View {

	private static final long serialVersionUID = 1L;
	private Color color = Color.MAGENTA;

	public PreBodmas() {
		detail = new JTextField();
		detail.setBorder(BorderFactory.createLineBorder(detail.getBackground(), 0));
		detail.setBackground(Color.BLACK);
		detail.setBounds(0, 0, 305, 30);
		this.add(detail);
		detail.setForeground(Color.RED);
		detail.setHorizontalAlignment(SwingConstants.RIGHT);
		detail.setText("Enter the Expression");
		detail.setEditable(false);
		detail.setFont(new Font("Microsoft JhengHei", Font.BOLD, 12));

		text = new JTextField();
		text.setBorder(BorderFactory.createLineBorder(text.getBackground(), 0));
		text.setBackground(Color.BLACK);
		text.setBounds(0, 30, 305, 30);
		this.add(text);
		text.setForeground(Color.YELLOW);
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		text.getCaret().setVisible(true);
		text.setCaretColor(Color.WHITE);
		text.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				if (!text.getCaret().isVisible()) {
					text.getCaret().setVisible(true);
				}
			}

		});

		JButton clear = new JButton("CE");
		clear.setBounds(0, 90, 75, 55);
		this.add(clear);
		clear.setForeground(Color.BLACK);
		clear.setBackground(Color.GRAY);
		clear.addActionListener(new BdmsListener(this));
		clear.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		final JButton open = new JButton("(");
		open.setBounds(80, 90, 75, 55);
		this.add(open);
		open.setForeground(Color.BLACK);
		open.setBackground(Color.GRAY);
		open.addActionListener(new BdmsListener(this));
		open.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		final JButton close = new JButton(")");
		close.setBounds(160, 90, 75, 55);
		this.add(close);
		close.setForeground(Color.BLACK);
		close.setBackground(Color.GRAY);
		close.addActionListener(new BdmsListener(this));
		close.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		JButton backspace = new JButton("←");
		backspace.setBounds(240, 90, 65, 55);
		this.add(backspace);
		backspace.setForeground(Color.BLACK);
		backspace.setBackground(Color.GRAY);
		backspace.addActionListener(new BdmsListener(this));
		backspace.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		JButton zero = new JButton("0");
		_init(zero);

		JButton one = new JButton("1");
		_init(one);

		JButton two = new JButton("2");
		_init(two);

		JButton three = new JButton("3");
		_init(three);

		JButton four = new JButton("4");
		_init(four);

		JButton five = new JButton("5");
		_init(five);

		JButton six = new JButton("6");
		_init(six);

		JButton seven = new JButton("7");
		_init(seven);

		JButton eight = new JButton("8");
		_init(eight);

		JButton nine = new JButton("9");
		_init(nine);

		final JButton divide = new JButton("÷");
		divide.setBounds(240, 150, 65, 55);
		this.add(divide);
		divide.setForeground(Color.BLACK);
		divide.setBackground(Color.GRAY);
		divide.addActionListener(new BdmsListener(this));
		divide.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		final JButton times = new JButton("×");
		times.setBounds(240, 210, 65, 55);
		this.add(times);
		times.setForeground(Color.BLACK);
		times.setBackground(Color.GRAY);
		times.addActionListener(new BdmsListener(this));
		times.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		JButton equals = new JButton("=");
		equals.setBounds(240, 270, 65, 55);
		this.add(equals);
		equals.setForeground(Color.BLACK);
		equals.setBackground(Color.GRAY);
		equals.addActionListener(new EqualsListener(this));
		equals.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		final JButton period = new JButton(".");
		period.setBounds(0, 330, 75, 55);
		this.add(period);
		period.setForeground(Color.BLACK);
		period.setBackground(Color.DARK_GRAY);
		period.addActionListener(new BdmsListener(this));
		period.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		final JButton plus = new JButton("+");
		plus.setBounds(160, 330, 75, 55);
		this.add(plus);
		plus.setForeground(Color.BLACK);
		plus.setBackground(Color.GRAY);
		plus.addActionListener(new BdmsListener(this));
		plus.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));

		final JButton minus = new JButton("-");
		minus.setBounds(240, 330, 65, 55);
		this.add(minus);
		minus.setForeground(Color.BLACK);
		minus.setBackground(Color.GRAY);
		minus.addActionListener(new BdmsListener(this));
		minus.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
	}

	public void _init(final JButton button) {
		int x = 0, y = 0, width = 75, height = 55;
		if (button.getText().equals("0")) {
			x = 80;
			y = 330;
		}
		if (button.getText().equals("1") || button.getText().equals("2") || button.getText().equals("3")) {
			y = 270;
		}
		if (button.getText().equals("4") || button.getText().equals("5") || button.getText().equals("6")) {
			y = 210;
		}
		if (button.getText().equals("7") || button.getText().equals("8") || button.getText().equals("9")) {
			y = 150;
		}
		if (button.getText().equals("1") || button.getText().equals("4") || button.getText().equals("7")) {
			x = 0;
		}
		if (button.getText().equals("2") || button.getText().equals("5") || button.getText().equals("8")) {
			x = 80;
		}
		if (button.getText().equals("3") || button.getText().equals("6") || button.getText().equals("9")) {
			x = 160;
		}
		button.setBounds(x, y, width, height);
		button.setForeground(color);
		button.setBackground(Color.DARK_GRAY);
		button.setFont(new Font("Microsoft JhengHei", Font.BOLD, 21));
		button.addActionListener(new BdmsListener(this));
		this.add(button);
	}
}
