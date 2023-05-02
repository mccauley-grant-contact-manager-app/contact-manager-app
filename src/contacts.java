//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class contacts {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int option = 0;
//
//        while(option!=5){
//            System.out.println("Main Menu\n---------\n1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete an existing contact\n5. Exit\nEnter an option (1, 2, 3, 4, or 5):");
//            option = scanner.nextInt();
//            scanner.nextLine();
//            switch(option){
//                case 1:
//                    viewContacts();
//                    break;
//
//                case 2: add(scanner);
//                break;
//                case 3: search(scanner);
//                break;
//                case 4: deleteContact(scanner);
//                break;
//                case 5: break;
//                default:
//                    System.out.println("Try again");
//            }
//        }
//
//
//
//
//        HashMap<String, String> names = new HashMap<>();
//        names.put("Savanna", "4156900506");
//        names.put("Auriel", "546456456");
//
//        try {
//            BufferedWriter bw = new BufferedWriter(
//                    new FileWriter("/Users/savannamccauley/IdeaProjects/test/contacts.txt"));
//
//            for (Map.Entry<String, String> entry : names.entrySet()) {
//                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
//            }
//
//            bw.close();
//
//            BufferedReader br = new BufferedReader(
//                    new FileReader("/Users/savannamccauley/IdeaProjects/test/contacts.txt"));
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            br.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    private static void deleteContact(Scanner scanner) {
//    }
//
//    private static void search(Scanner scanner) {
//    }
//
//    private static void add(Scanner scanner) {
//    }
//
//    private static void viewContacts() {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("contacts.txt"));
//            String line;
//            System.out.println("Name | Phone number");
//            System.out.println("-------------------");
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(",");
//                String name = parts[0];
//                String phone = parts[1];
//                System.out.println(name + " | " + phone);
//            }
//            br.close();
//        } catch (IOException e) {
//            System.out.println("Unable to read contacts file.");
//        }
//    }
//
//
//}


import java.io.*;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class contacts {
    private static final String CONTACTS_FILE = "/Users/savannamccauley/IdeaProjects/test/contacts.txt";
    private static HashMap<String, String> names = new HashMap<>();

    public static void main(String[] args) {
        loadContacts();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 5) {
            System.out.println("Main Menu\n---------\n1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete an existing contact\n5. Exit\nEnter an option (1, 2, 3, 4, or 5):");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    viewContacts();
                    break;
                case 2:
                    add(scanner);
                    break;
                case 3:
                    search(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Try again");
            }
        }

        saveContacts();
    }

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

    private static void viewContacts() {
        if (names.isEmpty()) {
            System.out.println("You have no contacts.");
        } else {
            System.out.println("Name | Phone number\n---------------");
            for (Map.Entry<String, String> entry : names.entrySet()) {
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }
        }
    }

    private static void add(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();

        names.put(name, number);
        System.out.println("Contact added.");
    }

    private static void search(Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        if (names.containsKey(name)) {
            System.out.println("Phone number: " + names.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        if (names.containsKey(name)) {
            names.remove(name);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
