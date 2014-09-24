package demo.example.spring;

import demo.example.spring.NewsFeed;

public abstract class NewsFeedManager{
	public abstract NewsFeed getNewsFeed();
	public void printNews(){
		NewsFeed newsFeed= getNewsFeed();
		System.out.println(newsFeed.getNews());
	}
}