package be.springPressOrder.domain;

import java.util.Date;

public class Weather {
    private int averageAmountOfRain;
    private int avarageHoursOfSun;
    private double avarageWindSpeed;
    private double avarageTemperature;
    private Date beginDate;
    private Date endDate;

    public Weather(int averageAmountOfRain, int avarageHoursOfSun, double avarageWindSpeed, double avarageTemperature, Date beginDate, Date endDate) {
        this.averageAmountOfRain = averageAmountOfRain;
        this.avarageHoursOfSun = avarageHoursOfSun;
        this.avarageWindSpeed = avarageWindSpeed;
        this.avarageTemperature = avarageTemperature;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public int getAverageAmountOfRain() {
        return averageAmountOfRain;
    }

    public int getAvarageHoursOfSun() {
        return avarageHoursOfSun;
    }

    public double getAvarageWindSpeed() {
        return avarageWindSpeed;
    }

    public double getAvarageTemperature() {
        return avarageTemperature;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
