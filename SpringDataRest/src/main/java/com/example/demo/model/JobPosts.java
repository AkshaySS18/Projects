package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPosts {
	
	private int postId;
	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;
	private List<String> postTechStack;
	
	
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getPostProfile() {
		return postProfile;
	}
	
	public void setPostProfile(String postProfile) {
		
		this.postProfile = postProfile;
	}
	
	public String getPostDesc() {
		return postDesc;
	}
	
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	
	public Integer getReqExperience() {
		return reqExperience;
	}
	
	public void setReqExperience(Integer reqExperience) {
		this.reqExperience = reqExperience;
	}
	
	public List<String> getPostTechStack() {
		return postTechStack;
	}
	
	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}

	public JobPosts(int postId, String postProfile, String postDesc, Integer reqExperience, List<String> postTechStack) {
		super();
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}

	public JobPosts() {
		
	}

	@Override
	public String toString() {
		return "JobPost [postId=" + postId + ", postProfile=" + postProfile + ", postDesc=" + postDesc
				+ ", reqExperience=" + reqExperience + ", postTechStack=" + postTechStack + "]";
	}
	
	

}
