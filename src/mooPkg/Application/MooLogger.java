package mootx;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Główna klasa loggera dla różnych zdarzeń w aplikaji, również dla urzytkownika
 * @author mOOlaq
 *
 */
public class MooLogger implements mootx.interfaces.MooAppInterface {
	
	
	//private MooDebuger mooDebuger = MooDebuger.getInstance();

	// START: Singleton
	
	private static MooLogger instance = new MooLogger();
	protected static  MooLogger getInstance() {
		if(MooApp.getMooLogLevel() == "DEBUG") System.out.println("["+ instance.getClass().getSimpleName() +"->getInstance()]");
		return instance;
	}
	// SINGLETON_REQUIREMENT: make the constructor private so that this class cannot be instantiated
		private MooLogger() {}
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
	
	
	
	protected void showDialog(String message) { // START: Wyświetlanie dialogu OK
   
		// TODO: If debug
		// TODO: message = "[Debuger]:[Generic name: " + getClass().toGenericString() + "]: protected void showDialog(String message)";
		JOptionPane MsgBox = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
		
	    JDialog dlg = MsgBox.createDialog(message);
	    dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	   
	    dlg.pack();
	    dlg.setVisible(true);
	    //Object n = MsgBox.getValue();
	    //System.out.println(n);
	    //System.out.println("Finished");
	    dlg.dispose();
   
	} // END: Wyświetlanie dialogu OK
	
}
