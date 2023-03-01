# fraction-calculator

```
  ______               _____      _      
 |  ____|             / ____|    | |     
 | |__ _ __ __ _  ___| |     __ _| | ___ 
 |  __| '__/ _` |/ __| |    / _` | |/ __|
 | |  | | | (_| | (__| |___| (_| | | (__ 
 |_|  |_|  \__,_|\___|\_____\__,_|_|\___|
```                                         

# Introduction
 
The objective of this assignment is to create a calculator to compute arithmetic operations between integers and/or fractions and output the result as a reduced mixed fraction.
 
This document contains:
- Specifications (exactly how the calculator should behave)
- Examples (specific examples of how the calculator behaves)
- Organization (requirements for how your code be structured)
- Checkpoints (three interim stages to lead up to a totally functional calculator)
 
# Specifications
 
## Input
Input will be in the form of a value, followed by an arithmetic operator, and then another value. Values and operators will be separated by a single space. Values will contain no spaces.
 
Input values may be in the form of mixed fractions, proper fractions, improper fractions or integers. The integer and fraction parts of a mixed fraction will be separated by an underscore (_). For example, "1_3/4" is one and three fourths to distinguish it from "13/4" which is thirteen fourths).
 
The calculator will support the 4 basic arithmetic operations: add (+), subtract (-), multiply (*), and divide (/).
 
The program should accept an equation, calculate the result in the proper form, print it to screen, and then be ready to accept another equation. The user should be able to exit the program by entering the command "quit" instead of an equation.
 
*See the examples section below for clarification.*
 
## Output
The output value must always be reduced and never improper (it may be an integer, fraction, or mixed fraction, as appropriate). For example, a result of 10/4 should be printed to the screen as 2_1/2).
 
*See the examples section below for clarification.*
 
# Examples
 
These input examples should be read as <input> => <output>. This means that when <input> is typed into the calculator, <output> should be the result. This is not what it will look like when your calculator runs, just as an example of the types of calculations your program will perform.
 
- 1/4 + 1_1/2      => 1_3/4
- 8/4 + 2          => 4
- -1 * -1/2        => 1/2
- -11/17 + -1/17   => -12/17
- 0 * -99_4678/232 => 0
