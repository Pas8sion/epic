import com.epic.app.model.Question;
import com.epic.app.service.QuestionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pas8sion on 06.01.2015.
 */
@Transactional
public class QuestionServiceIntegrationTest extends IntegrationTest{


    @Test
    public void CrudTest() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTestConfiguration.class);
        QuestionService questionService = (QuestionService) context.getBean("questionServiceImpl");

        Question question = new Question();
        question.setNumber("12345");
        question.setContent("12345 тестовый вопрос");

        questionService.addQuestion(question);
        Question questionDB = questionService.getQuestionByNumber("12345");

        assertEquals(question.getId(), questionDB.getId());
        assertEquals(question.getContent(), questionDB.getContent());

        questionService.removeQuestion(question);
        questionDB = questionService.getQuestionByNumber("12345");
        assertEquals(null, questionDB);


    }
}
