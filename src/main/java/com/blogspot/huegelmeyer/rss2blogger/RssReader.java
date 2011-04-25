/*
 * rss2blogger
 * Copyright (C) 2008 Philipp HŸgelmeyer
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
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

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

 

public class RssReader {
	public RssReader(URL source) {
		super();
		this.source = source;
	}

	URL source; 
	
	@SuppressWarnings("unchecked")
	public Vector<Entry> readfeed() throws IllegalArgumentException, FeedException, IOException{
		Vector<Entry> rssEntries = new Vector<Entry>();
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build( new XmlReader( source ) ); 
		for ( SyndEntry syndFeed : (List<SyndEntry> )feed.getEntries() )
		{
			Entry entry = new Entry();
			entry.setTitle( syndFeed.getTitle());
			entry.setContent(syndFeed.getDescription().getValue());
			entry.setDate(syndFeed.getPublishedDate());
			entry.setAuthor(syndFeed.getAuthor());
			rssEntries.add(entry);
		}
	
		return rssEntries;
	}
}
