package f4.web;

import f4.web.config.AppConfig;
import f4.web.dao.MenuDao;
import f4.web.entity.Menu;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by xuan on 16-10-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MenuDaoTest {

    private static final Logger log = Logger.getLogger(MenuDaoTest.class);

    @Autowired
    private MenuDao menuDao;

//    @Test
//    public void selectAll() {
//        menuDao.selectAll().forEach(menu -> log.debug(menu));
//    }

    public void insert() {
        Menu menu = new Menu();
        menu.setParentId(1);
        menu.setMenuName("Hello");
        menu.setLevel("1.3");
        menuDao.insert(menu);
        System.out.println(menu.getId());
    }

    @Test
    public void selectLike() {
        Example example = new Example(Menu.class);
        example.createCriteria().andLike("menuName", "%o%");
        for (Menu menu : menuDao.selectByExample(example)) {
            System.out.println(menu.getMenuName());
        }
    }

}
