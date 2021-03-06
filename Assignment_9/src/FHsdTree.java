public class FHsdTree<E> implements Cloneable
{
   protected int mSize;
   protected FHsdTreeNode<E> mRoot;
   
   public FHsdTree()
   { 
      clear(); 
   }
   public boolean empty()
   { 
      return (mSize == 0); 
   }
   public int sizePhysical()
   {
      return mSize; 
   }
   public void clear()
   {
      mSize = 0; mRoot = null; 
   }
   
   public FHsdTreeNode<E> find(E x) { return find(mRoot, x, 0); }
   public boolean remove(E x) { return remove(mRoot, x); }
   public void  display()  { displayPhysical(mRoot, 0); }
   //count virtual tree size
   public int size()
   { 
      return size_of_node(mRoot);
   }
   
   public < F extends Traverser< ? super E > > 
   void traverse(F func)  { traverse(func, mRoot, 0); }
   
   public FHsdTreeNode<E> addChild( FHsdTreeNode<E> treeNode,  E x )
   {
      // empty tree? - create a root node if user passes in null
      if (mSize == 0)
      {
         if (treeNode != null)
            return null; 
         mRoot = new FHsdTreeNode<E>(x, null, null, null, false);
         mRoot.myRoot = mRoot;
         mSize = 1;
         return mRoot;
      }
      // error inserting into non_null tree with a null parent
      if (treeNode == null)
         return null;
      // silent error, node does not belong to this tree
      if (treeNode.myRoot != mRoot)
         return null;  
      //error, add node to a deleted node
      if (treeNode.deleted == true)
         return null;

      // push this node into the head of the sibling list; adjust prev pointers
      FHsdTreeNode<E> newNode = new FHsdTreeNode<E>(x, 
         treeNode.firstChild, null, treeNode, mRoot, false);  
      treeNode.firstChild = newNode;
      if (newNode.sib != null)
         newNode.sib.prev = newNode;
      ++mSize;
      return newNode;  
   }
   
   public FHsdTreeNode<E> find(FHsdTreeNode<E> root, E x, int level)
   {
      FHsdTreeNode<E> retval;

      if (mSize == 0 || root == null)
         return null;

      if (root.data.equals(x) && root.deleted == false)
         return root;

      // otherwise, recurse.  don't process sibs if this was the original call
      if ( level > 0 && (retval = find(root.sib, x, level)) != null )
         return retval;
      return find(root.firstChild, x, ++level);
   }
   
   //not physically remove the node
   public boolean remove(FHsdTreeNode<E> root, E x)
   {
      FHsdTreeNode<E> tn = null;

      if (mSize == 0 || root == null)
         return false;
     
      if ( (tn = find(root, x, 0)) != null )
      {
         tn.deleted = true;
         return true;
      }
      return false;
   }
   
   private void removeNode(FHsdTreeNode<E> nodeToDelete )
   {
      if (nodeToDelete == null || mRoot == null)
         return;
      if (nodeToDelete.myRoot != mRoot)
         return;  // silent error, node does not belong to this tree

      // remove all the children of this node
      // (but for decrementing mSize, this loop might be unnecessary)
      while (nodeToDelete.firstChild != null)
         removeNode(nodeToDelete.firstChild);

      if (nodeToDelete.prev == null)
         mRoot = null;  // last node in tree
      else if (nodeToDelete.prev.sib == nodeToDelete)
         nodeToDelete.prev.sib = nodeToDelete.sib; // adjust left sibling
      else
         nodeToDelete.prev.firstChild = nodeToDelete.sib;  // adjust parent

      // adjust the successor sib's prev pointer
      if (nodeToDelete.sib != null)
         nodeToDelete.sib.prev = nodeToDelete.prev;
      --mSize;
   } 
   
   // count nodes excluded deleted nodes
   public int size_of_node(FHsdTreeNode<E> treeNode)
   {
      if(mRoot == null || mRoot.deleted == true)
         return 0;
      
      int retval=1;
      for(FHsdTreeNode<E> node = treeNode.firstChild; 
            node != null; node=node.sib)
      {
         if(node.deleted == false)
            retval += size_of_node(node);
      }
      return retval;
   }
   
   //remove deleted nodes  
   public void collectGarbage(FHsdTreeNode<E> node_to_collect)
   {
      if(node_to_collect.deleted)
      {      
         removeNode(node_to_collect);
         return;
      }

      for (FHsdTreeNode<E> node = node_to_collect.firstChild; 
            node!=null; node=node.sib)
         collectGarbage(node);
   }

   
   public Object clone() throws CloneNotSupportedException
   {
      FHsdTree<E> newObject = (FHsdTree<E>)super.clone();
      newObject.clear();  // can't point to other's data

      newObject.mRoot = cloneSubtree(mRoot);
      newObject.mSize = mSize;
      newObject.setMyRoots(newObject.mRoot);
      
      
      return newObject;
   }
   
   private FHsdTreeNode<E> cloneSubtree(FHsdTreeNode<E> root)
   {
      FHsdTreeNode<E> newNode;
      if (root == null)
         return null;

      // does not set myRoot which must be done by caller
      newNode = new FHsdTreeNode<E>
      (
         root.data, 
         cloneSubtree(root.sib), cloneSubtree(root.firstChild),
         null,false
      );
      
      // the prev pointer is set by parent recursive call ... this is the code:
      if (newNode.sib != null)
         newNode.sib.prev = newNode;
      if (newNode.firstChild != null)
         newNode.firstChild.prev = newNode;
      return newNode;
   }
   
   // recursively sets all myRoots to mRoot
   private void setMyRoots(FHsdTreeNode<E> treeNode)
   {
      if (treeNode == null)
         return;

      treeNode.myRoot = mRoot;
      setMyRoots(treeNode.sib);
      setMyRoots(treeNode.firstChild);
      
   }
   
   // define this as a static member so recursive display() does not need
   // a local version
   final static String blankString = "                                    ";
   
   // let be public so client can call on subtree
   public void  displayPhysical(FHsdTreeNode<E> treeNode, int level) 
   {
      String indent;

      // stop runaway indentation/recursion
      if  (level > (int)blankString.length() - 1)
      {
         System.out.println( blankString + " ... " );
         return;
      }
      
      if (treeNode == null)
         return;

      indent = blankString.substring(0, level);

      // pre-order processing done here ("visit")      
      if(treeNode.deleted) 
         System.out.println( treeNode.data + 
               "(D)");
      else System.out.println( indent + treeNode.data);
      
      // recursive step done here
      displayPhysical( treeNode.firstChild, level + 1 );
      if (level > 0 )
         displayPhysical( treeNode.sib, level );
   }
      
   // often helper of typical public version, but also callable by on subtree
   public <F extends Traverser<? super E>> 
   void traverse(F func, FHsdTreeNode<E> treeNode, int level)
   {
      if (treeNode == null)
         return;
      if (!treeNode.deleted)
         func.visit(treeNode.data);
      
      // recursive step done here
      traverse( func, treeNode.firstChild, level + 1);
      if (level > 0 )
         traverse( func,  treeNode.sib, level);
   }
   
  
}
