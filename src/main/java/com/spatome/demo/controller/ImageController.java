package com.spatome.demo.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spatome.demo.common.constants.ConfConstants;
import com.spatome.demo.vo.ImgVO;
import com.spatome.util.PropertiesUtil;
import com.spatome.util.SUtil;

@RestController
@RequestMapping(value = "/image")
public class ImageController extends BaseController {

	/** 
	 * @Description: 图片上传
	 * @param file
	 * @param type 见UploadTypeEnum定义
	 * @return 处理过的文件名
	 * @throws Exception
	 * @return: Object
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public Object upload(MultipartFile uploadFile, String type) throws Exception {
		BaseVO<ImgVO> result = new BaseVO<ImgVO>();
		ImgVO VO = new ImgVO();
		result.setBody(VO);

    	if(uploadFile==null){
    		result.setCodeMessage("9999", "file null");
    		return result;
    	}
    	if(StringUtils.isBlank(type)){
    		result.setCodeMessage("9999", "type null");
    		return result;
    	}

		String fileName = uploadFile.getOriginalFilename();
		LOGGER.info("上传fileName{{}}", fileName);
		String fileExtendName = StringUtils.substringAfter(fileName, ".");
		Path path = Paths.get(PropertiesUtil.getProperty(ConfConstants.FILE_PATH), type);
		String newFileName = SUtil.createNumberNo()+".png";

		if(StringUtils.isBlank(fileExtendName)) {
    		result.setCodeMessage("9999", "文件类型未知");
    		return result;
		}
		String canUploadFileType = PropertiesUtil.getProperty(ConfConstants.FILE_UPLOAD_TYPE);
		if(StringUtils.isNotBlank(canUploadFileType) && !canUploadFileType.toLowerCase().contains(fileExtendName)){
    		result.setCodeMessage("9999", "文件类型上传限制");
    		return result;
		}

		FileUtils.forceMkdir(path.toFile());
		uploadFile.transferTo(new File(path.toFile(), newFileName));

		//返回结果
		VO.setImageName(newFileName);
		VO.setImageUrl(PropertiesUtil.getProperty(ConfConstants.PROJECT_URL)+"/"+type+"/"+newFileName);

		return result;
	}

	/** 
	 * @Description: 调取图片
	 */
/*	@RequestMapping(value = "/{spacePath}/{fileName:.+}", method = RequestMethod.GET)
	public ResponseEntity<?> getImage(@PathVariable String spacePath, @PathVariable String fileName) {
		try {
			return ResponseEntity.ok((new DefaultResourceLoader()).getResource(
					"file:" + Paths.get(PropertiesUtil.getProperty(ConfConstants.FILE_BASE_PATH), spacePath, fileName).toString()));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}*/
}
