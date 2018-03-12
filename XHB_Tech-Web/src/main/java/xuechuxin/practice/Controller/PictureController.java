package xuechuxin.practice.Controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;




/**
 * 图片上传处理Controller
 * <p>Title: PictureController</p>
 * <p>Description: </p>
 * <p>Author:xuechuxin</p> 
 * @version 1.0
 */
@Controller
public class PictureController {
	
	/** 
     * 把图片上传到web工程
     * @return 返回图片所在硬盘的绝对地址
     */  
	@RequestMapping(value="/upload", produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		try {
			
			//设置图片的名称
			String picName = UUID.randomUUID().toString();		
			//获取源文件的扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.indexOf("."));
			//设置上传文件夹的地址
			uploadFile.transferTo(new File("G:/java/XHB_Tech/XHB_Tech-Web/src/main/webapp/img/"+picName+extName));
			//得到文件的相对地址和文件名
			String url = "/img/"+picName+extName;
			//封装到map返回
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			String json=JSONUtils.toJSONString(result);
			return json;
		}catch(Exception e) {
			e.printStackTrace();
			Map result =  new HashMap<>();
			result.put("error", 1);
			result.put("message","图片上传失败");
			String json=JSONUtils.toJSONString(result);
			return json;
		}
	}
}
