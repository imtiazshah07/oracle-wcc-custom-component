package ae.ebsCheckin.component.data;

import ae.mscJdbcUtility.data.IData;

public class CheckInParameter implements IData{
	private String axfDataSource;
	private String csdcDataSource;
	
	private String application;
	private String dDocName;
	private String dDocType;

	private String ebsTable;
	private String ebsPrimaryKey;
	
	private String wccFields;
	private String eBSCorresponding;
	
	private String businessObjectType;
	private String businessObject;
	
	private String ceecReferenceKey;
	private String ceecReferenceTable;
	private String ceecReferenceParameter;
	
	
	private String parameter1;
	private String parameter2;
	private String parameter3;
	private String parameter4;
	private String parameter5;
	private String parameter6;
	private String parameter7;
	private String parameter8;
	private String parameter9;
	private String parameter10;
	private String parameter11;
	
	
	public String getAxfDataSource() {
		return axfDataSource;
	}
	public void setAxfDataSource(String axfDataSource) {
		this.axfDataSource = axfDataSource;
	}
	public String getCsdcDataSource() {
		return csdcDataSource;
	}
	public void setCsdcDataSource(String csdcDataSource) {
		this.csdcDataSource = csdcDataSource;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getdDocName() {
		return dDocName;
	}
	public void setdDocName(String dDocName) {
		this.dDocName = dDocName;
	}
	public String getdDocType() {
		return dDocType;
	}
	public void setdDocType(String dDocType) {
		this.dDocType = dDocType;
	}
	public String getEbsTable() {
		return ebsTable;
	}
	public void setEbsTable(String ebsTable) {
		this.ebsTable = ebsTable;
	}
	public String getEbsPrimaryKey() {
		return ebsPrimaryKey;
	}
	public void setEbsPrimaryKey(String ebsPrimaryKey) {
		this.ebsPrimaryKey = ebsPrimaryKey;
	}
	public String getWccFields() {
		return wccFields;
	}
	public void setWccFields(String wccFields) {
		this.wccFields = wccFields;
	}
	public String geteBSCorresponding() {
		return eBSCorresponding;
	}
	public void seteBSCorresponding(String eBSCorresponding) {
		this.eBSCorresponding = eBSCorresponding;
	}
	public String getBusinessObjectType() {
		return businessObjectType;
	}
	public void setBusinessObjectType(String businessObjectType) {
		this.businessObjectType = businessObjectType;
	}
	public String getBusinessObject() {
		return businessObject;
	}
	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}
	
	public String getCeecReferenceParameter() {
		return ceecReferenceParameter;
	}
	public void setCeecReferenceParameter(String ceecReferenceParameter) {
		this.ceecReferenceParameter = ceecReferenceParameter;
	}
	public String getCeecReferenceKey() {
		return ceecReferenceKey;
	}
	public void setCeecReferenceKey(String ceecReferenceKey) {
		this.ceecReferenceKey = ceecReferenceKey;
	}
	public String getCeecReferenceTable() {
		return ceecReferenceTable;
	}
	public void setCeecReferenceTable(String ceecReferenceTable) {
		this.ceecReferenceTable = ceecReferenceTable;
	}
	public String getParameter1() {
		return parameter1;
	}
	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}
	public String getParameter2() {
		return parameter2;
	}
	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}
	public String getParameter3() {
		return parameter3;
	}
	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}
	
	
	
	
	public String getParameter4() {
		return parameter4;
	}
	public void setParameter4(String parameter4) {
		this.parameter4 = parameter4;
	}
	public String getParameter5() {
		return parameter5;
	}
	public void setParameter5(String parameter5) {
		this.parameter5 = parameter5;
	}
	public String getParameter6() {
		return parameter6;
	}
	public void setParameter6(String parameter6) {
		this.parameter6 = parameter6;
	}
	public String getParameter7() {
		return parameter7;
	}
	public void setParameter7(String parameter7) {
		this.parameter7 = parameter7;
	}
	public String getParameter8() {
		return parameter8;
	}
	public void setParameter8(String parameter8) {
		this.parameter8 = parameter8;
	}
	public String getParameter9() {
		return parameter9;
	}
	public void setParameter9(String parameter9) {
		this.parameter9 = parameter9;
	}
	public String getParameter10() {
		return parameter10;
	}
	public void setParameter10(String parameter10) {
		this.parameter10 = parameter10;
	}
	public String getParameter11() {
		return parameter11;
	}
	public void setParameter11(String parameter11) {
		this.parameter11 = parameter11;
	}
	@Override
	public String toString() {
		return "CheckInParameter [axfDataSource=" + axfDataSource
				+ ", csdcDataSource=" + csdcDataSource + ", application="
				+ application + ", dDocName=" + dDocName + ", dDocType="
				+ dDocType + ", ebsTable=" + ebsTable + ", ebsPrimaryKey="
				+ ebsPrimaryKey + ", wccFields=" + wccFields
				+ ", eBSCorresponding=" + eBSCorresponding
				+ ", businessObjectType=" + businessObjectType
				+ ", businessObject=" + businessObject + ", parameter1="
				+ parameter1 + ", parameter2=" + parameter2 + ", parameter3="
				+ parameter3 + "]";
	}
	
	
	
	
	
	
//	private String wccFieldsHRD;
//	private String EBSCorrespondingHRD;
//	
//	//private String wccFieldsInvoice;
//	//private String EBSCorrespondingInvoice;
//	
//	private String wccFieldsIOC;
//	private String EBSCorrespondingIOC;
//	
//	private String wccFieldsSPQ;
//	private String EBSCorrespondingSPQ;
//	
//	private String wccFieldsPC;
//	private String EBSCorrespondingPC;
//	
//	private String wccFieldsSI;
//	private String EBSCorrespondingSI;
//	
//	private String wccFieldsMD050;
//	private String EBSCorrespondingMD050;
//	
//	private String wccFieldsPAF;
//	private String EBSCorrespondingPAF;
//	
//	private String wccFieldsBOE;
//	private String EBSCorrespondingBOE;
//	
//	private String wccFieldsCD;
//	private String EBSCorrespondingCD;
//	
//	private String wccFieldsCF;
//	private String EBSCorrespondingCF;
//	
//	private String wccFieldsSR;
//	private String EBSCorrespondingSR;
//	
//	private String wccFieldsCA;
//	private String EBSCorrespondingCA;
//	
//	private String wccFieldsDN;
//	private String EBSCorrespondingDN;
//	
//	private String wccFieldsRC;
//	private String EBSCorrespondingRC;
//	
//	private String wccFieldsGRN;
//	private String EBSCorrespondingGRN;
//	
//	private String wccFieldsCPA;
//	private String EBSCorrespondingCPA;
//	
//	private String wccFieldsPV;
//	private String EBSCorrespondingPV;
//	
//	private String wccFieldsNonLPO;
//	private String EBSCorrespondingNonLPO;
//	
//	private String wccFieldsPrepayment;
//	private String EBSCorrespondingPrepayment;
//	
//	private String wccFieldsIOU;
//	private String EBSCorrespondingIOU;
//		
//	private String wccFieldsCN;
//	private String EBSCorrespondingCN;
//	
//	private String wccFieldsJV;
//	private String EBSCorrespondingJV;
//	
//	private String wccFieldsCEEC;
//	private String EBSCorrespondingCEEC;
//	
//	private String wccFieldsHRFP;
//	private String EBSCorrespondingHRFP;
//	
//	private String wccFieldsPA;
//	private String EBSCorrespondingPA;
//	
//	private String wccFieldsPO;
//	private String EBSCorrespondingPO;
//	
//	private String wccFieldsCLPO;
//	private String EBSCorrespondingCLPO;
//	
//	private String wccFieldsVLPO;
//	private String EBSCorrespondingVLPO;
//	
//	
	
	
	
	
	
	
	
	
	
}


/*
Inter Office Communication : IOC
Supplier Pre-Qualification : SPQ
Possession Certificate : PC
Sales Invoice :  	 SI
MD050 : MD050
Purchase Approval Form	: PAF
Bill of Entry : BOE
Customers Documents : CD
Credit Facilities : CF
Sales Recommendation : SR
Credit Approval : CA
Delivery Note : DN
Receipt Copy : RC
Goods Received Note : GRN
Customer Payment Advise : CPA
Payment Voucher : PV
Non LPO Payment : NonLPO
Prepayment : Prepayment
IOU :  IOU
Credit Note : CN
Journal Voucher : JV
Customs Exit / Entry Certificate : CEEC
HR Forms and Policies : HRFP
Purchase Agreement : 	PA
Purchase Order : PO
Customer Local Purchase Order  : CLPO
Vendor Local Purchase Order	: VLPO


HR Documents  :  HR
Inter Office Communication : IOC
Supplier Pre-Qualification : SPQ
Possession Certificate : PC
Sales Invoice : SI
MD050 : MD050
Bill of Entry  : BOE
Customers Documents : CD
Credit Facilities : CF
 Sales Recommendation : SR
Credit Approval : CA
Delivery Note : DN
Receipt Copy : RC
Goods Received Note  : GRN
Customer Payment Advise : CPA
Payment Voucher : PV
Non LPO Payment : NonLPO
Prepayment : Prepayment
IOU : IOU
Credit Note : CN
Journal Voucher : JV
Customs Exit / Entry Certificate : CEEC
HR Forms and Policies : HRFP
 Purchase Agreement : PA
Purchase Order : PO
Customer Local Purchase Order : CLPO
Vendor Local Purchase Order : VLPO

*/

/*
DocumentType=HRD,Invoice
EBSTable=PER_PEOPLE_F,AP_INVOICES 
EBSPrimaryKey=PERSON_ID,INVOICE_ID 

WCCFields_HRD=EmployeeNumber
EBSCorresponding_HRD=EMPLOYEE_NUMBER

WCCFieldsInvoice=InvoiceNumber,VendorNumber
EBSCorresponding_Invoice=INVOICE_NUMBER,VENDOR_NUMBER
*/

