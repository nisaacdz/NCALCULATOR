package maths.ncalculator.lookAndFeel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import maths.ncalculator.lookAndFeel.samples.PreBasic;
import maths.ncalculator.lookAndFeel.samples.PreBodmas;
import maths.ncalculator.lookAndFeel.samples.PreComplex;
import maths.ncalculator.lookAndFeel.samples.PreConstants;
import maths.ncalculator.lookAndFeel.samples.PreDifferential;
import maths.ncalculator.lookAndFeel.samples.PreEquations;
import maths.ncalculator.lookAndFeel.samples.PreGraph;
import maths.ncalculator.lookAndFeel.samples.PreInfo;
import maths.ncalculator.lookAndFeel.samples.PreIntegral;
import maths.ncalculator.lookAndFeel.samples.PreMatrices;
import maths.ncalculator.lookAndFeel.samples.PreMechanics;
import maths.ncalculator.lookAndFeel.samples.PreScientific;
import maths.ncalculator.lookAndFeel.samples.PreSettings;

public class Calcus {

	private JFrame frame;
	private static Calcus window;
	private static View panel = new PreEquations();
	private String[] variables = { "BASIC", "BODMAS", "EQUATIONS", "SCIENTIFIC", "MATRICES", "MECHANICS", "CONSTANTS",
			"COMPLEX", "DIFFERENTIAL", "INTEGRAL", "GRAPH", "SETTINGS", "INFO" };
	private JComboBox<String> menu = new JComboBox<String>(variables);
	private int activeTab;
	private static int height = 500, width = 340;

	/**
	 * Launch the application.
	 */
	public static void call() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Calcus();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calcus() {
		initialize();
		EQUATIONS();
		menuUpdate();
	}

	/**
	 * Initialize the contents of the frame.
	*/

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setTitle("NCalculator1.0.0");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(360, 25, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		menu.setBackground(Color.LIGHT_GRAY);
		menu.setBounds(12, 20, 200, 30);
		menu.setForeground(Color.BLACK);
		menu.setFont(new Font("Microsoft JhengHei", Font.BOLD, 25));
		menu.setSelectedItem("EQUATIONS");
		frame.getContentPane().add(menu);
	}

	private void menuUpdate() {
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activeTab = menu.getSelectedIndex();
				menuSetter(activeTab);
			}
		});
	}

	private void menuSetter(int arg) {
		if (arg == 0) {
			panel.setVisible(false);
			BASIC();
		} else if (arg == 1) {
			panel.setVisible(false);
			BODMAS();
		} else if (arg == 2) {
			panel.setVisible(false);
			EQUATIONS();
		} else if (arg == 3) {
			panel.setVisible(false);
			SCIENTIFIC();
		} else if (arg == 4) {
			panel.setVisible(false);
			MATRICES();
		} else if (arg == 5) {
			panel.setVisible(false);
			MECHANICS();
		} else if (arg == 6) {
			panel.setVisible(false);
			CONSTANTS();
		} else if (arg == 7) {
			panel.setVisible(false);
			COMPLEX();
		} else if (arg == 8) {
			panel.setVisible(false);
			DIFFERENTIAL();
		} else if (arg == 9) {
			panel.setVisible(false);
			INTEGRAL();
		} else if (arg == 10) {
			panel.setVisible(false);
			GRAPH();
		} else if (arg == 11) {
			panel.setVisible(false);
			SETTINGS();
		} else if (arg == 12) {
			panel.setVisible(false);
			INFO();
		}
	}

	private static void setWidth(int width) {
		Calcus.width = width;
	}

	private static void setHeight(int height) {
		Calcus.height = height;
	}

	private void GRAPH() {
		Calcus.setWidth(400);
		Calcus.setHeight(550);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreGraph();
		panel.setBounds(10, 75, 365, 425);

		supplimentary(panel);
	}

	private void INTEGRAL() {
		Calcus.setWidth(400);
		Calcus.setHeight(550);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreIntegral();
		panel.setBounds(10, 75, 365, 425);

		supplimentary(panel);
	}

	private void DIFFERENTIAL() {
		Calcus.setWidth(400);
		Calcus.setHeight(550);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreDifferential();
		panel.setBounds(10, 75, 365, 425);

		supplimentary(panel);
	}

	protected void COMPLEX() {
		Calcus.setWidth(400);
		Calcus.setHeight(550);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreComplex();
		panel.setBounds(10, 75, 365, 425);

		supplimentary(panel);
	}

	protected void CONSTANTS() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreConstants();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void MECHANICS() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreMechanics();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void MATRICES() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreMatrices();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void EQUATIONS() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreEquations();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void SCIENTIFIC() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreScientific();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	private void BODMAS() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreBodmas();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void BASIC() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreBasic();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void SETTINGS() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreSettings();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	protected void INFO() {
		Calcus.setWidth(340);
		Calcus.setHeight(500);
		frame.getContentPane().remove(panel);
		frame.setBounds(frame.getX(), frame.getY(), width, height);
		panel = new PreInfo();
		panel.setBounds(10, 72, 305, 380);

		supplimentary(panel);
	}

	private void supplimentary(JPanel panel) {
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);
	}
}