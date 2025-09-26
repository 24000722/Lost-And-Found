// This java code was used as an back-end ,meaning it has no affect on the original code.



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// LostAndFoundItem class
class LostAndFoundItem {
    String itemName;
     String description;
     String location;
     String contactInfo;
     boolean isLost;

    public LostAndFoundItem(String itemName, String description, String location, String contactInfo, boolean isLost) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.contactInfo = contactInfo;
        this.isLost = isLost;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }
}

// LostAndFoundSystem class
public class LostAndFoundJava{
    private List<LostAndFoundItem> items;
    private Scanner scanner;

    public LostAndFoundJava() {
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {

            System.out.println("****Univen Campus Lost and Found****");
            System.out.println("1. Post a lost item");
            System.out.println("2. Post a found item");
            System.out.println("3. Search for items");
            System.out.println("4. Display all items");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    postItem(true);
                    break;
                case 2:
                    postItem(false);
                    break;
                case 3:
                    searchItems();
                    break;
                case 4:
                    displayAllItems();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void postItem(boolean isLost) {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item description: ");
        String description = scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();

        LostAndFoundItem item = new LostAndFoundItem(itemName, description, location, contactInfo, isLost);
        items.add(item);
        System.out.println("Item posted successfully!");
    }

    private void searchItems() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        for (LostAndFoundItem item : items) {
            if (item.getItemName().toLowerCase().contains(searchTerm) || item.getDescription().toLowerCase().contains(searchTerm)) {
                System.out.println("Item Name: " + item.getItemName());
                System.out.println("Description: " + item.getDescription());
                System.out.println("Location: " + item.getLocation());
                System.out.println("Contact Info: " + item.getContactInfo());
                System.out.println("Status: " + (item.isLost() ? "Lost" : "Found"));
                System.out.println();
            }
        }
    }

    private void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items posted.");
        } else {
            for (LostAndFoundItem item : items) {
                System.out.println("Item Name: " + item.getItemName());
                System.out.println("Description: " + item.getDescription());
                System.out.println("Location: " + item.getLocation());
                System.out.println("Contact Info: " + item.getContactInfo());
                System.out.println("Status: " + (item.isLost() ? "Lost" : "Found"));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        LostAndFoundJava system = new LostAndFoundJava();
        system.run();
    }
}
