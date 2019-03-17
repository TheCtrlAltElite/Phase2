/**
 * Author: Osbaldo Matias
 */
package testDriver;

import dblibrary.project.csci230.*;
import java.io.*;
import java.util.*; 
import CMCDatabase.*;

public class DBLibraryDriver {
  private UniversityDBLibrary DBlib;
  
  public DBLibraryDriver() {
	 
  }
  
  
  public static void main(String[] args) {
    try{
    	System.out.println("hello");

    	DBController dbc = new DBController();
    	dbc.loadUniversities();


//    	AdminInteraction adint = new AdminInteraction ();
//    	adint.rMethod();
    	
  
//      DBLibraryDriver dbld = new DBLibraryDriver(args[0],args[1]);
//      
//      String[][] listUniv = dbld.getUnivDBlib().university_getUniversities();
//      
//      Scanner scan = new Scanner(System.in);
//      System.out.println("Enter school state: ");
//      String state = scan.nextLine();
//      
//      System.out.println("Enter number of students: ");
//      int students = scan.nextInt();
//      
//      for(int i = 0; i < listUniv.length; i++ ){
//    	  if(listUniv[i][1].equals(state.toUpperCase()) || (students + 5000) >= Integer.parseInt(listUniv[i][4]) && 
//    			  (students - 5000) <= Integer.parseInt(listUniv[i][4])  ) {
//    		  System.out.println(listUniv[i][0]);
//    	  }
//    	  else {
//    		  System.out.println("Not a match.");
//    	  }	  
//      }
      //System.out.println(Arrays.deepToString(dbld.getUnivDBlib().university_getUniversities()));
    }
    catch(Exception e){
      e.printStackTrace();
    }
    
  }
}