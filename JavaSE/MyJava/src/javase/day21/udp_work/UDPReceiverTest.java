package javase.day21.udp_work;


/**
 * @ClassName UDPReceiverTest
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/8 18:55
 * @Version 1.0
 */
public class UDPReceiverTest {
    public static void main(String[] args) throws Exception {
        /*实例化UDP发送端*/
        UDPReceiver udpReceiver = new UDPReceiver();
        udpReceiver.receiveMess();
    }
}
