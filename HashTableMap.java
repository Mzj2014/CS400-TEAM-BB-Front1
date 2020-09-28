package hashtableimplement;

import java.util.LinkedList;
import java.util.NoSuchElementException;
//--== CS400 File Header Information ==--
//Name: <Zijing Ma>
//Email: <zma253@wisc.edu>
//Team: <BB>
//TA: <Brianna Cochran>
//Lecturer: <Gary Dahl>
//Notes to Grader: <optional extra notes>

public class HashTableMap<String, CourseReading> {
	private LinkedList<String>[] K;
	private LinkedList<CourseReading>[] V;
	private int size;

	// Constructors with input capacity
	@SuppressWarnings("unchecked")
	public HashTableMap(int capacity) {
		K = new LinkedList[capacity];
		V = new LinkedList[capacity];
	}

	// Constructors with default capacity
	@SuppressWarnings("unchecked")
	public HashTableMap() {
		K = new LinkedList[10];
		V = new LinkedList[10];
	}

	public boolean put(String key, CourseReading value) {
		// TODO Auto-generated method stub
		int HashKey = key.hashCode() % 31;
		if (HashKey > K.length - 1) {
			while (HashKey > K.length - 1) {
				HashKey %= K.length;
			}
		}
		if (K[HashKey] == null) {
			K[HashKey] = new LinkedList<String>();
			V[HashKey] = new LinkedList<CourseReading>();
			K[HashKey].add(key);
			V[HashKey].add(value);
			// increase the key and value size and check the size of table
			size++;
			grow();
			return true;
		} else {
			double LinkedListSize = K.length / 2;
			if (K[HashKey].size() < LinkedListSize) {
				// to check the linkedlist size is less than half of table size
				if (containsKey(key) == false) {
					// check the value in the list
					K[HashKey].add(key);
					V[HashKey].add(value);
					// increase and check
					size++;
					grow();
					return true;
				}
				return false;
			} else {
				// move to next address
				HashKey += 1;
				if (HashKey > K.length - 1) {
					HashKey = 0;
				}
				if (containsKey(key) == false) {
					// check the value in the list
					K[HashKey].add(key);
					V[HashKey].add(value);
					size++;
					grow();
					return true;
				}
			}
		}
		return false;
	}

	public CourseReading get(String key) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (containsKey(key) == true) {
			int HashKey = key.hashCode() % 31;
			if (HashKey > K.length - 1) {
				while (HashKey > K.length - 1) {
					HashKey %= K.length;
				}
			}
			for (String c : K[HashKey]) {
				if (c.equals(key)) {
					return V[HashKey].get(K[HashKey].indexOf(key));
				}
			}

		}
		return null;
	}

	public boolean containsKey(String key) {
		// TODO Auto-generated method stub
		int HashKey = key.hashCode() % 31;
		if (HashKey > K.length - 1) {
			while (HashKey > K.length - 1) {
				HashKey %= K.length;
			}
		}
		if (K[HashKey] == null) {
			// LinkedList not exist
			return false;
		}
		for (String c : K[HashKey]) {
			if (c.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public CourseReading remove(String key) {
		// TODO Auto-generated method stub
		if (containsKey(key) == true) {
			int HashKey = key.hashCode() % 31;
			if (HashKey > K.length - 1) {
				while (HashKey > K.length - 1) {
					HashKey %= K.length;
				}
			}
			for (String c : K[HashKey]) {
				if (c.equals(key)) {
					// get location of key to delete it
					int KeyLocation = K[HashKey].indexOf(key);
					K[HashKey].remove(KeyLocation);
					V[HashKey].remove(KeyLocation);
					size--;
					return null;
				}
			}
		}
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public void clear() {
		// TODO Auto-generated method stub
		int index = 0;
		size = 0;
		while (index < K.length) {
			if (K[index] != null) {
				K[index].clear();
				V[index].clear();
			}
			index++;
		}
	}

	@SuppressWarnings("unchecked")
	public void grow() {
		if (size / K.length > (0.8)) {
			LinkedList<String>[] CloneKeyMap = K.clone();
			LinkedList<CourseReading>[] CloneValMap = V.clone();
			K = new LinkedList[CloneKeyMap.length * 2];
			V = new LinkedList[CloneValMap.length * 2];
			K = CloneKeyMap.clone();
			V = CloneValMap.clone();
		}
	}
}
