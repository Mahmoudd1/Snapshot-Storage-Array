# Snapshot-Storage-Array
This algorithm implements a SnapshotArray class that supports efficient storage and retrieval of snapshots of its elements at different points in time. It provides the following functionalities:
- Constructor: Initializes a new SnapshotArray with a given length. Each element is initialized to 0 by default.
- set: Sets the value of an element at a specific index in the array. If a snapshot has been taken since the last set operation at that index, a new entry is added to track the change.
- snap: Takes a snapshot of the current state of the array and returns the snapshot ID.
- get: Retrieves the value of an element at a specific index in a given snapshot. It performs a binary search on the snapshot entries to find the closest entry with a snapshot ID less than or equal to the given snapshot ID.

## Approach
The solution utilizes a list of lists to store the snapshots of the array. Each index in the main list represents an element in the original array. Each sublist contains pairs of snapshot IDs and corresponding values. The snapshot IDs are incremented with each call to the snap operation.

During the set operation, the algorithm checks if the most recent snapshot ID for a given index is the same as the current ID. If it is, the algorithm updates the value in-place. Otherwise, it appends a new pair with the current snapshot ID and the new value to the sublist.

During the snap operation, the algorithm increments the snapshot ID and returns its current value.

During the get operation, the algorithm performs a binary search within the sublist of a specific index to find the closest snapshot ID that is less than or equal to the provided snapshot ID. It returns the corresponding value from that pair.

## Usage
Create a new instance of the SnapshotArray by calling the constructor and providing the desired length of the array.
```java
SnapshotArray snapshotArray = new SnapshotArray(length);
```
Set the value of an element at a specific index using the set method.
```java
snapshotArray.set(index, value);
```
Take a snapshot of the array by calling the snap method, which returns the ID of the snapshot.
```java
int snapshotId = snapshotArray.snap();
```
Retrieve the value of an element at a specific index in a given snapshot using the get method.

```java
int elementValue = snapshotArray.get(index, snapshotId);
```
## Time and Space Complexity
The SnapshotArray algorithm has the following time and space complexities:

Constructor: O(length)
set: O(1)
snap: O(1)
get: O(log n), where n is the number of snapshots taken
The space complexity of the algorithm is O(length * snapshots), as it stores a separate entry for each change made to the array.

