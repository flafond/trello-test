# Sample JUnit tests exercising Selenium
This project is sample code displaying how to write JUnit tests using
Selenium without any external libraries. It does make use of
Selenium [Page Objects](https://code.google.com/p/selenium/wiki/PageObjects) though.

For simplicity, it only uses the Firefox driver.

It runs tests against the popular task management platform [Trello](https://trello.com),
which is likely a violation of their terms of service. I hope they won't sue me. :-(

I developed this project using [IntelliJ IDEA](https://www.jetbrains.com/idea/), Community Edition
(thank you Jetbrains!) so there is no Maven or Ant infrastructure to run the tests.

### Running the tests
Should you want to actually run the tests, you must:
* Create a [Trello](https://trello.com) account
* Create the boards **Play** and **Work** (there should already be a **Welcome Board** board)
* Define the environment variables **TRELLO_EMAIL** and **TRELLO_PASSWORD** to match the values used to create your Trello account

### License
The project is licensed under the MIT license.
