/*
 * rss2blogger
 * Copyright (C) 2008 Philipp Hgelmeyer
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

import java.io.IOException;
import java.net.URL;
import java.util.TimeZone;

import com.google.gdata.client.GoogleService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.util.ServiceException;

/**
 * @author phuegelm
 *
 */
public class BloggerWriter {

	public static  com.google.gdata.data.blogger.BlogEntry createPost(GoogleService myService, String blogId ,Entry e)
		    throws ServiceException, IOException {
		  // Create the entry to insert
		  com.google.gdata.data.blogger.BlogEntry myEntry = new com.google.gdata.data.blogger.BlogEntry();
		  myEntry.setTitle(new PlainTextConstruct(e.getTitle()));
		  myEntry.setContent(new PlainTextConstruct(e.getContent()));
		  myEntry.setPublished(new DateTime(e.getDate(),TimeZone.getDefault()));
		  myEntry.setDraft(true);

		  // Ask the service to insert the new entry
		  URL postUrl = new URL("http://www.blogger.com/feeds/" + blogId + "/posts/default");
		  return myService.insert(postUrl, myEntry);
		}

}
