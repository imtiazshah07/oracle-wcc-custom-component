package ae.validatecheckin.search;

import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.DataResultSet;
import oracle.stellent.ridc.protocol.ServiceResponse;


public class SearchContentManager {
	
		private IdcClient getIdcClient(String idcURL)throws IdcClientException{
			return new IdcClientManager().createClient(idcURL);
		}
		public boolean isDocAvailable(Search searchParam)throws IdcClientException{
			
		  IdcClient myIdcClient = getIdcClient(searchParam.getIdcURL());
		  
		  DataBinder myRequestDataBinder = myIdcClient.createBinder();
		  myRequestDataBinder.putLocal("IdcService", "GET_SEARCH_RESULTS");
		  myRequestDataBinder.putLocal("QueryText", getWCCSearchQuery(searchParam));
		 // myRequestDataBinder.putLocal("ResultCount", "20");
		  myRequestDataBinder.putLocal("SortField", "dInDate");
		  myRequestDataBinder.putLocal("SortOrder", "Desc");
		  ServiceResponse myServiceResponse = myIdcClient.sendRequest(new IdcContext(searchParam.getUser()), myRequestDataBinder);

		  DataBinder dataBinder = myServiceResponse.getResponseAsBinder();
		  DataResultSet dataResultSet = dataBinder.getResultSet("SearchResults");

		  if(dataResultSet.getRows().size()==0) 
			  return false;
		  else
			  return true;
	}
	
	
	private String getWCCSearchQuery(Search search){
		StringBuilder query = new StringBuilder();
			query.append(search.getUcmdDocType()+" <contains> `"+search.getdDocType()+"` ");
			query.append("<AND> ");
			query.append(search.getUcmdClassification()+" <contains> `"+search.getdClassification()+"` ");
			
			query.append("<AND> ");
			String fieldValues[] = search.getXfieldValues().split(",");
			int i=0;
			for(String field : search.getXfields().split(",")){
				query.append(field+" <contains> `"+fieldValues[i]+"` ");
				query.append("<AND> ");
				i++;
			}
		query = new StringBuilder(query.toString().subSequence(0, query.toString().length()-6));
	//	System.out.println(" Search QUERY : "+query.toString());
		return query.toString();
	}
}
