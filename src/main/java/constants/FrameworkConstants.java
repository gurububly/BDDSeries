package constants;

public final class FrameworkConstants {


    private FrameworkConstants() {

    }

    private static final int EXPLICITWAIT = 20;
    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "\\Configuration\\config.properties";


    public static int getExplicitwaitTimeOut() {
        return EXPLICITWAIT;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    private static final String EXCELFILEPATH = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx";

    public static String getExcelFilePath() {
        return EXCELFILEPATH;
    }
}
