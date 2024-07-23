import java.awt.Point;
import java.time.LocalDate;
import java.util.ArrayList;

public class assignment_6 {
    //Program 1
    public class polyline{
        //establish the array list of points
        ArrayList<Integer> array_of_points = new ArrayList<Integer>();
    }

    //make the point class with an x and a y attribute and a method to assign x and y co-ordinates to the point
    public class point{
        private int x = 0;
        private int y = 0;
        public point(int x, int y){

        };
        //return x and y functions 
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        //set x and y functions
        public void setX(int X){
            x = X;
        }
        public void setY(int Y){
            y = Y;
        }
        //return an array containing x and y
        public int[] getXY(){
            int[] a = {x, y};
            return a;
        }
        //set both values
        public void setXY(int x, int y){
            setX(x);
            setY(y);
        }
        //present it as a string
        public String returnString(){
            String a = String.valueOf(x);
            String b = String.valueOf(y);
            return '{' + a + ',' + b + '}';
        }
        //a method for returning the distance between two points
        public double distance(Point another){
            double answer = (another.x - x)^2 + (another.y - y)^2;
            answer = Math.sqrt(answer);
            return answer; 
        }
    }

    //Program 2
    //customer class
    static class Customer{
        //set the variables of this class
        String name = "";
        Boolean member = false;
        String membership = "None";
        
        //method to set every parameter within the class
        public void set_customer(String name, Boolean member, String membership){
            this.name = name;
            this.member = member;
            this.membership = membership;
        }
        //return the name of the customer
        public String get_name(){
            return this.name;
        }

        //return a boolean for wether or not the customer is a member
        public Boolean is_member(){
            return this.member;
        }

        //swap the customers membership
        public void swap_member(){
            this.member = !this.member;
        }

        //return the type of membership that this customer has
        public String membership_type(){
            return this.membership;
        }

        //a method for setting the membership
        public void set_membership(String membership){
            this.membership = membership;
        }
    }

    //visit class
    static class visit {
        //set the class variables
        Discount_rates Discount_rates = new Discount_rates();
        LocalDate date = LocalDate.now();
        Customer customer = new Customer();
        Double Service_expense = 0.0;
        Double product_expense = 0.0;

        //method to set customer for the visit
        public void customer_for_visit(String name, Boolean member, String membership){
            this.customer.set_customer(name, member, membership);
        }

        //return the name of the customer associated with this visit
        public String get_name(){
            return customer.get_name();
        }

        //a method to return the service expense
        public double get_serviceExpense(){
            return this.Service_expense;
        }

        //a method to return the product expense
        public double get_productExpense(){
            return this.product_expense;
        }

        //a method to set the service expense
        public void set_serviceExpence(Double num){
            this.Service_expense = num;
        }

        //a method to add to the service expense or take away if the input is a negative
        public void add_serviceExpense(Double num){
            this.Service_expense = this.Service_expense + num;
        }

        //a method to set the product expense
        public void set_productExpense(Double num){
            this.product_expense = num;
        }

        //a method for adding to the product expense or subtracting if the input is negative
        public void add_productExpense(Double num){
            this.product_expense = this.product_expense + num;
        }

        //a method for getting the total cost of the visit
        public Double get_totalCost(){
            Double withoutDiscount = this.Service_expense + this.product_expense;
            if (this.customer.member == true){
                switch(this.customer.membership){
                    case "Premium":
                        return (this.Service_expense - (this.Service_expense * this.Discount_rates.service_discountPremium)) + (this.product_expense - (this.product_expense * this.Discount_rates.product_discountPremium));
                    case "Gold":
                        return (this.Service_expense - (this.Service_expense * this.Discount_rates.service_discountPremium)) + (this.product_expense - (this.product_expense * this.Discount_rates.product_discountPremium));
                    case "Silver":
                        return (this.Service_expense - (this.Service_expense * this.Discount_rates.service_discountPremium)) + (this.product_expense - (this.product_expense * this.Discount_rates.product_discountPremium));
                    default:
                        return withoutDiscount;
                }
            }
            return withoutDiscount;
        }
    }

    //the discount rate class
    static class Discount_rates{
        Double service_discountPremium = 0.2;
        Double service_discountGold = 0.15;
        Double service_discountSilver = 0.1;
        Double product_discountPremium = 0.1;
        Double product_discountGold = 0.1;
        Double product_discountSilver = 0.1;
    }

    //program 3
    static class Circle {
        Double radius = 1.0;
        String colour = "red";

        //a method to get the radius double value of the circle
        public Double get_radius(){
            return this.radius;
        }

        //a method to get the color of the circle
        public String get_colour(){
            return this.colour;
        }

        //a method to set the radius of the circle
        public void set_radius(Double num){
            this.radius = num;
        }

        //a method to set the colour of the circle
        public void set_colour(String colour){
            this.colour = colour;
        }

        //a method for getting the area of this circle
        public Double get_area(){
            double area = (Math.sqrt(this.radius)) * Math.PI;
            return area;
        }
    }

    class Cylinder extends Circle {
        Double height = 1.0;

        //a method for setting the height of the cylinder
        public void set_height(Double height){
            this.height = height;
        }

        //a method for getting the height of the cylinder
        public Double get_height(){
            return this.height;
        }

        //a method for getting the surface area of the cylinder
        public Double get_area(){
            Double area = 2*(Math.PI * this.height * this.radius) + 2*(Math.sqrt(this.radius) * Math.PI);
            return area;
        }

    //Program 4
    /* interface for final part of program 4 */
    interface GeometricObject {
        public Double getParameter();
        public Double getArea();
    }

    static class shape {
        String colour = "";
        Boolean filled = false;

        //constructor method for filling without args
        public shape(){
            this.colour = "Green";
            this.filled = true;
        }

        //constructor method for filling with args
        public shape(String colour, Boolean filled){
            this.colour = colour;
            this.filled = filled;
        }

        //getter and setter for the colour attribute
        public String get_colour(){
            return this.colour;
        }

        public void set_colour(String colour){
            this.colour = colour;
        }

        //getter and setter for the filled attribute
        public Boolean filled(){
            return this.filled;
        }

        public void set_filled(Boolean input){
            this.filled = input;
        }

        //a to string method returns "a shape with <colour> and <filled / not filled>"
        public String toString(){
            String x = (this.filled == true) ? "filled" : "not filled" ;
            String a = "A shape with colour of" + this.colour +  "and" + x;
            return a;
        }}

    static class circle extends shape implements GeometricObject{
        //set instance variables
        Double radius = 1.0;

        /* Constructor classes */
        public circle(){
            this.radius = 5.0;
        }

        public circle(Double radius){
            this.radius = radius;
        }

        public circle(Double radius, String colour, Boolean filled){
            this.radius = radius;
            this.colour = colour;
            this.filled = filled;
        }

        //set and get methods for the radius
        public Double get_radius(){
            return this.radius;
        }

        public void set_raidus(Double num){
            this.radius = num;
        }

        //get area method for the circle
        public Double getArea(){
            return Math.PI * Math.sqrt(this.radius);
        }

        //get the permitter of the current circle
        public Double get_permitter(){
            return 2 * (Math.PI * this.radius);
        }

        public String to_string(){
            String b = (this.filled == true) ? "filled" : "not filled";
            String a = "A circle with radius," + this.radius + "a colour of, " + this.colour + "and it is " + b + "in.";
            return a;
        }

        public Double getParameter(){
            return this.radius;
        }}
        
        static class rectangle extends shape{
            //define the instance variables
            Double width = 1.0;
            Double length = 2.0;

            /*define the constructor methods for the rectangle class */
            public rectangle(){
                this.width = 1.0;
                this.length = 2.0;
            }

            public rectangle(Double width, Double length){
                this.width = width;
                this.length = length;
            }

            public rectangle(Double width, Double length, String colour, Boolean filled){
                this.width = width;
                this.length = length;
                this.colour = colour;
                this.filled = filled;
            }

            //get and set methods for the width attribute
            public Double get_width(){
                return this.width;
            }

            public void set_width(Double width){
                this.width = width;
            }

            //get and set methods for the length attribute
            public Double get_length(){
                return this.length;
            } 

            public void set_length(Double length){
                this.length = length;
            }

            //return the area of the rectangle
            public Double get_area(){
                return this.width * this.length;
            }

            //return the perimeter of the rectangle
            public Double get_perimiter(){
                return 2*(this.width + this.length);
            }

            //return a string representation of the object
            public String to_string(){
                String b = (this.filled == true) ? "filled" : "not filled";
                String a  = "This is a rectangle that is, " + this.width + "wide and " + this.length + "long. It is " + this.colour + "and is " + b + "in.";
                return a; 
            }}
        class square extends rectangle{
    	    /* constructor methods for the class */
           public square(){
                this.width = 1.0;
                this.length = this.width;
           } 

           public square(Double num){
                this.width = num;
                this.length = num;
           }

           public square(Double num, String colour, Boolean filled){
                this.width = num;
                this.length = num;
                this.colour = colour;
                this.filled = filled;
           }

           //get and set methods for the side attribute
           public Double get_side(){
                return this.width;
           }

           public void set_side(Double input){
                this.width = input;
                this.length = input;
           }

           public String to_string(){
                String b = (this.filled == true) ? "filled" : "not filled";
                String a = "This square has a side length of, " + this.width + "and is coloured " + this.colour + "and is " + b + "in.";
                return a;
           }}
    }

    public static void main(String[] args) {
    /* Testing for program 2 */
    // visit test_program_2 = new visit();
    // //create the customer for the visit
    // test_program_2.customer_for_visit("Rory Kirwan", false, "None");
    // //the customer signs up for a membership
    // test_program_2.customer.swap_member();
    // //apply a certain membership to the customer
    // test_program_2.customer.set_membership("Premium");
    // //set a cost for the service and product
    // test_program_2.set_serviceExpence(1200.00);
    // test_program_2.set_productExpense(70.00);
    // //adjust that cost
    // test_program_2.add_serviceExpense(100.00);
    // test_program_2.add_productExpense(-50.00);
    // //print a total cost including the premium discount
    // System.out.println(test_program_2.get_totalCost());
    // //remove the membership from the customer
    // test_program_2.customer.swap_member();
    // //print the same total cost again without any discount
    // System.out.println(test_program_2.get_totalCost());

    /* Testing for program 4 - shape only */ 
    // //create an instance of the shape class for the test. - NOT WORKING "chape cannot be resolved into a type"
    // shape test_program_4 = new shape();
    // //print the colour and shape of the newly created instance
    // System.out.println(test_program_4.toString());
    // //set the attributes to be different
    // test_program_4.set_colour("Purple");
    // test_program_4.set_filled(false);
    // //print the new values of the attributes
    // System.out.println(test_program_4.toString());
}}