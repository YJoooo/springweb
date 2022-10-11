package springweb.a02_mvc.a01_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownLoadController {
//	 파일 위치 : src\main\webapp\z01_upload
//     http://localhost:7080/springweb/download10.do?filename=KakaoTalk_20220707_174916586.png  
//		viewer fileView01
	@RequestMapping("download10.do")
	public String download10(@RequestParam("filename") String filename, Model d) {
		d.addAttribute("downloadFileName",filename);
		return "fileView01";
	}
//		jsp에서 click(function(){location.href="${path}/download10.do?filename="+$("[name=filename]")
//		http://localhost:7080/springweb/download11.do?file01=KakaoTalk_20220707_174916586.png  
	@RequestMapping("download11.do")
	public String download11(@RequestParam("file01") String fname, Model d) {
		d.addAttribute("downloadFileName",fname);
		return "fileView01";
	}

}
