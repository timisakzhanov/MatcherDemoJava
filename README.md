# MatcherDemoJava

Application reads text lines from file ```MatcherDemo/text.txt``` and reads pattern lines from file ```MatcherDemo/patterns.txt```.
Then it asks user to choose method for matching lines with pattern lines. User may select:
- exact - will be selected only lines that have exact matching with any of pattern lines
- contain - will be selected only lines that contain any of pattern lines
- levenstein - will be selected only lines that contain a match with edit distance <= 1
Finaly application displays lines that match to given pattern lines.



# Realization

To perform different types of comparison I splitted functionality on 3 classes: ```ExactMatcher```, ```ContainMatcher```
and ```LevensteinMatcher``` and made them implement ```Matcher``` interface. This allow us perform factory pattern to made code extendable.

When user entered comparison type ```MatchersFactory``` creates required matcher that perform computations.

To communicate with user I created ```ConsoleIO``` class that implementes ```IOInterface``` and uses console for reading user input and writing messages. ```IOInterface``` will allow us easyly switch on other input / output realization.


# Tools

- IntelliJ IDEA
- Maven build manager
