import java.util.Random;

public class Tests {
	static void tictac() {
		NeuralNetwork nn = new NeuralNetwork(9, 5, 1);
		Random rand = new Random(); 
		
		double[] input_arr = new double[9];
		double[] target_arr = new double[1];
		
		for (int i = 0; i < 90000000; i++) {
		for (int j = 0; j < input_arr.length; j++) {
			int input_chooser = rand.nextInt(2) + 1;
			if (input_chooser == 1) {
				input_arr[j] = -1;
			} else if (input_chooser == 2) {
				input_arr[j] = 1;
			}
		}
		
		if (input_arr[0] == 1 && input_arr[1] == 1 && input_arr[2] == 1 && input_arr[3] == -1 && input_arr[4] == -1 && input_arr[5] == -1 && input_arr[6] == -1 && input_arr[7] == -1 && input_arr[8] == -1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == -1 && input_arr[1] == -1 && input_arr[2] == -1 && input_arr[3] == 1 && input_arr[4] == 1 && input_arr[5] == 1 && input_arr[6] == -1 && input_arr[7] == -1 && input_arr[8] == -1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == -1 && input_arr[1] == -1 && input_arr[2] == -1 && input_arr[3] == -1 && input_arr[4] == -1 && input_arr[5] == -1 && input_arr[6] == 1 && input_arr[7] == 1 && input_arr[8] == 1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == 1 && input_arr[1] == -1 && input_arr[2] == -1 && input_arr[3] == 1 && input_arr[4] == -1 && input_arr[5] == -1 && input_arr[6] == 1 && input_arr[7] == -1 && input_arr[8] == -1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == -1 && input_arr[1] == 1 && input_arr[2] == -1 && input_arr[3] == -1 && input_arr[4] == 1 && input_arr[5] == -1 && input_arr[6] == -1 && input_arr[7] == 1 && input_arr[8] == -1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == -1 && input_arr[1] == -1 && input_arr[2] == 1 && input_arr[3] == -1 && input_arr[4] == -1 && input_arr[5] == 1 && input_arr[6] == -1 && input_arr[7] == -1 && input_arr[8] == 1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == 1 && input_arr[1] == -1 && input_arr[2] == -1 && input_arr[3] == -1 && input_arr[4] == 1 && input_arr[5] == -1 && input_arr[6] == -1 && input_arr[7] == -1 && input_arr[8] == 1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else if (input_arr[0] == -1 && input_arr[1] == -1 && input_arr[2] == 1 && input_arr[3] == -1 && input_arr[4] == 1 && input_arr[5] == -1 && input_arr[6] == 1 && input_arr[7] == -1 && input_arr[8] == -1) {
			target_arr[0] = 1;
			nn.train(input_arr, target_arr);
		} else {
			target_arr[0] = 0;
			nn.train(input_arr, target_arr);
		} 
	}
	 
	input_arr[0] = 1;
	input_arr[1] = -1;
	input_arr[2] = -1;
	input_arr[3] = 1;
	input_arr[4] = -1;
	input_arr[5] = -1;
	input_arr[6] = 1;
	input_arr[7] = -1;
	input_arr[8] = -1;
	Matrix m = Matrix.fromArray(input_arr);
	m = nn.feedForward(nn.feedForward(m, nn.weights_ih, nn.bias_h), nn.weights_ho, nn.bias_o);
	Matrix.displayAsTable(m.data);
	}
	
	static void xor() {
		NeuralNetwork nn = new NeuralNetwork(2, 3, 1);
		Random rand = new Random(); 
			
		double[] input_arr = new double[2];
		double[] target_arr = new double[1];
			
		for (int i = 0; i < 900000; i++) {
			for (int j = 0; j < input_arr.length; j++) {
				int input_chooser = rand.nextInt(2) + 1;
				if (input_chooser == 1) {
					input_arr[j] = -1;
				} else if (input_chooser == 2) {
					input_arr[j] = 1;
				}
			}
			if (input_arr[0] == 1 && input_arr[1] == 1){
				target_arr[0] = 0;
				nn.train(input_arr, target_arr);
			}
			else if(input_arr[0] == -1 && input_arr[1] == -1) {
				target_arr[0] = 0;
				nn.train(input_arr, target_arr);
			}
			else if(input_arr[0] == 1 && input_arr[1] == -1) {
				target_arr[0] = 1;
				nn.train(input_arr, target_arr);
			}
			else if(input_arr[0] == -1 && input_arr[1] == 1) {
				target_arr[0] = 1;
				nn.train(input_arr, target_arr);
			}
			
			
		}	
//		
//		///////MOVE TO TEST ACCURACY SOMEHOW////////////////////
//		input_arr[0] = 0;
//		input_arr[1] = 0;
//		
//		int totalErrors = 0;
//		for (int i = 0; i < 900000; i++) {
//			for (int j = 0; j < input_arr.length; j++) {
//				int input_chooser = rand.nextInt(2) + 1;
//				if (input_chooser == 1) {
//					input_arr[j] = -1;
//				} else if (input_chooser == 2) {
//					input_arr[j] = 1;
//				}
//			}
//			
//			if (input_arr[0] == 1 && input_arr[1] == 1){
//				target_arr[0] = 0;
//				Matrix m = Matrix.fromArray(input_arr);
//				m = nn.feedForward(nn.feedForward(m, nn.weights_ih, nn.bias_h), nn.weights_ho, nn.bias_o);
//				System.out.println(calculateError(Matrix.toArray(m), target_arr));
//			}
//			else if(input_arr[0] == -1 && input_arr[1] == -1) {
//				target_arr[0] = 0;
//				Matrix m = Matrix.fromArray(input_arr);
//				m = nn.feedForward(nn.feedForward(m, nn.weights_ih, nn.bias_h), nn.weights_ho, nn.bias_o);
//				System.out.println(calculateError(Matrix.toArray(m), target_arr));
//			}
//			else if(input_arr[0] == 1 && input_arr[1] == -1) {
//				target_arr[0] = 1;
//				Matrix m = Matrix.fromArray(input_arr);
//				m = nn.feedForward(nn.feedForward(m, nn.weights_ih, nn.bias_h), nn.weights_ho, nn.bias_o);
//				System.out.println(calculateError(Matrix.toArray(m), target_arr));
//			}
//			else if(input_arr[0] == -1 && input_arr[1] == 1) {
//				target_arr[0] = 1;
//				Matrix m = Matrix.fromArray(input_arr);
//				m = nn.feedForward(nn.feedForward(m, nn.weights_ih, nn.bias_h), nn.weights_ho, nn.bias_o);
//				System.out.println(calculateError(Matrix.toArray(m), target_arr));
//			}
//		}
//		System.out.println(totalErrors);
	}
	static double calculateError(double[] output, double[] target) {
		double[] diff = new double[output.length];
		double error = 0;
		for (int i = 0; i < output.length; i++) {
			diff[i] = target[i] - output[i];
		}
		
		for (int i = 0; i < diff.length; i++) {
			error += diff[i] * diff[i];
		}
		
		return error;
	}
	
	static float testAccuracy() {
		//Add where it runs the neural network several times and calculates the percent error
		float errorPercent = 0;
		
		return errorPercent;
		
	}
}
