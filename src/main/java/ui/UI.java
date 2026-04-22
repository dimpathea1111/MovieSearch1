

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
        while (true) { // 👈 OUTER LOOP (default page)

            System.out.println("""

                ▗▄ ▄▖            █             ▗▄▖                     ▗▖  
                ▐█ █▌            ▀            ▗▛▀▜                     ▐▌  
                ▐███▌ ▟█▙ ▐▙ ▟▌ ██   ▟█▙      ▐▙    ▟█▙  ▟██▖ █▟█▌ ▟██▖▐▙██▖
                ▐▌█▐▌▐▛ ▜▌ █ █   █  ▐▙▄▟▌      ▜█▙ ▐▙▄▟▌ ▘▄▟▌ █▘  ▐▛  ▘▐▛ ▐▌
                ▐▌▀▐▌▐▌ ▐▌ ▜▄▛   █  ▐▛▀▀▘        ▜▌▐▛▀▀▘▗█▀▜▌ █   ▐▌   ▐▌ ▐▌
                ▐▌ ▐▌▝█▄█▘ ▐█▌ ▗▄█▄▖▝█▄▄▌     ▐▄▄▟▘▝█▄▄▌▐▙▄█▌ █   ▝█▄▄▌▐▌ ▐▌
                ▝▘ ▝▘ ▝▀▘   ▀  ▝▀▀▀▘ ▝▀▀       ▀▀▘  ▝▀▀  ▀▀▝▘ ▀    ▝▀▀ ▝▘ ▝▘
                """);

            System.out.println("=========  MOVIE APP SEARCH  ==========");
            System.out.print("[-] Enter movie title: ");
            query = sc.nextLine();
            page = 1;

            refresh();

            while (true) { // 👈 INNER LOOP (menu)

                System.out.println("""
                    [n] Next Page
                    [p] Previous Page
                    [g] Go To
                    [md] Movie Detail
                    [b] Back
                    [e] Exit
                    """);

                System.out.print("[-] Choose an option: ");
                String opt = sc.nextLine().toLowerCase();

                switch (opt) {
                    case "e" -> System.exit(0);
                    case "n" -> { page++; refresh(); }
                    case "p" -> { if(page > 1) page--; refresh(); }
                    case "g" -> {
                        System.out.print("[-] Enter page number: ");
                        page = Integer.parseInt(sc.nextLine());
                        refresh();
                    }
                    case "md" -> {
                        System.out.print("[-] Enter movie ID: ");
                        MovieDetail d = service.getMovieDetails(Integer.parseInt(sc.nextLine()));
                        if (d != null) TableRenderer.renderDetails(d);
                    }
                    case "b" -> {
                        break; // 👈 break INNER LOOP → go back to default page
                    }
                    default -> {
                        query = opt;
                        page = 1;
                        refresh();
                    }
                }

                if (opt.equals("b")) break; // 👈 required to exit while
            }
        }
    }


    private void refresh() {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Please enter a movie name!");
            return;
        }

        MovieResponse r = service.searchMovies(query, page);
        if (r != null && r.getResults() != null) {
            TableRenderer.renderList(
                    r.getResults(),
                    page,
                    r.getTotalPages(),
                    r.getTotalResults()
            );
        } else {
            System.out.println("No results found!");
        }
    }


}