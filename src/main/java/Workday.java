import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;

public class Workday {

    public static void getParametrization(String jsonFile) throws IOException {

        final String regex = "(\"displayName\":) (\\w*.*),";
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

    public static void generateExclude(){
        String asd[] = {"AddAcademicAppointmentTestCase.xml\n" ,
                "CancelSupplierInvoiceTestCase.xml\n",
                "CloseJobRequisitionTestCase.xml\n",
                "EnterTimeOffTestCase.xml\n",
                "GetCompensationPlansTestCase.xml\n",
                "GetCustomListsTestCase.xml\n",
                "GetDegreesTestCase.xml\n",
                "GetEmployeeAwardsTestCase.xml\n",
                "GetHeadcountPlanStructuresTestCase.xml\n",
                "GetPaymentTypesTestCase.xml\n",
                "GetPayrollCANYearEndsFormsTestCase.xml\n",
                "GetPayrollPayeeNIsTestCase.xml\n",
                "GetPayrollPayeePT1sTestCase.xml\n",
                "GetPeriodSchedulesTestCase.xml\n",
                "GetTextBlockCategoryTestCase.xml\n",
                "GetWorkdayAccountSignOnsTestCase.xml\n",
                "performance-management-flows.xml\n",
                "performance-management-tests.xml\n",
                "PutBenefitAnnualRateTestCase.xml\n",
                "PutCompetencyTestCase.xml\n",
                "PutFundTestCase.xml\n",
                "PutIntegrationMessageTestCase.xml\n",
                "PutStudentApplicationTestCase.xml\n",
                "PutStudentCompetencyTestCase.xml\n",
                "PutStudentEducationalInstitutionTestCase.xml\n",
                "PutTimeClockEventsTestCase.xml\n",
                "PutTranslatableTenantDataPublicTestCase.xml\n",
                "SubmitDonorContributionIT.xml\n",
                "SubmitDonorContributionTestCase.xml\n",
                "SubmitStudentRecruiterTestCase.xml\n",
                "TerminateEmployeeTestCase.xml"};
        for (int i = 0; i < asd.length; i++) {
            System.out.println("<exclude>" + asd[i] + "<exclude/>");
        }
    }

    public static void main(String[] args) throws IOException {
            // PUT THE FILE NAME OF THE KEYS
            Workday.getParametrization("Adoption.json");
        //Workday.generateExclude();

    }
}







