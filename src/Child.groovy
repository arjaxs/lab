/**
 * Created by Development on 6/2/2014.
 */
class Child extends Parent {


   def  printCount(){
       //this.count=5;
      println     this.incrementCount(3);
   }

static main(String[] args){

def d=new Child();

    d.printCount();

}




}
