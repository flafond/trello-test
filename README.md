# Sample JUnit tests exercising Selenium
This project is sample code displaying how to write JUnit tests using
Selenium without any external libraries. It does make use of
Selenium [Page Objects](https://code.google.com/p/selenium/wiki/PageObjects) though.

For simplicity, it only uses the Firefox driver.

It runs tests against the popular task management platform [Trello](https://trello.com),
which is likely a violation of their terms of service. I hope they won't sue me. :-(

### Running the tests
Should you want to actually run the tests, you must:
* Have the following dependencies installed:
  * [Java 8](https://www.java.com/en/download/) (uses lambda expressions)
  * [Gradle](http://gradle.org/)

* Create a [Trello](https://trello.com) account
* Create the boards **Play** and **Work** (there should already be a **Welcome Board** board)
* Define the environment variables **TRELLO_EMAIL** and **TRELLO_PASSWORD** to match the values
used to create your Trello account

Then use Gradle to run the tests. From the *trello-test* top directory, run:
```bash
$ gradle test
```
### License
The project is available under the MIT license.
