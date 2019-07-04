import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;

public class Workday {

    public static void main(String[] args) throws IOException {

        final String regex = "(\"displayName\":) (\\w*.*),";

            String jsonFile = "compensationKeys.json";


            InputStream is = new FileInputStream("src/main/resources/" + jsonFile);
            String jsonTxt = IOUtils.toString(is, "UTF-8");

            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(jsonTxt);

        System.out.println("<munit:parameterizations>\n");

            while (matcher.find()) {

                System.out.println("<munit:parameterization name=\"param\">\n" +
                        "\t\t\t<munit:parameters>\n" +
                        "\t\t\t\t<munit:parameter propertyName=\"operation\" value=" + matcher.group(2) +
                        "/>\n" +
                        "\t\t\t</munit:parameters>\n" +
                        "\t\t</munit:parameterization>");

            }

        System.out.println("\t</munit:parameterizations>\n");

    }
}







