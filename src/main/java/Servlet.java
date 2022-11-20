import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Temperature> temperatureList = new ArrayList<>() {{
            add(new Temperature(32.1));
            add(new Temperature(23.1));
            add(new Temperature(31.8));
            add(new Temperature(11.2));
            add(new Temperature(41.1));
            add(new Temperature(35.2));
            add(new Temperature(16.7));
        }};


        final double number = temperatureList.stream()
                .mapToDouble(Temperature::getNumber)
                .average()
                .orElseThrow(() -> new IllegalArgumentException());

        List<Temperature> collectionOfDaysMoreAverage = temperatureList.stream()
                .filter(temperature -> temperature.getNumber() > number)
                .toList();

        long countDaysMoreAverage = temperatureList.stream()
                .filter(temperature -> temperature.getNumber() > number)
                .count();

        long countDaysLessAverage = temperatureList.stream()
                .filter(temperature -> temperature.getNumber() < number).count();


        List<Temperature> collectionOfDaysLessAverage = temperatureList.stream()
                .filter(temperature -> temperature.getNumber() < number)
                .toList();


        List<Double> top3HotDays = temperatureList.stream()
                .mapToDouble(Temperature::getNumber)
                .sorted()
                .skip(temperatureList.size() - 3)
                .boxed()
                .toList();

        PrintWriter printWriter = response.getWriter();
        System.out.println(printWriter);
        printWriter.write("<html>");
        printWriter.println("<p>" + "All temperature: " + Arrays.toString(temperatureList.toArray()) + "</p>");
        printWriter.println("<p>" + "Average temperature: " + number + "</p>");
        printWriter.println("<p>" + "Temperature that more than average: " + collectionOfDaysMoreAverage + "</p>");
        printWriter.println("<p>" + "Count of days more than average : " + countDaysMoreAverage + "</p>");
        printWriter.println("<p>" + "Temperature that less than average: " + collectionOfDaysLessAverage + "</p>");
        printWriter.println("<p>" + "Count of days less than average : " + countDaysLessAverage + "</p>");
        printWriter.println("<p>" + "top3HotDays : " + top3HotDays + "</p>");
        printWriter.write("</html>");
    }

}
