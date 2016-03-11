package utcn.pt.polynomials.gui;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private static int width = 500;
	private static int height = 250;

	private static final long serialVersionUID = 1L;

	// Swing Objects:

	private JPanel panel, panelA, panelB, panelOperators, panelResult, panelBottom;
	private JButton addButton, substractButton, multiplyButton, divideButton, derivateButton, integrateButton,
			closeButton;
	private JTextField A, B, Result, Status, aTextField, bTextField, resultTextField, statusTextField;
	private Dimension rowNameSize = new Dimension(45, 30);

	public MainFrame(String title) {

		super(title);

		initFrame();
		initPanel();

	}

	private void initFrame() {
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		System.out.println("Main Frame initialized");

	}

	private void initPanel() {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(LEFT_ALIGNMENT);
		add(panel);

		initInternalPanels();
		combineAllPanels();

	}

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
		panelOperators = new JPanel();
		panelOperators.setLayout(new BoxLayout(panelOperators, BoxLayout.X_AXIS));

		addButton = new JButton("+");
		substractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		derivateButton = new JButton("der()");
		integrateButton = new JButton("int()");

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
