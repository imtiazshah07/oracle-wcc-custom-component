package test.ae.msc;



import java.io.File;
import java.util.Date;
import java.util.Vector;

import org.apache.commons.io.FilenameUtils;

import intradoc.common.ExecutionContext;
import intradoc.common.FileUtils;
import intradoc.common.ServiceException;
import intradoc.data.DataBinder;
import intradoc.data.DataException;
import intradoc.data.Workspace;
import intradoc.shared.FilterImplementor;

public class JPEGHandlerCopy implements FilterImplementor{

	public int doFilter(Workspace ws, DataBinder binder, ExecutionContext cxt)
			throws DataException, ServiceException {
		
		String ridcService = binder.getLocal("IdcService");
		String dDocName =  binder.getLocal("dDocName");
		String dID =  binder.getLocal("dID");
		String dDocType = binder.getLocal("dDocType");

		System.out.println("ridcService: "+ridcService+", dDocName:"+dDocName+", dID: "+dID+", dDocType:"+dDocType);
		
		if(binder.getLocal("dDocType").equalsIgnoreCase("ITDocument") && binder.getLocal("dSecurityGroup").equalsIgnoreCase("FinanceDocument"))
			updateFilePath(ws,binder,cxt);
		
		return FilterImplementor.CONTINUE;
	}
	
		

	private void updateFilePath(Workspace ws, DataBinder binder, ExecutionContext cxt){
		System.out.println("****************************************************************************************************");
		System.out.println("<"+new Date().toString()+"> <Notice> EBSCheckIn.EBSCheckInComponent Continue with cutomized process ");
		System.out.println(" Content Type: "+binder.getContentType());
		binder.setContentType("image/jpg");
		
		Vector tempFileVector = binder.getTempFiles();
	
		System.out.println("Size : "+tempFileVector.size());
		
		
		if(!tempFileVector.isEmpty()){
			String rawFileName = (String)tempFileVector.get(0);
			String newFileName = getFileName(rawFileName);
			
			/*Object obj =  tempFileVector.get(0);			
			//File file = new File(obj.toString());
			String newFileName = obj.toString().substring(0, obj.toString().length()-1);
				newFileName = newFileName + "jpg";
			//File newFile = new File(newFileName); 
			System.out.println(" Vector: "+obj.toString());
			System.out.println(" File : "+newFileName);
			try {
				FileUtils f = new FileUtils();
				f.copyFile(obj.toString(), newFileName);
				binder.addTempFile(newFileName);
				tempFileVector.add(0, newFileName);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			File rawFile = new File(rawFileName);
			File newFile = new File(rawFile.getParent(), newFileName);
			if(rawFile.renameTo(newFile)){
				System.out.println(" Successfully Renamed : "+newFile.getAbsolutePath());
				tempFileVector.add(0, newFile.getAbsolutePath());
				binder.addTempFile(newFile.getAbsolutePath());
				binder.putLocal("primaryFile", newFileName);
				binder.putLocal("primaryFile:path", newFile.getAbsolutePath());
			}
		}

		
		System.out.println("****************************************************************************************************");
		System.out.println(" ToString : "+binder.toString());
		System.out.println("****************************************************************************************************");
		System.out.println("****************************************************************************************************");
	}

	private String getFileName(String path){
		String fileName = new File(path).getName();
		if(FileUtils.getExtension(fileName).equalsIgnoreCase("1")){
			String newFileName = FilenameUtils.removeExtension(fileName)+".jpg";
			return newFileName;
		}
		return fileName;
	}
	
	
	public static void main(String ary[]){
		System.out.println(" Component Compile and Execute...");
	}


	
}
