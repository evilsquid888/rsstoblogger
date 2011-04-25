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

package com.blogspot.huegelmeyer.rss2blogger.utils;

public class htmlencode {
	
	private static final char c[] = { '<', '>', '&', '\"'};
	
	private static final String expansion[] = {"&lt;", "&gt;", "&amp;","&quot;"};
	
	
	public static String HTMLEncode(String s) {
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			boolean copy = true;
			char ch = s.charAt(i);
			for (int j = 0; j < c.length ; j++) {
				if (c[j]==ch) {
					st.append(expansion[j]);
					copy = false;
					break;
				}
			}
			if (copy) st.append(ch);
		}
		return st.toString();
	}
	
	public static String HTMLDecode(String s) {
		String mine = new String(s); 
		for (int i = 0; i < c.length ; i++) {
			mine.replaceAll(expansion[i], new String(c[i]+""));
		}
		return mine;
	}
}

