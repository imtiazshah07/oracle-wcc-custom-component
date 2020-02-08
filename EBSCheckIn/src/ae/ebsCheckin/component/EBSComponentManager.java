package ae.ebsCheckin.component;

import intradoc.data.DataBinder;

import java.util.Date;

import ae.ebsCheckin.CheckInManager;
import ae.ebsCheckin.component.data.CheckInParameter;
import ae.ebsCheckin.util.EBSCheckInConstants;

public class EBSComponentManager {
	protected void startProcess(DataBinder binder){
		CheckInParameter checkIn = new CheckInParameter();
		EBSCheckInConstants.DATASOURCE_AXF = binder.getEnvironmentValue("AXFJNDI");
		EBSCheckInConstants.DATASOURCE_CSDC = binder.getEnvironmentValue("CSDCJNDI");
		
		checkIn.setAxfDataSource(binder.getEnvironmentValue("AXFJNDI"));
		checkIn.setCsdcDataSource( binder.getEnvironmentValue("CSDCJNDI"));
		checkIn.setApplication(binder.getEnvironmentValue("EBS_INSTANCE"));
		
		checkIn.setdDocType(binder.getLocal("dDocType"));
		checkIn.setdDocName(binder.getLocal("dDocName"));
		
		String ebsCorresponding = binder.getEnvironmentValue(new String("EBSCorresponding_"+checkIn.getdDocType()));
		String ebsPrimaryKey = binder.getEnvironmentValue(new String("EBSPrimaryKey_"+checkIn.getdDocType()));
		String wccFields = binder.getEnvironmentValue(new String("WCCFields_"+checkIn.getdDocType()));
		String ebsTables = binder.getEnvironmentValue(new String("EBSTable_"+checkIn.getdDocType()));
		String ebsBusinessObjectType = binder.getEnvironmentValue(new String("EBSBusinessObjectType_"+checkIn.getdDocType()));
		
		
		String enableWorkflow = binder.getEnvironmentValue("EnableWorkflow"); 
		
		//System.out.println(ebsCorresponding+":"+ebsPrimaryKey+":"+wccFields+":"+ebsTables);
		
			if( ebsCorresponding != null && !ebsCorresponding.isEmpty() &&  
						ebsPrimaryKey != null && !ebsPrimaryKey.isEmpty() &&
								wccFields != null && !wccFields.isEmpty() &&
										ebsTables != null && !ebsTables.isEmpty()
			){
				checkIn.seteBSCorresponding(ebsCorresponding);
				checkIn.setEbsPrimaryKey(ebsPrimaryKey);
				checkIn.setEbsTable(ebsTables);
				checkIn.setWccFields(getWccFieldsValue(wccFields,binder));
				checkIn.setBusinessObjectType(checkIn.getEbsTable());
				
				checkIn.setCeecReferenceKey(binder.getEnvironmentValue("CEEC_REFERENCE_KEYS"));
				checkIn.setCeecReferenceTable(binder.getEnvironmentValue("CEEC_REFERENCE_TABLE"));
				checkIn.setCeecReferenceParameter(binder.getEnvironmentValue("CEEC_REFERENCE_PARAMETER"));
				
				new  CheckInManager().getBusinessObject(checkIn);
				
				System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent.startProcess parameter bean @ "+checkIn.toString());
				if(checkIn.getBusinessObject() !=null && !checkIn.getBusinessObject().isEmpty()){
					binder.putLocal("dAFApplication", checkIn.getApplication());
					if(ebsBusinessObjectType == null)
						binder.putLocal("dAFBusinessObjectType",checkIn.getBusinessObjectType());
					else 
						binder.putLocal("dAFBusinessObjectType",ebsBusinessObjectType);
						
					binder.putLocal("dAFBusinessObject",checkIn.getBusinessObject());
					System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent.startProcess value setuped [DAP Application: "+binder.getLocal("dAFApplication")+
									"][dAFBusinessObjectType:"+binder.getLocal("dAFBusinessObjectType")+"][dAFBusinessObject:"+binder.getLocal("dAFBusinessObject"));
				}
				else 
				{
					if(enableWorkflow.equalsIgnoreCase("TRUE")){
						System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent.startProcess businessObject is null, Initiating Worklfow.");
						binder.putLocal(EBSCheckInConstants.VARIFICATION_REQUIRED, EBSCheckInConstants.INITIATE_WORKFLOW);
					}
				}
			}
	
		else {
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent.startProcess dDocType ("+checkIn.getdDocType()+") is not matched with any profile in cfg file.");
		}
	}
	
	private String getWccFieldsValue(String wccField,DataBinder binder){
		String wccFieldArray[] = wccField.split(",");
		StringBuilder wccValues = new StringBuilder();
		for(String wc : wccFieldArray){
			wccValues.append(binder.getLocal(wc));
			wccValues.append(",");
		}
		return wccValues.substring(0,wccValues.length()-1);
	}
}
