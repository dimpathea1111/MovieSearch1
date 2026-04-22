

package util;
import model.*;
import org.nocrala.tools.texttablefmt.*;
import java.util.List;

public class TableRenderer {
    public static void renderList(List<Movie> movies, int page, int totalPages, int totalResults) {
        System.out.println("\nPage " + page + " of " + totalPages + " | Total Results: " + totalResults);

        // FIX: Changed 4 to 5 because you have 5 columns now
        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);

        t.addCell("ID");
        t.addCell("Title");
        t.addCell("Release");
        t.addCell("Rating");
        t.addCell("Trailer");

        for (Movie m : movies) {
            t.addCell(String.valueOf(m.getId()));
            t.addCell(m.getTitle());
            t.addCell(m.getFormattedDate());
            t.addCell(String.format("%.1f", m.getVoteAverage()));

            // FIX: Removed the extra space in " +" to make the URL valid
            String trailerURL = "https://www.youtube.com/results?search_query=" + m.getTitle().replace(" ", "+");
            t.addCell(trailerURL);
        }
        System.out.println(t.render());
    }

    public static void renderDetails(MovieDetail d) {
        // Updated to match the double-border style of your list
        Table t = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        t.addCell("      MOVIE INFORMATION       ", 2);
        t.addCell("Title"); t.addCell(d.getTitle());
        t.addCell("Runtime"); t.addCell(d.getRuntime() + " min");
        t.addCell("Budget"); t.addCell("$" + String.format("%,d", d.getBudget()));
        t.addCell("Genres"); t.addCell(d.getGenresString());
        t.addCell("Origin"); t.addCell(d.getOrigin());
        System.out.println(t.render());
    }
}