import java.nio.file.FileAlreadyExistsException;
import java.util.Random;
import java.util.Scanner;

public class Assignment_3 {
    //Program 1
    public static void odd_or_even(){
        Scanner Input = new Scanner(System.in);
        int EvenNum = 0;
        int OddNum = 0;
        System.out.println("Please input 10 numbers");
        for (int i = 0 ; i <10 ; i ++){
            String a = Input.nextLine();
            if ((Integer.parseInt(a) % 2) == 0){
                EvenNum = EvenNum + 1;
           } else {
                OddNum = OddNum + 1;
           }
        }
        System.out.println("The amount of even numbers is : " + EvenNum);
        System.out.println("The amount of odd numbers are : " + OddNum);
        Input.close();
    }

    //Program 2
    public static void StandardDeviation(){
        Scanner Input = new Scanner(System.in);

        //Get the number of real numbers from the user
        System.out.println("Please input the number of real numbers : ");
        int N = Input.nextInt();

        //define and populate the array
        double[] array = new double[N];
        for (int i = 0 ; i < N ; i ++){
            System.out.println("Please input a real number : ");
            double digit = Input.nextDouble();
            array[i] = digit;
        }
        Input.close();

        //calculate the mean
        double sum = 0;
        for (double num : array){
            sum += num;
        };
        double mean = sum / N;

        //calculate the middle piece
        double variance = 0;
        for (double num : array){
            variance += Math.pow(num - mean, 2);
        };
        variance /= N;

        //calculate standard deviation and display it
        double StandardDeviation = Math.sqrt(variance);
        System.out.println("Standard Deviation is : " + StandardDeviation);
    }

    //program 3
    public static void alphabeticSort(){
        //Open scanner for input
        Scanner Input = new Scanner(System.in);
        String[] names = new String[10];
       
        //Take user input for the names
        System.out.println("Please input ten names : ");
        for (int i = 0 ; i <= 9 ; i++){
            String name = Input.nextLine();
            names[i] = name;
        };
        Input.close();

        int counter = 0;
        //While the array is not sorted shuffle it
        while (checkSorted(names) != true){
            names = shuffleArray(names);
            counter ++;
        }

        //print the sorted array
        System.out.println();
        System.out.println("Printed alphabetically :");
        for (String name : names){
            System.out.println(name);
        }
        System.out.println(counter);
    };

    //the function to sort the array
    static boolean checkSorted(String[] array){
        boolean result = true;
        for (int i = 0 ; i < (array.length - 1) ;  i ++){
            //compare the first letters of i and i + 1 to see if they're sorted
            char first = array[i].charAt(0);
            char second = array[i + 1].charAt(0);
            //if they aren't sorted return false
            if (first > second){  
                    result = false;   
                    return result;
                }
            }
        //if it went through the list and all is sorted return true
        return result;
    }

    //the fucntion to shuffle the array
    static String[] shuffleArray(String[] array) {
        String[] shuffledArray = array.clone(); // Copy the original array
        Random rnd = new Random();
        for (int i = shuffledArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Swap shuffledArray[i] with the element at random index
            String temp = shuffledArray[index];
            shuffledArray[index] = shuffledArray[i];
            shuffledArray[i] = temp;
        }
        //return the shuffles array
        return shuffledArray;
    }

    //Program 4
    static void adding_matrices(int num){
        //Call the support function to create a 2D matrix based off of the inputted number
            int [][] Matrix_1 = create_2D_matrix("Please input the numbers for the first matrix :", num);
            int[][] Matrix_2 = create_2D_matrix("Please input the numbers for the second Matrix :", num);
            int[][] return_Matrix = new int[num][num];

            //for loop to iterate through the matrix's and to add them together
            for(int i = 0; i < Matrix_1.length; i++){
                for (int n = 0; n < Matrix_1.length; n ++){
                    return_Matrix[i][n] = Matrix_1[i][n] + Matrix_2[i][n];
                }
            }

            //print all three matrix's
            print_Matrix(Matrix_1);
            print_Matrix(Matrix_2);
            print_Matrix(return_Matrix);
        }

        //a support function that creates a square 2D matrix based off an inputted number
        //and uses user input in order to make the matrix also takes in an string to prompt the user.
        static int[][] create_2D_matrix(String User_str, int num){
            //set up the returned matrix variable
            int[][] Matrix = new int[num][num];
            //set up the scanner for user input
            Scanner Input = new Scanner(System.in);
            //print the inputted string 
            System.out.println(User_str);
            //assign the inputted numbers into the matrix
            for (int i = 0; i < num; i++){
                for (int n = 0; n < num; n++){
                    Matrix[i][n] = Input.nextInt();
                }
            }
            Input.close();
            //return the full matrix
            return Matrix;
        }

        //Support function to print every element in the matrix
        static void print_Matrix(int[][] input){
            //loop through the matrix and print each element
            for (int i = 0; i < input.length; i++){
                for (int n = 0; n < input[0].length; n++){
                    System.out.print(input[i][n] + " ");
                }
            //move down to the next line
            System.out.println();
            }
        //move down to the next line
        System.out.println();
        }

        //program 5
        static void display_transpose(int input){
            int[][] num = create_2D_matrix("please input the numbers for the matrix :", input);
            print_Matrix(num);
            for (int i = 0; i < num.length; i++){
                for (int n = 0; n <num[0].length; n++){
                    System.out.print(num[n][i] + " ");
                }
                System.out.println();
            }
        }

        //Program 6
        static void check_if_present(int num){
            //define the array
            int [][][] array = new int[num][num][num];

            //get the input to check the array
            Scanner Input = new Scanner(System.in);
            System.out.println("Please input the number you wish to search for the presence of ");
            //get the desired number from the user
            int desired_num = Input.nextInt();

            //get the integers for the array
            System.out.println("Please input the numbers for the array:");
            for (int i = 0; i < array.length; i++ ){
                for (int n = 0; n<array[0].length; n++){
                    for (int j = 0; j<array[0][0].length; j++){
                        array[i][n][j] = Input.nextInt();
                    }
                }
            }
            //close the scanner
            Input.close();

            //loop through the array and compare the values
            int return_variable = 0;
            for (int i = 0; i < array.length; i++ ){
                for (int n = 0; n<array[0].length; n++){
                    for (int j = 0; j<array[0][0].length; j++){
                        //if the desired number is present update the return variable.
                        return_variable = (desired_num == array[i][n][j]) ? return_variable += 1 : return_variable + 0;
                    }
                }
            }

            //check the return variable to see if the desired number is present and print an appropriate response
            if (return_variable != 0){
            System.out.printf("The inputted number %d appears %d times.", desired_num , return_variable);
            } else {
                System.out.printf("The inputted number %d does not appear in the matrix.", desired_num);
            }
        }
    
    
    
    
    
    public static void main(String[] args) {
        // odd_or_even();
        // StandardDeviation();
        // alphabeticSort();
        // adding_matrices(3);
        // display_transpose(3);
        // check_if_present(3);
    }
}
