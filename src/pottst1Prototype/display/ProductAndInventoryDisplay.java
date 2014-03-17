/*         ====================================================
*          # Name: Teresa Potts (POTTST1)
*          # Date: 3/11/14
*          # Course Name: CITP 290
*          # Description: 
*          ====================================================
*
*
*/

package pottst1Prototype.display;

import pottst1Prototype.data.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * This class contains method to check if the productsandinventory.txt file exists,
 * the add and remove product method for the manager function to use.
 */

public class ProductAndInventoryDisplay
{
	private static Scanner sc = new Scanner(System.in);
	private static Product prod;
	static File f;
	static PrintWriter pw = null;

	/**
	 * This method checks to see if the ProductsAndInventory.txt file exists and if not it will create it.
	 */
	public static void doesFileExist()
	{
		f = new File("ProductsAndInventory.txt");

		if (!f.exists())
		{
			try
			{
				f.createNewFile();
			} catch (IOException e)
			{
				System.out.println("Could not create file.");
				System.exit(-1);
			}
		}

		try
		{
			pw = new PrintWriter(new FileOutputStream(f, true));
		} catch (FileNotFoundException e)
		{
			System.out.println("Could not locate file.");
		}
	}

	/**
	 * This method will allow a manager to add a new product. After they enter in the answers based on the prompts it
	 * will write the new product to the file. It will also catch the exception if the file is not found.
	 */

	public static void addNewProduct()
	{
		File f = new File("ProductsAndInventory.txt");

		String choice = "y";

		try
		{
			pw = new PrintWriter(new FileOutputStream(f, true));

			while (choice.equalsIgnoreCase("y"))
			{
				System.out.print("What is the upc? ");
				String upc = sc.nextLine();

				System.out.print("What is the product description? ");
				String description = sc.nextLine();

				System.out.print("What is the product price per unit? ");
				BigDecimal price = BigDecimal.valueOf(Double.parseDouble(sc.nextLine()));

				System.out.print("What is the number in stock of the product? ");
				int quantity = Integer.parseInt(sc.nextLine());

				prod = new Product(upc, description, price, quantity);

				pw.write(prod.getUpc() + "\t");
				pw.write(prod.getDescription() + "\t");
				pw.write(String.valueOf(prod.getPrice()) + "\t");
				pw.write(prod.getQuantity() + "\n");

				System.out.print("Would you like to add another product? Y or N ");
				choice = sc.nextLine();
			}
			pw.close();

		} catch (FileNotFoundException e)
		{
			System.out.println("Could not locate file.");
		}
	}
}