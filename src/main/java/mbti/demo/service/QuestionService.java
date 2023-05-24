package mbti.demo.service;

import lombok.RequiredArgsConstructor;
import mbti.demo.DTO.DepQuestionDTO;
import mbti.demo.DTO.QuestionDTO;
import mbti.demo.entity.DepQuestion;
import mbti.demo.entity.Question;

import mbti.demo.repository.DepQuestionRepository;
import mbti.demo.repository.QuestionRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static mbti.demo.DTO.QuestionDTO.toDto;
import static mbti.demo.DTO.DepQuestionDTO.toDto;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    //수정한 코드

    public List<QuestionDTO> findAll(){
        List<QuestionDTO> questionDTO = new ArrayList<>();
        List<Question> questions = questionRepository.findAll();

        for (Question question : questions) {
            questionDTO.add(toDto(question));
        }

        return questionDTO;
    }

    private final DepQuestionRepository depQuestionRepository;

    public List<DepQuestionDTO> finddepAll(){
        List<DepQuestionDTO> depQuestionDTOs = new ArrayList<>();
        List<DepQuestion> depQuestions = depQuestionRepository.findAll();

        for (DepQuestion depQuestion : depQuestions) {
            depQuestionDTOs.add(toDto(depQuestion));
        }

        return depQuestionDTOs;
    }
}
