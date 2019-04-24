package androidsrus;

import java.util.Scanner;

/**
 *
 * @author aldana
 */
public class Menu 
{

    public Menu() 
    {

        String choice = null;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("AndroidRus Company\nMENU\n");
        System.out.println("Select one option:");
        System.out.println("<1> Show all the Old Androids");
        System.out.println("<2> Show all the types and respective models");
        System.out.println("<3> Show all the models available of a particular type");
        System.out.println("<4> Quantity of available types");
        System.out.println("<5> Parts donated to a particular robot");

//        do {
//            choice = scan.nextLine();
//            switch (choice) {
//                case "1": {
//                    listSU.getList();
//                    new Menu(d, su, listSU);
//                    break;
//                }
//                case "2": {
//                    usu.userFlightCreation(d, listSU);
//                    new Menu(d, su, listSU);
//                    break;
//                }
//
//                case "3": {
//                    usu.ModifyArrivalTime(d);
//                    new Menu(d, su, listSU);
//                    break;
//                }
//                case "4": {
//                    usu.ModifyDepartureArrivalTime(d);
//                    new Menu(d, su, listSU);
//                    break;
//                }
//                case "5": {
//                    listSU.GetTotalList();
//                    new Menu(d, su, listSU);
//                    break;
//                }
//                case "6": {
//                    d.generateFlightsFromFile();
//                    d.getPilotsAssigned();
//                    new Menu(d, su, listSU);
//                    break;
//                }
//
//                case "7": {
//                    System.exit(0);
//                }
//
//                default: {
//                    System.out.println("You chose and invalid option. Please, try again");
//                    new Menu(d, su, listSU);
//                    break;
//                }
//
//            } // end of switch
//
//        } while (!choice.equals("7")); // end of loop do-while
//
    }

}
