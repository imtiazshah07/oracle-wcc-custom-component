package ae.validatecheckin.component;

import intradoc.common.ExecutionContext;
import intradoc.common.ServiceException;
import intradoc.data.DataBinder;
import intradoc.data.DataException;
import intradoc.data.Workspace;
import intradoc.shared.FilterImplementor;

import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import ae.validatecheckin.jdbc.ValidateDAO;
import ae.validatecheckin.search.Search;
import ae.validatecheckin.search.SearchContentManager;
//import oracle.apps.fnd.common.VersionInfo;

public class ValidateCheckIn  implements FilterImplementor{
	
	public int doFilter(Workspace ws, DataBinder binder, ExecutionContext cxt)
			throws DataException, ServiceException {
		
		System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, Checking Duplicate Contents ");
		String ridcService  = binder.getLocal("IdcService");
		String xWfField = binder.getEnvironmentValue("workflow.init.xfield");
		if(ridcService.equalsIgnoreCase("CHECKIN_NEW") || ridcService.equalsIgnoreCase("CHECKIN_UNIVERSAL")){
			Search search = new Search();
				search.setDbdDocTypeTitle(binder.getEnvironmentValue("dbfield.dDocType"));
				search.setDbdClassificationTitle(binder.getEnvironmentValue("dbfield.dClassification"));
				search.setDbxFieldTitle(binder.getEnvironmentValue("dbfield.xField"));
				search.setDbTableTitle(binder.getEnvironmentValue("db.tableTitle"));
				
				search.setUcmdDocType(binder.getEnvironmentValue("ucm.dDocType"));
				search.setUcmdClassification(binder.getEnvironmentValue("ucm.dClassification"));
									
				search.setdDocType(binder.getLocal(search.getUcmdDocType()));
				search.setdClassification(binder.getLocal(search.getUcmdClassification()));
				
				search.setJndi(binder.getEnvironmentValue("SystemDatabase:DataSource"));
				search.setIdcURL(binder.getEnvironmentValue("SystemIDC")); 
				search.setUser(binder.getEnvironmentValue("SystemUser"));
				
				//System.out.println("To String Value Search :"+search.toString());
			try {
				Search result = new ValidateDAO(search.getJndi()).getValidationFields(search);
						//result.setXfieldValues(getFieldValue(result.getXfields(),binder));
				if(result == null){
					System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, dDocType and classification does't matched.");
					return FilterImplementor.CONTINUE;
				}	
				//result.getdClassification()
				search.setXfields(result.getXfields());
				search.setXfieldValues(getFieldValue(search.getXfields(),binder));

				//System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, Result Fields : "+search.getXfields());
				//System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, Result Fields Values : "+search.getXfieldValues());
				
				boolean isDuplicate = new SearchContentManager().isDocAvailable(search);
				if(isDuplicate){
					binder.putLocal(xWfField, "1");
					System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, Duplicate Document WF Initiated.");
				}
				else
					System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, Check In processed.");
				
			} catch (SQLException e) {
				System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, SQLException : "+e.getMessage());
				//e.printStackTrace();
			} catch (NamingException e) {
				System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, NamingException : "+e.getMessage());
				//e.printStackTrace();
			} catch (Exception e) {
				System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, Exception : "+e.getMessage());
				//e.printStackTrace();
			}
		}
		else {
			System.out.println("<"+new Date().toString()+"> <Notice> ValidateCheckIn.ValidateCheckIn, No Operation Performed RIDC call ("+ridcService+") doesn't matched. ");
		}
		return FilterImplementor.CONTINUE;
	}
	
	private String getFieldValue(String fieldList,DataBinder binder){
		StringBuilder fieldValues = new StringBuilder();
		for(String field : fieldList.split(",")){
			fieldValues.append(binder.getLocal(field)+",");
		}
		fieldValues = new StringBuilder(fieldValues.toString().subSequence(0, fieldValues.toString().length()-1));	
		return fieldValues.toString();
	}
	public static void main(String ary[]){
		System.out.println("Compnent is running..");
	}
}
