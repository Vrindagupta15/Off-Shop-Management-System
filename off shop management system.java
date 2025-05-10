import java.util.Scanner;  
class ShopInventory {  
    private String liquorName;  
    private String liquorCategory;  
    private int quantity;  
    private long cost;  
    Scanner sc = new Scanner(System.in);  
    
    public void addCategory() {  
        System.out.print("Enter Liquor name: ");  
        liquorName = sc.next();  
        System.out.print("Enter Liquor type: ");  
        liquorCategory = sc.next();  
        System.out.print("Enter quantity: ");  
        quantity = sc.nextInt();  
        System.out.print("Enter cost per bottle: ");  
        cost = sc.nextLong();  
    }  
    
    public void showInventory() {  
        System.out.println("Name of Liquor: " + liquorName);
        System.out.println("Name of Type: " + liquorCategory);
        System.out.println("quantity: " + quantity);  
        System.out.println("cost per bottle: " + cost);  
    }  
    //method to update Inventory  
    public void updateInventory() {  
        int amt_of_bottles;
        long newCost;
        System.out.println("Enter the no. of bottles to deposit: ");  
        amt_of_bottles = sc.nextInt();  
        quantity = quantity + amt_of_bottles;
         System.out.println("Enter the new cost per bottle: ");  
        newCost = sc.nextLong();  
        cost = newCost;
       
    }  
    
    public long buy() {  
        int bottles;
        long bill=0;
        System.out.println("Enter the no. of bottles: ");  
        bottles = sc.nextInt();  
        if (quantity >= bottles) {  
            quantity = quantity - bottles;  
            bill=bottles*cost;
            return bill;
        } else {  
            return -1;
        }  
    }  
 
    public boolean search(String ac_no) {  
        if (liquorCategory.equals(ac_no)) {  
            showInventory();  
            return (true);  
        }  
        return (false);  
    }  
        public boolean searchByName(String ac_no) {  
        if (liquorName.equals(ac_no)) {  
            showInventory();  
            return (true);  
        }  
        return (false);  
    }
}  
class LiquourApp {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
        System.out.print("How many liquors do you want to input? ");  
        int n = sc.nextInt();  
        ShopInventory C[] = new ShopInventory[n];  
        for (int i = 0; i < C.length; i++) {  
            C[i] = new ShopInventory();  
            C[i].addCategory();  
        }  
        // loop runs until number 5 is not pressed to exit  
        int ch;  
        boolean found;
        do {  
            System.out.println("\n **Liquor Store Management System**");  
            System.out.println("1. Display all inventory details \n 2. Search by Category\n 3. Update Inventory \n 4. Buy \n 5.Exit ");  
            System.out.println("Enter your choice: ");  
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].showInventory();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter category you want to search: ");  
                        String category_name = sc.next();  
                        for (int i = 0; i < C.length; i++) {  
                            C[i].search(category_name);  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Enter liquor name : ");  
                        String liq_Name = sc.next();  
                        found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].searchByName(liq_Name);  
                            if (found) {  
                                C[i].updateInventory();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Not Found");  
                        }  
                        break;  
                    case 4:
                        for (int i = 0; i < C.length; i++) {  
                            C[i].showInventory();  
                        }
                        String ch1;
                        System.out.println("Enter your choice and -1 to proceed to billing: ");
                        ch1 = sc.next();
                        long bill=0;
                        while(ch1.equals("-1")==false){
                            found = false;  
                        for (int i = 0; i < C.length; i++) {  
                            found = C[i].searchByName(ch1);  
                            if (found) {  
                                bill = bill+C[i].buy();  
                                break;  
                            }
                            if (!found) {  
                            System.out.println("Not found");  
                        }  
                        }
                            for (int i = 0; i < C.length; i++) {  
                            C[i].showInventory();  
                        }
                            System.out.println("Enter your choice and -1 to proceed to billing: ");
                        ch1 = sc.next();
                        }
                       System.out.println("The bill is:" + bill);

                        break;  
                    case 5:  
                        System.out.println("See you soon...");  
                        break;  
                }  
            }  
            while (ch != 5);  
        }  
    }