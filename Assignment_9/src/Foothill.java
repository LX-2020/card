import java.text.*;
import java.util.*;

//------------------------------------------------------
public class Foothill
{ 
   // -------  main --------------
   public static void main(String[] args) throws Exception
   {
      FHsdTree<String> sceneTree = new FHsdTree<String>();
      FHsdTreeNode<String> tn;
      
      // create a scene in a room
      tn = sceneTree.addChild(null, "room");

      // add three objects to the scene tree
      sceneTree.addChild(tn, "Lily the canine");
      sceneTree.addChild(tn, "Miguel the human");
      sceneTree.addChild(tn, "table");
      
      // add some parts to Miguel
      // Miguel's left arm
      tn = sceneTree.find("Miguel the human");      
      tn = sceneTree.addChild(tn, "torso");
      tn = sceneTree.addChild(tn, "left arm");
      tn =  sceneTree.addChild(tn, "left hand");
      sceneTree.addChild(tn, "thumb");
      sceneTree.addChild(tn, "index finger");
      sceneTree.addChild(tn, "middle finger");
      sceneTree.addChild(tn, "ring finger");
      sceneTree.addChild(tn, "pinky");
      // Miguel's right arm
      tn = sceneTree.find("Miguel the human");
      tn = sceneTree.find(tn, "torso", 0);
      tn = sceneTree.addChild(tn, "right arm");
      tn =  sceneTree.addChild(tn, "right hand");
      sceneTree.addChild(tn, "thumb");
      sceneTree.addChild(tn, "index finger");
      sceneTree.addChild(tn, "middle finger");
      sceneTree.addChild(tn, "ring finger");
      sceneTree.addChild(tn, "pinky");

      // add some parts to Lily
      tn = sceneTree.find("Lily the canine");
      tn = sceneTree.addChild(tn, "torso");
      sceneTree.addChild(tn, "right front paw");
      sceneTree.addChild(tn, "left front paw");
      sceneTree.addChild(tn, "right rear paw");
      sceneTree.addChild(tn, "left rear paw");
      sceneTree.addChild(tn, "spare mutant paw");
      sceneTree.addChild(tn, "wagging tail");

      // add some parts to table
      tn = sceneTree.find("table");
      sceneTree.addChild(tn, "north east leg");
      sceneTree.addChild(tn, "north west leg");
      sceneTree.addChild(tn, "south east leg");
      sceneTree.addChild(tn, "south west leg");

      sceneTree.display();
      System.out.println("\nVirtual Size: " + sceneTree.size());
      System.out.println("\nPhysical Size: " + sceneTree.sizePhysical() + "\n");

      // see if the clone worked
      FHsdTree<String> ClonedTree = (FHsdTree<String>) sceneTree.clone();
      System.out.println("Clone display");
      ClonedTree.display();
      System.out.println("\nClone's Virtual Size: " + ClonedTree.size() + "\n");

      // remove some nodes
      sceneTree.remove("spare mutant paw");
      sceneTree.remove("Miguel the human");
      sceneTree.remove("an imagined higgs boson");
      System.out.println("\nAfter remove nodes:\n");
      sceneTree.display();
      System.out.println("\nVirtual Size after remove nodes:" 
      + sceneTree.size());
      System.out.println("\nPhysical Size after remove nodes: "
      + sceneTree.sizePhysical() + "\n");

      //test collect garbage
      sceneTree.collectGarbage(sceneTree.mRoot.myRoot);
      System.out.println("\nAfter collect garbage:\n");
      sceneTree.display();
      System.out.println("\nVirtual Size after collect garbage: " 
      + sceneTree.size());
      System.out.println("\nPhysical Size after collect garbage: " 
      + sceneTree.sizePhysical() + "\n");

      
   }

}
