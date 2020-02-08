package ae.test.ebscheckin.main;

public class TestEBSCheckIn {

	public static void main(String ary[]) {

//			CheckInParameter parameter = new CheckInParameter();
//		 	parameter.setdDocType("HR");
//		 	
//		 	parameter.setEbsTable("PER_PEOPLE_F");
//		 	parameter.setEbsPrimaryKey("PERSON_ID");
//		 	parameter.setdDocName("AWR001807");
//		 	
//		 	parameter.setWccFields("6562,imtiaz,19855,12/13/2013");
//		 	parameter.seteBSCorresponding("EMPLOYEE_NUMBER,xEmployeeName,xReferenceNumber,xDocumentDate");
//		 	
//		 	
//		 	
//		new  CheckInManager().getBusinessObject(parameter);

		String wccFields = "14-1-2-06045684";

		if (wccFields.indexOf("-") > 0) {
			String withoutHifonWccFields = wccFields.replaceAll("-", "");
			System.out.println(withoutHifonWccFields);
		}

	}

}
