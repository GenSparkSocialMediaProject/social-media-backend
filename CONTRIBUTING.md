This project will be open to Hacktoberfest 2022. It started out as a project for 
a training program. The rules below do not apply to my classmates from the 
training. But I doubt they'll be working on this by the time Hacktoberfest rolls 
around.

# Rules for Hacktoberfest contributors

* Be sure to fork from the original and not from a fork.
* You may use Java 11 but try to stick to Java 8 features.
* Use JUnit 5. Unfortunately this means you probably can't use Apache NetBeans 
for this project.
* Build tool is Maven. Not my favorite, but IntelliJ IDEA deals with Maven 
headaches well enough.
* Column width is 80.
* Prefer spaces to tabs.
* Opening curly braces should not go on lines by themselves. I do know that the 
 Spring framework likes to put all curly braces on lines by themselves, so it's 
okay if it escapes your notice because Spring generated it that way.
* As much as is practical, each class in src/main/java should have a 
corresponding test class in src/test/java.
* Do not delete test classes nor test stubs without explanation.
* Do not add dependencies, but feel free to upgrade existing dependencies.
* Do not delete dependencies except when they're unused or redundant.
* No comments except Javadoc, TODO or FIXME.
* Prefer small commits. But avoid making a pull request for a single commit 
 (unless it's to fix a defect).
* Pull requests should address a TODO or FIXME comment in the source, or an open 
 issue on GitHub.
* Example posts should adhere to typical Terms of Use for a typical social media 
 network.