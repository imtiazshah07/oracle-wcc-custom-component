package ae.ebsCheckin.database;

import ae.mscJdbcUtility.data.IData;

public class EBSCheckIn implements IData{
	
	private Integer employeeNumber;

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	
}
