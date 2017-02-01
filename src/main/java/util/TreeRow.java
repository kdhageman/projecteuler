package util;

public class TreeRow {
		public TreeRow child;
		public int[] values;
		
		public TreeRow(){
			child = null;
		}
		
		/* returns the value of the child row left of the given index node */
		public int leftChild(int index){
			if (child != null && child.values.length > index){
				return child.values[index];
			}
			return -1;
		}
		
		/* returns the value of the child row right of the given index node */
		public int rightChild(int index){
			if (child != null && child.values.length > index+1){
				return child.values[index+1];
			}
			return -1;
		}
		
		public int depth(){
			if (child == null){
				return 1;
			}
			return 1 + child.depth();
		}

		/* returns the maximum total for the subtree denoted by root created from the index */
		public int maxTotal(int index){
			if (child == null){
				return values[index];
			}
			else if (child.values.length > index+1){
				return values[index] + Math.max(child.maxTotal(index), child.maxTotal(index+1));	
			}
			return -1;
			
			
		}
		
		public TreeRow getLeaf(){
			if (child == null){
				return this;
			}
			else{
				return child.getLeaf();
			}
		}
		
		public String toString(){
			String res = "";
			for (int v : values) {
				res += " " + v;
			}
			if (child != null){
				res += "\n" + child.toString();
			}
			return res;
		}
		
}
