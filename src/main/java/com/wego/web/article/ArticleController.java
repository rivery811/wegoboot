package com.wego.web.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
	@Autowired private ArticleRepository articleRepository;
	@RequestMapping("/article")
	public String index() {
		return null;
	}

}
