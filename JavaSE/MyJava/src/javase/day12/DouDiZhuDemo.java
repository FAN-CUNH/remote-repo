package javase.day12;

import java.util.*;

public class DouDiZhuDemo {
    //成员变量
    LinkedHashMap<Integer,String> allCards = new LinkedHashMap<>();//存储所有编号对应牌字符串关系
    ArrayList<Integer> arrayList = new ArrayList<>();//所有的编号

    //编号对应的字符串
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> secord = new ArrayList<>();
    ArrayList<String> thid = new ArrayList<>();
    ArrayList<String> diPai = new ArrayList<>();
    //初始化
    public  void init(){
        //初始化编号和字符串的关系
        String[] colors = "♥-♠-♦-♣".split("-");
        String[] nums = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");
        int index = 2;
        for (int i = 0;i<nums.length;i++){

            for (int j = 0; j <colors.length ; j++) {
                String mess = colors[j]+nums[i];
                allCards.put(index,mess);
                index++;
            }

        }
        allCards.put(0,"大王");
        allCards.put(1,"小王");

        //初始化编号
        for (int i = 0; i < 54; i++) {
            arrayList.add(i);
        }

    }


    //洗牌
    public  void suffer(){
        Collections.shuffle(arrayList);
    }


    //发牌
    String firstAllBianHao = "";
    String secordAllBianHao = "";
    String thirdAllBianHao = "";
    String diPaiAllBianHao = "";

    public void faPai(){
        //先发
        for (int i = 0; i < arrayList.size()-3; i++) {
          //0    1  2
            //3  4  5
            //6   7  8
            if(i % 3 == 0 ) {
                Integer bianHao = arrayList.get(i);
                firstAllBianHao = firstAllBianHao + bianHao + "/";
                //排序
               // first.add(allCards.get(bianHao));
            }
            else if(i % 3 == 1){
                Integer bianHao = arrayList.get(i);
                secordAllBianHao = secordAllBianHao + bianHao + "/";
               // 排序
               // secord.add(allCards.get(bianHao));
            }
            else if(i % 3 == 2){
                Integer bianHao = arrayList.get(i);
                thirdAllBianHao = thirdAllBianHao + bianHao + "/";
                //thid.add(allCards.get(bianHao));
            }
        }

        //剩下的3的留底
        for (int i = arrayList.size()-3; i <arrayList.size() ; i++) {
            Integer bianHao = arrayList.get(i);
            diPaiAllBianHao = diPaiAllBianHao + bianHao + "/";
           // diPai.add(allCards.get(bianHao));
        }
        //1     2     3    4   5    6    7    8   9


    }
   //排序：编号排序
   public String[] paiXu(String bianHao) {
       //先将字符串拆分成数组
       String[] first = bianHao.split("/");
       //排序
       Arrays.sort(first, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               return Integer.parseInt(o1) - Integer.parseInt(o2);
           }
       });
       return first;

    }



    //看牌
    public  void kanPai(){
        //打印底牌
        System.out.println("以下是底牌：");
        String[] allBianHaos = paiXu(diPaiAllBianHao);
        for (int i = 0; i < allBianHaos.length; i++) {
            Integer everyBianHao = Integer.parseInt(allBianHaos[i]);//编号，map的key
             diPai.add(allCards.get(everyBianHao));
        }
        for (String card1:diPai
             ) {
            System.out.print(card1+"    ");
        }
        System.out.println();
        System.out.println("第一个人的牌");
        String[] allFirstBianHaos = paiXu(firstAllBianHao);
        for (int i = 0; i < allFirstBianHaos.length; i++) {
            Integer everyBianHao = Integer.parseInt(allFirstBianHaos[i]);//编号，map的key
            first.add(allCards.get(everyBianHao));
        }
        //打印第一个人牌
        for (String card1:first
        ) {
            System.out.print(card1+"    ");
        }
        System.out.println();
        System.out.println("以下是第二个人的牌");
        String[] allSecordBianHaos = paiXu(secordAllBianHao);
        for (int i = 0; i < allSecordBianHaos.length; i++) {
            Integer everyBianHao = Integer.parseInt(allSecordBianHaos[i]);//编号，map的key
            secord.add(allCards.get(everyBianHao));
        }
        //打印第二个人牌
        for (String card1:secord
        ) {
            System.out.print(card1+"    ");
        }
        System.out.println();
        System.out.println("以下是第三个人的牌：");
        String[] allThirdBianHaos = paiXu(thirdAllBianHao);
        for (int i = 0; i < allThirdBianHaos.length; i++) {
            Integer everyBianHao = Integer.parseInt(allThirdBianHaos[i]);//编号，map的key
            thid.add(allCards.get(everyBianHao));
        }
        //打印第三个人牌
        for (String card1:thid
        ) {
            System.out.print(card1+"    ");
        }


    }

    public static void main(String[] args) {
        DouDiZhuDemo douDiZhuDemo = new DouDiZhuDemo();
        douDiZhuDemo.init();
        douDiZhuDemo.suffer();
        douDiZhuDemo.faPai();
        douDiZhuDemo.kanPai();
    }

}
