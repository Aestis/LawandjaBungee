package de.aestis.lawandjabsuite.Listeners;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import de.aestis.lawandjabsuite.Main;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LawandjaMessageListener implements Listener {

	@EventHandler
    public void receivePluginMessage(PluginMessageEvent event) throws IOException {

		if (event.isCancelled()) return; 
        if (!(event.getSender() instanceof Server))
            return;
        if (!event.getTag().equalsIgnoreCase("lawandja:lbchat")) return;
        
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(event.getData()));
        String task = null;

        try {
            task = in.readUTF();

            if (task.equals("SendGlobalMessage"))
            {
            	String server, player, message;
            	server = in.readUTF();
            	player = in.readUTF();
            	message = in.readUTF();
            	Main.instance.getLogger().info("Message received from <" + server + ">: <PLAYER:" + player + "> -> " + message);
            }
            
            if (task.equals("SendGlobalAchievement"))
            {
            	Main.instance.getLogger().info("Achievement received from <SERVER>: <PLAYER:" + in.readUTF() + "> -> " + in.readUTF());
            }
            
            if (task.equals("SendGlobalNote"))
            {
            	Main.instance.getLogger().info("Notification received from <SERVER>: " + in.readUTF());
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
