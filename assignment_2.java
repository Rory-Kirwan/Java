import java.util.Scanner;

public class assignment_2 {
    //Program 1
   public static void coffeeBags(){
        Scanner Input = new Scanner(System.in);
        System.out.println("Input weight of bags in lbs : ");
        String unitWeight = Input.nextLine();
        Float unitWeightF = Float.parseFloat(unitWeight);
        System.out.println("Please input the amount of bags sold : ");
        String numSold = Input.nextLine();
        Float numSoldF = Float.parseFloat(numSold);

        //calculate the total price
        Double TotalPrice = unitWeightF * numSoldF * 5.99;
        Double totalPriceWTax = TotalPrice + (TotalPrice * 0.0725);
        
        //print the result
        System.out.println("Number of bags sold : " + numSold);
        System.out.println("Weight per bag : " + unitWeight);
        System.out.println("Price per pound : $5.99");
        System.out.println("Sales Tax : 7.25%");
        System.out.println("Total Price : " + totalPriceWTax);    
        Input.close();
    }    

    //program 2
    static void perfectNumber(){
        //take user input
        Scanner Input = new Scanner(System.in);
        System.out.println("Please input a number between 20 and 30");
        String answer = Input.nextLine();
        int num = Integer.parseInt(answer);
        Input.close();

        //create an empty array for the list of perfect divisors
        int[] perf_div;
        perf_div = new int[10];
        int n = 0;
        //for loop to test if perfect divisors are present
        for (int i = 1 ; i < num - 1 ; i++){
            //check if the divisor is a perfect divisor and add them ot the array
            if (num % i == 0) {
                perf_div[n] = i;
                n++;
            }
        }
        int a = 0;
        System.out.print("The perfect divisors are: ");
        //iterate through the list of perfect divisors and print them all out
        for (int i = 0; i < perf_div.length; i++){
            a = a + perf_div[i];
            if (perf_div[i] != 0 ){
                System.out.println(perf_div[i]);
            }
        }
        //print out a true or false depending on the result
        String result = (num == a) ? "The number " + answer + " is a perfect number" : "The number " + answer + " is not a perfect number";
        System.out.println(result);
    };

    //program 3
    public static void classGrades(String[][] grades){
        //define some misc variables
        String grade = "D";
        int numOfStudents = 0;
        int avg_gradeSTU = 0;
        for (int i = 0 ; i < grades.length ; i++){
            numOfStudents ++;
            // print name of student
            System.out.println(grades[i][0]);
            //iterate through the smaller list in order to get the grade numbers
            for (int g = 1 ; g < grades[i].length ; g++){
                //convert the string grade into an int
                int integer_grade = Integer.parseInt(grades[i][g]);
                //if else to find the grade
                if (integer_grade > 80){
                    grade = "A";
                } else if (integer_grade > 60){
                    grade = "B";
                }else if(integer_grade > 40){
                    grade = "C";
                } else{
                    grade = "D";
                }
                //add the number result to the average for this student
                avg_gradeSTU += integer_grade;
                //print the letter grade result 
                System.out.println("Grade for this subject is :" + grade);
            };
        };
        //once both loops are finished calculate the average of the class and print it
        avg_gradeSTU = avg_gradeSTU / (grades.length * (grades[0].length - 1));
        System.out.println("The average grade for this class is : " + avg_gradeSTU);
    };

    //Program 5
    public static void printPyramid(int num){
        for (int n = 0 ; n <= num ; n++){
            String message = "*".repeat(n);
            System.out.println(message);
        };
    };

    //Program 6
    public static void printPyramidRev(int num){
        for (int n = 0; n <= num; n++){
            String message = "*".repeat(n);
            String Added_spaces = "";
            //for loop to add spaces before to space them out
            for (int i =0; i <= num - message.length(); i ++){
                Added_spaces = " ".repeat(i);
            };
            //print the final pyramid out
            System.out.println( Added_spaces+message);
        };
    };

    //Program 7
    public static void printDiamond(int num){
        //find out if the inputted number is odd or even
        int odd_or_even = (num % 2 == 0) ? 0 : 1;
        //first for loop to make the first half of the pyramid
        for (int n = odd_or_even; n <= num; n += 2){
            String Added_Spaces = "";
            String message = "*".repeat(n);
            int formula = (num - message.length()) / 2;
            //add the spaces in beforehand
            for (int i = 0; i <= formula; i++){
                Added_Spaces = " ".repeat(i);
            }
            //print out the first half of the pyramid 
            System.out.println(Added_Spaces + message);
        };
        // loop to make the second half of the pyramid
        for (int a = num - 2; a >= 1; a -= 2){
            String Added_Spaces = "";
            String message = "*".repeat(a);
            //the loop for adding spaces before
            int formula = (num - message.length()) / 2;
            for (int i = 0; i <= formula; i++){
                Added_Spaces = " ".repeat(i);
            }
            //print out the bottom half of the pyramid
            System.out.println(Added_Spaces + message);
        };
    };
    
    public static void main(String[] args){
        // CODE TO TEST ALL PROGRAMS IN THE ASSIGNMENT
        // coffeeBags();
        // perfectNumber();
        // classGrades(new String[][] {{"John", "20", "30", "10"}, {"Mary", "90", "80", "70"}, {"Mark", "50", "40", "30"}});
        // printPyramid(5);
        // printPyramidRev(5);
        // printDiamond(5);
    };
};