package constants;

public final class FrameworkConstants {


    private FrameworkConstants() {
         System.out.println("hi");
    }

    private static final int EXPLICITWAIT = 20;
    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "\\Configuration\\config.properties";


    public static int getExplicitwaitTimeOut() {
        return EXPLICITWAIT;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
}
