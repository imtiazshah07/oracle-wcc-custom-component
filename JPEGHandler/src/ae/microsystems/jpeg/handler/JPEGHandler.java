package ae.microsystems.jpeg.handler;

import java.io.File;
import java.util.Vector;

import org.apache.commons.io.FilenameUtils;

import intradoc.common.ExecutionContext;
import intradoc.common.FileUtils;
import intradoc.common.ServiceException;
import intradoc.data.DataBinder;
import intradoc.data.DataException;
import intradoc.data.Workspace;
import intradoc.shared.FilterImplementor;

public class JPEGHandler implements FilterImplementor {

	public int doFilter(Workspace ws, DataBinder binder, ExecutionContext cxt) throws DataException, ServiceException {

		String alloweddDocType = binder.getEnvironmentValue("dDocType");
		String alloweddSecurityGroup = binder.getEnvironmentValue("dSecurityGroup");

		if (binder.getLocal("dDocType").equalsIgnoreCase(alloweddDocType)
				&& binder.getLocal("dSecurityGroup").equalsIgnoreCase(alloweddSecurityGroup))
			converFile(ws, binder, cxt);

		return FilterImplementor.CONTINUE;
	}

	private void converFile(Workspace ws, DataBinder binder, ExecutionContext cxt) {
		binder.setContentType(binder.getEnvironmentValue("dContentType"));
		String newFileExtension = binder.getEnvironmentValue("dFileExtension");
		String nativeFileType = binder.getEnvironmentValue("dNativeFileType");
		Vector tempFileVector = binder.getTempFiles();
		if (!tempFileVector.isEmpty()) {
			String rawFileName = (String) tempFileVector.get(0);
			String newFileName = getFileName(rawFileName, newFileExtension,nativeFileType);
			File rawFile = new File(rawFileName);
			File newFile = new File(rawFile.getParent(), newFileName);
			if (rawFile.renameTo(newFile)) {
				tempFileVector.add(0, newFile.getAbsolutePath());
				binder.addTempFile(newFile.getAbsolutePath());
				binder.putLocal("primaryFile", newFileName);
				binder.putLocal("primaryFile:path", newFile.getAbsolutePath());
			}
		}
	}

	private String getFileName(String path, String ext,String nativeFileType) {
		String fileName = new File(path).getName();
		if (FileUtils.getExtension(fileName).equalsIgnoreCase(nativeFileType)) {
			String newFileName = FilenameUtils.removeExtension(fileName) + "." + ext;
			return newFileName;
		}
		return fileName;
	}

	public static void main(String ary[]) {
		System.out.println(" Component Compile and Execute...");
	}

}
