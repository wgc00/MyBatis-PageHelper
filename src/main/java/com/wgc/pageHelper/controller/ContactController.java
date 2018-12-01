
package com.wgc.pageHelper.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wgc.pageHelper.entity.Directories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wgc.pageHelper.dao.DirectoriesMapper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired
    private DirectoriesMapper directories;

    /*查询的方法*/
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public String home(@RequestParam(defaultValue = "1") int page, Model model) {
        //ModelAndView mv = new ModelAndView("home");
        PageHelper.startPage(page, 2);
        List<Directories> directoriesList = directories.selectAll();
        model.addAttribute("directoriesList", directoriesList);
        model.addAttribute("pageInfo", new PageInfo<>(directoriesList));
        //返回给jsp
        return "home";
    }

    /*删除的方法*/
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        directories.deleteByPrimaryKey(id);
        return "redirect:/query";
    }

    /*增加的方法*/
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Directories directorie) {
        directories.insert(directorie);
        return "redirect:/query";
    }


}
