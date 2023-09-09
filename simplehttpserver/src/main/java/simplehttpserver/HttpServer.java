package simplehttpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import config.Configuration;
import config.ConfigurationManager;
import core.ServerListenerThread;

/**
 * 
 * 
 * Driver Class for Http Server
 * 
 * 
 */
public class HttpServer {
	
	private final static Logger LOGGER =  (Logger) LoggerFactory.getLogger(HttpServer.class);
	
	public static void main(String[] args) {
		//System.out.println("Server Started...");
		LOGGER.info("Server Started...");
		ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
		Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
		int availablePort = findAvailablePort(conf.getPort(), conf.getPortMax());
		LOGGER.info("Using port: " + availablePort);
		LOGGER.info("Using webRoot: " + conf.getWebroot());
		
		try {
			ServerListenerThread serverListenerThread = new ServerListenerThread(availablePort,conf.getWebroot());
			serverListenerThread.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	public static int findAvailablePort(int startPort, int endPort) {
	    for (int port = startPort; port <= endPort; port++) {
	        try {
	            new ServerSocket(port).close(); // Try to open and close the socket
	            return port; // Port is available
	        } catch (IOException e) {
	            // Port is not available, continue to the next port
	        }
	    }
	    return -1; // No available ports in the range
	}
}
