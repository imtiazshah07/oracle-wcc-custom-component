package ae.ebsCheckin.component;

import java.util.Date;

import ae.ebsCheckin.util.EBSCheckInConstants;
import intradoc.common.ExecutionContext;
import intradoc.common.ServiceException;
import intradoc.data.DataBinder;
import intradoc.data.DataException;
import intradoc.data.Workspace;
import intradoc.shared.FilterImplementor;

public class EBSCheckInComponent  extends EBSComponentManager implements FilterImplementor{
	
	public int doFilter(Workspace ws, DataBinder binder, ExecutionContext cxt)
			throws DataException, ServiceException {
		
		String ridcService  = binder.getLocal("IdcService");
		System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent RIDC Service : "+ridcService);
		boolean executeProcess = false;
		String enableDIS = binder.getEnvironmentValue("EnableDIS") ;
		String enableCapture = binder.getEnvironmentValue("EnableCapture") ;
		String enableWebCheckIn = binder.getEnvironmentValue("EnableWebCheckIn") ;

		String application = binder.getLocal("dAFApplication");
		String businessObjectType = binder.getLocal("dAFBusinessObjectType");
		String businessObject =  binder.getLocal("dAFBusinessObject");
		
		
		
		//... Check Call Is not from EBS
		if( application != null && !application.isEmpty() &&
				businessObjectType != null && !businessObjectType.isEmpty()	&&
					businessObject != null && !businessObject.isEmpty() ) {
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent call is from EBS. ");
			return FilterImplementor.CONTINUE;
		}
		
		if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_VALIDATE_DECINFO)){
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent(VALIDATE_DECINFO) call is DIS for validation. ");
			return FilterImplementor.CONTINUE;
		}
			
		if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_CHECKIN_NEW) && enableWebCheckIn.equalsIgnoreCase("TRUE") ) executeProcess = true;
	else
		if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_CHECKIN_UNIVERSAL)){
			if(enableDIS.equalsIgnoreCase("TRUE") || enableCapture.equalsIgnoreCase("TRUE") ){
				executeProcess = true;
			}
		}
	else 	
		if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_UPDATE_DOCINFO_BYFORM)) executeProcess = true;
		
		if(executeProcess){
			startProcess(binder);
		}
		else{
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent No Conditions Matched executeProcess : "+executeProcess);
		}
		return FilterImplementor.CONTINUE;
	}
	
	
	
	private void updateFilePath(Workspace ws, DataBinder binder, ExecutionContext cxt){
		
	}
	
	
	public static void main(String ary[]){
		System.out.println(" Component Compile and Execute...");
	}
}
