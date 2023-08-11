package One234Fi;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * Client main class that handles behaviour
 *
 */
@SpringBootApplication
public class App {
    private static Client client;
    private static ArrayList<Item> items;
    private static Scanner sc; 

    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        client = context.getBean(Client.class);    
        sc = new Scanner(System.in);

        printTodo();
        boolean running = prompt();
        while (running) {
            running = prompt();
        }

        sc.close();
        System.exit(0);
    }

    private static void refreshList() {
        items = new ArrayList<Item>();
        Collections.addAll(items, client.get().block());
    }

    private static void printTodo() {
        if (items == null) {
            refreshList();
        }

        if (items.size() < 1) {
            System.out.println("Todo list is empty");
            return;
        }

        System.out.println("TODO:\n");
        for (Item i : items) {
            System.out.println(i.toString());
        }
    }

    private static void addItem() {
        System.out.println("Enter a title...");
        sc.nextLine();
        String title = sc.nextLine();

        System.out.println("Enter a body...");
        String body = sc.nextLine();

        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setBody(body);

        client.post(newItem).block();
        items.add(newItem);
    }

    private static void modifyItem() {
        System.out.println("Which item (enter the index or 0 to cancel)?...");
        int index = sc.nextInt() -1;
        if (index < 0 || index > items.size()) {
            System.out.println("Cancelling");
            return;
        }

        String title = items.get(index).getTitle();
        String body = items.get(index).getBody();
        Integer id = items.get(index).getId();
        if (id == null) {
            refreshList();

            for (Item i : items) {
                if (title.compareTo(i.getTitle()) == 0 && body.compareTo(i.getBody()) == 0) {
                    id = i.getId();
                    break;
                }
            }
        }

        System.out.println("Enter the new title or \".\" to skip changing the title...");
        sc.nextLine();
        String temp = sc.nextLine();
        if (!temp.equalsIgnoreCase(".")) {
            title = temp;
        }

        System.out.println("Enter the new body or \".\" to skip changing the body...");
        temp = sc.nextLine();
        if (!temp.equalsIgnoreCase(".")) {
            body = temp;
        }

        Item rItem = items.get(index);
        rItem.setTitle(title);
        rItem.setBody(body);

        client.put(id, rItem).block();
        rItem = client.get(id).block();

        items.set(index, rItem);
    }

    private static void deleteItem() {
        System.out.println("Which item (enter the index or 0 to cancel)?...");
        int index = sc.nextInt() -1;
        if (index < 0 || index > items.size()) {
            System.out.println("Cancelling");
            return;
        }

        Integer id = items.get(index).getId();
        if (id == null) {
            String title = items.get(index).getTitle();
            String body = items.get(index).getBody();
            refreshList();

            for (Item i : items) {
                if (title.compareTo(i.getTitle()) == 0 && body.compareTo(i.getBody()) == 0) {
                    id = i.getId();
                    break;
                }
            }
        }

        items.remove(index);
        client.delete(id).block();
    }

    private static boolean prompt() {
        System.out.println("Please enter an option:");
        System.out.println("\t1. Print todo list");
        System.out.println("\t2. Add a new todo item");
        System.out.println("\t3. Modify an existing todo item");
        System.out.println("\t4. Delete a todo item");
        System.out.println("\t5. Exit");
        

        switch (sc.nextInt()) {
            case 1:
                printTodo();
                break;
            case 2:
                addItem();
                break;
            case 3:
                modifyItem();
                break;
            case 4:
                deleteItem();
                break;
            case 5:
                return false;
            default:
                System.out.println("Something went wrong processing your option, please try again...");
                return prompt();
        }
        return true;
    }
    

}
