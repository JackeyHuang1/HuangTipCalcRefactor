public class TipCalculator {
    private int numPeople;
    private int tipPercentage;
    private double totalBillBeforeTip;

    public TipCalculator(int numPeople, int tipPercentage) {
        this.numPeople = numPeople;
        this.tipPercentage = tipPercentage;
        totalBillBeforeTip = 0.0;
    }

    public double getTotalBillBeforeTip() {
        return totalBillBeforeTip;
    }

    public int getTipPercentage() {
        return tipPercentage;
    }

    public void addMeal(double cost) {
        totalBillBeforeTip += cost;
    }

    public double tipAmount() {
        return totalBillBeforeTip*tipPercentage*0.01;
    }

    public double totalBill() {
        return totalBillBeforeTip + (totalBillBeforeTip*tipPercentage*0.01);
    }
    public double perPersonCostBeforeTip() {
        return totalBillBeforeTip / numPeople;
    }

    public double perPersonTipAmount() {
        return (totalBillBeforeTip * tipPercentage * 0.01) / numPeople;
    }

    public double perPersonTotalCost() {
        return (totalBillBeforeTip + (totalBillBeforeTip * tipPercentage * 0.01)) / numPeople;
    }
}