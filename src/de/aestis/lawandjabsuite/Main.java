package de.aestis.lawandjabsuite;

import de.aestis.lawandjabsuite.Listeners.LawandjaMessageListener;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	public static String Version = "0.0.1";
	
	public static Main instance;
	public static ProxyServer proxy;
	
	@Override
	public void onEnable() {
		
		getLogger().info("Starting LawandjaBungeeSuite v" + Version + "...");
		
		instance = this;
		proxy = ProxyServer.getInstance();
		
		getLogger().info("Registering Listeners...");
		
		registerListeners();		
	}
	
	private void registerListeners() {
		
        this.getProxy().registerChannel("lawandja.lbchat"); //Input
        this.getProxy().registerChannel("lawandja.lbungeechat"); //Output - DISABLED @ Lawandja
        this.getProxy().registerChannel("lawandja.lbachievement"); //Input
        this.getProxy().registerChannel("lawandja.lbungeeachievement"); //Output - DISABLED @ Lawandja
        this.getProxy().registerChannel("lawandja.lbnotify"); //Input
        this.getProxy().registerChannel("lawandja.lbungeenotify"); //Output - DISABLED @ Lawandja

        proxy.getPluginManager().registerListener(this, (Listener) new LawandjaMessageListener());
    }
	
}
