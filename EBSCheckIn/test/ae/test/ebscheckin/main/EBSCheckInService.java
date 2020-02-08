package ae.test.ebscheckin.main;

import java.util.Date;

import intradoc.common.ServiceException;
import intradoc.common.SystemUtils;
import intradoc.data.DataException;
import intradoc.server.Service;

public class EBSCheckInService extends Service {

	public void validateCheckIn() throws DataException, ServiceException {
		SystemUtils.info("<" + new Date().toString() + "> <Notice> in EBSCheckInService.validateCheckIn ");
		System.out.println("<" + new Date().toString() + "> <Notice> in EBSCheckInService.validateCheckIn ");

		// m_binder.putLocal("StatusMessage", "Hello World Sample ");
		// String statusmessage = m_binder.getLocal("StatusMessage");

		SystemUtils.info("statusmessage:");
	}

	public void prepareCheckinSecurity() throws DataException, ServiceException {
	}

	public void checkSecurity() throws DataException, ServiceException {
	}

	public void doScriptableAction() throws DataException, ServiceException {
	}

	public void prepareRedirect() throws DataException, ServiceException {
	}

	public static void main(String[] args) {
		System.out.println("EBSCheckInService executed..");
	}
}
