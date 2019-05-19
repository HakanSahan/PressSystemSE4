package be.springPressOrder.domain;

import java.util.Date;

public class Prediction {
    private Date madePrediction;
    private int predictedAmount;
    private Fruit predictedFruit;
    private Date beginPrediction;
    private Date endPrediction;

    public Prediction(Fruit predictedFruit, Date beginPrediction, Date endPrediction) {
        this.madePrediction = new Date();
        this.predictedFruit = predictedFruit;
        this.beginPrediction = beginPrediction;
        this.endPrediction = endPrediction;
    }

    public Date getMadePrediction() {
        return madePrediction;
    }

    public int getPredictedAmount() {
        return predictedAmount;
    }

    public Fruit getPredictedFruit() {
        return predictedFruit;
    }

    public Date getBeginPrediction() {
        return beginPrediction;
    }

    public Date getEndPrediction() {
        return endPrediction;
    }
}
