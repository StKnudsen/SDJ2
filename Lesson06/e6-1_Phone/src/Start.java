public class Start {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.volumeUpButton();
        phone.receiveCall();
        phone.turnVolumeDown();
        phone.receiveCall();
        phone.turnVolumeDown();
        phone.receiveCall();
        phone.goToVibrateState();
        phone.receiveCall();
    }
}
