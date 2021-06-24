package AbstractRooms;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;


public class Test {
	private static Scanner in = new Scanner(System.in);
	private static String regex = "\\w{2}-\\d{3}";
	
	public static int findRoom(Room[] list, int count, String roomNumber) {
		for(int i = 0; i < count; i++) {
			
			if(list[i].getNumber().equals(roomNumber)) {
				return i;
			}
		}
		
		return -1; 
	}
	
	
	public static void printRooms(Room[] list, int count) {
		for(int i = 0; i < count; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static void checkRoomNumber(String roomNumber) throws Exception{
		final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(roomNumber);
        if(!matcher.matches()) {
        	throw new Exception("Not the correct format -- XX-DDD");
        }
        
        
	}
	
	
	public static int readFromFile(Room[] list, String filename) {
		int count = 0;
		File roomFile = new File(filename);
		
		try {
	    	   //file input scanner
	           Scanner fileReader = new Scanner(roomFile);
	           
	           while (fileReader.hasNext()) {
	        	   
	        	   String data = fileReader.nextLine();
	        	   //splits words when it encounters space and stores in dataItem list
	        	   String[] dataItem = data.split(" ");
	        	   
	        	   Room room = null;
	        	   
	        	   String type = dataItem[0];
	        	   String number = dataItem[1];
	        	   Integer capacity = Integer.parseInt(dataItem[2]);
  				   Integer area = Integer.parseInt(dataItem[3]);
    			 switch(type) {
        			 case "office":
//		        				 office PA-252 2 36 Houria Oudghiri

        				 String name = dataItem[4];
        				 if (dataItem.length>5) {
        					 name =  name + " " + dataItem[5];
        				 }
        				 room = new Office(number, capacity, area, name);
        				 break;
        			 case "lab":
        				 //lab PA-110 65 150 45
        				 Integer computers = Integer.parseInt(dataItem[4]);
        				 room = new Lab(number, capacity, area, computers);
        				 break;
        			 case "classroom":
        				 room = new Classroom(number, capacity, area);
        				 break;
        			 default:
    			 }
    			 
    			 list[count] = room;
    			 count++;
	           
	           }
	       } catch (Exception e) {
	           
	           e.printStackTrace();
	       }
		return count;
	}
	
	public static void main(String[] args) {
		Room[] rooms = new Room[5];
		int count = readFromFile(rooms, "rooms.txt");
		
		while (true) {
			
			System.out.println("Select an operation:");
			System.out.println(" 1 - Find A Room.");
			System.out.println(" 2 - View all rooms.");
			System.out.println(" 3 - Sort Rooms.");
			System.out.println(" 4 - Exit.");

			System.out.print("Option : ");
			int option = in.nextInt();
			
			switch (option) {
				case 1:
					try {
						System.out.print(" Enter a Room Number: ");
						String num = in.next();
						checkRoomNumber(num);
						int index = findRoom(rooms, count ,num);
						if (index != -1) {
							Room r = rooms[index];
							System.out.println(r);
						} else {
							System.out.println("Not found");
						}
					} catch (Exception e) {
						System.out.println("Invalid room number – Must be (XX-ddd)");
					}
					break;
				case 2:
					printRooms(rooms, count);
					break;
				case 3:
					Arrays.sort(rooms);
					System.out.println(Arrays.toString(rooms));
					break;
				case 4:
					return;
					
			}

		}

	}
	}