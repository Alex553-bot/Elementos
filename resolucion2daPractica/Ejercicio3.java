import java.util.Scanner;
public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        Tree<Integer> tree = new Tree<Integer>();
        tree.data = 1;
        tree.i = 0;
        for (int i=2; i<=n; i++) {
            int a = sc.nextInt();
            Tree<Integer> aux = tree.find(a);
            Tree<Integer> nuevo = new Tree<Integer>();
            nuevo.data = i;
            nuevo.i = aux.i+1;
            aux.childs.add(nuevo);
        }
        tree.mirarArbol(tree); 
        sc.close();
    }
    

}
