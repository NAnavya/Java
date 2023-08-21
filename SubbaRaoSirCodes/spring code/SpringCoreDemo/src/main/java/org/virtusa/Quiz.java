package org.virtusa;

import java.util.Map;

public class Quiz {
	private String question;
	private Map<String, User> answers;
	public Quiz() {
		// TODO Auto-generated constructor stub
	}
	public Quiz(String question, Map<String, User> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Map<String, User> getAnswers() {
		return answers;
	}
	public void setAnswers(Map<String, User> answers) {
		this.answers = answers;
	}
	
	
}
