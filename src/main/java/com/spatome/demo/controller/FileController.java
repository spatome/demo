package com.spatome.demo.controller;
//package com.hengpeng.qmdlb.controller;
//
//import java.io.File;
//import java.nio.file.Paths;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang.RandomStringUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.hengpeng.qmdlb.common.constants.ConfConstants;
//import com.hengpeng.qmdlb.common.exception.SException;
//import com.hengpeng.qmdlb.vo.SSVO;
//import com.hengpeng.util.DateUtil;
//import com.hengpeng.util.PropertiesUtil;
//
//@RestController
//@RequestMapping(value = "/file")
//public class FileController extends BaseController {
//
//	/** 
//	 * @Description: 文件上传
//	 * @param file
//	 * @return 处理过的文件名
//	 * @throws Exception
//	 * @return: Object
//	 */
//	@RequestMapping(value = "upload/excel/{activityId}", method = RequestMethod.POST)
//	public Object upload(@PathVariable Long activityId, MultipartFile file, String type) throws Exception {
//		type = "excel";
//
//		BaseVO<SSVO> result = new BaseVO<SSVO>();
//
//    	if(file==null){
//    		result.setCodeMessage("9999", "file null");
//    		return result;
//    	}
//
//		String fileName = file.getOriginalFilename();
//		LOGGER.info("fileName{{}}", fileName);
//		String extendName = StringUtils.substringAfter(fileName, ".");
//		String filePath = PropertiesUtil.getProperty(ConfConstants.FILE_BASE_PATH)+File.separator+type;
//		String newFileName = DateUtil.formatDate(new Date(), DateUtil.LONG_DATE_FORMAT_NO_SPLIT)+RandomStringUtils.randomAlphanumeric(4)+"-"+fileName;
//
//		if(StringUtils.isBlank(extendName)) {
//    		result.setCodeMessage("9999", "文件类型未知");
//    		return result;
//		}
//		String canUploadType = PropertiesUtil.getProperty(ConfConstants.FILE_UPLOAD_TYPE);
//		if(StringUtils.isNotBlank(canUploadType) && !canUploadType.toLowerCase().contains(extendName)){
//    		result.setCodeMessage("9999", "文件类型上传限制");
//    		return result;
//		}
//
//		FileUtils.forceMkdir(new File(filePath));
//		file.transferTo(new File(filePath, newFileName));
//
//		LOGGER.info("业务处理");
//		SException sException = serviceFactory.getExcelFileService().disposeGoods(activityId, Paths.get(filePath, newFileName));
//
//		result.setMessage(sException.getMessage());
//		result.setBody(new SSVO(newFileName));
//		return result;
//	}
//
//	/** 
//	 * @Description: 下载Excel文件
//	 */
//	@RequestMapping(value = "/excel/{fileName:.+}", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) throws Exception {
//        String path = Paths.get(PropertiesUtil.getProperty(ConfConstants.FILE_BASE_PATH), "excel", fileName).toString();  
//        File file=new File(path);
//        HttpHeaders headers = new HttpHeaders();
//        String newFileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
//        headers.setContentDispositionFormData("attachment", newFileName);
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
//	}
//}
