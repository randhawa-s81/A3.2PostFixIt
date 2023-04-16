  public class Node{

  //class variables 
  int payLoad; //value stored in Node 
  Node next;   //points to next node in structure

  //constructor 
   Node(int value){
     next = null;
    payLoad = value;  
  }// end Node Construcotr 

  //no arg constructor 
  Node(){
    next = null; 
    payLoad = 0; 
  }// no arg constructor 

  //******getters*******
  
  public Node getNext(){
    return next; 
  }// end get next node 

  public int getPayLoad(){
    return payLoad; 
  }// end get paylaod 

  //******setters*******
  public void setPayLoad(int s){
    payLoad = s; 
  }// end set pay laod 

 public void setNext(Node node ){
   next = node; 
 }// end set Node 

    //@Override 
    //public String toString(){
      //return = Integer.toString(Node.getPayload()); 
    //}

}// end class Node 
