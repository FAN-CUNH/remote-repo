package basejava.day6.work;

public class Work4 {
    // 在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100的整数
    // 选手的最后得分为：去掉一个最高分和一个最低分后 其余4个评委打分的平均值。(不考虑小数部分)
    public static void main(String[] args) {
        int [] score = {5,2,8,6,4,3};
        // 遍历数组，找出最小值和最大值
        // 假设第一个数既是最大值又是最小值
        int max = 0; // 最大值下标
        int min = 0; // 最小值下标
        int sum = 0,avg = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > score[max]){ // 当前数比最大值大就把下标传给max
                max = i;
            }
            if (score[i] < score[min]){ // 当前数比最小值小就把下标传给min
                min = i;
            }
        }
        for (int i = 0; i < score.length; i++) {
            if (i != max && i != min){ // 既不是最大值也不是最小值
                sum+=score[i]; // 和
            }
        }
        avg = sum / (score.length-2); // 平均值
        System.out.println("平均值为："+avg);
    }
}
