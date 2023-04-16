public class Stack{
  
  Node topNode; //top node of stack 
  
//full arg constructor 
  Stack(){
  topNode = null;  //sets top node to null
}// end full arg constructor 

  //class methods 
  
  //pop 
  public Node pop(){
    if(topNode == null){
      return null; //if stack is empty, return null to tell that its empty
    }// end if 

    //temp
    Node temp = topNode;//temporary node that is the top node  
    topNode = temp.getNext(); //the second node is now the top node
    temp.setNext(null);//destroying the link between the next node
  
    return temp; 
  }// end pop method 
  
  public void push(Node node){
    node.setNext(topNode);//
    topNode = node; //top node 
  }// end push method 

  public Node peek(){
    if(topNode != null){
       return topNode; 
    }// end if 
    else{
      return null;
    }//end else
   
  }// end peek method 

  public boolean isEmpty(){
    if(topNode == null){
    return true;
    }//end if 
    else{
      return false;
    }//end else 
  }//end is empty
  
}// end Stack class 