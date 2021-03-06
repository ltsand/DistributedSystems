package processor;


import bean.ClientJSON;
import net.sf.json.JSONObject;
import server.Main;
import serverIO.Listener;

public class ExchangeProcessor {
	
	public JSONObject process(ClientJSON cJSON){
		
		// ------------------------------secure----------------------------------------------//
		if (Listener.isSecure == true) {
				String[] secureServerList = cJSON.getSecureServerList();
				for (String s : secureServerList) {
					boolean is_exist = false;
					/*
					 * secure issue modify here
					 */
					for (String k : Main.secureServerList) {
						if (k.equals(s))
							is_exist = true;
					}
					if (!is_exist)
						Main.addSecureServerList(s);
				}

				if (secureServerList.length == 0) {
					JSONObject jObject = new JSONObject();
					jObject.put("response", "error");
					jObject.put("errorMessage", "missing or invalid server list");
					return jObject;
				}
				JSONObject jObject = new JSONObject();
				jObject.put("response", "success");
				//System.out.println("jObject: " + jObject);
				return jObject;			
		}
		// ------------------------------secure----------------------------------------------//
		
		else{
		String[] serverList = cJSON.getServerList();
		for(String s:serverList){
			boolean is_exist=false;
			/*
			 * secure issue modify here 
			 * */
			for(String k:Main.serverList){
				if(k.equals(s))
					is_exist = true;
			}
			if(!is_exist)
				Main.addServerList(s);
			//Main.serverList.add(s);
		}
		
		if(serverList.length==0){
			JSONObject jObject = new JSONObject();
			jObject.put("response", "error");
			jObject.put("errorMessage", "missing or invalid server list");
			return jObject;
		}
		
		
		JSONObject jObject = new JSONObject();
		jObject.put("response", "success");
		return jObject;
		}
	}
}
