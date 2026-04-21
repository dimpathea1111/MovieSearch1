//package util;
//
//import model.Movie;
//import model.MovieResponse;
//import org.nocrala.tools.texttablefmt.*;
//
//import java.util.List;
//
//public class TableRenderer {
//
////    public static void displayTable(MovieResponse response) {
////
////        List<Movie> movies = response.getResults();
////
////        if (movies == null || movies.isEmpty()) {
////            System.out.println("No movies found!");
////            return;
////        }
////
////        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
////
////        table.addCell("No");
////        table.addCell("Title");
////        table.addCell("Overview");
////        table.addCell("Release");
////        table.addCell("Rating");
////
////        int i = 1;
////
////        for (Movie m : movies) {
////
////            String overview = m.getOverview();
////            if (overview != null && overview.length() > 30) {
////                overview = overview.substring(0, 30) + "...";
////            }
////
////            table.addCell(String.valueOf(i++));
////            table.addCell(m.getTitle());
////            table.addCell(overview);
////            table.addCell(m.getReleaseDate());
////            table.addCell(String.format("%.1f", m.getVoteAverage()));
////        }
////
////        System.out.println(table.render());
////    }
////
//
//    public static void displayTable(MovieResponse response) {
//
//        List<Movie> movies = response.getResults();
//
//        if (movies == null || movies.isEmpty()) {
//            System.out.println("No movies found!");
//            return;
//        }
//
//        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
//
//        table.addCell("ID");
//        table.addCell("Title");
//        table.addCell("Release");
//        table.addCell("Rating");
//
//        int i = 1;
//
//        for (Movie m : movies) {
//            table.addCell(String.valueOf(m.getId()));
//            table.addCell(m.getTitle());
//            table.addCell(m.getReleaseDate());
//            table.addCell(String.format("%.1f", m.getVoteAverage()));
//        }
//
//        System.out.println(table.render());
//    }
//
//
//    public static void displayDetail(Movie m) {
//        System.out.println("\n===== MOVIE DETAIL =====");
//        System.out.println("Title: " + m.getTitle());
//        System.out.println("Overview: " + m.getOverview());
//        System.out.println("Release: " + m.getReleaseDate());
//        System.out.println("Rating: " + m.getVoteAverage());
//        System.out.println("========================\n");
//    }
//
//    public static void displayAll(List<Movie> movies) {
//
//        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
//
//        table.addCell("No");
//        table.addCell("Title");
//        table.addCell("Release");
//        table.addCell("Rating");
//
//        int i = 1;
//        for (Movie m : movies) {
//            table.addCell(String.valueOf(i++));
//            table.addCell(m.getTitle());
//            table.addCell(m.getReleaseDate());
//            table.addCell(String.format("%.1f", m.getVoteAverage()));
//        }
//
//        System.out.println(table.render());
//    }
//}



package util;
import model.*;
import org.nocrala.tools.texttablefmt.*;
import java.util.List;

public class TableRenderer {
    public static void renderList(List<Movie> movies, int page, int totalPages, int totalResults) {
        System.out.println("\nPage " + page + " of " + totalPages + " | Total Results: " + totalResults);
        Table t = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        t.addCell("ID"); t.addCell("Title"); t.addCell("Release"); t.addCell("Rating");
        for (Movie m : movies) {
            t.addCell(String.valueOf(m.getId()));
            t.addCell(m.getTitle());
            t.addCell(m.getFormattedDate());
            t.addCell(String.format("%.1f", m.getVoteAverage()));
        }
        System.out.println(t.render());
    }

    public static void renderDetails(MovieDetail d) {
        Table t = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        t.addCell("MOVIE INFORMATION", 2);
        t.addCell("Title"); t.addCell(d.getTitle());
        t.addCell("Runtime"); t.addCell(d.getRuntime() + " min");
        t.addCell("Budget"); t.addCell("$" + String.format("%,d", d.getBudget()));
        t.addCell("Genres"); t.addCell(d.getGenresString());
        t.addCell("Origin"); t.addCell(d.getOrigin());
        System.out.println(t.render());
    }
}