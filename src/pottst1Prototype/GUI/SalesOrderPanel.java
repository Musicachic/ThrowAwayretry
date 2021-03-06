/*         ====================================================
*          # Name: Teresa Potts (POTTST1)
*          # Date: 3/25/14
*          # Course Name: CITP 290
*          # Description: 
*          ====================================================
*
*
*/

package pottst1Prototype.GUI;

import pottst1Prototype.data.Product;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the display for the sales order panel, which is the default panel after logging in.
 */
public class SalesOrderPanel extends JPanel
{
	public static Map<Product, Integer> invoiceDisplay = new HashMap<>();
	private JTextField add;
	private JTextField remove;
	private JTextField finish;
	private JTextField management;
	private JTextField exit;
	private SalesOrderPanel salesView = this;
	private JLabel errorMessage = new JLabel("");
	private JFrame frame;

	/**
	 * This method creates the buttons and fields for the sales order panel.
	 *
	 * @param frame
	 */
	public SalesOrderPanel(JFrame frame)

	{

		this.setLayout(new GridLayout(7, 3));
		this.frame = frame;
		this.add(new JPanel());

		//Add button section
		JPanel buttonPanel = new JPanel();
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new SalesOrderPanelListener(add, remove, finish, management, exit, salesView,
		                                                        invoiceDisplay));
		addButton.setName("Add");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(addButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new SalesOrderPanelListener(add, remove, finish, management, exit, salesView,
		                                                           invoiceDisplay
		));
		removeButton.setName("Remove");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(removeButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton finishButton = new JButton("Finish");
		finishButton.addActionListener(new SalesOrderPanelListener(add, remove, finish, management, exit, salesView,
		                                                           invoiceDisplay
		));
		finishButton.setName("Finish");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(finishButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton managementButton = new JButton("Management");
		managementButton.addActionListener(new SalesOrderPanelListener(add, remove, finish, management, exit,
		                                                               salesView, invoiceDisplay));
		managementButton.setName("Management");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(managementButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new SalesOrderPanelListener(add, remove, finish, management, exit, salesView,
		                                                         invoiceDisplay));
		exitButton.setName("Exit");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(exitButton);
		this.add(buttonPanel);
	}

	/**
	 * This is a generic error message method that is used to display errors on each page.
	 *
	 * @param message
	 */
	public void displayError(String message)
	{
		errorMessage.setText(message);
	}

	/**
	 * This is a generic method to help transition between frames.
	 *
	 * @return JFrame
	 */
	public JFrame getFrame()
	{
		return frame;
	}

}
