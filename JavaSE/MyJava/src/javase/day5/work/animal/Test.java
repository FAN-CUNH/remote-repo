package javase.day5.work.animal;

public class Test {
    public static void main(String[] args) {
        Tiger myTig = new ActorTiger("黄色",2);
        Gorilla myGor = new ActorGorilla("黑色",3);
        Parrot myPar = new ActorParrot("绿色",1);
        ZooManager myZman = new ZooManager("邓超",30);
        myZman.feed(myTig);
        myZman.feed(myGor);
        myZman.feed(myPar);
        myZman.letItShow(((ActorTiger)myTig));
        myZman.letItShow((ActorGorilla)myGor);
        myZman.letItShow((ActorParrot)myPar);
    }
}
