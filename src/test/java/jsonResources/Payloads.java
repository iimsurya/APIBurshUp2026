package jsonResources;

public class Payloads {

    public static String addPlace(){

        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Home one\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, chennai 13\",\n" +
                "  \"types\": [\n" +
                "    \"toe park\",\n" +
                "    \"house\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String coursesPrice(){

        return "{\n" +
                "    \"dashboard\": {\n" +
                "        \"purchaseAmount\": 910,\n" +
                "        \"website\": \"rahulshettyacademy.com\"\n" +
                "    },\n" +
                "    \"courses\": [\n" +
                "        {\n" +
                "            \"title\": \"Selenium Python\",\n" +
                "            \"price\": 50,\n" +
                "            \"copies\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"Cypress\",\n" +
                "            \"price\": 40,\n" +
                "            \"copies\": 4\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"RPA\",\n" +
                "            \"price\": 45,\n" +
                "            \"copies\": 10\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public static String addBookPayload(String isbn, String aisle){

        return "{\n" +
                "    \"name\": \"Learn Appium Automation with Java New\",\n" +
                "    \"isbn\": \""+isbn+"\",\n" +
                "    \"aisle\": \""+aisle+"\",\n" +
                "    \"author\": \"John foe\"\n" +
                "}";
    }

    public static String createIssue(){

        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"SCRUM\"\n" +
                "        },\n" +
                "        \"summary\": \"Defect number 1\",\n" +
                "        \"description\": {\n" +
                "            \"type\": \"doc\",\n" +
                "            \"version\": 1,\n" +
                "            \"content\": [\n" +
                "                {\n" +
                "                    \"type\": \"paragraph\",\n" +
                "                    \"content\": [\n" +
                "                        {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"text\": \"Description of the issue being created.\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }
}
