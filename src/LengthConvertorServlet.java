import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lengthConvertor")
public class LengthConvertorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String m = request.getParameter("m");
        String cm = request.getParameter("cm");
        String mm = request.getParameter("mm");


        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        Double mDouble = null;
        Double cmDouble = null;
        Double mmDouble = null;

        if (m != null && cm.equals("") && mm.equals("")) {
            mDouble = Double.valueOf(m);
            cmDouble = Convertor.convertFromMetersToCm(mDouble);
            mmDouble = Convertor.convertFromMetersToMm(mDouble);

        } else if (cm != null && m.equals("") && mm.equals("")) {
            cmDouble = Double.valueOf(cm);
            mDouble = Convertor.convertFromCMetersToM(cmDouble);
            mmDouble = Convertor.convertFromCMetersToMm(cmDouble);

        } else if (mm != null && m.equals("") && cm.equals("")) {
            mmDouble = Double.valueOf(mm);
            mDouble = Convertor.convertFromMMetersToM(mmDouble);
            cmDouble = Convertor.convertFromMMetersToCm(mmDouble);

        } else
            writer.println("<h1>Należy wypełnić tylko jedno pole!</h1>");


        if (mDouble != null && cmDouble != null && mmDouble != null) {
            writer.println("<h1>Podana wartość w przeliczeniu na: </h1>");
            writer.println("<h2>metry: " + mDouble + "</h2>");
            writer.println("<h2>centymetry: " + cmDouble + "</h2>");
            writer.println("<h2>milimetry: " + mmDouble + "</h2>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
