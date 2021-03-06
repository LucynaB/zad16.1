import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/weightConvertor")
public class WeightConvertorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kg = request.getParameter("kg");
        String g = request.getParameter("g");
        String mg = request.getParameter("mg");


        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        Double kgDouble = null;
        Double gDouble = null;
        Double mgDouble = null;


        if (kg != null && g.equals("") && mg.equals("")) {
            kgDouble = Double.valueOf(kg);
            gDouble = Convertor.convertFromKgToGrams(kgDouble);
            mgDouble = Convertor.convertFromKgToMg(kgDouble);

        } else if (g != null && kg.equals("") && mg.equals("")) {
            gDouble = Double.valueOf(g);
            kgDouble = Convertor.convertFromGramsToKg(gDouble);
            mgDouble = Convertor.convertFromGramsToMg(gDouble);

        } else if (mg != null && kg.equals("") && g.equals("")) {
            mgDouble = Double.valueOf(mg);
            kgDouble = Convertor.convertFromMgToKg(mgDouble);
            gDouble = Convertor.convertFromMgToGrams(mgDouble);

        } else
            writer.println("<h1>Należy wypełnić tylko jedno pole!</h1>");

        if (kgDouble != null && gDouble != null && mgDouble != null) {
            writer.println("<h1>Podana wartość w przeliczeniu na: </h2>");
            writer.println("<h2>kilogramy: " + kgDouble + "</h2>");
            writer.println("<h2>gramy: " + gDouble + "</h2>");
            writer.println("<h2>miligramy: " + mgDouble + "</h2>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
