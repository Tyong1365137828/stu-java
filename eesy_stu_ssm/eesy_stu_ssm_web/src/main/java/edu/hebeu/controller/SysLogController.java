package edu.hebeu.controller;

import com.github.pagehelper.PageInfo;
import edu.hebeu.domain.SysLog;
import edu.hebeu.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAllS(page, pageSize);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);

        modelAndView.addObject("sysLogsPageInfo", pageInfo);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
