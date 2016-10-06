The classes in this jar comprise the examples used Java Regular Expressions,
grouped by chapter number. For additional help, see the docs package.

Additionally, there are some very useful classes in the 
util directory, which might help you as form your own examples. These are

GetGroup.java
- Extracts the indicated regex group number from the given text.

RegexProperties.jva
- Extends java.util.properties, and allows regex patterns to be externally
stored. Further, it doesn't require that regex patterns be java-delimited.

RegexUtil.java
-Provides basic greplike functionality, but in a Java friendly way. For example, 
it offers a method which searches for occurrences of a pattern, then returns a
java.util.Map which marks the line number of the matches as the key, and the 
actual match as the value.

ReplaceString.java
-quick utility for replacing one String with another using regex. Designed to 
help debug regex expressions quickly

RX.java
-Applies a regex pattern. Designed to help debug regex expressions quickly.

Spliter.java
-Splits a String along a regex pattern. Designed to help debug regex 
expressions quickly.

StrictRX.java
-Applies a regex pattern strictly: that is, only a perfect match will do. 
Designed to help debug regex expressions quickly.


for comments, please email
coach@influxs.com
