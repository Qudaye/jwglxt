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

import f4.web.entity.Dictionary;
import f4.web.service.DictionaryService;

@Controller
public class DictionaryController {

	@Autowired
    private DictionaryService dictionaryService;


	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/dictionarys", method = RequestMethod.GET)
	public @ResponseBody List<Dictionary> selectAll() {
		return dictionaryService.selectAll();
	}

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/dictionary/{id}", method = RequestMethod.GET)
    public @ResponseBody Dictionary selectById(@PathVariable Integer id) {
    	Dictionary dictionary = new Dictionary();
    	dictionary.setId(id);
        return dictionaryService.selectOne(dictionary);
    }
    
    /**
     * 查询记录
     * 
     * @param dictionary
     * @return
     */
    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public @ResponseBody Dictionary selectOne(@RequestBody Dictionary dictionary) {
    	return dictionaryService.selectOne(dictionary);
    }

    /**
     * update Page
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/dictionary/{id}/update", method = RequestMethod.GET)
    public String updatePage(@PathVariable Integer id, ModelMap modelMap) {
        Dictionary dictionary = new Dictionary();
        dictionary.setId(id);
        modelMap.addAttribute("dictionary", dictionaryService.selectOne(dictionary));
        return "system/datadictionary/datadictionary_update";
    }

    /**
     * 添加
     *
     * @param dictionary
     * @return
     */
    @RequestMapping(value = "/dictionary", method = RequestMethod.POST)
    public @ResponseBody int insert(@RequestBody Dictionary dictionary) {
        return dictionaryService.insert(dictionary);
    }

    /**
     * 修改
     *
     * @param dictionary
     * @return
     */
    @RequestMapping(value = "/dictionary", method = RequestMethod.PUT)
    public @ResponseBody int update(@RequestBody Dictionary dictionary) {
        return dictionaryService.update(dictionary);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/dictionary/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteById(@PathVariable Integer id) {
        return dictionaryService.deleteById(id);
    }
}
