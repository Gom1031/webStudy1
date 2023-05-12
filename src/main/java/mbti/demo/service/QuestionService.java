package mbti.demo.service;

import mbti.demo.entity.Question;
import mbti.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }
}
