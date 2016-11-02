package f4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import f4.web.entity.Message;
import f4.web.service.MessageService;

@Controller
public class MessageController {

	@Autowired
    private MessageService messageService;


	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public @ResponseBody List<Message> selectAll() {
		return messageService.selectAll();
	}

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public @ResponseBody Message selectById(@PathVariable Integer id) {
    	Message message = new Message();
    	message.setId(id);
        return messageService.selectOne(message);
    }

    /**
     * message send Page
     *
     * @return
     */
    @RequestMapping(value = "/message/send", method = RequestMethod.GET)
    public String sendPage() {
        return "marketactive/messafeinfo/messafeinfo_send";
    }
    
    /**
     * 查询记录
     * 
     * @param message
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public @ResponseBody Message selectOne(@RequestBody Message message) {
    	return messageService.selectOne(message);
    }

    /**
     * 添加
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public @ResponseBody int insert(@RequestBody Message message) {
        return messageService.insert(message);
    }

    /**
     * 修改
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.PUT)
    public @ResponseBody int update(@RequestBody Message message) {
        return messageService.update(message);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteById(@PathVariable Integer id) {
        return messageService.deleteById(id);
    }
}
