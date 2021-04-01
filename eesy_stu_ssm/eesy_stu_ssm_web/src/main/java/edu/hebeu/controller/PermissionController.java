package edu.hebeu.controller;

import com.github.pagehelper.PageInfo;
import edu.hebeu.domain.Permission;
import edu.hebeu.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.saveS(permission);
        return "redirect:/permission/findAll.do";
    }

    @RequestMapping("/cut.do")
    public String cut(@RequestParam(name = "id", required = true) String permissionId) throws Exception {
        permissionService.cutS(permissionId);
        return "redirect:/permission/findAll.do";
    }

    @RequestMapping("/alter.do")
    public String alter(Permission permission) throws Exception{
        permissionService.alterS(permission);
        return "redirect:/permission/findSingle.do?id=" + permission.getId();
    }

    @RequestMapping("/findAll.do")
//    @Secured("ROLE_ADMIN") // 表示这个请求只能被 角色为管理员的 用户使用(注意这种方式的角色信息的前缀不能省略)
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "5") Integer pageSize)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions = permissionService.findAllS(page, pageSize);
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);

        modelAndView.addObject("permissionsPageInfo", pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/findSingle.do")
    public ModelAndView findSingle(@RequestParam(name = "id", required = true) String permissionId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = permissionService.findSingleS(permissionId);
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("permission-show");

        return modelAndView;
    }
}
