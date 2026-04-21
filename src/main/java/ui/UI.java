package ui;

public class UI {

    public static void header() {
        System.out.println("\n================ MOVIE SEARCH ENGINE ================\n");
    }

    public static void footer(int page, int total) {
        System.out.println("\nPage " + page + " of " + total + " | Total Results: ...");

        System.out.println("""
                [n] Next Page      [p] Previous Page
                [g] Go to Page     [md] Movie Detail
                [b] Back           [e] Exit
                """);

        System.out.print("[-] Choose an option: ");
    }

    public static void movieDetailHeader() {
        System.out.println("\n================ MOVIE INFORMATION ================\n");
    }
}