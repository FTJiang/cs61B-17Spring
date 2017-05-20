###To run code
comparable
```
cd comparable
javac Dog.java DogLauncher.java Maximizer.java
java DogLauncher
```

comparator
```
cd comparator
javac Dog.java DogLauncher.java Maximizer.java
java DogLauncher
```

###Summary
Same between comparable and comparator
1. Both of them are used to implement comparation and ordering of objects
2. Both of them are interface of JAVA

Difference
1. Comparator is under java.util and Comparable is under java.lang
2. Implement of Comparable is inside the class, user-class should implement Comparable and override compareTo() method
3. Comparator is implemented outside the user-class or as nested class in user-class, override compare method
4. Comparator requires java.util.Comparator package


How to choose
If compare function is just used in one class, we can use comparable
If compare function is used in many class, we should write our own comparator class can pass it as parameter in comparation
