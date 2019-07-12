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
        String asd[] = {"AddAcademicAppointmentTestCase.xml" ,
                "CancelSupplierInvoiceTestCase.xml",
                "CloseJobRequisitionTestCase.xml",
                "EnterTimeOffTestCase.xml",
                "GetCompensationPlansTestCase.xml",
                "GetCustomListsTestCase.xml",
                "GetDegreesTestCase.xml",
                "GetEmployeeAwardsTestCase.xml",
                "GetHeadcountPlanStructuresTestCase.xml",
                "GetPaymentTypesTestCase.xml",
                "GetPayrollCANYearEndsFormsTestCase.xml",
                "GetPayrollPayeeNIsTestCase.xml",
                "GetPayrollPayeePT1sTestCase.xml",
                "GetPeriodSchedulesTestCase.xml",
                "GetTextBlockCategoryTestCase.xml",
                "GetWorkdayAccountSignOnsTestCase.xml",
                "performance-management-flows.xml",
                "performance-management-tests.xml",
                "PutBenefitAnnualRateTestCase.xml",
                "PutCompetencyTestCase.xml",
                "PutFundTestCase.xml",
                "PutIntegrationMessageTestCase.xml",
                "PutStudentApplicationTestCase.xml",
                "PutStudentCompetencyTestCase.xml",
                "PutStudentEducationalInstitutionTestCase.xml",
                "PutTimeClockEventsTestCase.xml",
                "PutTranslatableTenantDataPublicTestCase.xml",
                "SubmitDonorContributionIT.xml",
                "SubmitDonorContributionTestCase.xml",
                "SubmitStudentRecruiterTestCase.xml",
                "TerminateEmployeeTestCase.xml"};
        for (int i = 0; i < asd.length; i++) {
            System.out.println("<exclude>" + asd[i] + "<exclude/>");
        }
    }

    public static void main(String[] args) throws IOException {
            // PUT THE FILE NAME OF THE KEYS
            Workday.getParametrization("IdentityManagement.json");
//        Workday.generateExclude();

    }
}







