package mbti.demo.controller;

import mbti.demo.entity.Question;
import mbti.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @GetMapping("/main")
    public String mainForm() {

        return "main";
    }
    @Autowired
    private QuestionService questionService;

    @GetMapping("/mbti/test")
    public String testForm(Model model) {

        List<Question> questions = questionService.findAllQuestion();
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
    public String depressionTest() {

        return "depresstionTest";
    }

}
