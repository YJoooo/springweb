package springweb.a02_mvc.a01_controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import springweb.a02_mvc.a02_service.FileUploadService;
import springweb.a02_mvc.a04_vo.FileVo;
// springweb.a02_mvc.a01_controller.FileUploadController
@Controller
public class FileUploadController {
	// 1. 파일업로드 연습을 위한 초기 화면
	// http://localhost:7080/springweb/uploadForm01.do
	@GetMapping("uploadForm01.do")  //get 방식 호출
	public String uploadForm01() {
		return "WEB-INF\\views\\a02_mvc\\a10_fileUpload.jsp";
	}
	// 15:15~
	@PostMapping("uploadForm01.do")	// post 방식 호출
	public String uploadForm02(@RequestParam("report") MultipartFile report) {
		// MultipartFile : stream 방식으로 client ==> server로 파일을 가져왔을 때, 받을 수 있음.
		System.out.println("업로드된 파일명:"+report.getOriginalFilename());
		return "WEB-INF\\views\\a02_mvc\\a10_fileUpload.jsp";
	}	
	// ex) a11_fileUpload.jsp uploadForm02.do
	//     <input name="fileData" /> 로 파일이 업로드된 것을 확인하세요.
	// http://localhost:7080/springweb/uploadForm02.do
	@GetMapping("uploadForm02.do")
	public String uploadForm02_2() {
		return "WEB-INF\\views\\a02_mvc\\a11_fileUpload.jsp";
	}	
	@PostMapping("uploadForm02.do")
	public String uploadForm02_1(@RequestParam("fileData") MultipartFile fileData) {
		System.out.println("업로드할 파일명:"+fileData.getOriginalFilename());
		String fname = fileData.getOriginalFilename();
		// 경로를 지정하여 파일 객체 생성
		String path = "C:\\a01_javaexp\\workspace\\springweb\\src\\main\\webapp\\z01_upload\\";
		File f = new File(path+fname);
		// MultipartFile ==> File 변환..
		try {
			fileData.transferTo(f);
			System.out.println("파일 업로드 완료");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "WEB-INF\\views\\a02_mvc\\a11_fileUpload.jsp";
	}
	// // http://localhost:7080/springweb/fileUpload06.do
	@GetMapping("fileUpload06.do")
	public String fileUpload06() {
		
		return "z10_homework\\0719.jsp";
	}
	@Autowired(required = false)
	private FileUploadService service;
	
	@PostMapping("fileUpload06.do")
	public String fileUpload06_post(FileVo fo, Model d) {
		
		System.out.println(fo.getTitle());
		String fname =fo.getAddFile().getOriginalFilename();
		service.upload(fo);
		
		System.out.println(fo.getAddFile().getOriginalFilename());
		d.addAttribute("msg", fname+"파일 업로드 성공");
		
		
		return "z10_homework\\0719.jsp";
	}	
	
	
	
	
}
