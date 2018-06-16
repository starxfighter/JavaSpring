package com.starxfighter.dojooverflow.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.starxfighter.dojooverflow.models.Answer;
import com.starxfighter.dojooverflow.models.Question;
import com.starxfighter.dojooverflow.models.Tag;
import com.starxfighter.dojooverflow.models.TagQuestion;
import com.starxfighter.dojooverflow.repository.AnswerRepository;
import com.starxfighter.dojooverflow.repository.QuestionRepository;
import com.starxfighter.dojooverflow.repository.TagQuestionRepository;
import com.starxfighter.dojooverflow.repository.TagRepository;

@Service
public class DojoOverflowService {
	private final QuestionRepository questionRepo;
	private final AnswerRepository answerRepo;
	private final TagRepository tagRepo;
	private final TagQuestionRepository tagQuestionRepo;
	
	public DojoOverflowService(QuestionRepository questionRepo, AnswerRepository answerRepo, TagRepository tagRepo, TagQuestionRepository tagQuestionRepo) {
		this.questionRepo = questionRepo;
		this.answerRepo = answerRepo;
		this.tagRepo = tagRepo;
		this.tagQuestionRepo = tagQuestionRepo;
	}
	
	public List<Question> allQuestion(){
		return questionRepo.findAll();
	}
	
	public List<Answer> allAnswer(){
		return answerRepo.findAll();
	}
	
	public List<Tag> allTag(){
		return tagRepo.findAll();
	}
	
	public List<TagQuestion> allTagQues(){
		return tagQuestionRepo.findAll();
	}
	
	public Question createQuestion(Question q) {
		return questionRepo.save(q);
	}
	
	public Answer createAnswer(Answer a) {
		return answerRepo.save(a);
	}
	
	public Tag createTag(Tag t) {
		return tagRepo.save(t);
	}
	
	public TagQuestion createTagQuest(TagQuestion tq) {
		return tagQuestionRepo.save(tq);
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuest = questionRepo.findById(id);
		if(optionalQuest.isPresent()) {
			return optionalQuest.get();
		} else {
			return null;
		}
	}
	
	public Answer findAnswer(Long id) {
		Optional<Answer> optionalAnswer = answerRepo.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
	
	public Tag findTag(Long id) {
		Optional<Tag> optionalTag = tagRepo.findById(id);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	
	public List<TagQuestion> findTagQuest(Long id){
		return tagQuestionRepo.findAllByTag_id(id);
	}
	
	public List<TagQuestion> findQuestTag(Long id){
		return tagQuestionRepo.findAllByQuestion_id(id);
	}
	
	public List<Answer> findAnsweByQuest(Long id){
		return answerRepo.findAllByQuestion_id(id);
	}

	public Tag findTagName(String tag) {
		return tagRepo.findBySubject(tag);
	}
	
	public HashMap<Long, ArrayList<String>> buildIndex(){
		HashMap<Long, ArrayList<String>> hmap = new HashMap<Long, ArrayList<String>>();
		
		List<Question> tempQuest = questionRepo.findAll();
		for(int x = 0; x < tempQuest.size(); x++) {
			ArrayList<String> screenData = new ArrayList<String>();
			Long tempId = tempQuest.get(x).getId();
			String tempDes = tempQuest.get(x).getQuestiondt();
			screenData.add(0, tempDes);
			List<TagQuestion> tempTQ = tagQuestionRepo.findAllByQuestion_id(tempId);
			for(int z = 0; z < tempTQ.size(); z++) {
				String tempTag = tempTQ.get(z).getTag().getSubject();
				screenData.add(tempTag);
			}
			hmap.put(tempId, screenData);
		}
		
		return hmap;
	}
//end
}
