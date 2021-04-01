package edu.hebeu.controller;

import edu.hebeu.domain.Permission;
import edu.hebeu.domain.Role;
import edu.hebeu.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username == 'tyong'") // 表示这个请求只能被 username为 tyong的用户使用
    public String save(Role role) throws Exception {
        roleService.saveS(role);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/cut.do")
    public String cut(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        roleService.cutS(roleId);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("alter.do")
    public String alter(Role role) throws Exception {
        roleService.alterS(role);
        return "redirect:/role/findSingle.do?id=" + role.getId();
    }

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')") // 表示这个请求只有 角色为 ROLE_ADMIN 的用户才能使用
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAllS();
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/findSingle.do")
    public ModelAndView findSingle(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findSingleS(roleId); // 查询出角色表的详细信息
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    /**
     * 查询该角色可添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/canAddPermissions.do")
    public ModelAndView canAddPermissions(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findSingleS(roleId); // 查询出角色表的详细信息
        List<Permission> canAddPermissions = roleService.canAddPermissionsS(roleId); // 查询该角色可以添加的权限
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", canAddPermissions);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 给该角色添加权限
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addPermissions.do")
    public String addPermissions(@RequestParam(name = "roleId", required = true) String roleId,
                                 @RequestParam(name = "ids", required = true) String[] permissionIds)
            throws Exception {

        roleService.addPermissionsS(roleId, permissionIds);
        return "redirect:/role/canAddPermissions.do?id=" + roleId;
    }

    @RequestMapping("/cutPermission.do")
    public String cutPermission(@RequestParam(name = "roleId", required = true) String roleId,
                                @RequestParam(name = "permissionId", required = true) String permissionId)
            throws Exception{

        roleService.cutPermissionS(roleId, permissionId);
        return "redirect:/role/findSingle.do?id=" + roleId;
    }
}
