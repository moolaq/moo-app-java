/**
 * 
 */
package mooPkg;

import java.util.Properties;

/**
 * Główna klasa całej aplikacji uruchamiająca logikę aplikacji
 * @author mOOlaq
 *
 */
public class MooApp implements mooPkg.interfaces.MooAppInterface {
	//private MooApp mooApp;
	private MooLogger mooLogger = MooLogger.getInstance();
	private MooConfig mooConfig = MooConfig.getInstance();
	//private MooDebuger mooDebuger = MooDebuger.getInstance();
	
	private static String MOO_LOG_LEVEL = "DEBUG";
	protected static String getMooLogLevel() {
		return MOO_LOG_LEVEL;
	}
	/**
	 * 
	 */
	public MooApp() {
		//super();
		// TODO Auto-generated constructor stub
		

		// 
		//mooLogger = new MooLogger(this);
		
		
//mooDebuger = new MooDebuger();		
		
		// SAMPLE_METHOD_USAGE: MooDebuger.showDialog("Wiadomość ....");
		//mooLogger.mooApp = this;
		
		//System.out.println(mooLogger.getMooApp()); 
		//System.out.println(mooLogger);
		
		//System.out.println(MooLogger.getInstance());
		if(MOO_LOG_LEVEL == "DEBUG") System.out.println("[MooApp]"+mooLogger);
		//System.out.println(MooConfig.getInstance());
		if(MOO_LOG_LEVEL == "DEBUG") System.out.println("[MooApp]"+mooConfig);
		Properties config = mooConfig.getConfig();
		System.out.println("[MooApp]"+config);
	}
	
	// START: Getters for fields
	//protected MooDebuger getMooDebuger() {
	//	return mooDebuger;
	//}
	
	// END: Getters for fields

	/**
	 * Moo Template
	 * Required to cast as System.out.println(instanceName)
	 */
	@Override
	public String toString() {
	  return "[PATH: " + System.getProperty("user.dir") + "]" + 
			 "[TIME: " + (System.currentTimeMillis()) + "]" +
			 "[Generic name: " + getClass().toGenericString() + "]" +
			 "[Simple name" + getClass().getSimpleName() + "]" +
			 "METHOD: [@Override toString()]" +
			 "[HashCode: " + java.lang.System.identityHashCode(this) + "]";
	}

}
