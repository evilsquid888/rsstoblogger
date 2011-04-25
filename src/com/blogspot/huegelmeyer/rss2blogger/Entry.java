/*
 * rss2blogger
 * Copyright (C) 2008 Philipp HŸgelmeyer
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */


package com.blogspot.huegelmeyer.rss2blogger;

import java.util.Date;

import com.blogspot.huegelmeyer.rss2blogger.utils.htmlencode;


public class Entry {
	String title;
	Date   date;
	String content; 
	String author; 
	String cathegorie;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = htmlencode.HTMLDecode(content);
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the cathegorie
	 */
	public String getCathegorie() {
		return cathegorie;
	}
	/**
	 * @param cathegorie the cathegorie to set
	 */
	public void setCathegorie(String cathegorie) {
		this.cathegorie = cathegorie;
	} 
}
