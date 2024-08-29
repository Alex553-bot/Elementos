import LSE.*;
public class Tren<T extends Comparable> 
{
	private Stack<T> stack; 
	public void setStack(Stack<T> stack) {
		this.stack = stack;
	}

	public void eliminarVagon(T id) {
		Stack<T> auxiliar = new Stack<T>(); 
		Stack<T> descarte = new Stack<T>(); 
		while (stack.size()>0 && stack.top().compareTo(id)!=0) {
			auxiliar.push(stack.top());
			stack.pop();
		}
		while (stack.size()>0) {
			descarte.push(stack.top());
			stack.pop();			
		}


		while (descarte.size()>1) {
			stack.push(descarte.top());
			descarte.pop();
		}

		while (auxiliar.size()>0) {
			stack.push(auxiliar.top());
			auxiliar.pop();
		}	
	}
	public void print() {
		Stack<T> aux = new Stack<T>();
		while (stack.size()>0) {
			aux.push(stack.top()); 
			System.out.println(stack.top().toString()); 
			stack.pop();
		}
		while (aux.size()>0) {
			stack.push(aux.top()); 
			aux.pop();
		}
	}
}