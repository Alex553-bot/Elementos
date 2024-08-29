import java.util.Scanner;
import java.util.ArrayList;
public class Main 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree<Integer> root = new Tree<Integer>(15);
        root.childs.add(new Tree<Integer>(25));
        root.childs.add(new Tree<Integer>(12));
        root.childs.get(0).childs.add(new Tree<Integer>(3)); 
        Tree<Integer> segundl = new Tree<Integer>(1);
        root.childs.get(0).childs.add(segundl);
        root.childs.get(1).childs.add(new Tree<Integer>(34)); 
        Tree<Integer> ult = new Tree<Integer>(10);
        root.childs.get(1).childs.add(ult);
        Tree<Integer> first = new Tree<Integer>(1); 
        root.childs.get(0).childs.get(0).childs.add(first); 
        root.childs.get(1).childs.get(0).childs.add(new Tree<>(30));
        Tree<Integer> ter = new Tree<>(23);
        root.childs.get(1).childs.get(0).childs.get(0).childs.add(ter);


        first.nextLeaf = segundl;
        segundl.nextLeaf = ter;
        ter.nextLeaf = ult;

        ArrayList<Tree<Integer>> nodos = root.leafs();
        for (int i= 0; i<nodos.size(); i++) 
            System.out.println(nodos.get(i).data.toString());

        sc.close();
    }
    private static Stack<Integer> stack = new Stack<>();
    public static void add(int i) {
        if (stack.size()==0) stack.push(i); 
        else {
            int ac = i; 
            while (stack.size()!=0 && stack.top()==ac) {
                stack.pop(); 
                ac*=2; 
            }
            stack.push(ac);
        }
    }
    public static void print() {
        while (stack.size()!=0) {
            System.out.println(stack.top().toString());
            stack.pop();
        }
    }
}