
import com.epic.app.model.Item;
import com.epic.app.service.ItemService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pas8sion on 06.01.2015.
 */
@Transactional
public class ItemServiceIntegrationTest extends IntegrationTest{


    @Test
    public void CrudTest() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTestConfiguration.class);
        ItemService itemService = (ItemService) context.getBean("itemServiceImpl");

        Item item = new Item();
        item.setNumber("12345");
        item.setContent("12345 тестовый вопрос");

        itemService.addItem(item);
        Item itemDB = itemService.getItemByNumber("12345");

        assertEquals(item.getId(), itemDB.getId());
        assertEquals(item.getContent(), itemDB.getContent());

        itemService.removeItem(item);
        itemDB = itemService.getItemByNumber("12345");
        assertEquals(null, itemDB);


    }
}
