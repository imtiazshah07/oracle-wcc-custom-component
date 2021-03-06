package ae.test.ebscheckin.main;

import java.util.Date;

import ae.ebsCheckin.component.EBSComponentManager;
import ae.ebsCheckin.util.EBSCheckInConstants;
import intradoc.common.ExecutionContext;
import intradoc.common.ServiceException;
import intradoc.data.DataBinder;
import intradoc.data.DataException;
import intradoc.data.Workspace;
import intradoc.shared.FilterImplementor;

public class EBSWorkflowFilter extends EBSComponentManager implements FilterImplementor {
	// WORKFLOW_APPROVED , UPDATE_DOCINFO_BYFORM

	public int doFilter(Workspace ws, DataBinder binder, ExecutionContext cxt) throws DataException, ServiceException {
		String ridcService = binder.getLocal("IdcService");
		System.out.println(" dDocName  : " + binder.getLocal("dDocName"));

//		if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_UPDATE_DOCINFO_BYFORM)) return FilterImplementor.CONTINUE;
//		else 
//			if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_CHECKIN_NEW)) return FilterImplementor.CONTINUE;
//			else 
//				if(ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_CHECKIN_UNIVERSAL)) return FilterImplementor.CONTINUE;
//				else 
		if (ridcService.equalsIgnoreCase(EBSCheckInConstants.FILTER_WORKFLOW_APPROVE)) {
			System.out.println(
					"<" + new Date().toString() + "> **************************************************************");
			System.out.println(
					"<" + new Date().toString() + "> <Notice> EBSCheckIn.WorkflowFilter RIDC Service : " + ridcService);
			System.out.println(
					"<" + new Date().toString() + "> **************************************************************");
			startProcess(binder);

			// return FilterImplementor.ABORT;
		}

		return FilterImplementor.CONTINUE;
	}

	public static void main(String[] args) {
		System.out.println("EBSCheckInService executed..");
	}
}
