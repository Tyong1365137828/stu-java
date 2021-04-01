package edu.hebeu.controller;

import edu.hebeu.domain.Role;
import edu.hebeu.domain.UserInfo;
import edu.hebeu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.saveS(userInfo);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("/alter.do")
    public String alter(UserInfo userInfo) throws Exception {
        userService.alterS(userInfo);

        return "redirect:/user/findSingle.do?id=" + userInfo.getId();
    }

    /**
     * 查询全部用户UserInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
//    @RolesAllowed("ADMIN") // 表示这个请求只能被 角色为管理员的 用户使用(注意这种方式的角色信息的前缀可以省略)
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfos = userService.findAllS();
        modelAndView.addObject("userList", userInfos);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/findSingle.do")
    public ModelAndView findSingle(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findSingleS(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");

        return modelAndView;
    }

    @RequestMapping("/canAddRoles.do")
    public ModelAndView canAddRoles(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findSingleS(userId);
        List<Role> roles = userService.canAddRolesS(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("user-role-add");

        return modelAndView;
    }

    @RequestMapping("/addRoles.do")
    public String addRoles(@RequestParam(name = "userId", required = true) String userId,
                           @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
        userService.addRoles(userId, roleIds);
        return "redirect:/user/canAddRoles.do?id=" + userId;
    }

    @RequestMapping("/cutRole.do")
    public String cutRole(@RequestParam(name = "userId", required = true) String userId,
                          @RequestParam(name = "roleId", required = true) String roleId) throws Exception {
        userService.cutRoleS(userId, roleId);
        return "redirect:/user/findSingle.do?id=" + userId;
    }
}
