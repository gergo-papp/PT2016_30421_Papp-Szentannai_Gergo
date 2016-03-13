package utcn.pt.polynomials.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utcn.pt.polynomials.App;
import utcn.pt.polynomials.polynomial.operators.*;

public class MainFrame extends JFrame {

	// This class should be instantiated only once => static fields.

	private static UnaryOperator unaryOperator;
	private static BinaryOperator binaryOperator;

	private static int width = 500;
	private static int height = 250;

	private static final long serialVersionUID = 1L;

	// Swing Objects:

	private JPanel panel, panelA, panelB, panelOperators, panelResult, panelBottom;
	private JButton addButton, substractButton, multiplyButton, divideButton, derivateButton, integrateButton,
			closeButton;
	private JTextField A, B, Result, Status, aTextField, bTextField, resultTextField, statusTextField;
	private Dimension rowNameSize = new Dimension(45, 30);

	// Constructor:

	/**
	 * Instantiates the MainFrame with a title. All graphical content will be
	 * displayed within this Frame.
	 * 
	 * @param title
	 */
	public MainFrame(String title) {

		super(title);

		initFrame();
		initPanel();

	}

	/**
	 * Initializes the JFrame.
	 */
	private void initFrame() {

		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		System.out.println("Main Frame initialized\n");

	}

	/**
	 * Initializes the panel of the MainFrame. Sets the layout.
	 */
	private void initPanel() {

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(LEFT_ALIGNMENT);
		add(panel);

		initInternalPanels();
		combineAllPanels();

	}

	/**
	 * Initializes all the internal JPanels inside the MainFrame.
	 */
	private void initInternalPanels() {
		initA();
		initB();
		initOperators();
		initResult();
		initBottom();
	}

	private void initA() {
		panelA = new JPanel();
		panelA.setLayout(new BoxLayout(panelA, BoxLayout.X_AXIS));

		A = new JTextField("  A(x)=");
		A.setPreferredSize(rowNameSize);
		A.setMaximumSize(rowNameSize);
		A.setEditable(false);

		panelA.add(A);
		panelA.add(Box.createRigidArea(new Dimension(5, 0)));

		aTextField = new JTextField();

		panelA.add(aTextField);
	}

	private void initB() {
		panelB = new JPanel();
		panelB.setLayout(new BoxLayout(panelB, BoxLayout.X_AXIS));

		B = new JTextField("  B(x)=");
		B.setPreferredSize(rowNameSize);
		B.setMaximumSize(rowNameSize);
		B.setEditable(false);

		panelB.add(B);
		panelB.add(Box.createRigidArea(new Dimension(5, 0)));

		bTextField = new JTextField();

		panelB.add(bTextField);
	}

	private void initOperators() {
		// Initialize layout of the panel(horizontal box layout):

		panelOperators = new JPanel();
		panelOperators.setLayout(new BoxLayout(panelOperators, BoxLayout.X_AXIS));

		// Instantiating buttons:

		addButton = new JButton("+");
		substractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		derivateButton = new JButton("A'");
		integrateButton = new JButton("int(A)");

		// Adding buttons and rigid areas between them:

		panelOperators.add(Box.createRigidArea(new Dimension(40, 0)));
		panelOperators.add(addButton);
		panelOperators.add(Box.createRigidArea(new Dimension(20, 0)));
		panelOperators.add(substractButton);
		panelOperators.add(Box.createRigidArea(new Dimension(20, 0)));
		panelOperators.add(multiplyButton);
		panelOperators.add(Box.createRigidArea(new Dimension(20, 0)));
		panelOperators.add(divideButton);
		panelOperators.add(Box.createRigidArea(new Dimension(20, 0)));
		panelOperators.add(derivateButton);
		panelOperators.add(Box.createRigidArea(new Dimension(20, 0)));
		panelOperators.add(integrateButton);

		// Adding ActionListeners:

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryOperator = new Add();
				App.printer.printStatus("Addition");
				binaryCompute();

			}
		});
		substractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryOperator = new Substract();
				App.printer.printStatus("Substraction");
				binaryCompute();
			}
		});
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryOperator = new Multiply();
				App.printer.printStatus("Multiplication");
				binaryCompute();
			}
		});
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryOperator = new Divide();
				App.printer.printStatus("Division");
				binaryCompute();
			}
		});
		derivateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unaryOperator = new Derivate();
				App.printer.printStatus("Derivation");
				unaryCompute();
			}
		});
		integrateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unaryOperator = new Integrate();
				App.printer.printStatus("Integration (warinng, fractions are rounded!)");
				unaryCompute();
			}
		});
	}

	// Calling required operation:

	protected void binaryCompute() {
		App.printer.printPolynom(binaryOperator.compute(App.reader.readPolynom(0), App.reader.readPolynom(1)));
	}

	protected void unaryCompute() {
		App.printer.printPolynom(unaryOperator.compute(App.reader.readPolynom(0)));
	}

	private void initResult() {
		panelResult = new JPanel();
		panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.X_AXIS));

		Result = new JTextField(" Result");
		Result.setPreferredSize(rowNameSize);
		Result.setMaximumSize(rowNameSize);
		Result.setEditable(false);
		panelResult.add(Result);

		panelResult.add(Box.createRigidArea(new Dimension(5, 0)));
		resultTextField = new JTextField();
		resultTextField.setEditable(false);
		panelResult.add(resultTextField);
	}

	private void initBottom() {
		panelBottom = new JPanel();
		panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.X_AXIS));

		Status = new JTextField(" Status");
		Status.setPreferredSize(rowNameSize);
		Status.setMaximumSize(rowNameSize);
		Status.setEditable(false);

		panelBottom.add(Status);
		panelBottom.add(Box.createRigidArea(new Dimension(5, 0)));

		statusTextField = new JTextField();
		statusTextField.setEditable(false);
		panelBottom.add(statusTextField);

		panelBottom.add(Box.createRigidArea(new Dimension(5, 0)));
		closeButton = new JButton("Close");
		panelBottom.add(closeButton);
	}

	private void combineAllPanels() {
		panel.add(panelA);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(panelB);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(panelOperators);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(panelResult);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(panelBottom);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
	}

	public String getA() {
		return aTextField.getText();
	}

	public String getB() {
		return bTextField.getText();
	}

	public void setResult(String result) {
		resultTextField.setText(result);
	}

	public void setStatus(String status) {
		statusTextField.setText(status);
	}
}
