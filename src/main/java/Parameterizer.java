import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;


public class Parameterizer {

    public static final String[] ENUM_NETSUITE_SEARCH;
    static {
        String[] strings = {"COUPON_CODE",
                "CAMPAIGN",
                "PROMOTION_CODE",
                "PROMOTION_CODE_ADVANCED",
                "COUPON_CODE_ADVANCED",
                "CAMPAIGN_ADVANCED",
                "ITEM_DEMAND_PLAN",
                "ITEM_SUPPLY_PLAN",
                "MANUFACTURING_OPERATION_TASK",
                "MANUFACTURING_ROUTING",
                "MANUFACTURING_COST_TEMPLATE",
                "MANUFACTURING_OPERATION_TASK_ADVANCED",
                "MANUFACTURING_ROUTING_ADVANCED",
                "MANUFACTURING_COST_TEMPLATE_ADVANCED",
                "CUSTOM_RECORD",
                "CUSTOM_LIST",
                "CUSTOM_RECORD_ADVANCED",
                "TOPIC",
                "SOLUTION",
                "SUPPORT_CASE",
                "ISSUE",
                "TOPIC_ADVANCED",
                "SOLUTION_ADVANCED",
                "SUPPORT_CASE_ADVANCED",
                "ISSUE_ADVANCED",
                "TIME_BILL",
                "TIME_BILL_ADVANCED",
                "BIN",
                "PAYMENT_METHOD",
                "NOTE_TYPE",
                "ACCOUNTING_PERIOD",
                "VENDOR_CATEGORY",
                "CURRENCY_RATE",
                "OTHER_NAME_CATEGORY",
                "SUBSIDIARY",
                "CUSTOMER_CATEGORY",
                "CONTACT_ROLE",
                "REV_REC_TEMPLATE",
                "PRICE_LEVEL",
                "ITEM_REVISION",
                "ITEM",
                "ACCOUNT",
                "REV_REC_SCHEDULE",
                "UNITS_TYPE",
                "INVENTORY_NUMBER",
                "CLASSIFICATION",
                "WIN_LOSS_REASON",
                "PRICING_GROUP",
                "EXPENSE_CATEGORY",
                "GIFT_CERTIFICATE",
                "LOCATION",
                "CUSTOMER_MESSAGE",
                "SALES_ROLE",
                "DEPARTMENT",
                "TERM",
                "CONTACT_CATEGORY",
                "PARTNER_CATEGORY",
                "NEXUS",
                "NEXUS_ADVANCED",
                "CONTACT_CATEGORY_ADVANCED",
                "GIFT_CERTIFICATE_ADVANCED",
                "CLASSIFICATION_ADVANCED",
                "ACCOUNTING_PERIOD_ADVANCED",
                "DEPARTMENT_ADVANCED",
                "VENDOR_CATEGORY_ADVANCED",
                "PRICING_GROUP_ADVANCED",
                "REV_REC_SCHEDULE_ADVANCED",
                "ITEM_ADVANCED",
                "PAYMENT_METHOD_ADVANCED",
                "PARTNER_CATEGORY_ADVANCED",
                "CONTACT_ROLE_ADVANCED",
                "UNITS_TYPE_ADVANCED",
                "CURRENCY_RATE_ADVANCED",
                "WIN_LOSS_REASON_ADVANCED",
                "ITEM_REVISION_ADVANCED",
                "OTHER_NAME_CATEGORY_ADVANCED",
                "INVENTORY_NUMBER_ADVANCED",
                "LOCATION_ADVANCED",
                "CUSTOMER_MESSAGE_ADVANCED",
                "REV_REC_TEMPLATE_ADVANCED",
                "NOTE_TYPE_ADVANCED",
                "PRICE_LEVEL_ADVANCED",
                "TERM_ADVANCED",
                "CUSTOMER_CATEGORY_ADVANCED",
                "EXPENSE_CATEGORY_ADVANCED",
                "ACCOUNT_ADVANCED",
                "BIN_ADVANCED",
                "SUBSIDIARY_ADVANCED",
                "SALES_ROLE_ADVANCED",
                "VENDOR",
                "JOB_STATUS",
                "CUSTOMER_STATUS",
                "ORIGINATING_LEAD",
                "CUSTOMER",
                "PARTNER",
                "JOB",
                "ENTITY_GROUP",
                "CONTACT",
                "JOB_TYPE",
                "JOB_STATUS_ADVANCED",
                "CONTACT_ADVANCED",
                "VENDOR_ADVANCED",
                "CUSTOMER_STATUS_ADVANCED",
                "JOB_ADVANCED",
                "JOB_TYPE_ADVANCED",
                "PARTNER_ADVANCED",
                "CUSTOMER_ADVANCED",
                "ENTITY_GROUP_ADVANCED",
                "PHONE_CALL",
                "PROJECT_TASK",
                "CALENDAR_EVENT",
                "TASK",
                "PHONE_CALL_ADVANCED",
                "TASK_ADVANCED",
                "PROJECT_TASK_ADVANCED",
                "CALENDAR_EVENT_ADVANCED",
                "INVENTORY_DETAIL_BASIC",
                "MANUFACTURING_ROUTING_BASIC",
                "TRANSACTION_BASIC",
                "BUDGET_BASIC",
                "VENDOR_BASIC",
                "SUBSIDIARY_BASIC",
                "ISSUE_BASIC",
                "PROJECT_TASK_BASIC",
                "COUPON_CODE_BASIC",
                "TIME_BILL_BASIC",
                "NEXUS_BASIC",
                "CONTACT_BASIC",
                "VENDOR_CATEGORY_BASIC",
                "ITEM_SUPPLY_PLAN_BASIC",
                "CUSTOM_RECORD_BASIC",
                "DEPARTMENT_BASIC",
                "CONTACT_ROLE_BASIC",
                "GIFT_CERTIFICATE_BASIC",
                "PAYMENT_METHOD_BASIC",
                "OPPORTUNITY_BASIC",
                "JOB_TYPE_BASIC",
                "TOPIC_BASIC",
                "CONTACT_CATEGORY_BASIC",
                "PARTNER_BASIC",
                "PRICING_GROUP_BASIC",
                "REV_REC_SCHEDULE_BASIC",
                "GROUP_MEMBER_BASIC",
                "CUSTOMER_STATUS_BASIC",
                "ACCOUNT_BASIC",
                "ITEM_REVISION_BASIC",
                "OTHER_NAME_CATEGORY_BASIC",
                "REV_REC_TEMPLATE_BASIC",
                "MANUFACTURING_COST_TEMPLATE_BASIC",
                "PRICE_LEVEL_BASIC",
                "CLASSIFICATION_BASIC",
                "UNITS_TYPE_BASIC",
                "BIN_BASIC",
                "EMPLOYEE_BASIC",
                "INVENTORY_NUMBER_BASIC",
                "ENTITY_BASIC",
                "MANUFACTURING_OPERATION_TASK_BASIC",
                "CURRENCY_RATE_BASIC",
                "SUPPORT_CASE_BASIC",
                "EXPENSE_CATEGORY_BASIC",
                "CUSTOMER_MESSAGE_BASIC",
                "CUSTOM_LIST_BASIC",
                "ITEM_DEMAND_PLAN_BASIC",
                "JOB_BASIC",
                "PROMOTION_CODE_BASIC",
                "SOLUTION_BASIC",
                "SITE_CATEGORY_BASIC",
                "PARTNER_CATEGORY_BASIC",
                "MESSAGE_BASIC",
                "ENTITY_GROUP_BASIC",
                "PAYROLL_ITEM_BASIC",
                "JOB_STATUS_BASIC",
                "FILE_BASIC",
                "CAMPAIGN_BASIC",
                "LOCATION_BASIC",
                "WIN_LOSS_REASON_BASIC",
                "CUSTOMER_CATEGORY_BASIC",
                "PHONE_CALL_BASIC",
                "ORIGINATING_LEAD_BASIC",
                "FOLDER_BASIC",
                "ACCOUNTING_PERIOD_BASIC",
                "TERM_BASIC",
                "CALENDAR_EVENT_BASIC",
                "PROJECT_TASK_ASSIGNMENT_BASIC",
                "ITEM_BASIC",
                "CUSTOMER_BASIC",
                "SALES_ROLE_BASIC",
                "NOTE_TYPE_BASIC",
                "NOTE_BASIC",
                "TASK_BASIC",
                "FILE",
                "FOLDER",
                "FILE_ADVANCED",
                "FOLDER_ADVANCED",
                "BUDGET",
                "BUDGET_ADVANCED",
                "SITE_CATEGORY",
                "SITE_CATEGORY_ADVANCED",
                "EMPLOYEE",
                "PAYROLL_ITEM",
                "EMPLOYEE_ADVANCED",
                "MESSAGE",
                "NOTE",
                "MESSAGE_ADVANCED",
                "NOTE_ADVANCED",
                "TRANSACTION",
                "OPPORTUNITY",
                "TRANSACTION_ADVANCED",
                "OPPORTUNITY_ADVANCED",
                "CHARGE_BASIC",
                "CHARGE",
                "CHARGE_ADVANCED",
                "RESOURCE_ALLOCATION",
                "RESOURCE_ALLOCATION_ADVANCED",
                "RESOURCE_ALLOCATION_BASIC",
                "INVENTORY_NUMBER_BIN_BASIC",
                "PAYROLL_ITEM_ADVANCED",
                "ITEM_BIN_NUMBER_BASIC",
                "CUSTOM_LIST_ADVANCED",
                "ITEM_DEMAND_PLAN_ADVANCED",
                "ITEM_DEMAND_SUPPLY_ADVANCED",
                "BILLING_SCHEDULE",
                "BILLING_SCHEDULE_ADVANCED",
                "BILLING_SCHEDULE_BASIC",
                "GLOBAL_ACCOUNT_MAPPING",
                "GLOBAL_ACCOUNT_MAPPING_ADVANCED",
                "GLOBAL_ACCOUNT_MAPPING_BASIC",
                "TIME_SHEET",
                "TIME_SHEET_ADVANCED",
                "TIME_SHEET_BASIC",
                "TIME_ENTRY",
                "TIME_ENTRY_ADVANCED",
                "TIME_ENTRY_BASIC",
                "ITEM_ACCOUNT_MAPPING",
                "ITEM_ACCOUNT_MAPPING_ADVANCED",
                "ITEM_ACCOUNT_MAPPING_BASIC",
                "PRICING",
                "ACCOUNTING_TRANSACTION",
                "ACCOUNTING_TRANSACTION_BASIC",
                "ACCOUNTING_TRANSACTION_ADVANCED",
                "ADDRESS_BASIC",
                "BILLING_ACCOUNT",
                "BILLING_ACCOUNT_BASIC",
                "BILLING_ACCOUNT_ADVANCED",
                "FAIR_VALUE_PRICE",
                "FAIR_VALUE_PRICE_BASIC",
                "FAIR_VALUE_PRICE_ADVANCED",
                "COST_CATEGORY",
                "COST_CATEGORY_ADVANCED",
                "USAGE",
                "USAGE_ADVANCED",
                "USAGE_BASIC",
                "COST_CATEGORY_BASIC",
                "CONSOLIDATED_EXCHANGE_RATE",
                "CONSOLIDATED_EXCHANGE_RATE_BASIC",
                "CONSOLIDATED_EXCHANGE_RATE_ADVANCED",
                "TAX_GROUP",
                "TAX_GROUP_BASIC",
                "TAX_GROUP_ADVANCED",
                "TAX_DETAIL_BASIC",
                "TAX_TYPE",
                "TAX_TYPE_BASIC",
                "TAX_TYPE_ADVANCED",
                "SALES_TAX_ITEM",
                "SALES_TAX_ITEM_BASIC",
                "SALES_TAX_ITEM_ADVANCED"};
        ENUM_NETSUITE_SEARCH = strings;
    }

    public static final String WORKDAY = "(\"displayName\":) (\\w*.*),";
    public static final String COMPOSITE = "(\"id\":) (\\w*.*),\n";


    public static void getParametrization(String jsonFile, String connector) throws IOException {


        InputStream is = new FileInputStream("src/main/resources/" + jsonFile);
        String jsonTxt = IOUtils.toString(is, "UTF-8");

        final Pattern pattern = Pattern.compile(connector, Pattern.MULTILINE);
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

    public static void paramKeysOfEnum() {

        for(int i = 0; i < ENUM_NETSUITE_SEARCH.length; i++){
            System.out.println("<munit:parameterization name=\"param\">\n" +
                    "\t\t\t<munit:parameters>\n" +
                    "\t\t\t\t<munit:parameter propertyName=\"key\" value=\"" + ENUM_NETSUITE_SEARCH[i] + "\"" +
                    "/>\n" +
                    "\t\t\t</munit:parameters>\n" +
                    "\t\t</munit:parameterization>");
        }
    }


    public static void main(String[] args) throws IOException {
        // PUT THE FILE NAME OF THE KEYS
        // Parameterizer.getParametrization("IdentityManagement.json", WORKDAY);
        //Parameterizer.getParametrization("Record.json", COMPOSITE);
        paramKeysOfEnum();
    }
}







