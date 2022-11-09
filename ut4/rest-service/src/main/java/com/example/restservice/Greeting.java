package com.example.restservice;
/**
 * 
 * @author Juan Cebrian
 *
 */
public class Greeting {

	private final long id;
	private final String content;
/**
 * Constructor
 * 
 * @param id
 * @param content
 */
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
/**
 * 
 * @return long
 */
	public long getId() {
		return id;
	}
/**
 * 
 * @return String
 */
	public String getContent() {
		return content;
	}
	
}
