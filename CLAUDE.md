# CLAUDE.md — rsstoblogger

## Project Overview

RSS-to-Blogger is a Java command-line tool that reads entries from an RSS feed and publishes them as draft posts to a Google Blogger blog. It was originally forked from `rss2blogger.googlecode.com` (Copyright 2008 Philipp Huegelmeyer) and is licensed under GPLv3.

## Build & Run

This is a **Maven** project targeting **Java 1.6**.

```bash
# Compile
mvn compile

# Package into a single executable JAR (uses onejar-maven-plugin)
mvn package

# Run (requires rss2blogger.properties in the working directory)
java -jar target/rssToBlogger-1.0.one-jar.jar
```

### Configuration

Before running, edit `rss2blogger.properties` in the project root:

| Property      | Description                          |
|---------------|--------------------------------------|
| `b_username`  | Google/Gmail account email address   |
| `b_password`  | Account password                     |
| `b_id`        | Blogger blog ID                      |
| `rss_source`  | URL of the RSS feed to import        |

## Tests

There are no tests in this project.

## Architecture

```
src/main/java/com/blogspot/huegelmeyer/rss2blogger/
├── Main.java            # Entry point — loads properties, orchestrates read/write
├── RssReader.java       # Parses RSS feed via Rome (SyndFeed) into Entry objects
├── BloggerWriter.java   # Posts Entry objects to Blogger via Google GData API
├── Entry.java           # POJO for a blog entry (title, date, content, author, category)
└── utils/
    └── htmlencode.java  # HTML entity encode/decode utility
```

**Data flow:** `RSS Feed → RssReader → Vector<Entry> → BloggerWriter → Blogger API`

All posts are created as **drafts** (`setDraft(true)`).

## Key Dependencies

- **Rome 0.9** — RSS/Atom feed parsing
- **Google GData Client 1.41.5** — Blogger API access (legacy ClientLogin auth)
- **Commons Lang 2.4** — string utilities
- **JavaMail 1.4.1** — transitive dependency

## Coding Conventions

- Package: `com.blogspot.huegelmeyer.rss2blogger`
- Indentation: tabs
- No test framework in use
- Class-level Javadoc with GPL header on every file
- Utility class names are lowercase (`htmlencode`) — non-standard but existing convention
