# COMP 271 002 F17 Lab 9 (Week 11)

# Team project

Work in teams of two.

# Objectives

An understanding of the following concepts and techniques:

- Set and Map ADTs
- custom implementations of standard interfaces
- building more advanced data structures from simpler predefined ones
- sorting arrays and ArrayLists (parameterized by a strategy)
- basic experiments to measure performance

# Instructions

In this lab, you will have the opportunity to implement the `Map` interface using an `ArrayList` of `LinkedList`s.
Then you will be able to stress-test and performance-test your implementation based on the previous lab.

Specifically:

1. Complete the TODO items in the various sources until the tests pass.
1. Download this book (or use the file you already downloaded): https://archive.org/stream/lesmisrables01unkngoog/lesmisrables01unkngoog_djvu.txt.
1. Use the program to determine the 10 most frequent words and their frequencies in this text by redirecting stdin from the downloaded file:

        ./build/scripts/cs2-lab11-hashtable-java < lesmisrables01unkngoog_djvu.txt
        time in ms: 762
        the=33282
        of=18016
        and=12849
        a=12717
        to=12450
        in=9387
        was=7788
        that=6601
        he=6202
        his=5529

1. Answer the following questions in Answers.md:
    - Try using a `TreeMap` and a `HashMap` instead of `MyHashMap`.
        1. Are the resulting word frequencies any different?
        1. Is the time performance any different? If so, how would you rank the three implementations (in increasing order of time complexity)?
    - How are `%` and `Math.floorMod` different? Which works more reliably for computing a hash table index?
    - What is the time complexity of `MyHashMap.size()`, and how could you make it much more efficient?

# Grading

- 0.5 correct project structure (based on Gradle)
- 0.5 submission via GitHub (including multiple commits over time)
- 2.5 completion of items marked TODO in `src/main` and correct behavior
- 1.5 written part
    - 1.2 responses to the questions above
    - 0.3 grammar, style, formatting

*5 points TOTAL*
