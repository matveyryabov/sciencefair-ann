import java.io.BufferedReader;
import java.util.Random; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	static Matrix m1;
	static Matrix m2;
	static Matrix m3;
	
	
	
	
	public static void main(String[] args) {
//		m1 = new Matrix(2, 2);
//		m2 = new Matrix(2, 2);
//		Matrix.randomize(m1.data, 0, 10);  
//		Matrix.randomize(m2.data, 0, 10);
//		Matrix.displayAsTable(m1.data);
//		//LEARN ABOUT THIS HOLY GRAIL - LAMBDA
//	    Matrix.map(m1, x -> sigmoid(x));
//		Matrix.displayAsTable(m2.data);
//		m3= Matrix.findDiffrence(m1, m2);
//	 	Matrix.displayAsTable(m3.data);
	

		
		Tests.xor();

//
//		//(System.getProperty("user.dir") + "\\" + "csv.txt")
//        String csvFile = "C:\\Users\\i_ism\\eclipse-workspace\\Neural Network XOR\\src\\csv.txt";
//        System.out.println(csvFile);
//        String line = "";
//        String cvsSplitBy = ",";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//
//            while ((line = br.readLine()) != null) {
//
//                // use comma as separator
//                String[] country = line.split(cvsSplitBy);
//                for(int i = 0; i < country.length; i++) {
//                	System.out.println(country[i]);
//                }
//
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//	}
	}	
}
