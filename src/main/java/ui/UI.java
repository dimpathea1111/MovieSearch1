//package ui;
//
//public class UI {
//
//    public static void header() {
////        System.out.println("\n================ MOVIE SEARCH ENGINE ================\n");
//        System.out.println("""
//
//                ▗▄ ▄▖            █             ▗▄▖                     ▗▖  \s
//                ▐█ █▌            ▀            ▗▛▀▜                     ▐▌  \s
//                ▐███▌ ▟█▙ ▐▙ ▟▌ ██   ▟█▙      ▐▙    ▟█▙  ▟██▖ █▟█▌ ▟██▖▐▙██▖
//                ▐▌█▐▌▐▛ ▜▌ █ █   █  ▐▙▄▟▌      ▜█▙ ▐▙▄▟▌ ▘▄▟▌ █▘  ▐▛  ▘▐▛ ▐▌
//                ▐▌▀▐▌▐▌ ▐▌ ▜▄▛   █  ▐▛▀▀▘        ▜▌▐▛▀▀▘▗█▀▜▌ █   ▐▌   ▐▌ ▐▌
//                ▐▌ ▐▌▝█▄█▘ ▐█▌ ▗▄█▄▖▝█▄▄▌     ▐▄▄▟▘▝█▄▄▌▐▙▄█▌ █   ▝█▄▄▌▐▌ ▐▌
//                ▝▘ ▝▘ ▝▀▘   ▀  ▝▀▀▀▘ ▝▀▀       ▀▀▘  ▝▀▀  ▀▀▝▘ ▀    ▝▀▀ ▝▘ ▝▘
//
//
//                """);
//    }
//
//    public static void footer(int page, int total) {
//        System.out.println("\nPage " + page + " of " + total + " | Total Results: ...");
//
//        System.out.println("""
//                [n] Next Page      [p] Previous Page
//                [g] Go to Page     [md] Movie Detail
//                [b] Back           [e] Exit
//                """);
//
//        System.out.print("[-] Choose an option: ");
//    }
//
//    public static void movieDetailHeader() {
//        System.out.println("\n================ MOVIE INFORMATION ================\n");
//    }
//}


package ui;
import model.*;
import service.*;
import util.TableRenderer;
import java.util.Scanner;

public class UI {
    private final MovieService service = new MovieServiceImpl();
    private final Scanner sc = new Scanner(System.in);
    private String query = "";
    private int page = 1;

    public void start() {
        System.out.println("▗▄ ▄▖  MOVIE APP SEARCH  ▗▄▖");
        System.out.print("[-] Enter movie title: ");
        query = sc.nextLine();
        refresh();
        while (true) {
            System.out.println("\n[n]Next [p]Prev [g]Go [md]Detail [e]Exit");
            System.out.print("[-] Choose an option: ");
            String opt = sc.nextLine().toLowerCase();
            switch (opt) {
                case "e" -> System.exit(0);
                case "n" -> { page++; refresh(); }
                case "p" -> { if(page > 1) page--; refresh(); }
                case "g" -> { System.out.print("[-] Enter page number: "); page = Integer.parseInt(sc.nextLine()); refresh(); }
                case "md" -> {
                    System.out.print("[-] Enter movie ID: ");
                    MovieDetail d = service.getMovieDetails(Integer.parseInt(sc.nextLine()));
                    if (d != null) TableRenderer.renderDetails(d);
                }
                default -> { query = opt; page = 1; refresh(); }
            }
        }
    }
    private void refresh() {
        MovieResponse r = service.searchMovies(query, page);
        if (r != null && r.getResults() != null) {
            TableRenderer.renderList(r.getResults(), page, r.getTotalPages(), r.getTotalResults());
        }
    }
}