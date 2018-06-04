# SeleniumNewsWebsite
The NewsPage folder contains a java program that has two methods
1: addisFortune2() gets all the article links from "https://addisfortune.net/articles/" and writes them onto a file called links.txt in the 
DynamicPage2 folder

2: updateSite2() reads the links one by one, navigates to those links, gets the news text and creates an html file with the title of the page as the filename. It then writes the text to that file and writes the link to html file onto the index.html file.

when it is finished, it will load index.html
