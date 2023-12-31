# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.1] - 2022-12-12

### Fixed

- The storing of values in memory.
- Some minor spelling mistakes in AsciiView.

## [1.0.0] - 2022-12-12

### Release

- First release and releasenotes.

### Added

- Two new methods in CalcModel which allow for the storing of results in memory.
- Option to store and view results in AsciiView.

## [0.0.1] - 2022-12-12

### Added

- CalcMain which handles the setup and running of the main menu.

### Changed

- AsciiView to now only store the menu and not run it directly.

## [0.0.1] - 2022-12-11

### Added

- Ability to store float returns in String.
- AsciiView class which allows the user to interact with the calculator.

## [0.0.1] - 2022-12-07

### Added

- top method in opStack to return the top value of the stack.
- swapOp method to prevent repeated code.
- getImport method to get the precedence of an operator within StandardCalc.
- ability to calculate expressions with brackets in StandardCalc class.

### Changed

- Symbol to include precedence of operators.
- Symbol to remove spaces inbetween strings.
- TestEntry to evaluate the fixed symbol strings.

### Fixed

- StandardCalc not utilising precedence of operators. Now calculates expressions correctly.

## [0.0.1] - 2022-12-05

### Fixed

- Reading negative numbers as an operator and a number separately in RevPolishCalc.

## [0.0.1] - 2022-12-04

### Added

- Ability to evaluate infix and postfix expressions.
- Javadoc to CalcModel.

## [0.0.1] - 2022-11-27

### Added

- CalcModel class which returns hard-coded value.
- Javadoc to CalcModel, OpStack and StandardCalc.

## [0.0.1] - 2022-11-24

### Added

- StandardCalc class that evaluates empty strings and singular digit numbers.
- Ability for StandardCalc to evaluate simple expressions.
- getOperator method in OpStack to return the operator associated with a specific String.

## [0.0.1] - 2022-11-21

### Added

- getSize method to NumStack class.

### Changed

- RevPolishCalc to throw an InvalidExpression if an invalid expression is provided.

## [0.0.1] - 2022-11-18

### Added

- RevPolishCalc class.
- RevPolishCalc which now evaluates empty strings and singular numbers.
- Ability to evaluate simple expressions in RevPolishCalc.
- Comments to understand the code better.
- Javadoc to RevPolishCalc.

### Changed

- RevPolishCalc to push results to a stack instead of returning them immediately.
- RevPolishCalc to now also evaluate expressions with more than one operator.

### Deleted

- Unecessary code in Stack class.

## [0.0.1] - 2022-11-17

### Added

- interface Calculator.
- InvalidExpression exception to be thrown by the interface.

## [0.0.1] - 2022-11-12

### Added

- Javadoc to NumStack class.
- Javadoc to StrStack class.
- Constructor in OpStack class.
- OpStack class which now contains a push method to push a Symbol.
- OpStack class which now contains a pop method to return the top value.
- OpStack class which now contains an isEmpty method to return if a stack is empty.
- Javadoc to OpStack class.

### Fixed

- Checkstyle errors in StrStack class.

## [0.0.1] - 2022-11-11

### Added

- Constructor in StrStack.java.
- StrStack class which now contains a pop method to return a top value.
- StrStack class which now contains an isEmpty method to return if a stack is empty.
- Constructor in NumStack.java.
- NumStack class which contains push method to push a float to an Entry object.
- NumStack class which contains isEmpty method to return if a stack is empty.
- NumStack class which contains pop method to return the top value.

### Changed

- StrStack no longer extends Stack.

## [0.0.1] - 2022-11-07

### Added

- testFile.txt to understand commits and branches.
- Files from coursework one.
- StrStack.java to push String values to Entry objects.

### Changed

- Changed README.md to understand egit on eclipse.
- Stack.java file to construct a stack object.
