package mbti.demo.DTO;

import lombok.Data;
import mbti.demo.entity.DepQuestion;

@Data
public class DepQuestionDTO {
    private Long id;
    private String content;

    public static DepQuestionDTO toDto(DepQuestion question){
        DepQuestionDTO depQuestionDTO = new DepQuestionDTO();
        depQuestionDTO.setId(question.getId());
        depQuestionDTO.setContent(question.getContent());

        return depQuestionDTO;
    }
}
