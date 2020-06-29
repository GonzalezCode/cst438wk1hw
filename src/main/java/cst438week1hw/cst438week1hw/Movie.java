package cst438week1hw.cst438week1hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class Movie {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/post/new")
    public String createTitle(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "post_form";
    }

    @PostMapping("/post")
    public String processTitleForm(@Valid Post post, BindingResult result, Model model) {
        if(result.hasErrors())
            return "post_form";
        postRepository.save(post);
        return "post_show";
    }

    @GetMapping("/post")
    public String getAllTitles(Model model){
        Iterable<Post> post = postRepository.findAllPostingsOrderByTitleDateDesc();
        model.addAttribute("posts", post);
        return "post_list";
    }
}
