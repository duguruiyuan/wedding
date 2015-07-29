package com.fh.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Iterator;

import com.google.common.base.Splitter;
import com.google.common.io.ByteStreams;

public class FileUtil {

	public static void main(String[] args) {
		String dirName = "d:/FH/topic/";// 创建目录
		FileUtil.createDir(dirName);
	}

	/**
	 * 创建目录
	 * 
	 * @param destDirName
	 *            目标目录名
	 * @return 目录创建成功返回true，否则返回false
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建单个目录
		if (dir.mkdirs()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 读取到字节数组0
	 * 
	 * @param filePath
	 *            //路径
	 * @throws IOException
	 */
	public static byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length
				&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		fi.close();
		return buffer;
	}

	/**
	 * 读取到字节数组1
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(f));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bos.close();
		}
	}

	/**
	 * 读取到字节数组2
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray2(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}

		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray3(String filePath) throws IOException {

		FileChannel fc = null;
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(filePath, "r");
			fc = rf.getChannel();
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
					fc.size()).load();
			// System.out.println(byteBuffer.isLoaded());
			byte[] result = new byte[(int) fc.size()];
			if (byteBuffer.remaining() > 0) {
				// System.out.println("remain");
				byteBuffer.get(result, 0, byteBuffer.remaining());
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				rf.close();
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static final String rootPath = new PropertiesLoader(
			"dbconfig.properties").getProperty("upload.root.path");

	/**
	 * 构建文件上传的路径
	 * 
	 * @author SM
	 * @param
	 * 
	 * @return 上传的路径
	 */
	public static String builderUploadPath(String type, Long id) {
		// 从配置文件里取得文件上传的根路径:如,d:\\upload
		// 这里是组成文件上传的目录,组合方式:类型/ID/文件名
		return rootPath + "/" + type + "/" + id + "/";
	}

	/**
	 * 上传文件
	 * 
	 * @author SM
	 * @param byte[] 需要上传文件的比特
	 * @param uploadPath
	 *            上传路径
	 * @param uploadFileName
	 *            上传的文件名(即重命名的文件名)
	 * @return 是否上传成功
	 * @throws IOException
	 */
	public static String upload(String uploadPath, String fileName,
			InputStream inputStream) throws IOException {
		String allPath = uploadPath + fileName;
		File file = new File(allPath);// 构建上传文件
		mkDir(uploadPath);// 判断目录是否存在,创建一个目录，并修改目录权限为777
		InputStream bufferInputStream = new BufferedInputStream(inputStream);
		OutputStream bufferOutputStream = new BufferedOutputStream(
				new FileOutputStream(file));
		try {
			ByteStreams.copy(bufferInputStream, bufferOutputStream);
		} finally {
			if (null != bufferInputStream) {
				bufferInputStream.close();
			}
			if (null != bufferOutputStream) {
				bufferOutputStream.close();
			}
		}
		return allPath;
	}

	/**
	 * 根据目录名创建目录，目录权限为777
	 */
	public static void mkDir(String pathName) {
		File file = new File(pathName);
		if (file.exists()) {
			return;
		}
		if (file.mkdirs()) {
			file.setExecutable(true, false);
			file.setReadable(true, false);
			file.setWritable(true, false);
			return;
		}
		/*
		 * File canonFile = null; try { canonFile = file.getCanonicalFile(); }
		 * catch (IOException e) { return; } File parent =
		 * canonFile.getParentFile(); mkDir(parent.getPath());
		 * mkDir(canonFile.getPath());
		 */
	}

	/**
	 * 构建新的文件名,文件名生成规则,UUID+原文件名后缀。
	 * 
	 * @author SM
	 * @param fileName
	 *            原文件名
	 * @return 新生成的文件名
	 */
	public static String builderNewFileName(String fileName) {
		return Identities.uuid() + "." + getExtension(fileName);
	}

	/**
	 * 返回文件的后缀名
	 * 
	 * @author SM
	 * @param fileName
	 *            文件名
	 * @return 后缀名
	 */
	public static String getExtension(String fileName) {

		Iterator<String> iterable = Splitter.on('.').split(fileName).iterator();
		String postfix = "";
		while (iterable.hasNext()) {
			postfix = iterable.next().trim();
		}
		return postfix;

	}

	/**
	 * 下载文件
	 * 
	 * @author SM
	 * @param downloadPath
	 *            下载的地址
	 * @return 文件流
	 */
	public static byte[] download(String downloadPath) throws IOException {
		File file = new File(downloadPath);// 构建下载文件
		InputStream bufferInputStream = new BufferedInputStream(
				new FileInputStream(file));
		try {
			return ByteStreams.toByteArray(bufferInputStream);
		} finally {
			if (null != bufferInputStream) {
				bufferInputStream.close();
			}

		}
	}

	public static byte[] downloadNio(String downloadPath) throws IOException {
		RandomAccessFile file = new RandomAccessFile(downloadPath, "rw");// 构建下载文件
		FileChannel fileChannel = file.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(48);
		int bytesRead = fileChannel.read(buffer);
		while (bytesRead != -1) {
			buffer.flip();
		}
		return null;
	}

}