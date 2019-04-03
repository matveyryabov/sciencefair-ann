import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Random; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {	
	public static void main(String[] args) {

		//TO DO 
		//NOTATE THE CODE MORE
		//CHANGE DERIVATIVE AND SIGMOID VARS IN NEURALNETWORK CLASS
		//SEPERATE TESTING FILE READER INTO TESTS CLASS
		//PUT THE CODE IN MAIN INTO TEST CLASS
		//Create a config file system and place these in there

		int number_of_input_nodes = 9;
		int number_of_output_nodes = 3;
		int number_of_hidden_nodes = 5;
		
		//Create a neural net
		NeuralNetwork nn = new NeuralNetwork(number_of_input_nodes, number_of_hidden_nodes, number_of_output_nodes);
		Random rand = new Random(); 
		
		//stuff we might wanna change based on dataset
		String file_path = "C:\\Users\\david\\Documents\\sciencefair-ann-master-1\\sciencefair-ann-master\\csv2.csv";
		
		//Replace with a function which counts the number of lines in a file.
		int lines_in_file = 45000;
		
		//Represents the place the target value is in the list
		int target_value_place = 10;
		
		//Initialize the target and input arrays
		double[] target_arr = new double[number_of_output_nodes];
        double[] input_arr = new double[number_of_input_nodes];
		double[] target_value = new double[1];
        BufferedReader br = null;
        String line = " ";
        
        //Create a config file system and place this in there
        String splitting_char = ",";
        
        for (int k = 0; k < 1000; k++)
        {
        try {
            br = new BufferedReader(new FileReader(file_path));
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(splitting_char);

        		for (int i = 0; i < number_of_input_nodes ; i++) {
        			input_arr[i] = Double.parseDouble(data[i]);
        		}
        		
				target_value[0] = Double.parseDouble(data[(target_value_place -1)]);
				for (int i = 0 ; i < number_of_output_nodes ; i++) {
					target_arr[i] = 0;
				}
				
				target_arr[(int) (Math.round(target_value[0]) +1)] = 1;
				nn.train(input_arr, target_arr);
				
				

				//System.out.println(target_arr[(int) (Math.round(target_value[0]) )]);
				
				
				

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
    	String test_path = "C:\\Users\\david\\Documents\\sciencefair-ann-master-1\\sciencefair-ann-master\\csv3.csv";
    	try {
            br = new BufferedReader(new FileReader(test_path));
            while ((line = br.readLine()) != null) {
            	String[] data = line.split(splitting_char);
            	for (int i = 0; i < number_of_input_nodes ; i++) {
        			input_arr[i] = Double.parseDouble(data[i]);
        		}
            	target_value[0] = Double.parseDouble(data[(target_value_place-2)]);
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
    	Matrix m = Matrix.fromArray(input_arr);
    	m = nn.feedForward(nn.feedForward(m, nn.weights_ih, nn.bias_h), nn.weights_ho, nn.bias_o);
    	Matrix.displayAsTable(m.data);
	}
	
}
