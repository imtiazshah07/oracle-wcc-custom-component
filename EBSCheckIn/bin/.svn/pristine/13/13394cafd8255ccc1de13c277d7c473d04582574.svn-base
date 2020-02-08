package ae.ebsCheckin.database;

import java.math.BigDecimal;
import java.util.Date;

import ae.ebsCheckin.component.data.CheckInParameter;
import ae.mscJdbcUtility.base.JdbcFectory;
import ae.mscJdbcUtility.data.DataWorker;

public class PersistenceDAO {
	
	private String jndi;
	public PersistenceDAO(String jndi){
		this.jndi = jndi;
	}
	public PersistenceDAO(String csdc,String axf){
		
	}
	
	public CheckInParameter getCheckInParameter(String sql){
		JdbcFectory jdbc = new JdbcFectory(jndi);
		//sql = "SELECT username,useremail from AWRFinanceNotificationUsers";
		try {
			CheckInParameter checkInParameter = jdbc.getEntity(sql, new CheckInParameter(), null);
			return checkInParameter;
		} catch (Exception e) {
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.PersistenceDAO.getCheckInParameter : Exception "+e.getMessage());
			//e.printStackTrace();
		}
		return null;
	}
	
/*	public BigDecimal findParamative(String sql,boolean diff){
		JdbcFectory jdbc = new JdbcFectory(jndi);
		BigDecimal dafBusinessObject = new BigDecimal(0);
		try {
			dafBusinessObject = jdbc.getPrimitive(sql);	
			return dafBusinessObject;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String findParamative(String sql){
		JdbcFectory jdbc = new JdbcFectory(jndi);
		String dafBusinessObject = null;
		try {
			dafBusinessObject = jdbc.getStringPrimitive(sql);	
			return dafBusinessObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	public String findParamative(String sql){
		JdbcFectory jdbc = new JdbcFectory(jndi);
		//sql = "SELECT username,useremail from AWRFinanceNotificationUsers";
		try {
			CheckInParameter checkInParameter = jdbc.getEntity(sql, new CheckInParameter(), null);
			return checkInParameter.getParameter1();
		} catch (Exception e) {
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.PersistenceDAO.findParamative : Exception "+e.getMessage());
			//e.printStackTrace();
		}
		return null;
	}
	
	public void insertParamative(String sql,BigDecimal paramativeValue){
		DataWorker dataWorker = new DataWorker(sql, null, paramativeValue);
		JdbcFectory jdbc = new JdbcFectory(jndi);
		try {
			jdbc.executeDataWorkers(dataWorker);
		} catch (Exception e) {
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.PersistenceDAO.insertParamative : Exception "+e.getMessage());
			//e.printStackTrace();
		}
	}
	
}
