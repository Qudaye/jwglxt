package f4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import f4.web.entity.Template;
import f4.web.service.TemplateService;

@Controller
public class TemplateController {

	@Autowired
    private TemplateService templateService;

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/templates", method = RequestMethod.GET)
	public @ResponseBody List<Template> selectAll() {
		return templateService.selectAll();
	}

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/template/{id}", method = RequestMethod.GET)
    public @ResponseBody Template selectById(@PathVariable Integer id) {
    	Template template = new Template();
    	template.setId(id);
        return templateService.selectOne(template);
    }

    /**
     * update Page
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/template/{id}/update", method = RequestMethod.GET)
    public String updatePage(@PathVariable Integer id, ModelMap modelMap) {
        Template template = new Template();
        template.setId(id);
        modelMap.addAttribute("template", templateService.selectOne(template));
        return "marketactive/template/template_update";
    }
    
    /**
     * 查询记录
     * 
     * @param template
     * @return
     */
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public @ResponseBody Template selectOne(@RequestBody Template template) {
    	return templateService.selectOne(template);
    }

    /**
     * 添加
     *
     * @param template
     * @return
     */
    @RequestMapping(value = "/template", method = RequestMethod.POST)
    public @ResponseBody int insert(@RequestBody Template template) {
        return templateService.insert(template);
    }

    /**
     * 修改
     *
     * @param template
     * @return
     */
    @RequestMapping(value = "/template", method = RequestMethod.PUT)
    public @ResponseBody int update(@RequestBody Template template) {
        return templateService.update(template);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/template/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteById(@PathVariable Integer id) {
        return templateService.deleteById(id);
    }
}
