package module3.lecture11;

public class Facade {

    public static void main(String[] args) {
        String tableName = "Employee";

        //generating HTML report and PDF report without using Facade
        String xmlFile = XmlHelper.getXmlFile();
        XmlHelper xmlHelper = new XmlHelper();
        xmlHelper.generateToHtmlReport(tableName, xmlFile);

        String jsonFile = JsonHelper.getJsonFile();
        JsonHelper jsonHelper = new JsonHelper();
        jsonHelper.generateToPdfReport(tableName, jsonFile);

        //generating HTML report and  PDF report using Facade
        HelperFacade.generateReport(HelperFacade.FileTypes.XML, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.FileTypes.JSON, HelperFacade.ReportTypes.PDF, tableName);
    }

    interface ReportHelper {
        void generateToPdfReport(String tableName, String file);

        void generateToHtmlReport(String tableName, String file);
    }

    static class HelperFacade {

        public static void generateReport(FileTypes fileTypes, ReportTypes reportType, String tableName) {
            String file;

            ReportHelper reportHelper = switch (fileTypes) {
                case XML -> {
                    file = XmlHelper.getXmlFile();
                    yield new XmlHelper();
                }
                case JSON -> {
                    file = JsonHelper.getJsonFile();
                    yield new JsonHelper();
                }
            };

            switch (reportType) {
                case HTML -> reportHelper.generateToHtmlReport(tableName, file);
                case PDF -> reportHelper.generateToPdfReport(tableName, file);
            }
        }

        enum FileTypes {
            XML, JSON;
        }

        enum ReportTypes {
            HTML, PDF;
        }
    }

    static class XmlHelper implements ReportHelper {

        public static String getXmlFile() {
            return null;
        }

        public void generateToPdfReport(String tableName, String file) {
        }

        public void generateToHtmlReport(String tableName, String file) {
        }
    }

    static class JsonHelper implements ReportHelper {

        public static String getJsonFile() {
            return null;
        }

        public void generateToPdfReport(String tableName, String file) {
        }

        public void generateToHtmlReport(String tableName, String file) {
        }
    }
}
