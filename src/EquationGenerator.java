import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * Class used to generate a csv file with random math questions and answers for each level
 * @author Matthew Nazaruk
 *
 */
public class EquationGenerator {
	private FileWriter csvWriter;
	private int num1, num2, answer;
	
	/**
	 * Constructor. Takes in the world and generates the csv file
	 * @param world the world the level is in
	 */
	public EquationGenerator(int world) {
		//Gnerates a csv file for the appropriate world
		switch(world) {
		case 0:
			try {
				csvWriter = new FileWriter(System.getProperty("user.dir") + "/equations.csv");
				
				// Generating and writing addition equations
	            for (int i = 0; i < 40; i++) {
	                csvWriter.append(generateAdditionEquation() + "\n");
	            }
	            
	            csvWriter.flush();
	            csvWriter.close();
			}
			catch(IOException e) {
				System.out.println("Error generating equations");
			}
			break;
			
		case 1:
			try {
				csvWriter = new FileWriter("equations.csv");
				
				// Generating and writing subtraction equations
	            for (int i = 0; i < 40; i++) {
	                csvWriter.append(generateSubtractionEquation() + "\n");
	            }
	            
	            csvWriter.flush();
	            csvWriter.close();
			}
			catch(IOException e) {
				System.out.println("Error generating equations");
			}
			break;
			
		case 2:
			try {
				csvWriter = new FileWriter("equations.csv");
				
				// Generating and writing multiplication equations
	            for (int i = 0; i < 40; i++) {
	                csvWriter.append(generateMultiplicationEquation() + "\n");
	            }
	            
	            csvWriter.flush();
	            csvWriter.close();
			}
			catch(IOException e) {
				System.out.println("Error generating equations");
			}
			break;
			
		case 3:
			try {
				csvWriter = new FileWriter("equations.csv");
				
				// Generating and writing division equations
	            for (int i = 0; i < 40; i++) {
	                csvWriter.append(generateDivisionEquation() + "\n");
	            }
	            
	            csvWriter.flush();
	            csvWriter.close();
			}
			catch(IOException e) {
				System.out.println("Error generating equations");
			}
			break;
			
		case 4:
			try {
				csvWriter = new FileWriter("equations.csv");
				
				// Generating and writing combination of all equations
	            for (int i = 0; i < 12; i++) {
	            	csvWriter.append(generateAdditionEquation() + "\n");
	            	csvWriter.append(generateSubtractionEquation() + "\n");
	            	csvWriter.append(generateMultiplicationEquation() + "\n");
	                csvWriter.append(generateDivisionEquation() + "\n");
	            }
	            
	            csvWriter.flush();
	            csvWriter.close();
			}
			catch(IOException e) {
				System.out.println("Error generating equations");
			}
			break;
		}
    }
	
	/**
	 * Method to generate a random addition equation
	 * @return a string containing the equation and answer separated by a comma
	 */
    private String generateAdditionEquation() {
        Random random = new Random();
        do {
        	num1 = random.nextInt(90) + 10; // Generate a random 2-digit number
        	num2 = random.nextInt(90) + 10; // Generate another random 2-digit number
        	answer = num1 + num2;
        }while(answer>= 100);
        return num1 + " + " + num2 + "," + answer;
    }

    /**
     * Method to generate a random subtraction equation
     * @return a string containing the equation and answer separated by a comma
     */
    private String generateSubtractionEquation() {
        Random random = new Random();
        do {
        	num1 = random.nextInt(90) + 10; // Generate a random 2-digit number
        	num2 = random.nextInt(num1 - 9) + 10; // Ensure num2 is smaller than num1 to avoid negative result
        }while(num2 == num1);
        answer = num1 - num2;
        return num1 + " - " + num2 + "," + answer;
    }
    
    /**
     * Method to generate a random multiplication equation
     * @return a string containing the equation and answer separated by a comma
     */
    private String generateMultiplicationEquation() {
        Random random = new Random();
        do {
        	num1 = random.nextInt(12) + 1; // Generate a random number from 1-12
        	num2 = random.nextInt(12) + 1; // Generate another random number from 1-12
        }while(num2 == 1 || num1 == 1);
        
        answer = num1 * num2;
        return num1 + " × " + num2 + "," + answer;
    }
    
    /**
     * Method to generate a random multiplication equation
     * @return a string containing the equation and answer separated by a comma
     */
    private String generateDivisionEquation() {
        Random random = new Random();
        do {
        	num1 = random.nextInt(90) + 10; // Generate a random number from 1-12
            num2 = random.nextInt(90) + 10; // Generate another random number from 1-12
            answer = num1 / num2;
        }while(num1 % num2 != 0 || num2 == 1 || num2 == num1);
        
        return num1 + " ÷ " + num2 + "," + answer;
    }
}
