//import model.Movie;
//import model.MovieResponse;
//import service.MovieService;
//import service.MovieServiceImpl;
//import ui.UI;
//import util.TableRenderer;
//
//import java.util.Scanner;
//
//public class Main {
//
//    private static final MovieService service = new MovieServiceImpl();
//    private static final Scanner sc = new Scanner(System.in);
//    private static int page = 1;
//
//    public static void main(String[] args) {
//
//        while (true) {
//
//            UI.header();
//
//            MovieResponse response = service.getTMDBMovie(page);
//
//            if (response == null || response.getResults() == null) {
//                System.out.println("API error or empty response!");
//                continue;
//            }
//
//            TableRenderer.displayTable(response);
//
//            UI.footer(page, response.getTotalPages());
//
//            String op = sc.next();
//
//            switch (op.toLowerCase()) {
//
//                case "n" -> {
//                    if (page < response.getTotalPages()) page++;
//                }
//
//                case "p" -> {
//                    if (page > 1) page--;
//                }
//
//                case "g" -> {
//                    System.out.print("[-] Enter page number (1-" + response.getTotalPages() + "): ");
//                    int input = sc.nextInt();
//
//                    if (input >= 1 && input <= response.getTotalPages()) {
//                        page = input;
//                    } else {
//                        System.out.println("Invalid page!");
//                    }
//                }
//
//                case "md" -> {
//                    System.out.print("[-] Enter movie ID: ");
//                    int id = sc.nextInt();
//
//                    Movie movie = response.getResults()
//                            .stream()
//                            .filter(m -> m.getId() == id)
//                            .findFirst()
//                            .orElse(null);
//
//                    if (movie != null) {
//                        UI.movieDetailHeader();
//
//                        System.out.println("Title   : " + movie.getTitle());
//                        System.out.println("Release : " + movie.getReleaseDate());
//                        System.out.println("Rating  : " + movie.getVoteAverage());
//                        System.out.println("Overview: " + movie.getOverview());
//
//                        System.out.println("\n[-] Press 'b' to go back");
//                        while (!sc.next().equalsIgnoreCase("b")) {
//                            // wait
//                        }
//                    } else {
//                        System.out.println("Movie not found!");
//                    }
//                }
//
//                case "e" -> {
//                    System.out.println("Goodbye ");
//                    System.exit(0);
//                }
//
//                default -> System.out.println("Invalid option!");
//            }
//
//            if (page < 1) page = 1;
//        }
//    }
//}


import ui.UI;
public class Main {
    public static void main(String[] args) {
        new UI().start();
    }
}