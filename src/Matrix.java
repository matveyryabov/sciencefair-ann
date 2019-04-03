import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Matrix {
	double[][] data;
	  static double value;
	  
	  Matrix(int rows, int cols) {
	    data = new double[rows][cols];
	    
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        data[i][j] = 1;  
	      }
	      
	      
	    }
	  }
	  
	  static void randomize(double[][] m_data, double min, double max) {
	    Random rand = new Random();
	    for (int i = 0; i < m_data.length; i++) {
	      for (int j = 0; j < m_data[0].length; j++) {
	        m_data[i][j] = min + rand.nextFloat() * (max - min); 
	        //m_data[i][j] = rand.nextInt((int) (max)) + min;
	      }
	    }
	  }
	  
	  //Multiply a matrix by a scalar - scale the matrix
	  static void scaleMatrix(double[][] m_data, double n) {
	    for (int i = 0; i < m_data.length; i++) {
	      for (int j = 0; j < m_data[0].length; j++) {
	        m_data[i][j] *= n;  
	      }
	    }
	  }
	  
	  
	  static Matrix map(Matrix m, Func map) {
		    for (int i = 0; i < m.data.length; i++) {
		      for (int j = 0; j < m.data[0].length; j++) {
		    	  double val = m.data[i][j];
		    	  m.data[i][j] = map.apply(val);  
		      }
		    }
		    return m;
	  }
		  
	  static Matrix fromArray(double[] arr) {
		  Matrix m = new Matrix(arr.length, 1);
		  for (int i = 0; i < arr.length; i++) {
			  m.data[i][0] = arr[i];
		  }
		  return m;
	  }
	  
	  static double[] toArray(Matrix m) {
		  double[] arr = new double[m.data.length];
		  for(int i = 0; i < m.data.length; i++) {
			arr[i] = m.data[i][0];  
		  }
		  return arr;
	  }
	  
	  static double sigmoid(double x) {
			x = (1/( 1 + Math.pow(Math.E,(-1*x))));
			return x;
	  }
	  
	  static double dsigmoid(double y) {  
		  return y * (1 - y);
	  }
	  
	  static double[] softmax(double[] v) {
		  for(int i = 0; i < v.length; i++) {
			  v[i] = Math.exp(v[i]);
		  }
		  
		  for(int i = 0; i < v.length; i++) {
			  v[i] = v[i] / sumArray(v);
		  }
		  
		  return v;
	  }
	  
	  static double dsoftmax(double v_j) {
		return v_j * (1- v_j);
	  }
	  
	  static double sumArray(double[] arr) {
		  double sum = 0;
		  for(int i = 0; i < arr.length; i++) {
			sum += arr[i];  
		  }
		  return sum;
	  }
	  
	  
	  
//	
//	  Learn about lambda expressions 
//	  https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
//	  http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
//	  
	  static Matrix productOfTwoMatrices(double[][] m1_data, double[][] m2_data) {
	    Matrix resulting_matrix = new Matrix(m1_data.length,m2_data[0].length);
	    if (m1_data[0].length != m2_data.length) {
	      System.out.println("ERROR - # of columns of matrix A must equal the # of rows of matrix B");  
	    } else {
	      for (int i = 0; i < resulting_matrix.data.length; i++) {
	        for (int j = 0; j < resulting_matrix.data[0].length; j++) {
	          //Dot product of values in col
	          double sum = 0;
	          for (int k = 0; k < m1_data[0].length; k++) {
	            sum += m1_data[i][k] * m2_data[k][j];
	          }
	          resulting_matrix.data[i][j] = sum;
	        }
	      }
	    }
	    return resulting_matrix;
	  }
	  
	  private static void println(String string) {
		// TODO Auto-generated method stub
		
	}

	//Hadamard Product - Schur Product - Entrywise Product - multiply matrix by matrix
	  static Matrix hadamardProduct(Matrix m1, Matrix m2) {
	    Matrix resulting_matrix = new Matrix(m1.data.length, m2.data[0].length);
	    for (int i = 0; i < m1.data.length; i++) {
	      for (int j = 0; j < m1.data[0].length; j++) {
	        resulting_matrix.data[i][j] = m1.data[i][j];
	        resulting_matrix.data[i][j] *= m2.data[i][j];  
	      }
	    }
	    return resulting_matrix;
	  }
	  
	  static Matrix transposeMatrix(double[][] m_data) {
	    Matrix resulting_matrix = new Matrix(m_data[0].length, m_data.length);
	     for (int i = 0; i < m_data.length; i++) {
	      for (int j = 0; j < m_data[0].length; j++) {
	        resulting_matrix.data[j][i] = m_data[i][j];  
	      }
	    }
	    return resulting_matrix;
	  }
	  
	  static void displayAsTable(double[][] m_data) {
	    System.out.println(Arrays.deepToString(m_data).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	  }
	  
	  //Function overload - add a scalar - might not be mathimatically correct
	  static void addToMatrix(double n, double[][] m_data) {
	    for (int i = 0; i < m_data.length; i++) {
	      for (int j = 0; j < m_data[0].length; j++) {
	        m_data[i][j] += n;  
	      }
	    }
	  }
	  
	  //Add to matrix - elementwise (Entrywise Sum)
	  static Matrix addTwoMatrices(double[][] m1_data, double[][] m2_data) {
	  Matrix resulting_matrix = new Matrix(m1_data.length, m2_data[0].length);
	  for (int i = 0; i < m1_data.length; i++) {
	      for (int j = 0; j < m1_data[0].length; j++) {
	        resulting_matrix.data[i][j] = m1_data[i][j] + m2_data[i][j];  
	      }
	    }
	    return resulting_matrix;
	  }
	  
	  //element wise subtraction
	  static Matrix findDiffrence(Matrix m1,  Matrix m2) {
		  //
		  //ADD IN ERROR CHECKING IN ALL MATRIX METHODS
		  //
		  
		  Matrix diffrence_m = new Matrix(m1.data.length, m2.data[0].length);
		  for (int i = 0; i < m1.data.length; i++) {
			  for(int j = 0; j < m1.data[0].length; j++) {
				  diffrence_m.data[i][j] = m1.data[i][j] - m2.data[i][j];
			  }
		  }
		  return diffrence_m;
	  }
}
