package com.banana.spytutors.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.activation.MimetypesFileTypeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Component;


/**
 * 
 * @author ANKEM
 *
 */
@ManagedBean(name = "fileUploadBean")
@SessionScoped
@Component
public class FileUploadBean implements Serializable {

	private static final long serialVersionUID = -1739043523263499225L;
	
	private static final Logger LOGGER = Logger.getLogger(FileUploadBean.class);

	private String destination = "C:\\images\\";
	
	private String fileMetadataPath;

	private UploadedFile file;
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}	

	public String getFileMetadataPath() {
		return fileMetadataPath;
	}

	public void setFileMetadataPath(String fileMetadataPath) {
		this.fileMetadataPath = fileMetadataPath;
	}

	public void upload(FileUploadEvent event) {

		// Do what you want with the file
		try {
			setFile(null);
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());	
			setFile(event.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination
					+ fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			LOGGER.info("New File uploaded :::: "+fileName);
		} catch (IOException e) {
			LOGGER.error("Error Occured while uploading the file :::::: ",e);
		}
	}

	public StreamedContent getFileToDisplay() throws IOException {
	    if(file != null) {
	    	String fileName = getFile().getFileName();
	    	setFileMetadataPath("C:\\images\\"+fileName);
	    	MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
	    	String mimeType = mimeTypesMap.getContentType(fileName);
	        return new DefaultStreamedContent(new FileInputStream("C:/images/"+fileName), mimeType);	       
	    }
	    else {
	        return null;
	    }
	}

}
