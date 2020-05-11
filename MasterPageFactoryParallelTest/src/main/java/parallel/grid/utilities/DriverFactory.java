package parallel.grid.utilities;

public class DriverFactory {
	
	
	private static String GECKO_DRIVER_PATH;
	private static String IE_DRIVER_PATH;
	private static String PROPERTY_FILE_PATH;
	private static String GRIDE_PATH;
	private static boolean _isREMOTE;

	
	
	
	private static String CHROME_DRIVER_PATH;
	public static String getCHROME_DRIVER_PATH() {
		return CHROME_DRIVER_PATH;
	}
	public static void setCHROME_DRIVER_PATH(String cHROME_DRIVER_PATH) {
		CHROME_DRIVER_PATH = cHROME_DRIVER_PATH;
	}
	public static String getGECKO_DRIVER_PATH() {
		return GECKO_DRIVER_PATH;
	}
	public static void setGECKO_DRIVER_PATH(String gECKO_DRIVER_PATH) {
		GECKO_DRIVER_PATH = gECKO_DRIVER_PATH;
	}
	public static String getIE_DRIVER_PATH() {
		return IE_DRIVER_PATH;
	}
	public static void setIE_DRIVER_PATH(String iE_DRIVER_PATH) {
		IE_DRIVER_PATH = iE_DRIVER_PATH;
	}
	public static String getPROPERTY_FILE_PATH() {
		return PROPERTY_FILE_PATH;
	}
	public static void setPROPERTY_FILE_PATH(String pROPERTY_FILE_PATH) {
		PROPERTY_FILE_PATH = pROPERTY_FILE_PATH;
	}
	public static String getGRIDE_PATH() {
		return GRIDE_PATH;
	}
	public static void setGRIDE_PATH(String gRIDE_PATH) {
		GRIDE_PATH = gRIDE_PATH;
	}
	public static boolean is_isREMOTE() {
		return _isREMOTE;
	}
	public static void set_isREMOTE(boolean _isREMOTE) {
		DriverFactory._isREMOTE = _isREMOTE;
	}
	
}
