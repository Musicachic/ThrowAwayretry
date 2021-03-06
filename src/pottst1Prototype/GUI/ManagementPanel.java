/*         ====================================================
*          # Name: Teresa Potts (POTTST1)
*          # Date: 4/11/14
*          # Course Name: CITP 290
*          # Description: 
*          ====================================================
*
*
*/

package pottst1Prototype.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class contains the display for the management panel, which is the panel for managing inventory and employees.
 */
public class ManagementPanel extends JPanel
{
	private JFrame frame;
	private JLabel errorMessage = new JLabel("");
	private JButton employeeButton;
	private JButton inventoryButton;
	private JButton backButton;
	private ManagementPanel mgmtView = this;

	/**
	 * This method creates the buttons and fields for the management panel.
	 *
	 * @param frame
	 */
	public ManagementPanel(JFrame frame)
	{
		super(new GridLayout(7, 3));
		this.frame = frame;
		this.add(new JPanel());

		Font font = errorMessage.getFont();
		errorMessage.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
		errorMessage.setForeground(Color.RED);

		//Employee Button Stuff
		JPanel buttonPanel = new JPanel();
		JButton employeeButton = new JButton("Employee Management");
		employeeButton.addActionListener(new ManagementPanelListener(mgmtView, employeeButton, inventoryButton,
		                                                             backButton));
		employeeButton.setName("Employee Management");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(employeeButton);
		this.add(buttonPanel);

		//Inventory Button Stuff
		buttonPanel = new JPanel();
		JButton inventoryButton = new JButton("Inventory Management");
		inventoryButton.addActionListener(new ManagementPanelListener(mgmtView, employeeButton, inventoryButton,
		                                                              backButton));
		inventoryButton.setName("Inventory Management");
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(inventoryButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton backButton = new JButton("Back to Previous Menu");
		backButton.addActionListener(new ManagementPanelListener(mgmtView, employeeButton, inventoryButton,
		                                                         backButton));
		backButton.setName("Back");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(backButton);
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
