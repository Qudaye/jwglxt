package f4.web.controller;

import f4.web.entity.Attendance;
import f4.web.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AttendanceController {

	@Autowired
    private AttendanceService attendanceService;
	
	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/attendances", method = RequestMethod.GET)
	public @ResponseBody List<Attendance> selectAll() {
		return attendanceService.selectAll();
	}

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.GET)
    public @ResponseBody Attendance selectById(@PathVariable Integer id) {
    	Attendance attendance = new Attendance();
    	attendance.setId(id);
        return attendanceService.selectOne(attendance);
    }
    
    /**
     * 查询记录
     * 
     * @param attendance
     * @return
     */
    @RequestMapping(value = "/attendance", method = RequestMethod.GET)
    public @ResponseBody Attendance selectOne(@RequestBody Attendance attendance) {
    	return attendanceService.selectOne(attendance);
    }

    /**
     * 添加
     *
     * @param attendance
     * @return
     */
    @RequestMapping(value = "/attendance", method = RequestMethod.POST)
    public @ResponseBody int insert(@RequestBody Attendance attendance) {
        return attendanceService.insert(attendance);
    }

    /**
     * 修改.
     *
     * @param attendance
     * @return
     */
    @RequestMapping(value = "/attendance", method = RequestMethod.PUT)
    public @ResponseBody int update(@RequestBody Attendance attendance) {
        return attendanceService.update(attendance);
    }

    /**
     * 删除.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/attendance/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteById(@PathVariable Integer id) {
        return attendanceService.deleteById(id);
    }
}
