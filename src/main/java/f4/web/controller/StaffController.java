package f4.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import f4.web.entity.Staff;
import f4.web.service.StaffService;

@Controller
public class StaffController {

    private static final Logger log = Logger.getLogger(StaffController.class);

	@Autowired
    private StaffService staffService;

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/staffs", method = RequestMethod.GET)
	public @ResponseBody List<Staff> selectAll() {
		return staffService.selectAll();
	}

    /**
     * show page
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/staff/{id}/show", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, ModelMap modelMap) {
    	Staff staff = new Staff();
    	staff.setId(id);
        modelMap.addAttribute("staff", staffService.selectOne(staff));
        return "system/staffinfo/staffinfo_show";
    }

    /**
     * update page
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/staff/{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable Integer id, ModelMap modelMap) {
        Staff staff = new Staff();
        staff.setId(id);
        modelMap.addAttribute("staff", staffService.selectOne(staff));
        return "system/staffinfo/staffinfo_update";
    }
    
    /**
     * 查询记录
     * 
     * @param staff
     * @return
     */
    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public @ResponseBody Staff selectOne(@RequestBody Staff staff) {
    	return staffService.selectOne(staff);
    }

    /**
     * 添加
     *
     * @param staff
     * @return
     */
    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    public @ResponseBody int insert(@RequestBody Staff staff) {
        log.debug("===================================================");
        log.debug(staff.getRoleId());
        log.debug("===================================================");
        return staffService.insert(staff);
    }

    /**
     * 修改
     *
     * @param staff
     * @return
     */
    @RequestMapping(value = "/staff", method = RequestMethod.PUT)
    public @ResponseBody int update(@RequestBody Staff staff) {
        return staffService.update(staff);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteById(@PathVariable Integer id) {
        return staffService.deleteById(id);
    }

    /**
     * 角色变更
     *
     * @param staffId
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/staff/{staffId}/role/{roleId}", method = RequestMethod.PUT)
    public @ResponseBody int update(@PathVariable Integer staffId, @PathVariable Integer roleId) {
        Staff staff = new Staff();
        staff.setId(staffId);
        Staff staffP = staffService.selectOne(staff);
        staffP.setRoleId(roleId);
        return staffService.update(staffP);
    }
}
