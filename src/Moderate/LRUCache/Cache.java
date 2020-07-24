package Moderate.LRUCache;

import java.util.HashMap;

public class Cache {
	
	private int maxCacheSize;
	private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
	
	private LinkedListNode listHead = null;
	private LinkedListNode listTail = null;
	
	public Cache(int maxSize) {
		this.maxCacheSize= maxSize;
	}
	
	//Remove node from linked List
	public void removeFromLinkedList(LinkedListNode node) {
		
		if(node == null) return;
		if(node.prev != null) {node.prev.next = node.next;}
		if(node.next != null) {node.next.prev = node.prev;}
		
		if(node == listTail) {listTail = node.prev;}
		if(node == listHead) {listHead = node.next;}
	}
	
	//Insert node at front of the list
	public void insertAtFrontOfLinkedList(LinkedListNode node) {
		if(listHead == null) {
			listHead = node;
			listTail = node;
		} else {
			listHead.prev = node;
			node.next = listHead;
			listHead = node;
		}
	}
	
	//remove key/value pair from cache, deleting from hash table and linked list
	public boolean removeKey(int key) {
		LinkedListNode node = map.get(key);
		removeFromLinkedList(node);
		map.remove(key);
		return true;
	}
	
	//puts a new key value pair in cache. removes old value for key if necessary.
	//inserts a pair into hash table and linked list
	public void setKeyValue(int key, String value) {
		
		//remove key if already there
		removeKey(key);
		
		//if cache size is full, remove the least recently used cache
		if(map.size() >= maxCacheSize && listTail != null){
			removeKey(listTail.key);
		}
		
		//Insert New node
		LinkedListNode node = new LinkedListNode(key, value);
		insertAtFrontOfLinkedList(node);
		map.put(key, node);
		
		
	}
	
	//get value for key and mark that node as most recently used
	
	public String getValue(int key) {
		
		LinkedListNode node = map.get(key);
		if(node == null) return null;
		
		if(node != listHead)
		removeFromLinkedList(node);
		insertAtFrontOfLinkedList(node);
		
		return node.value;
	}
	
	
	

}
