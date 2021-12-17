# Sort Manager
Sort Manager is an application that allows user to sort randomly generated array of numbers, by 
using different sorting algorithms.

## Description

Sort Manager allows user to use 5 sorting algorithms:

Bubble Sorter

Merge Sorter

Binary Tree Sorter

Insertion Sorter

Selection Sorter

After receiving size of array to be generated and sorted, Sort Manager runs sorter chosen by user.
When sorting is done, Sort Manager gives user information about sorting time and compares an 
array numbers order before and after sorting. User may add his own sorting algorithms to Sort 
Manager.

## Getting started

### Using Sort Manager

1. Type a number of sorter you would like to use. Make sure that number you will use is
   visible on the list. Otherwise, "**Sorter doesn't exist**" error will appear. You should only use 
   number format. Any other input will cause "**Invalid user input**" error.


2. Type a size of array you would like to generate and sort. Typing 0 will cause "**Array size 
   must be greater than 0**" error. Try to avoid using large numbers, as they may cause 
   application console problems.

### Adding sorting algorithms

#### 1. Add sorter name to **sortersList.txt** file. Pay attention to whitespaces and numeration:

EXAMPLE:

1. Bubble Sorter
2. Merge Sorter
3. Binary Tree Sorter
4. Insertion Sorter
5. Selection Sorter
6. Quick Sort Sorter    <--------



#### 2. Add new sorter class to application **sorters** package. Make sure the class name is the same as sorter name in sortersList.txt and without whitespaces and numeration. 
   

EXAMPLE:

sortersList.txt -----> 6. Quick Sort Sorter

class name -----> QuickSortSorter

#### 3. Implement Sorters interface in your sorter class. Sorters interface has 3 methods:

int[] sort(int[] arrayToSort) -----> calls sorter algorithm and returns sorted array

Long getSortingTime() -----> method returns sorting time

String getSorterName() -----> returns name of the sorter to display in final message


#### 4. Add sorter to SortersFactory class

EXAMPLE:

public static Sorters getSorter(int numberOfSorter) {

if (numberOfSorter == 1) {
Logger.log(Level.FINE, "Bubble Sorter object created");
return new BubbleSorter(); 
} 

else if (numberOfSorter == 2) {
Logger.log(Level.FINE, "Merge Sorter object created");
return new MergeSorter();
}

else if (numberOfSorter == 3) {
Logger.log(Level.FINE, "Binary Tree object created");
return new BinaryTreeSorter();
}

else if(numberOfSorter == 4) {
Logger.log(Level.FINE, "Insertion Sorter object created");
return new InsertionSorter();
}

else if(numberOfSorter == 5) {
Logger.log(Level.FINE, "Selection Sorter object created");
return new SelectionSorter();}

**else if(numberOfSorter == 6) {
Logger.log(Level.FINE, "Quick Sort Sorter object created");
return new QuickSortSorter();}** <-----
}

Make sure that numberOfSorter condition should be the same as sorter number in **sortersList.txt**


### Troubleshooting

#### 1. I'm getting error:

* "sortersList.txt file not found! Closing application"

Make sure that **sortersList.txt** file exists in sorters package

* "Invalid user input. Please try again."

Make sure to use number to choose sorter

* "Sorter doesn't exist. Please try again."

Make sure you followed steps of [Adding sorting algorithms](#adding-sorting-algorithms) section

* "Array size must be greater than 0. Please try again."

Use number grater than 0 for array generating

#### 2. Sort Manager is not showing final message

Make sure to not use very large numbers for array size, as it may cause application console problems

#### 3. Logger default location

src/main/java/com/sparta/paweldyjak/sortManagerLog.log

## Author

Pawel Dyjak

[PDyjak@spartaglobal.com]()


