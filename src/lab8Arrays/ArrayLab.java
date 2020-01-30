package lab8Arrays;

/*
 * Author is SeanWarchuck
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayLab {

	public static void main(String[] args) {

		try {
			
			boolean goAgain = true;
			
			while (goAgain) {
				
				Scanner scnr = new Scanner(System.in);
				System.out.println("Welcome to our Java class, which student would you like to learn about? 1-10.");

				int input = scnr.nextInt();

				String name = WhichStudent(input);
				
				System.out.println("You chose " + name + ", What would you like to know? hometown or favorite food?");
				System.out.println(HometownOrFaveFood(name, input));
				System.out.println("Would you like to learn about another student? (y/n)");
				
				goAgain = scnr.next().toLowerCase().startsWith("y");
			}
			System.out.println("See ya!");

		} catch (InputMismatchException e) {
			System.out.println("You put something that doesnt make sense, rethink your choice and try again.");
		} catch (IndexOutOfBoundsException f) {
			System.out.println("Index you requested is out of the bounds of the array. Sorry. Please restart.");
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

	public static String WhichStudent(int i) {

		String[] names = { "Sean", "Kyle", "Mike", "John", "Kayla", "Anette", "Mary", "Suzie", "Johnny", "Josh" };

		String name = names[i-1];
		return name;

	}

	public static String HometownOrFaveFood(String name, int i) {
		Scanner scnr = new Scanner(System.in);

		String[] hometown = { "Livonia", "Detroit", "Garden City", "Lansing", "Romulous", "Kansas",
				"the Undead Settlement", "the High Wall of Lothric", "Blight Town", "Los Santos" };
		String[] faveFood = { "Ribs", "Grilled Chicken", "Pie", "Peas", "Carrots", "Asparagus", "Water(She is vegan)",
				"Boneless Chicken Wings", "Mud", "Deer" };
		String choice1 = null;

		String choice = null;
		choice = scnr.nextLine().toLowerCase();

		while (!(choice.equals("hometown")) && (!(choice.equals("favorite food")))) {
			System.out.println(
					"You did not pick \"hometown\" or \"favorite food\", would you like to know their hometown or favorite food?");
			choice = scnr.next();
		}

		if (choice.equals("hometown"))
			choice1 = (name + "'s hometown is " + hometown[i-1]);
		else
			choice1 = (name + "'s favorite food is " + faveFood[i-1]);

		return choice1;
	}
}