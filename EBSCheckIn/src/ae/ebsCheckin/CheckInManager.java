package ae.ebsCheckin;

import java.util.Date;

import ae.ebsCheckin.component.data.CheckInParameter;
import ae.ebsCheckin.database.PersistenceDAO;
import ae.ebsCheckin.util.EBSCheckInConstants;

public class CheckInManager {
	
	public void getBusinessObject(CheckInParameter parameter){
		PersistenceDAO dao = new PersistenceDAO(parameter.getAxfDataSource());
		
		String wccFields = parameter.getWccFields();
		String eBSCorresponding = parameter.geteBSCorresponding();
		//parameter.setBusinessObjectType(parameter.getEbsTable());
		
		/*if(parameter.getdDocType().equalsIgnoreCase(EBSCheckInConstants.DDOCTYPE_JOURNAL_VOUCHER)){
			parameter.setEbsPrimaryKey(getPrimaryKey(parameter.getEbsPrimaryKey()));
			
			String selectSQL = getEBSDynamicSQL(parameter.getEbsTable(),parameter.getEbsPrimaryKey(),wccFields,eBSCorresponding);
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn Sql Query @ "+selectSQL);
			
			CheckInParameter checkInParameterObj = dao.getCheckInParameter(selectSQL);
			if(checkInParameterObj != null){
				parameter.setBusinessObject(checkInParameterObj.getParameter1()+"|"+checkInParameterObj.getParameter2());
			}	
		}
		/*else if(parameter.getdDocType().equalsIgnoreCase(EBSCheckInConstants.DDOCTYPE_POSSESSION_CERTIFICATE)){
		
		}*/
		/*else if(parameter.getdDocType().equalsIgnoreCase(EBSCheckInConstants.DDOCTYPE_PREPAYMENT)){
			String vendorIdSql = "SELECT VENDOR_ID FROM AP_SUPPLIERS WHERE SEGMENT1 = '"+wccFields+"'";
			 BigDecimal  vendorId = dao.findParamative(vendorIdSql);
			 String selectSQL = getEBSDynamicSQL(parameter.getEbsTable(),parameter.getEbsPrimaryKey(),vendorId.toString(),eBSCorresponding);
			 System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn Sql Query @ "+selectSQL);
			 BigDecimal businessObject = dao.findParamative(selectSQL);
				//BigDecimal id = new BigDecimal(35425);
				parameter.setBusinessObjectType(parameter.getEbsTable());
				if(businessObject != null)
					parameter.setBusinessObject(businessObject.toString());
		}* /
		else if(parameter.getdDocType().equalsIgnoreCase(EBSCheckInConstants.DDOCTYPE_CUSTOMER_EXIT_ENTRY_CERTIFICATE)){
			String selectValues = getPrimaryKey(parameter.getCeecReferenceKey());
			String selectSQL = getEBSDynamicSQL(parameter.getCeecReferenceTable(),selectValues,wccFields,parameter.getCeecReferenceParameter());
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn CheckInManager.getBusinessObject[CEEC] Reference Sql Query @ "+selectSQL);
			CheckInParameter checkInParameterObj = dao.getCheckInParameter(selectSQL);
			if(checkInParameterObj != null){
				String values = checkInParameterObj.getParameter1() +","+checkInParameterObj.getParameter2();
				String sql = getEBSDynamicSQL(parameter.getEbsTable(),parameter.getEbsPrimaryKey(),values,parameter.getCeecReferenceKey());
				System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn CheckInManager.getBusinessObject[CEEC] BusinessObject Sql Query @ "+sql);
				BigDecimal businessObject = dao.findParamative(sql);
				if(businessObject != null)
					parameter.setBusinessObject(businessObject.toString());
				//parameter.setBusinessObject(checkInParameterObj.getParameter1()+"|"+checkInParameterObj.getParameter2());
			}	
		}
		else 
		{*/
			String selectSQL = getEBSDynamicSQL(parameter.getEbsTable(),parameter.getEbsPrimaryKey(),wccFields,eBSCorresponding);
			 if(parameter.getdDocType().equalsIgnoreCase(EBSCheckInConstants.DDOCTYPE_CUSTOMER_EXIT_ENTRY_CERTIFICATE)
					 || parameter.getdDocType().equalsIgnoreCase(EBSCheckInConstants.DDOCTYPE_BOE)){
				if(wccFields.indexOf("-")>0){
					String withoutHifonWccFields = wccFields.replaceAll("-", "");
					selectSQL = selectSQL + " OR "+eBSCorresponding+"="+withoutHifonWccFields;
				}
			 }
			System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn Sql Query @ "+selectSQL);
			
			String businessObject = dao.findParamative(selectSQL);
			//BigDecimal id = new BigDecimal(35425);
			
			if(businessObject != null)
				parameter.setBusinessObject(businessObject);
			

		//}
	   //String inserSQL = getInsertDynamicSQL();
	}	
	
	private String getEBSDynamicSQL(String ebsTable,String primaryKey,String wccField,String ebsCorresponding){
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT "+primaryKey+" AS parameter1 FROM "+ebsTable);
		sql.append(" WHERE ");
		String wccFieldArray [] = wccField.split(",");
		String correspondingArray [] = ebsCorresponding.split(",");
		int i=0;
		for(String ebsco : correspondingArray){
			sql.append(" "+ebsco+"='"+wccFieldArray[i]+"'");
			sql.append(" AND");
			i++;
		}
		return sql.substring(0, sql.length()-3).toString();
	}
	
	public void getBusinessObjectJournalVoucher(CheckInParameter parameter){
		//PersistenceDAO dao = new PersistenceDAO(parameter.getAxfDataSource());
		
		String wccFields = parameter.getWccFields();
		String eBSCorresponding = parameter.geteBSCorresponding();
		
		String selectSQL = getEBSDynamicSQL(parameter.getEbsTable(),parameter.getEbsPrimaryKey(),wccFields,eBSCorresponding);
		System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn Sql Query @ "+selectSQL);
		
	}

	private String getPrimaryKey(String primaryKey){
		String primaryKeyObj [] = primaryKey.split(",");
		StringBuilder object = new StringBuilder();
		int i=1;
		for(String obj :  primaryKeyObj){
			object.append(obj+" AS parameter"+i+",");
			i++;
		}
		return object.toString().substring(0, object.toString().length()-1);	
	}
	
	public static void main(String ary[]){
		System.out.println(new CheckInManager().getPrimaryKey("JE_BATCH_ID,JE_HEADER_ID"));
	}
}
