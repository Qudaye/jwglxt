package f4.web.controller;

import f4.web.entity.Role;
import f4.web.entity.Staff;
import f4.web.service.RoleService;

import f4.web.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 角色
 * @author 12638
 *
 */
@Controller
public class RoleController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private RoleService roleService;


	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public @ResponseBody List<Role> selectAll() {
		return roleService.selectAll();
	}

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public @ResponseBody Role selectById(@PathVariable Integer id) {
    	Role role = new Role();
    	role.setId(id);
        return roleService.selectOne(role);
    }

    /**
     * update page
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/role/{id}/update", method = RequestMethod.GET)
    public String updatePage(@PathVariable Integer id, ModelMap modelMap) {
        Role role = new Role();
        role.setId(id);
        modelMap.addAttribute("role", roleService.selectOne(role));
        return "/system/roleinfo/roleinfo_update";
    }
    
    /**
     * 查询记录
     * 
     * @param role
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody Role selectOne(@RequestBody Role role) {
    	return roleService.selectOne(role);
    }

    /**
     * 添加
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public @ResponseBody int insert(@RequestBody Role role) {
        return roleService.insert(role);
    }

    /**
     * 修改
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public @ResponseBody int update(@RequestBody Role role) {
        return roleService.update(role);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteById(@PathVariable Integer id) {
        return roleService.deleteById(id);
    }

    /**
     * 用户角色变更
     *
     * @param staffId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/roleChange/{staffId}", method = RequestMethod.GET)
    public String roleChange(@PathVariable Integer staffId, ModelMap modelMap) {
        Staff staff = new Staff();
        staff.setId(staffId);
        Staff staffP = staffService.selectOne(staff);
        modelMap.addAttribute("staff", staffP);
        modelMap.addAttribute("roles", roleService.selectAll());
        return "system/roleinfo/role_change";
    }
}
