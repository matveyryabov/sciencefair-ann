
public class NeuralNetwork {
	
	Matrix weights_ih;
	Matrix weights_ho;
	 
	Matrix bias_h;
	Matrix bias_o;
	
	public int accuracyValue = 0;
	
	
	
	NeuralNetwork(int numI, int numH, int numO) {
		 weights_ih = new Matrix(numH, numI);
		 weights_ho = new Matrix(numO, numH);
		 Matrix.randomize(weights_ih.data, -1, 1);
		 Matrix.randomize(weights_ho.data, -1, 1);
		 
		 bias_h = new Matrix(numH, 1);
		 bias_o = new Matrix(numO, 1);
		 Matrix.randomize(bias_h.data, -1, 1);
		 Matrix.randomize(bias_o.data, -1, 1);
		
	}
	
	void train(double[] input_arr, double[] target_arr) {
		
		double lr = 0.01;
		
		//Convert function inputs to Matrix
		Matrix input_m = Matrix.fromArray(input_arr);
		Matrix target_m = Matrix.fromArray(target_arr);
		
		//Feed Forward
		Matrix hidden_output_m = feedForward(input_m, weights_ih, bias_h);
		Matrix output_m = feedForward(hidden_output_m, weights_ho, bias_o);
		
		//Calculate the  output layer error
		//Error = target - outputs
	
		Matrix error_m = Matrix.findDiffrence(target_m, output_m);
		///
		/// Change nottation to accept L1 L2
		///
		
		//Transpose hidden layer output to allow for the calculation of the gradient of the weights_ho
		Matrix hidden_output_m_t = Matrix.transposeMatrix(hidden_output_m.data);
		
		//Transpose input matrix to allow for the calculation of the gradient of the weights_ih
		Matrix input_m_t = Matrix.transposeMatrix(input_m.data);
		
		//Calculate the derivative of sigmoid
		Matrix derivative_of_sigmoid_m = Matrix.map(output_m, x -> Matrix.dsoftmax(x));
		
		//Calculate the gradient of the weights_ho matrix
		Matrix gradient_of_weights_ho_m = Matrix.hadamardProduct(derivative_of_sigmoid_m, error_m);
		Matrix.scaleMatrix(gradient_of_weights_ho_m.data, lr);
		bias_o = Matrix.addTwoMatrices(bias_o.data, gradient_of_weights_ho_m.data);
		gradient_of_weights_ho_m = Matrix.productOfTwoMatrices(gradient_of_weights_ho_m.data, hidden_output_m_t.data);
		
		
		//Adjust the weights_ho matrix accordingly
		weights_ho = Matrix.addTwoMatrices(weights_ho.data, gradient_of_weights_ho_m.data);
		
		//Transpose weights matrix to calculate hidden layer error
		Matrix weights_ho_t = Matrix.transposeMatrix(weights_ho.data);
				

		//Calculate hidden error (error * weight ignoring the normalization)
		Matrix hidden_error_m = Matrix.productOfTwoMatrices(weights_ho_t.data, error_m.data);
		
		//Recalculate the derivative of sigmoid
		derivative_of_sigmoid_m = Matrix.map(hidden_output_m, x -> Matrix.dsoftmax(x));
		
		//Calculate the gradient of the weights_oh matrix
		Matrix gradient_of_weights_ih_m = Matrix.hadamardProduct(derivative_of_sigmoid_m, hidden_error_m);
		Matrix.scaleMatrix(gradient_of_weights_ih_m.data, lr);
		bias_h = Matrix.addTwoMatrices(bias_h.data, gradient_of_weights_ih_m.data);
		gradient_of_weights_ih_m = Matrix.productOfTwoMatrices(gradient_of_weights_ih_m.data, input_m_t.data);
		
		
		//Adjust the weights_ih matrix accordingly
		weights_ih = Matrix.addTwoMatrices(weights_ih.data, gradient_of_weights_ih_m.data);
	}
	
	Matrix feedForward(Matrix input_m, Matrix weights_m, Matrix bias_m) {
		Matrix output_m = Matrix.productOfTwoMatrices(weights_m.data, input_m.data);
		output_m = Matrix.addTwoMatrices(output_m.data, bias_m.data);
		//output_m = Matrix.map(output_m, x -> Matrix.sigmoid(x));
		output_m = Matrix.fromArray(Matrix.softmax(Matrix.toArray(output_m)));
		return output_m;
	}
	
	void displayOutput(float[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
