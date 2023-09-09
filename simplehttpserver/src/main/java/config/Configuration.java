package config;

public class Configuration {

	private int port;
	private String webroot;
	private int portMax;
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port=port;
	}
	public int getPortMax() {
		return portMax;
	}
	public void setPortMax(int port) {
		this.portMax=port;
	}
	public String getWebroot() {
		return webroot;
	}
	public void setWebroot(String webroot) {
		this.webroot = webroot;
	}
	
}
