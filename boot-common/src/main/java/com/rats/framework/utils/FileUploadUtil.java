package com.rats.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

/**
 * 文件上传、下载工具类
 */
public class FileUploadUtil {
	
	// 上传路径
	public static final String UPLAOD_PATH = "/upload";

	/**
	 * 重命名
	 * @param orderId
	 * @param filename
	 * @return
	 */
	public static String rename(String orderId, String filename) {
		String ext = "";
		if(filename.lastIndexOf('.') > -1){
			ext = filename.substring(filename.lastIndexOf('.'));
		}
		return "AbilityTestFile-" + orderId + ext ;
	}

	/**
	 * 处理上传的方法,将上传上来的文件写到上传路径下
	 * @param testFile - form表单提交上来的文件
	 * @param rename
	 * @param request
	 * @throws IOException
	 */
	public static void upload(DefaultMultipartHttpServletRequest request, String fileId, String rename) throws IOException {
		CommonsMultipartFile upFile = (CommonsMultipartFile) request.getFile(fileId); 
		if (!upFile.isEmpty()) {
			String name = upFile.getOriginalFilename();
			String path = request.getSession().getServletContext()
					.getRealPath(UPLAOD_PATH);
			FileCopyUtils.copy(upFile.getBytes(), new File(path + "/"
					+ rename));
		}
	}
	
	/**
	 * 处理上传的方法,将上传上来的文件写到指定路径下
	 * @param testFile - form表单提交上来的文件
	 * @param rename
	 * @param request
	 * @throws IOException
	 */
	public static void upload(DefaultMultipartHttpServletRequest request, String fileId, String rename, String filePath) throws IOException {
		CommonsMultipartFile upFile = (CommonsMultipartFile) request.getFile(fileId); 
		if (!upFile.isEmpty()) {
			if(!filePath.endsWith(File.separator)) {
				filePath += File.separator;
			}
			filePath += rename;
			FileCopyUtils.copy(upFile.getBytes(), new File(filePath));
		}
	}
	
	/**
	 * 处理文件上传 
	 * @param request - form表单提交request
	 * @param fileId
	 * @return byte[] - 返回文件的二进制数组
	 */
	public static byte[] getUploadFile(DefaultMultipartHttpServletRequest request, String fileId) throws IOException{
		// 获取表单提交的文件
		CommonsMultipartFile file = (CommonsMultipartFile) request.getFile(fileId); 
		byte[] bytes = null;
		InputStream is = null;
		try {
			is = file.getInputStream();  
			bytes = new byte[(int) file.getSize()];  
		    is.read(bytes);  
		    
		    //imgBytes = imgFile.getBytes();
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				is.close();
			} catch (IOException e2) {
				is = null;
			}
		}
		return bytes;
	}
	
	/**
	 * 处理下载的方法
	 * @param downloadFileName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void download(String downloadFileName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String path = request.getSession().getServletContext().getRealPath(UPLAOD_PATH);

		download(downloadFileName, path, request, response);
	}

	
	/**
	 * 处理下载
	 * @param downloadFileName
	 * @param parentPath
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void download(String downloadFileName, String parentPath, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ downloadFileName);
		response.setContentType("application/octet-stream; charset=UTF-8");

		InputStream ins = null;
		OutputStream os = null;
		try {
			if(!parentPath.endsWith(File.separator)) {
				parentPath += File.separator;
			}
			parentPath += downloadFileName;
			
			ins = new FileInputStream(new File(parentPath));
			os = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;
			while ((length = ins.read(b)) > 0) {
				os.write(b, 0, length);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				ins.close();
			}
		}
	}
}
