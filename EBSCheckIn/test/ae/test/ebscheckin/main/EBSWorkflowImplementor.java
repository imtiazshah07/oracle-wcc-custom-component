package ae.test.ebscheckin.main;

import java.util.Vector;

import intradoc.common.ServiceException;
import intradoc.data.DataException;
import intradoc.server.workflow.WorkflowDocImplementor;
import intradoc.shared.UserAttribInfo;
import intradoc.shared.UserData;

public class EBSWorkflowImplementor extends WorkflowDocImplementor {
	/**
	 * Default constructor
	 */
	public EBSWorkflowImplementor() {
	}

	/**
	 * This code is called by checkCriteriaWorkflow(), which is called in the
	 * services "CHECKIN_NEW" and "CHECKIN_SEL". This customized code will make
	 * certain that the content has been checked in by a user with the security role
	 * "workflow_contributor." If the user does not have this role, the check to
	 * place this content into a worklow will always fail.
	 */
	public void checkCriteriaWorkflowEx1(boolean isUpdate) throws DataException, ServiceException {
		// obtain the data about the user performing the checkin
		UserData user = m_service.getUserData();

		// obtain the list of roles for the user, you can also
		// obtain the attribute "account" in this manner.
		Vector roles = user.getAttributes("role");

		// loop through the roles, and look for "workflow_contributor"
		boolean success = false;
		for (int i = 0; i < roles.size(); i++) {
			UserAttribInfo info = (UserAttribInfo) roles.elementAt(i);
			if (info.m_attribName.equals("workflow_contributor")) {
				System.out.println("Starting the workflow for the user'" + user.m_name
						+ "' who has the role 'workflow_contributor'.");
				success = true;
				break;
			}
		}

		// if they dont have the correct role, the document should not go
		// into a workflow no matter what.
		if (!success) {
			System.out.println("User does not have the role 'workflow_contributor'. No workflow will be started.");
			return;
		}

		// if they do have the role, perform all the normal checks to determine
		// which workflow, if any, the document should be placed in
		super.checkCriteriaWorkflowEx(isUpdate);
	}
}
