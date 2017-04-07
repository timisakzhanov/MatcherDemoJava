# MatcherDemoJava

Application reads text lines from file ```MatcherDemo/text.txt``` and reads pattern lines from following file ```MatcherDemo/patterns.txt```.
Then it asks user to choose method for matching lines with pattern lines. User may select one of the below options:
- exact - will select only lines that have exact matching with any of the pattern lines
- contain - will select only lines that contain any of the pattern lines
- levenstein - will select only lines that contain a match with edit distance <= 1
At the end, application displays lines that match to the given pattern lines.



# Realization

To perform different types of comparisons I splitted functionality into 3 classes: ```ExactMatcher```, ```ContainMatcher```
and ```LevensteinMatcher``` and made them to implement ```Matcher``` interface. This allow us to perform factory pattern to make code extendable.

When user enters comparison type, ```MatchersFactory``` creates required matcher that performs computations.

To communicate with user I have created ```ConsoleIO``` class, that implements ```IOInterface``` and uses console for reading user input and writing messages. ```IOInterface``` will allow us to add easily other input / output realizations.


# Tools

- IntelliJ IDEA
- Maven build manager
