package com.starxfighter.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starxfighter.dojooverflow.models.Answer;
import com.starxfighter.dojooverflow.models.Question;
import com.starxfighter.dojooverflow.models.Tag;
import com.starxfighter.dojooverflow.models.TagQuestion;
import com.starxfighter.dojooverflow.service.DojoOverflowService;

@Controller
public class DojoOverflowController {
	
	private final DojoOverflowService dojoOverflowService;
	
	public DojoOverflowController(DojoOverflowService dojoOverflowService) {
		this.dojoOverflowService = dojoOverflowService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
//		List<TagQuestion> tq = dojoOverflowService.allTagQues();
//		model.addAttribute("tagquest", tq);
		model.addAttribute("data", dojoOverflowService.buildIndex());
		return "/dojooverflow/Index.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuest(@ModelAttribute Question question) {
		return "/dojooverflow/NewQuestion.jsp";
	}
	
	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
	public String createQuest(@Valid @ModelAttribute Question question, BindingResult result, @RequestParam("qtags") String tags, Model model) {
		if(result.hasErrors()) {
			return "/dojooverflow/NewQuestion.jsp";
		} else {
			System.out.println("\n\nincoming tags\n\n" + tags);
		      String[] items = tags.split(",");
		      List<String> itemList = new ArrayList<String>(Arrays.asList(items));
		      System.out.println("itemList" + itemList);
		      if(itemList.size() > 3) {
		    	  model.addAttribute("error", "You can only enter a maximum of 3 tags");
		    	  return "/dojooverflow/NewQuestion.jsp";
		      }
		      
		      for(int x = 0; x < itemList.size(); x++) {
		    	  String convertTag = itemList.get(x).toLowerCase().trim();
		    	  Tag tagCheck = dojoOverflowService.findTagName(convertTag);
		    	  if(tagCheck == null) {
		    		  System.out.println("Tag not found");
		    		  Tag creTag = new Tag();
		    		  creTag.setSubject(convertTag);
		    		  Tag tagCre = dojoOverflowService.createTag(creTag);
		    		  System.out.println("Created Tag");
		    		  Question creQuest = dojoOverflowService.createQuestion(question);
		    		  System.out.println("Cretaed Question");
		    		  TagQuestion creTQ = new TagQuestion();
		    		  creTQ.setQuestion(creQuest);
		    		  creTQ.setTag(tagCre);
		    		  dojoOverflowService.createTagQuest(creTQ);
		    		  System.out.println("Created Join Table");
		    	  } else {
		    		  System.out.println("Tag found");
		    		  Question creQuest = dojoOverflowService.createQuestion(question);
		    		  TagQuestion creTQ = new TagQuestion();
		    		  creTQ.setQuestion(creQuest);
		    		  creTQ.setTag(tagCheck);
		    		  dojoOverflowService.createTagQuest(creTQ); 
		    	  }
		      }
			return "redirect:/";
		}
	}
	
	@RequestMapping("/questions/{qid}")
	public String newAns(@PathVariable("qid") Long qid, @ModelAttribute Answer answer, Model model) {
		Question question = dojoOverflowService.findQuestion(qid);
		List<TagQuestion> tagQuestion = dojoOverflowService.findQuestTag(qid);
		model.addAttribute("tags", tagQuestion);
		model.addAttribute("quest", question);
//		model.addAttribute("ans", answers);
		return "/dojooverflow/NewAnswer.jsp";
	}
	
	@RequestMapping(value="/questions/{qid}", method=RequestMethod.POST)
	public String createAns(@PathVariable("qid") Long qid, @Valid @ModelAttribute Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojooverflow/NewAnswer.jsp";
		} else {
			Question tempQuest = dojoOverflowService.findQuestion(qid);
			answer.setQuestions(tempQuest);
			dojoOverflowService.createAnswer(answer);
			return "redirect:/";
		}
	}
	
//end
}
