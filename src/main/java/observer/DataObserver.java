package observer;

import analysis.StatisticsCalculator;

public class DataObserver implements Observer {

    private StatisticsCalculator calculator;

    public DataObserver(StatisticsCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void update() {
        calculator.calculate();
    }
}