package processor;

import bean.ClientJSON;
import net.sf.json.JSONObject;

public class Processor {
	ClientJSON clientJSON;
	
	public void getClientJSON(JSONObject jObject){
		clientJSON = (ClientJSON) JSONObject.toBean(jObject, ClientJSON.class);
		
	}
	
	public JSONObject assignRequest(){
		String command = clientJSON.getCommand();
		
		if(command.equals("EXCHANGE")){
			ExchangeProcessor ep = new ExchangeProcessor();
			return ep.process(clientJSON);
		}
		
		if(command.equals("FETCH")){
			FetchProcessor fp = new FetchProcessor();
			return fp.process(clientJSON);
		}
		
		if(command.equals("PUBLISH")){
			PublishProcessor pp = new PublishProcessor();
			return pp.process(clientJSON);
		}
		
		if(command.equals("QUERY")){
			QueryProcessor qp = new QueryProcessor();
			return qp.process(clientJSON);
		}
		
		if(command.equals("REMOVE")){
			RemoveProcessor rp = new RemoveProcessor();
			return rp.process(clientJSON);
		}
		
		if(command.equals("SHARE")){
			ShareProcessor sp = new ShareProcessor();
			return sp.process(clientJSON);
		}
		
		else{
			JSONObject jObject = new JSONObject();
			jObject.put("err", "wrong command");
			return jObject;
		}
		
		
	}
}
