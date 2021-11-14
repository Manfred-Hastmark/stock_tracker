package stock_tracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Stock {
    private final String SYMBOL;
    private double open,close,high,low;

    /* Constructors */

    public Stock(String symbol) {
        this.SYMBOL = symbol;
    }

    public Stock(String symbol, double open, double close, double high, double low) {
        this.SYMBOL = symbol;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    /* Functions */

    public void getValuesFromPolygonAPI(String key) {
        try {
            URL url = new URL("https://api.polygon.io/v2/aggs/ticker/" + getSYMBOL() + "/prev?adjusted=true&apiKey=" + key);
            URLConnection connection = url.openConnection();

            //Get page as stringbuilder
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuilder page = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                page.append(inputLine);
            in.close();

            open = getValueAt("\"o\":", page);
            close = getValueAt("\"c\":", page);
            high = getValueAt("\"h\":", page);
            low = getValueAt("\"l\":", page);
        } catch (Exception e) {
            System.out.println("Not able to retrieve data from API");
        }
    }

    private double getValueAt(String pattern, StringBuilder page) {
        int index = page.indexOf(pattern) + pattern.length();
        StringBuilder result = new StringBuilder();
        while(48 <= page.charAt(index) && page.charAt(index) <= 58 || page.charAt(index) == 46){ //Number 0-9 and .
            result.append(page.charAt(index));
            index++;
        }
        return Double.parseDouble(result.toString());
    }

    

    @Override
    public String toString() {
        return "Stock{" +
                "SYMBOL='" + SYMBOL + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                '}';
    }

    /* Setters */

    public void setOpen(int open) {
        this.open = open;
    }

    public void setClose(int close) {
        this.close = close;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    /* Getters */

    public String getSYMBOL() {
        return SYMBOL;
    }

    public double getOpen() {
        return open;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }
}
