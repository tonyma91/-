package com.wu.demo.fileupload.demo.controller;

import com.wu.demo.fileupload.demo.util.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class TestController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public TestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path="/home/mi/桌面/FileUploadDemo-master/src/main/resources/static/";

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("test")
    public String toUpload(){
        return "test";
    }

    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("fileUpload")
    public String upload(@RequestParam("fileName") MultipartFile file, Map<String, Object> map){

        // 要上传的目标文件存放路径
//        String localPath = "E:/Develop/Files/Photos";
        String localPath = "/home/mi/桌面/FileUploadDemo-master/src/main/resources/static/";

        // 上传成功或者失败的提示
        String msg = "";

        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功来自后端的消息！";
        }else {
            msg = "上传失败来自后端的消息！";

        }

        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());

        return "forward:/test";
    }

    /**
     * 显示单张图片
     * @return
     */
//    @RequestMapping("show")
//    public ResponseEntity showPhotos(String fileName, Model model){
//
//        try {
//            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
//            model.addAttribute("filePath",path+fileName);
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
    @RequestMapping("show")
    public String showPhotos(@RequestParam("failName") String fileName, Model model){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            model.addAttribute("filePath",fileName);

        } catch (Exception e) {
            model.addAttribute("msg","显示失败");
        }
        return "show";
    }

}
