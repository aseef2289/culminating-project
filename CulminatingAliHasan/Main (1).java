/*
* File Name: Main.java
* Author: Aseef Ali Hasan
* Date: August 23, 2021
* Description:
* This program allows the user to calculate what marks they
* need on their final activies to reach their desired marks.
* These final activites include a culminating and exam.
* It features various senarious a student might be in 
* where some parts may be completed.
* It takes user input and checks if it meets the requirements.
* All calculations are performed in seperate methods.
* Methods recieve parameters and return values to main method.
* All information is displayed through JOptionPane GUI.
*/

//Imports JOptionPane for GUI
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        //Stores the total courses the user is taking
        int totalCourses = 0;
        //Array to store all the user's desired marks
        double [] studentMarks = new double [totalCourses];
        //Constant array to store all the options for types of finals
        final String[] FINAL_OPTIONS = {"Exam", "Culminating AND Exam", 
            "Already completed either culminating OR exam"};
        //Constant array to store options to use the program again
        final String[] CONTINUE_CHOICES = {"Yes", "No"};
        //Stores what type of final the user chose
        String finalChoice;
        //Stores string for looping the program
        String continueChoice = "Yes";
        
        //While the user keeps agreeing to use the program again
        //The program will continue to loop
        while (continueChoice.equals("Yes"))
        {
            //Asks user what final type they have 
            //Stores returned string of what final type the user chose
            finalChoice = finalOptions(FINAL_OPTIONS);
            totalCourses = numCourses();
            //Actions if user has an exam
            if (finalChoice.equals("Exam"))
            {
                //Calculates mark needed to reach desired mark
                //for all of the user's courses
                //Stores the desired mark for each course in an array
                studentMarks = finalExamMarks(totalCourses);
                //Calculates total average using the array of desired marks
                //To show the user what their mark could be
                totalAverage(studentMarks, totalCourses);
                //Asks user if they want to continue
                //Stores answer in a string 
                continueChoice = ifContinue(CONTINUE_CHOICES);
            }
            //Actions if the user has a culminating and exam
            else if (finalChoice.equals("Culminating AND Exam"))
            {
                /*
                *Calculates the average needed between their exam and 
                *culminating that is needed to reach desired mark
                *for all of the user's courses
                *Stores the desired mark for each course in an array
                */
                studentMarks = finalExamCulminatingMarks(totalCourses);
                //Calculates total average using the array of desired marks
                //To show the user what their mark could be
                totalAverage(studentMarks, totalCourses);
                //Asks user if they want to continue
                //Stores answer in a string 
                continueChoice = ifContinue(CONTINUE_CHOICES);
            }
            //Actions if the user has a culminating and exam 
            //but has completed on of the two
            else
            {
                /*
                *Calculates the mark needed on the culminating 
                *or exam (depending on user choice) to reach the user's
                *desired mark for all of the user's courses
                *Stores the desired mark for each course in an array
                */
                studentMarks = oneCompletedMarks(totalCourses);
                //Calculates total average using the array of desired marks
                //To show the user what their mark could be
                totalAverage(studentMarks, totalCourses);
                //Asks user if they want to continue
                //Stores answer in a string 
                continueChoice = ifContinue(CONTINUE_CHOICES);
            }     
        }
        //Shows goodbye message if user quits
        JOptionPane.showMessageDialog(null, "Goodbye");     
    }//End of main method
    
  /**
   * method name: finalOptions 
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 23 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method shows a user a drop down list of their 
   * options for types of finals
   * The user picks the option that applies to their situation
   * It uses a JOptionPane
   *
   * Parameters: final String [] FINAL_OPTIONS: stores all the 
   * types of finals a student can have 
   *
   * Return: String choice: stores the user's choice for 
   * what kind of final they have 
   */
    public static String finalOptions(final String [] FINAL_OPTIONS)
    {
        //Drop down list giving choices 
        String choice = (String) javax.swing.JOptionPane.showInputDialog(
                null, //Component parentComponent
                "What do your finals look like? ", //String title
                "Choose an option",//information
                javax.swing.JOptionPane.PLAIN_MESSAGE, //int optionType
                null, //Icon icon,
                FINAL_OPTIONS, //Object[] options,
                FINAL_OPTIONS[0] //Object initialValue 
        );
        //Returns a string to store the user's choice for 
        //what kind of final they have to main method 
        return (choice);
    }//End of finalOptions method 

  /**
   * method name: numCourses 
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 23 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method asks the user for how many courses they have
   * This information is used to repeat the program for all courses
   * It uses try and catch to avoid NumberFormatExceptions
   * It accounts for invalid inputs like negatives
   * It uses a JOptionPane
   *
   * Parameters: none
   *
   * Return: int numCourses: returns number of courses
   * the user has 
   */
    public static int numCourses()
    {
        //Stores the number of courses the user has
        int numCourses;
        //Counter to add to for every invalid input
        int counter = 0;
        //Stores the string value of the user's input 
        String userInput;
        
        //Loop continues while true
        while (true)
        {
          //Trys to get user's input
          try
          {
              //While loop continues as long as there are 
              //less than 3 invalid inputs
              while(counter < 3)
              {
                //Asks the user for how many courses they have
                //Stores the string value of the input
                userInput = JOptionPane.showInputDialog(null, "How many course "
                        + "are you taking?");
                //Converts and stores input as an integer
                numCourses = Integer.parseInt(userInput);
                //Actions if input was valid
                if (numCourses >= 1)
                {
                  //Number of courses is returned to main method 
                  return(numCourses);
                }
                //Actions if input was invalid 
                else
                {
                  //Tells user what type of input they should use
                  JOptionPane.showMessageDialog(null, "Please enter a positive "
                          + "whole number");
                  //Adds to the counter
                  counter++;
                } 
              }
            //Actions if the counter has reached its limit
            if (counter == 3)
                {
                  //Tells user they had 3 invalid inputs 
                  JOptionPane.showMessageDialog(null,"That was 3 invalid inputs."
                          + " Try again next time.");
                  //Exits the program
                  System.exit(0);
                }
            else
                {
                  //Do nothing
                }      
          }
          //Catches any number format exceptions 
          catch(NumberFormatException e)
          {
              //Tells user what type of input they should use
              JOptionPane.showMessageDialog(null, "Please enter a positive "
                      + "whole number");
              //Adds to the counter 
              counter++;
          }
        }  
    }//End of numCourses method 
    
    /**
   * method name: finalExamMarks
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 23 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method finds what marks the user needs
   * to get on their exam to get their desired mark
   * It gets the user's current and desired marks
   * It gets the weight of the user's exam
   * It uses a JOptionPane
   *
   * Parameters: int size: stores how many times
   * the method will be looped for all the courses
   * the user is taking 
   *
   * Return: double [] finalExamMarks: an array storing all
   * of the user's desired marks to find the average of 
   * in a seperate method 
   */
    public static double [] finalExamMarks(int size)
    {
        //Array storing all the user's desired marks
        double userMarks []  = new double [size];
        //Stores user's current mark
        double currentMark;
        //Stores user's desired mark
        double desiredMark;
        //Stores the weight of the exam 
        double weight;
        //Stores the mark the user must get on their
        //exam to reach their desired marks
        double requiredMark;
        //boolean to check if inputs are valid is set to false
        boolean valid = false;
        //Counter to add to for every invalid input 
        int counter = 0;
        
        //Method loops while the user's inputs are invlaid
        //and they have made less than 3 invalid inputs 
        while (valid == false && counter < 3)
        { 
            //Trys to get user input 
            try
            { 
                /*
                * i starts at 0
                * will calculate the required mark each time 
                * until i is less than or equal to size
                * returns a desired mark to array
                */
                for (int i = 0; i < size; i++)
                {
                    //Asks user for current mark and stores it as double
                    currentMark = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What is your current mark?"));
                    //Asks user for desired mark and stores it as double
                    desiredMark = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What mark do you want to end with?"));
                    //Asks user for weight and stories it as double 
                    weight = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What is the weight percentage for your final?"));

                    //Actions if user has an invalid input
                    if (currentMark < 0|| desiredMark < 0|| weight < 0)
                    { 
                        //Tells the user what values they should input
                        JOptionPane.showMessageDialog(null, 
                                "Please enter a positive number");
                        //Adds to the counter of invlaid inputs 
                        counter++;
                    }
                    //Actions if the user has a valid input
                    else
                    { 
                        //Converts percentage into decimal
                        weight = weight / 100;

                        //Calculates required mark and rounds to 2 decimal places 
                        requiredMark = (desiredMark - ((1 - weight) * currentMark)) / weight;
                        requiredMark = requiredMark * 100;
                        requiredMark = Math.round(requiredMark);
                        requiredMark = requiredMark / 100;
                        //Actions if the required mark is not possible
                        if (requiredMark > 100 || requiredMark < 0)
                        {
                            //Tells the user their desired mark is not possible
                            //based on their required mark
                            JOptionPane.showMessageDialog(null, "You need to get " 
                                   + requiredMark + "% on your "
                                   + "final which is not possible."
                                   + "\nTry again with different numbers."); 
                            //Adds to the counter of invalid inputs 
                            counter++;
                        }
                        //Actions if the required mark is possible
                        else
                        { 
                            //Tells the user what mark they must get on their exam
                            //To get their desired mark
                            JOptionPane.showMessageDialog(null, "You need to get " 
                                + requiredMark + "% on your final to get " + desiredMark 
                                + "% as your final mark");   
                            //Adds desired mark to array
                            userMarks[i] = desiredMark;
                            //All info is valid so it will leave the while loop
                            valid = true;  
                        }  
                    }
                }
            }
            //Catches NumberFormatExceptions
            catch(NumberFormatException e)
            { 
                //Tells the user what kind of inputs they should use
                JOptionPane.showMessageDialog(null, "Please enter a positive"
                        + " number");
                //Adds to the counter for invalid inputs 
                counter++;
            }  
        }
        //Action if the user reaches 3 invalid inputs 
        if (counter == 3)
            {
              //Tells user they had 3 invalid inputs  
              JOptionPane.showMessageDialog(null,"That was 3 invalid inputs. "
                      + "Try again next time.");
              //Ends the program 
              System.exit(0);
            }
        else
            {
              //Do nothing
            } 
        
        //Returns array of desired marks to main method 
        return (userMarks);
    }//End of finalExamMarks method 
    
    /**
    * method name: finalExamCulminatingMarks
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 23 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * This method finds the average mark the user needs
    * to get on their exam and culminating to get their desired mark
    * It gets the user's current and desired marks
    * It gets the weight of the user's exam
    * It gets the weight of the user's culminating 
    * It uses a JOptionPane
    *
    * Parameters: int size: stores how many times
    * the method will be looped for all the courses
    * the user is taking 
    *
    * Return: double [] finalExamMarks: an array storing all
    * of the user's desired marks to find the average of 
    * in a seperate method 
    */
    public static double [] finalExamCulminatingMarks(int size)
    {
        //Array storing all the user's desired marks
        double userMarks []  = new double [size];
        //Stores user's current mark
        double currentMark;
        //Stores user's desired mark
        double desiredMark;
        //Stores the weight of the user's exam
        double weightExam;
        //Stores the weight of the user's culminating
        double weightCulminating;
        //Stores the weight of the user's final parts
        double weightTotal;
        //Stores the mark required for the user to 
        //reach their desired mark
        double requiredMark;
        //boolean to check if inputs are valid is set to false
        boolean valid = false;
        //Counter to add to for every invalid input 
        int counter = 0;
        
        //Method loops while the user's inputs are invlaid
        //and they have made less than 3 invalid inputs 
        while (valid == false && counter < 3)
        {
            //Try to get the user's input 
            try
            {
                /*
                * i starts at 0
                * will calculate the required mark each time 
                * until i is less size
                * returns a desired mark to array
                */
                for (int i = 0; i < size; i++) 
                {
                    //Gets user's current mark and stores as double
                    currentMark = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What is your current mark?"));
                    //Gets user's desired mark and stores as double
                    desiredMark = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What mark do you want to end with?"));
                    //Gets the weight of the user's exam and stores as double
                    weightExam = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What is the weight percentage of your exam?"));
                    //Gets the weight of the user's culminating and stores as double
                    weightCulminating = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "What is the weight percentage of your culminating?"));

                    //Actions if the user inputted invalid numbers
                    if (currentMark < 0 || desiredMark < 0 || weightExam < 0 || weightCulminating < 0) 
                    {
                        //Tells the user what values they should use
                        JOptionPane.showMessageDialog(null, "Please enter a "
                                + "positive number");
                        //Adds to the counter for invalid inputs 
                        counter++;
                    } 
                    //Actions if the user inputted valid numbers
                    else 
                    { 
                        //Calculates the weight of the user's final parts
                        weightTotal = weightExam + weightCulminating;
                        //Converts to decimal
                        weightTotal = weightTotal / 100;

                        //Calculates required mark and rounds to 2 decimal places
                        requiredMark = (desiredMark - ((1 - weightTotal) * currentMark)) / weightTotal;
                        requiredMark = requiredMark * 100;
                        requiredMark = Math.round(requiredMark);
                        requiredMark = requiredMark / 100;
                        //Actions if required mark is not possible 
                        if (requiredMark > 100 || requiredMark < 0)
                        { 
                            //Tells user their desired mark is not possible 
                            //based on their required mark
                            JOptionPane.showMessageDialog(null, "You need to get " 
                                   + requiredMark + "% on your "
                                   + "final which is not possible."
                                   + "\nTry again with different numbers.");
                            //Adds to the counter for invalid inputs  
                            counter++;
                        }
                        //Actions if required mark is possible
                        else
                        {
                            //Tells what average the user needs between their exam
                            //and culminating to reach their desired mark
                            JOptionPane.showMessageDialog(null, "You need an average of "
                                   + requiredMark + "% on your exam and culminating to get "
                                   + desiredMark + "% as your final mark");
                            //Adds desired mark to array 
                            userMarks[i] = desiredMark;  
                            //All info is valid so it will leave the while loop
                            valid = true;
                        }
                    }
                }
            }
            //Catches NumberFormatExceptions
            catch(NumberFormatException e)
            {
              //Tells the user what kind of values they should use
               JOptionPane.showMessageDialog(null, "Please enter a positive "
                       + "number");
                //Adds to the counter for invalid inputs 
               counter++; 
            }
        }
        //Actions if the counter for invalid inputs reaches 3 
        if (counter == 3)
            {
              //Tells user they had 3 invalid inputs 
              JOptionPane.showMessageDialog(null,"That was 3 invalid inputs. "
                      + "Try again next time.");
              //Ends the program 
              System.exit(0);
            }
        else
            {
              //Do nothing
            } 
        
        //Returns array of desired marks to main method 
        return (userMarks);
    }//End of finalExamCulminatingMarks method 
    
     /**
   * method name: oneCompletedMarks
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 23 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method finds what mark the user needs
   * on their remaining part of their final (exam or culminating)
   * to reach their desired mark
   * It gets the user's current and desired marks
   * It gets the weight of the user's exam
   * It gets the weight of the user's culminating
   * It gets the user's mark on their final part
   * It uses a JOptionPane
   *
   * Parameters: int size: stores how many times
   * the method will be looped for all the courses
   * the user is taking 
   *
   * Return: double [] finalExamMarks: an array storing all
   * of the user's desired marks to find the average of 
   * in a seperate method 
   */
    public static double [] oneCompletedMarks(int size)
    {
        //Constant array storing options for what final part 
        //the user has already completed
        final String [] WHICH_COMPLETED = {"Exam", "Culminating"};
        //Stores the user's desired marks for all coursesin an array
        double userMarks []  = new double [size];
        //Stores the user's current mark
        double currentMark;
        //Stores the user's desired mark
        double desiredMark;
        //Stores the user's exam mark
        double examMark;
        //Stores the user's culminating mark
        double culminatingMark;
        //Stores the weight of the user's exam
        double weightExam;
        //Stores the weight of the user's culminating 
        double weightCulminating;
        //Stores the weight of the user's term work
        double weightTotal;
        //Stores the user's required mark
        double requiredMark; 
        //boolean to check if inputs are valid is set to false
        boolean valid = false;
        //Counter for invalid inputs
        int counter = 0; 
        
        //Shows dropdown menu for user to chose what final part
        //they have already completed 
        String choice = (String) javax.swing.JOptionPane.showInputDialog(
                null, //Component parentComponent
                "What have you completed so far?", //String title
                "Choose an option",//information
                javax.swing.JOptionPane.PLAIN_MESSAGE, //int optionType
                null, //Icon icon,
                WHICH_COMPLETED, //Object[] options,
                WHICH_COMPLETED[0] //Object initialValue 
        );
        
        //Actions if the user has already completed their exam
        if (choice.equals("Exam"))
        {
            //Method loops while the user's inputs are invlaid
            //and they have made less than 3 invalid inputs 
            while (valid == false && counter < 3)
            {
                //Try's to get user input
                try
                {
                    /*
                    * i starts at 0
                    * will calculate the required mark each time 
                    * until i is less than size
                    * returns a desired mark to array
                    */
                    for (int i = 0; i < size; i++) 
                    {
                        //Asks user for current mark and stores as double
                        currentMark = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is your current mark?"));
                        //Asks user for desired mark and stores as double
                        desiredMark = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What mark do you want to end with?"));
                        //Asks user for the exam's weight and stores as double
                        weightExam = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is the weight percentage of your exam?"));
                        //Asks user for exam's mark and stores as double
                        examMark = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is your exam mark?"));
                        //Asks user for culminating's weight and stores as double
                        weightCulminating = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is the weight percentage of your culminating?"));
                        //Actions if the user inputs invalid numbers
                        if (currentMark < 0 || desiredMark < 0 || weightExam < 0 || 
                                weightCulminating < 0 || examMark < 0)
                        {
                            //Tells the user what kind of values they should use
                            JOptionPane.showMessageDialog(null, "Please enter "
                                    + "a positive number");
                            //Adds to the counter for invalid inputs
                            counter++;
                        }
                        //Actions if the user inputs valid numbers
                        else
                        {
                            //Calculates the term weight and converts to decimal
                            weightTotal = 100 - (weightExam + weightCulminating);
                            weightTotal = weightTotal / 100;
                            
                            //Converts exam and culminating weight to decimals
                            weightExam = weightExam / 100;
                            weightCulminating = weightCulminating / 100;

                            //Calculates the required mark to 2 decmial places
                            requiredMark = (((currentMark * weightTotal) 
                                    + (examMark * weightExam)) 
                                    - desiredMark) / (weightCulminating * -1);

                            requiredMark = requiredMark * 100;
                            requiredMark = Math.round(requiredMark);
                            requiredMark = requiredMark / 100;
                            //Actions if required mark is not possible
                            if (requiredMark > 100 || requiredMark < 0)
                            { 
                                //Tells the user their desired mark is not possible
                                //based on their required mark
                                JOptionPane.showMessageDialog(null, "You need to get " 
                                       + requiredMark + "% on your "
                                       + "final which is not possible."
                                       + "\nTry again with different numbers."); 
                                //Adds to the counter for invalid inputs 
                                counter++;
                            }
                            //Actions if the mark is possible
                            else
                            { 
                                //Tells the user what mark they need on their culminating
                                //to reach their desired mark
                                JOptionPane.showMessageDialog(null, "You need to get " 
                                    + requiredMark + "% on your culminating to reach " 
                                    + desiredMark + "% as your final mark");
                                //Adds desired mark to array
                                userMarks[i] = desiredMark;
                                //All info is valid so it will leave the loop 
                                valid = true;
                            }   
                        }
                    }
                }
                //Catches NumberFormatExceptions
                catch(NumberFormatException e)
                {
                    //Tells the user what kind of values they should input 
                    JOptionPane.showMessageDialog(null, "Please enter a "
                            + "positive number");
                    //Adds to the counter for invalid inputs 
                    counter++;
                } 
            }
            //Actions if user reaches 3 invalid inputs 
            if (counter == 3)
            {
              //Tells user they had 3 invalid inputs 
              JOptionPane.showMessageDialog(null,"That was 3 invalid inputs. "
                      + "Try again next time.");
              //Program ends
              System.exit(0);
            }
            else
            {
              //Do nothing
            } 
        }
        //Actions if the user finished their culminating 
        else
        {
            //Method loops while the user's inputs are invlaid
            //and they have made less than 3 invalid inputs 
            while (valid == false && counter < 3)
            {
                //Try to recive user input 
                try
                {
                    /*
                    * i starts at 0
                    * will calculate the required mark each time 
                    * until i is less size
                    * returns a desired mark to array
                    */
                    for (int i = 0; i < size; i++) 
                    {
                        //Ask for user's current mark and store as double
                        currentMark = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is your current mark?"));
                        //Ask for user's desired mark and store as double
                        desiredMark = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What mark do you want to end with?"));
                        //Ask for weight of user's exam and store as double
                        weightExam = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is the weight percentage of your exam?"));
                        //Ask for weight of user's culminating and store as double 
                        weightCulminating = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is the weight percentage of your culminating?"));
                        //Ask for user's culminating mark and store as double 
                        culminatingMark = Double.parseDouble(JOptionPane.showInputDialog
                        (null, "What is your culminating mark?"));
                        
                        //Actions if user's inputs were invalid 
                        if (currentMark < 0 || desiredMark < 0 || weightExam < 0 || 
                                weightCulminating < 0 || culminatingMark < 0)
                        {
                            //Tells user what kind of values they should use
                            JOptionPane.showMessageDialog(null, "Please enter a "
                                    + "positive number");
                            //Adds to the counter for invalid inputs 
                            counter++;
                        }
                        //Actions if the user inputs were valid 
                        else
                        {
                            //Calculates term work weight to 2 decmal places
                            weightTotal = 100 - (weightExam + weightCulminating);
                            weightTotal = weightTotal / 100;

                            //Converts exam weight to 2 decmal places
                            weightExam = weightExam / 100;
                            //Converts culminating weight to 2 decimal places 
                            weightCulminating = weightCulminating / 100;

                            //Calculates the user's required mark to 2 decimal places
                            requiredMark = (((currentMark * weightTotal) 
                                    + (culminatingMark * weightCulminating)) 
                                    - desiredMark) / (weightExam * -1);

                            requiredMark = requiredMark * 100;
                            requiredMark = Math.round(requiredMark);
                            requiredMark = requiredMark / 100;
                            //Action if user's required mark is not possible
                            if (requiredMark > 100 || requiredMark < 0)
                            {
                                //Tells the user their desired mark is not possible 
                                //based on their required mark
                                JOptionPane.showMessageDialog(null, "You need to get " 
                                       + requiredMark + "% on your "
                                       + "final which is not possible."
                                       + "\nTry again with different numbers."); 
                                //Adds to counter for invalid inputs
                                counter++;
                            }
                            //Actions if reqired mark is possible
                            else
                            {
                                //Tells user what mark they need on their exam to 
                                //reach their desired mark
                               JOptionPane.showMessageDialog(null, "You need to get " 
                                    + requiredMark + "% on your exam to reach " 
                                    + desiredMark + "% as your final mark");
                                //Stored desired mark in array
                                userMarks[i] = desiredMark;  
                                //All info is valid so we leave the loop
                                valid = true;
                            } 
                        }  
                    }
                }
                //Cathes NumberFormatExceptions 
                catch(NumberFormatException e)
                { 
                    //Tells user what kind of values they should use
                    JOptionPane.showMessageDialog(null, "Please enter a "
                            + "positive number");
                    //Adds to the counter for invalid inputs 
                    counter++;
                }
            }
            //Actions if the user has 3 invalid inputs 
            if (counter == 3)
            {
              //Tells user they have 3 invalid inputs
              JOptionPane.showMessageDialog(null,"That was 3 invalid inputs."
                      + " Try again next time.");
              //Program ends
              System.exit(0);
            }
            else
            {
              //Do nothing
            }     
        }
        //Returns array of desired marks to main method 
        return (userMarks);
    }//End of oneCompletedMarks method 
    
     /**
   * method name: totalAverage
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 23 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method find what the user's average can be
   * if they reach all the required marks that were
   * calculated in previous methods 
   * It uses a JOptionPane
   *
   * Parameters: int size: stores how many times
   * the method will be looped for all the courses
   * the user is taking 
   * double [] studentMarks: stores all the user's desired marks
   *
   * Return: none
   */
    public static void totalAverage(double [] studentMarks, int size)
    {
        //Stores average mark
        double avg = 0;
        //Stores total of all marks
        double total = 0;
        
        /*
        * i starts at 0
        * will add a desired mark from array
        * to the total each time
        * until i is less than size
        */
        for (int i = 0; i < size; i++)
        {
            total = total + studentMarks[i];
        }
        
        //Calculates average to 2 decimal places
        avg = total/size;
        avg = avg * 100;
        avg = Math.round(avg);
        avg = avg / 100;
        //Shows user their average if they reach all their required marks 
        JOptionPane.showMessageDialog(null, "Your total average could be " + avg 
                + "% if you get the required marks on your finals");
    }//End of totalAverage method 
    
    /**
    * method name: ifContinue
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 23 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * This method finds out if the user wants
    * to use the program again 
    * It uses a drop down menu
    * It uses a JOptionPane
    *
    * Parameters: final String [] CONTINUE_CHOICES:
    * stores yes or no choices to continue 
    *
    * Return: String choice: stores what choice the user made 
    */
    public static String ifContinue(final String [] CONTINUE_CHOICES)
    {
        //Creates drop down menu
        String choice = (String) javax.swing.JOptionPane.showInputDialog(
                null, //Component parentComponent
                "Would you like to use the program again?", //String title
                "Choose an option",//information
                javax.swing.JOptionPane.PLAIN_MESSAGE, //int optionType
                null, //Icon icon,
                CONTINUE_CHOICES, //Object[] options,
                CONTINUE_CHOICES[0] //Object initialValue 
        );
        //Retruns what choice the user made
        return (choice);
    }//End of ifContinue method 
    
}//End of class method 
