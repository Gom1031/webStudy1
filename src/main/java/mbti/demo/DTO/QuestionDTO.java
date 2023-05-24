package mbti.demo.DTO;

import lombok.Data;
import mbti.demo.entity.Question;

@Data
public class QuestionDTO {
    private Long id;
    private String content;

    public static QuestionDTO toDto(Question question){
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setContent(question.getContent());

        return questionDTO;
    }
}
