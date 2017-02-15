/**
 * An implementation of the ADT Dequeue using a doubly linked list
 * Angel Jauregui
 * February 15 2017
 * 
 */

package cs240;

public class Dequeue<T> implements DequeueInterface<T> {

	private DLNode firstNode;
	private DLNode lastNode;
	
	public Dequeue(){
		
	}
	
	@Override
	public void addToFront(Object newEntry) {
		@SuppressWarnings("unchecked")
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		
		if(isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		
		firstNode = newNode;
		
	}

	@Override
	public void addToBack(Object newEntry) {
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T result = null;
		if(!isEmpty()){
			result = (T) firstNode.getData();
			firstNode = firstNode.getNextNode();
			
			if(firstNode == null)
				lastNode = null;
			else
				firstNode.setPreviousNode(null);
		}
		
		return result;
	}

	@Override
	public T removeBack() {
		T result = null;
		if(!isEmpty()){
			result = (T) lastNode.getData();
			lastNode = lastNode.getPreviousNode();
			
			if(lastNode == null)
				firstNode = null;
			else
				lastNode.setNextNode(null);
		}
		return result;
	}

	@Override
	public T getFront() {
		return (T) firstNode.getData();
	}

	@Override
	public T getBack() {
		return (T) lastNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

	
	private class DLNode<T>{
		private T data;
		private DLNode before;
		private DLNode after;
		
		private DLNode(DLNode before, T data, DLNode after){
			this.before = before;
			this.data = data;
			this.after = after;
		}
		
		private void setNextNode(DLNode newNode){
			after = newNode;
		}
		
		private DLNode getNextNode(){
			return after;
		}
		
		private void setPreviousNode(DLNode newNode){
			before = newNode;
		}
		
		private DLNode getPreviousNode(){
			return before;
		}
		
		private void setData(T data){
			this.data = data;
		}
		
		private T getData(){
			return data;
		}
	}
}
