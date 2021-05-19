import javax.swing.JOptionPane;

public class ExceptionsExample {
	public static void main(String[] args) {
		int num;
		double root;

		while (true) {
			try {
				num = getNumberInput();
				root = calcSquareRoot(num);
				System.out.println("\n\n" + root);
				System.out.println("the program executed normally. No exceptions.");
				break;
			}
			catch (NumberFormatException e) {
				System.err.println("\n\n" + e.getMessage());
				e.printStackTrace();
				System.out.println("the program cought an exception but did not crash!!!!!!!");
			}
			catch (NegativeNumberException e) {
				System.err.println("\n\n" + e.getMessage());
				e.printStackTrace();
				System.out.println("the program cought an exception but did not crash!!!!!!!");
			}
		}


	}

	// the calcSquareRoot is a method that throws an exception
	public static double calcSquareRoot(int num) throws NegativeNumberException {
		if (num >= 0)
			return Math.sqrt(num);
		else
			throw new NegativeNumberException("Please don't use negative numbers");
	}

	// the getNumberInput calls Integer.parseInt, which may throw a NumberFormatException,
	// but does not handle the exception itself ---it simply throws it again to whichever
	// method has called it

	public static int getNumberInput() throws NumberFormatException {
		String in = JOptionPane.showInputDialog("Please enter a positive integer:");
		return Integer.parseInt(in);
	}
}
