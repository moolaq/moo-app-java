/**
 * 
 */
package mootx;

/**
 * @author mOOlaq
 *
 */
public class MooTxRunMain {

	private static MooApp app;
	/**
	 * @param args Commandline parameters - not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		app = new MooApp();
	}

	
	
	
	/*
	 * 
	 * public class BlackJack{
    private Client client;

    public BlackJack(){
        // Setup Client class, which will be passed to all other classes
        client = new Client(server, port, username);

    }  
Then each Client object has an instance of the GUI classes, e.g.

public class Client{
    private ChatGUI chatgui;
    private GameGUI gamegui;

    Client(String server, int port, String username){
             chatgui = new ChatGUI(this);
             gamegui = new GameGUI(this);
    }

    //handle messages from server
    void onMessageRecieved(String msg){
            if(// the message pertains to the game gui )
                    gamegui.newMessage(msg);
            else if(// the message pertains to the chat gui )
                    chatgui.newMessage(msg);
    }

    //here you can add functions for the gui classes to call
    public void sendChat(String chat){

    }
}

then your gui classes could look like...

public class ChatGUI{
    private JTextArea textarea;
    private Client client;

    public ChatGUI(Client c){
        client = c;
    }

    //receive message/command from server
    public void newMessage(String msg){
        //perform the desired action based on the command
    }

    public void sendChat(String msg){
        client.sendChat(msg);
    }
}

public class GameGUI{
    private Client client;

    public GameGUI(Client c){
        client = c;
    }

    //receive message/command from server
    public void newMessage(String msg){
        //perform the desired action based on the command
    }
}

	 * 
	 * 
	 * 
	 * 
	 */
}
