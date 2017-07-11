package mootx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class MooConfig {

	

	// START: Singleton
	
	private static MooConfig instance = new MooConfig();
	protected static  MooConfig getInstance() {
		if(MooApp.getMooLogLevel() == "DEBUG") System.out.println("["+ instance.getClass().getSimpleName() +"->getInstance()]");
		return instance;
	}
	// SINGLETON_REQUIREMENT: make the constructor private so that this class cannot be instantiated
		private MooConfig() {}
	// END: Singleton
	
	
	
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
	// ============================ KONIEC: BRAK_EDYCJI ===================================
	
	
	
	private Properties configProperities = new Properties();
	protected Boolean mooConfigProperitiesInitialized = false;
	
	protected Properties getConfig() {
		if(!mooConfigProperitiesInitialized) {
			initializeConfigPropertiesFile();
			mooConfigProperitiesInitialized = true;
		}
		return configProperities;
	}
	
	// ============================ Inicjalizacja konfiguracji z pliku config.properities ===============
	
	private void initializeConfigPropertiesFile() {
		File propertiesFile = new File("config.properties");
		 OutputStream output = null;
		 InputStream input = null;
		 
		 // Jeśli plik config.properties istnieje
        if (propertiesFile.exists()) {
            System.out.println("Properties file was found");
            try {
            	input = new FileInputStream(propertiesFile);

				configProperities.load(input);
				
				// TODO: Sprawdzanie czy plik konfiguracji posiada wymagane wartości
				if(configProperities.getProperty("user") != null && configProperities.getProperty("pass") != null) {
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        } else {
        	MooLogger.getInstance().showDialog("Properties file is being created");
        	System.out.println("Properties file is being created");
            //createProperties(propertiesFile);
            try {

                output = new FileOutputStream(propertiesFile);

                configProperities.setProperty("user", "username");
                configProperities.setProperty("pass", "password");

                // save properties to project root folder
                configProperities.store(output, null);

            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            MooLogger.getInstance().showDialog("Properties file was created!");
        }
		
	}
	// ============================ Odczyt konfiguracji do pliku =========================================
	private void loadFromFile() {
			InputStream input = null;

			try {
				String filename = "config.properties";
	    		input = getClass().getClassLoader().getResourceAsStream(filename);
	    		if(input==null){
	    			
	    			MooLogger.getInstance().showDialog("Sorry, unable to find " + filename);
	    	            System.out.println("Sorry, unable to find " + filename);
	    		    return;
	    		}
				input = new FileInputStream("config.properties");

				// load a properties file
				configProperities.load(input);

				// get the property value and print it out
				System.out.println(configProperities.getProperty("database"));
				System.out.println(configProperities.getProperty("dbuser"));
				System.out.println(configProperities.getProperty("dbpassword"));

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	  }
	// ============================ Zapis konfiguracji do pliku =========================================
	private void saveToFile() {
	OutputStream output = null;

	try {

		output = new FileOutputStream("config.properties");

		// set the properties value
		configProperities.setProperty("database", "localhost");
		configProperities.setProperty("dbuser", "mkyong");
		configProperities.setProperty("dbpassword", "password");

		// save properties to project root folder
		configProperities.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
}
