package com.zhuxiaoxue.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/home")
    public String home() {

        System.out.println("Hello SpringMvc");
        return "/home";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        return "/upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String fileUpload(String fileDec, MultipartFile file) {
        System.out.println(file.getContentType());

        return "redirect:/users";
    }
}
