/*         ====================================================
*          # Name: Teresa Potts (POTTST1)
*          # Date: 3/27/14
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
 * This class contains the display for the invoice panel, which is the panel for adding and removing to invoice.
 */
public class InvoicePanel extends JPanel
{
	public static Map<Product, Integer> invoiceDisplay = new HashMap<>();
	private DefaultListModel<Product> product;
	private JList<Product> invoiceList;
	private static JTextField upcField;
	private static JTextField qtyField;
	private static JTextField invAmtField;
	private InvoicePanel invoiceView = this;
	private JLabel errorMessage = new JLabel("");
	private JFrame frame;

	/**
	 * This method creates the buttons and fields for the invoice panel.
	 *
	 * @param frame
	 */
	public InvoicePanel(JFrame frame)
	{

		this.frame = frame;
		this.product = new DefaultListModel<>();
		invoiceList = new JList<>(product);
		//invoiceList.addListSelectionListener(new InvoiceListListener(invoiceList));
		invoiceList.setLayout(new FlowLayout());

		this.add(invoiceList);
		this.setLayout(new FlowLayout());
		Font font = errorMessage.getFont();
		errorMessage.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
		errorMessage.setForeground(Color.RED);

		JTextField upcField = new JTextField();
		upcField.setColumns(8);

		this.add(new JPanel());
		this.add(errorMessage);

/*		JPanel invAmtPanel = new JPanel();
		invAmtPanel.setLayout(new FlowLayout());
		invAmtPanel.add(new JLabel("Invoice Amount"));
		invAmtPanel.setName("Invoice Amount");
		invAmtPanel.add(invAmtField);
		this.add(invAmtPanel);*/

		JPanel upcPanel = new JPanel();
		upcPanel.setLayout(new FlowLayout());
		upcPanel.add(new JLabel("UPC"));
		upcPanel.setName("UPC");
		upcPanel.add(upcField);
		this.add(upcPanel);

		JTextField qtyField = new JTextField();
		qtyField.setColumns(3);

		JPanel qtyPanel = new JPanel();
		qtyPanel.setLayout(new FlowLayout());
		qtyPanel.add(new JLabel("Quantity"));
		qtyPanel.setName("Quantity");
		qtyPanel.add(qtyField);
		this.add(qtyPanel);

		//Add button section
		JPanel buttonPanel = new JPanel();
		JButton addButton = new JButton("Add to Invoice");
		addButton.addActionListener(new InvoicePanelListener(invoiceList, upcField, qtyField, invoiceView,
		                                                     invoiceDisplay));
		addButton.setName("Add");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton removeButton = new JButton("Remove from Invoice");
		removeButton.addActionListener(new InvoicePanelListener(invoiceList, upcField, qtyField, invoiceView,
		                                                        invoiceDisplay));
		removeButton.setName("Remove");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(removeButton);
		this.add(buttonPanel);

		buttonPanel = new JPanel();
		JButton backButton = new JButton("Back to Previous Menu");
		backButton.addActionListener(new InvoicePanelListener(invoiceList, upcField, qtyField, invoiceView,
		                                                      invoiceDisplay));
		backButton.setName("Back");
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(backButton);
		this.add(buttonPanel);

	}

	private JPanel buildListPanel()
	{

		invoiceList.setPreferredSize(new Dimension(300, 380));

		JPanel listPanel =
				new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		listPanel.add(invoiceList);

		return listPanel;
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
