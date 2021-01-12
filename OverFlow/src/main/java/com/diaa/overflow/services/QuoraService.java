package com.diaa.overflow.services;

import com.diaa.overflow.models.Answer;
import com.diaa.overflow.models.Question;
import com.diaa.overflow.models.Tag;
import com.diaa.overflow.reposirories.AnswerRepository;
import com.diaa.overflow.reposirories.QuestionRepository;
import com.diaa.overflow.reposirories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoraService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final TagRepository tagRepository;

    public QuoraService(QuestionRepository questionRepository, AnswerRepository answerRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.tagRepository = tagRepository;
    }
    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }
    public Question getQuestion(Long id){
        return questionRepository.findById(id).orElse(null);
    }
    public List<Question> allQuestions(){
        return questionRepository.findAll();
    }
    public Answer addAnswer(Answer answer){
        return answerRepository.save(answer);
    }
    public Answer getAnswer(Long id){
        return answerRepository.findById(id).orElse(null);
    }
    public List<Answer> allAnswers(){
        return answerRepository.findAll();
    }
    public Tag addTag(Tag tag){
        return tagRepository.save(tag);
    }
    public Tag getTag(Long id){
        return tagRepository.findById(id).orElse(null);
    }
    public List<Tag> allTags(){
        return tagRepository.findAll();
    }
    public void add(Tag tag, Question question){
        List<Tag> tags = question.getTags();
        tags.add(tag);
        question.setTags(tags);
        questionRepository.save(question);
    }
    public void newQuestion(Question question, Tag stringTag){
        Question newQuestion = this.addQuestion(question);
        String[] newSubjects = stringTag.arrayOfTags();
        ArrayList<Tag> tags = new ArrayList<>();
        for (String subject: newSubjects) {
            subject = subject.trim();
            if(subject.length() != 0){
                Tag tag = this.tagRepository.findBySubject(subject);
                if(tag == null){
                    tag = new Tag(subject);
                    this.tagRepository.save(tag);
                }
                tags.add(tag);
            }
        }
        newQuestion.setTags(tags);
        questionRepository.save(newQuestion);
    }
    public void addNewAnswer(Long q_id, Answer answer){
        Question question = this.getQuestion(q_id);
        Answer ans = new Answer(answer.getContext(), question);
        answerRepository.save(ans);
    }
}
