package com.zf.controller;

import com.zf.pojo.Artical;
import com.zf.service.ArticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class ArticalController {


    @Autowired
    private ArticalService articalService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize) {
        Page<Artical> articalList = articalService.findArticalList(pageNum, pageSize);
        System.out.println("总页数" + articalList.getTotalPages());
        Iterator<Artical> iterator = articalList.iterator();
        model.addAttribute("articles",articalList);
        return "index";
    }


}
