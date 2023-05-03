

import java.io.*;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class contacts {
    private static final String CONTACTS_FILE = "/Users/savannamccauley/IdeaProjects/contact-manager-app/src/contacts.txt";

    private static HashMap<String, String> names = new HashMap<>();

    public static void main(String[] args) {

        names.put("Savanna", "4156900506");
        names.put("Auriel", "546456456");

        loadContacts();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        HashMap<String, String> names = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("contacts.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String phoneNumber = parts[1];
                names.put(name, phoneNumber);
            }

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        while (option != 5) {
            System.out.println("Main Menu\n---------\n1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete an existing contact\n5. Exit\nEnter an option (1, 2, 3, 4, or 5):");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    viewContacts(names);
                    break;
                case 2:
                    add(scanner, names);
                    break;
                case 3:
                    search(scanner, names);
                    break;
                case 4:
                    deleteContact(scanner, names);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Try again");
            }
        }
    }


//    void saveContacts() {
//
//    }
//
//}

    private static void loadContacts() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(CONTACTS_FILE));

            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(",");
                names.put(contact[0], contact[1]);
            }

            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void saveContacts() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(CONTACTS_FILE));

            for (Map.Entry<String, String> entry : names.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void viewContacts(HashMap<String, String> names) {
        if (contacts.names.isEmpty()) {
            System.out.println("You have no contacts.");
        } else {
            System.out.println("Name | Phone number\n---------------");


            String phoneNumber = entry.getValue();
            String formattedPhoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
            System.out.println(entry.getKey() + " | " + formattedPhoneNumber + " | ");


        }
    }

}

    private static void add(Scanner scanner, HashMap<String, String> names) {
        System.out.print("Enter the name of the new contact: ");
        String name = scanner.nextLine();
        System.out.print("Enter the phone number of the new contact: ");
        String phoneNumber = scanner.nextLine();
        contacts.names.put(name, phoneNumber);

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("contacts.txt"));

            for (Map.Entry<String, String> entry : contacts.names.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            bw.close();
            
            System.out.println("Contact added successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        names.put(name, number);
        System.out.println("Contact added.");
        saveContacts();
    }


    private static void search(Scanner scanner, HashMap<String, String> names) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        if (contacts.names.containsKey(name)) {
            System.out.println("Phone number: " + contacts.names.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner, HashMap<String, String> names) {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        if (contacts.names.containsKey(name)) {
            contacts.names.remove(name);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
        saveContacts();

    }
}
