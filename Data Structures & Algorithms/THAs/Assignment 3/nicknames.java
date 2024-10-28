/**
 * @author Ali
 */

import java.io.*;
import java.util.HashMap;

public class nicknames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(System.out)));

        //First stores nicknames already processed. Second stores AVL trees by 1st letter for max height.   
        HashMap<String, Integer> duplicates = new HashMap<String, Integer>();
        HashMap<Character, AVL> trees = new HashMap<Character, AVL>();

        //Reads names and inserts into corresponding AVL trees
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String nextName = br.readLine();
            char firstLetter = nextName.charAt(0);
            if (trees.containsKey(firstLetter)) {
                trees.get(firstLetter).insert(nextName);
            } else {
                AVL tree = new AVL();
                tree.insert(nextName);
                trees.put(firstLetter, tree);
            }
        }

        //Reads nicknames and query them through the corresponding AVL trees
        int b = Integer.parseInt(br.readLine());
        for (int j = 0; j < b; j++) {
            String nextNickname = br.readLine();
            int matches;
            if (duplicates.containsKey(nextNickname)) {
                matches = duplicates.get(nextNickname);
            } else {
                char firstLetter = nextNickname.charAt(0);
                if (trees.containsKey(firstLetter)) {
                    matches = trees.get(firstLetter).checkValid(nextNickname);
                } else {
                    matches = 0;
                }
                duplicates.put(nextNickname, matches);
            }
            pw.write(matches + "\n");
        }
        pw.close();
    }
}

//Vertex object for AVL tree
class Vertex {
    Vertex parent;
    Vertex left;
    Vertex right;
    String key;
    int height;
    int size;

    //Constructor for Vertex
    Vertex(String v) {
        this.key = v;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.size = 1;
    }
}

//AVL tree class
class AVL {
    Vertex root;

    //Constructor for AVL tree
    AVL() {
        this.root = null;
    }

    //Method to print inorder traversal
    void inorder() {
        inorder(this.root);
    }

    //Recursive method to print inorder traversal
    void inorder(Vertex T) {
        if (T != null) {
            inorder(T.left);
            System.out.println(T.key + " ");
            inorder(T.right);
        }
    }

    //Method to insert a new string into the AVL tree
    void insert(String v) {
        this.root = insert(this.root, v);
    }

    //Recursive method to insert a new string into the AVL tree
    Vertex insert(Vertex T, String v) {
        if (T == null) {
            return new Vertex(v);
        }
        if (v.compareTo(T.key) < 0) {
            T.left = insert(T.left, v);
            T.left.parent = T;
        } else {
            T.right = insert(T.right, v);
            T.right.parent = T;
        }
        updateSize(T);
        updateHeight(T);
        return checkRotation(T);
    }

    //Getter to check height of current Vertex
    int height(Vertex T) {
        return T == null ? -1 : T.height;
    }

    //Getter to check balance factor of current Vertex
    int balanceFactor(Vertex T) {
        return T == null ? 0 : height(T.left) - height(T.right);
    }

    //Setter to update new height of current Vertex
    void updateHeight(Vertex T) {
        if (T != null) {
            T.height = Math.max(height(T.left), height(T.right)) + 1;
        }
    }

    //Getter to check size of current Vertex
    int size(Vertex T) {
        return T == null ? 0: T.size;
    }

    //Setter to update new size of current Vertex
    void updateSize(Vertex T) {
        if (T != null) {
            T.size = size(T.left) + size(T.right) + 1;
        }
    }

    //Conducts left rotation about current Vertex and updates size/height of T and rotated Vertex
    Vertex rotateLeft(Vertex T) {
        if (T.right != null) {
            Vertex w = T.right;
            T.right = w.left;
            if (w.left != null) {
                w.left.parent = T;
            }
            w.parent = T.parent;
            if (T.parent == null) {
                this.root = w;
            } else if (T == T.parent.left) {
                T.parent.left = w;
            } else {
                T.parent.right = w;
            }
            w.left = T;
            T.parent = w;

            w.size = T.size;
            updateSize(T);
            updateHeight(T);
            updateHeight(w);
            return w;
        }
        return T;
    }

    //Conducts right rotation about current Vertex and updates size/height of T and rotated Vertex
    Vertex rotateRight(Vertex T) {
        if (T.left != null) {
            Vertex w = T.left;
            T.left = w.right;
            if (w.right != null) {
                w.right.parent = T;
            }
            w.parent = T.parent;
            if (T.parent == null) {
                this.root = w;
            } else if (T == T.parent.right) {
                T.parent.right = w;
            } else {
                T.parent.left = w;
            }
            w.right = T;
            T.parent = w;

            w.size = T.size;
            updateSize(T);
            updateHeight(T);
            updateHeight(w);
            return w;
        }
        return T;
    }

    //Checks if any rotations are needed about T based on its balance factor
    Vertex checkRotation(Vertex T) {
        if (balanceFactor(T) < -1) {
            if (balanceFactor(T.right) > 0) {
                T.right = rotateRight(T.right);
            }
            T = rotateLeft(T);
        } else if (balanceFactor(T) > 1) {
            if (balanceFactor(T.left) < 0) {
                T.left = rotateLeft(T.left);
            }
            T = rotateRight(T);
        }
        return T;
    }

    //Method to check if a nickname is valid and return number of matches
    int checkValid(String query) {
        Vertex highestValid = findHighestValid(this.root, query);
        if (highestValid == null) {
            return 0;
        }
        return 1 + checkLeft(highestValid.left, query) + checkRight(highestValid.right, query);
    }

    //Method to find highest valid Vertex recursively
    Vertex findHighestValid(Vertex T, String query) {
        if (T == null) {
            return null;
        }
        String current = T.key;
        if (current.indexOf(query) == 0) {
            return T;
        }
        int compare = query.compareTo(current);
        if (compare < 0) {
            return findHighestValid(T.left, query);
        } else {
            return findHighestValid(T.right, query);
        }
    }

    //Method to find lower bound Vertex recursively
    int checkLeft(Vertex T, String query) {
        if (T == null) {
            return 0;
        }
        String current = T.key;
        if (current.indexOf(query) == 0) {
            return 1 + checkLeft(T.left, query) + size(T.right);
        } else {
            return checkLeft(T.right, query);
        }
    }

    //Method to find upper bound Vertex recursively
    int checkRight(Vertex T, String query) {
        if (T == null) {
            return 0;
        }
        String current = T.key;
        if (current.indexOf(query) == 0) {
            return 1 + checkRight(T.right, query) + size(T.left);
        } else {
            return checkRight(T.left, query);
        }
    }
}