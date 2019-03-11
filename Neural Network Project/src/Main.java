import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Random; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) {
		//Create a config file system and place these in there
		int number_of_input_nodes = 10;
		int number_of_output_nodes = 9;
		int number_of_hidden_nodes = 10;
		
		//Create a neural net
		NeuralNetwork nn = new NeuralNetwork(number_of_input_nodes, number_of_hidden_nodes, number_of_output_nodes);
		Random rand = new Random(); 
		
		//stuff we might wanna change based on dataset
		String file_path = "C:\\git\\sciencefair-ann\\csv.csv";
		
		//Replace with a function which counts the number of lines in a file.
		int lines_in_file = 45000;
		
		//Represents the place the target value is in the list
		int target_value_place = 11;
		
		//Initialize the target and input arrays
		double[] target_arr = new double[number_of_output_nodes];
        double[] input_arr = new double[number_of_input_nodes];
		
        BufferedReader br = null;
        String line = " ";
        
        //Create a config file system and place this in there
        String splitting_char = ",";
        
        try {
            br = new BufferedReader(new FileReader(file_path));
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(splitting_char);

        		for (int i = 0; i < number_of_input_nodes ; i++) {
        			input_arr[i] = Double.parseDouble(data[i]);
        		}
        		
        		target_arr[0] = Double.parseDouble(data[10]);
        		System.out.println(target_arr[0]);
            }
                	
                			
                		
                	
                
            
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();}
	        
        }
	}
	}
}
