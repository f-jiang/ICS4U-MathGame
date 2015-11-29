/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.gui;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import mathgame.util.calculator.Calculator;

/**
 *
 * @author feilan
 */
public class FunctionPlot extends LineChart {            
    
    public FunctionPlot(NumberAxis xAxis, NumberAxis yAxis, String function, String var) {
        super(xAxis, yAxis);
        this.getData().add(getSeries(function, var));
        this.setCreateSymbols(false);
    }
    
    private XYChart.Series<Double, Double> getSeries(String function, String var) {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        NumberAxis xAxis = (NumberAxis) this.getXAxis();
        double start = xAxis.getLowerBound();
        double end = xAxis.getUpperBound();
        double tickUnit = xAxis.getTickUnit();
        double x, y;
                        
        for (x = start; x < end; x += tickUnit) {            
            Calculator.storeVariable(var, x);
            y = Double.parseDouble(Calculator.eval(function, false));
            series.getData().add(new XYChart.Data<>(x, y));
        }
        
        return series;
    }
    
}
