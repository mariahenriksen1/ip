public class main {
    public static void main(String[] args) {
        RejseKort card = new RejseKort();
        card.depositMoney(100);

        card.checkIn(1, 5, 34);
        card.checkOut(1, 5, 34);
    
    }

    
}
