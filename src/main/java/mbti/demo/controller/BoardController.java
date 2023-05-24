package mbti.demo.controller;

import lombok.RequiredArgsConstructor;
import mbti.demo.DTO.DepQuestionDTO;
import mbti.demo.DTO.QuestionDTO;

import mbti.demo.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {
    @GetMapping("/main")
    public String mainForm() {

        return "main";
    }
    private final QuestionService questionService;

    @GetMapping("/mbti/test")
    public String testForm(Model model) {

        List<QuestionDTO> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "mbtiTest";
    }

    @PostMapping("/mbti/result")
    public String submitScores(@RequestParam Map<String, String> scores, Model model) {
        int totalScore = scores.values().stream()
                .mapToInt(Integer::parseInt)
                .sum();

        model.addAttribute("totalScore", totalScore);
        return "mbtiResult";
    }

    @GetMapping("/depression/test")
    public String depressionTest(Model model) {
        List<DepQuestionDTO> depQuestions = questionService.finddepAll();
        model.addAttribute("depQuestions", depQuestions);

        return "depresstionTest";
    }

}
