package de.aestis.lawandjabsuite.Listeners;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import de.aestis.lawandjabsuite.Main;

public class LawandjaMessageListener implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
    	
        DataInputStream in = new DataInputStream( new ByteArrayInputStream( message ) );
        String task = null;

        try {
            task = in.readUTF();

            if (task.equals("SendGlobalMessage"))
            {
                Main.instance.getLogger().info("Message received from <SERVER>: " + in.readUTF());
            }
            
            if (task.equals("SendGlobalAchievement"))
            {
                
            }
            
            if (task.equals("SendGlobalNote"))
            {
                
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
