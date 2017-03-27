package bean;

public class ClientJSON {
	private String command;
	private Resource resource;
	private String secret;
	private boolean relay;
	private ResourceTemplate resourceTemplate;
	private String[] serverList;
	
	//getter&setter
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public boolean isRelay() {
		return relay;
	}
	public void setRelay(boolean relay) {
		this.relay = relay;
	}
	public ResourceTemplate getResourceTemplate() {
		return resourceTemplate;
	}
	public void setResourceTemplate(ResourceTemplate resourceTemplate) {
		this.resourceTemplate = resourceTemplate;
	}
	public String[] getServerList() {
		return serverList;
	}
	public void setServerList(String[] serverList) {
		this.serverList = serverList;
	}
	
	
	
}