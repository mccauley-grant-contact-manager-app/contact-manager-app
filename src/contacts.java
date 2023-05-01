import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class contacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while(option!=5){
            System.out.println("Main Menu\n---------\n1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete an existing contact\n5. Exit\nEnter an option (1, 2, 3, 4, or 5):");
            option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1 : viewContacts();
                break;
                case 2: add(scanner);
                break;
                case 3: search(scanner);
                break;
                case 4: deleteContact(scanner);
                break;
                case 5: break;
                default:
                    System.out.println("Try again");
            }
        }




        HashMap<String, String> names = new HashMap<>();
        names.put("Savanna", "4156900506");
        names.put("Auriel", "546456456");

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("/Users/savannamccauley/IdeaProjects/test/contacts.txt"));

            for (Map.Entry<String, String> entry : names.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            bw.close();

            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/savannamccauley/IdeaProjects/test/contacts.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}