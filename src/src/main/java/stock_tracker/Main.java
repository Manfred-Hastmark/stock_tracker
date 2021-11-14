package stock_tracker;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args){
        BasicConfigurator.configure();
        new Main();
    }

    final String[] symbols = {"MSFT", "AAPL", "AMZN", "GOOGL", "GOOG", "TSLA", "FB", "NVDA", "BRK.B", "JPM", "UNH", "JNJ", "HD", "V", "PG", "BAC", "ADBE", "DIS", "CRM", "MA", "NFLX", "XOM", "PFE", "CMCSA", "TMO", "CSCO", "PYPL", "ACN", "AVGO", "PEP", "COST", "CVX", "ABT", "NKE", "KO", "VZ", "WMT", "MRK", "LLY", "INTC", "WFC", "ABBV", "DHR", "MCD", "QCOM", "AMD", "T", "TXN", "LIN", "INTU", "NEE", "LOW", "MDT", "HON", "UNP", "ORCL", "UPS", "PM", "MS", "AMAT", "BLK", "C", "RTX", "NOW", "GS", "SBUX", "BMY", "ISRG", "AMT", "TGT", "CVS", "GE", "BA", "SCHW", "AMGN", "AXP", "CAT", "SPGI", "PLD", "BKNG", "IBM", "MMM", "ANTM", "ZTS", "COP", "DE", "ADI", "ADP", "SYK", "LRCX", "CHTR", "PNC", "MDLZ", "TFC", "GM", "MU", "CB", "TJX", "MMC", "LMT", "MRNA", "GILD", "MO", "USB", "EL", "CSX", "CME", "F", "DUK", "SHW", "CCI", "ICE", "EW", "CI", "ADSK", "EQIX", "FIS", "TMUS", "NSC", "BDX", "ETN", "APD", "COF", "ITW", "AON", "SO", "CL", "REGN", "KLAC", "MCO", "WM", "DXCM", "FDX", "BSX", "HCA", "D", "FISV", "NXPI", "EMR", "ILMN", "HUM", "FCX", "ECL", "EOG", "PGR", "SPG", "NOC", "JCI", "MSCI", "IDXX", "SNPS", "EXC", "TEL", "ATVI", "DG", "ROP", "ALGN", "CMG", "XLNX", "CDNS", "INFO", "AIG", "TROW", "VRTX", "PSA", "APH", "A", "IQV", "SLB", "CARR", "FTNT", "EBAY", "GD", "APTV", "BK", "MET", "MCHP", "NEM", "LHX", "MAR", "TT", "KMB", "DLR", "ORLY", "SIVB", "DOW", "CNC", "MTCH", "TWTR", "MPC", "ROST", "PH", "PXD", "DD", "CTSH", "MSI", "PRU", "AEP", "HLT", "SYY", "BIIB", "AZO", "EA", "SRE", "PAYX", "TRV", "GPN", "O", "ROK", "BAX", "FRC", "PPG", "GIS", "SBAC", "CTAS", "HPQ", "IFF", "RMD", "YUM", "STZ", "ADM", "MTD", "WELL", "TDG", "OTIS", "CBRE", "ANSS", "WBA", "EFX", "CTVA", "STT", "DFS", "VRSK", "AFL", "AMP", "PSX", "WMB", "XEL", "KEYS", "MNST", "ALL", "MCK", "CMI", "FAST", "AVB", "AJG", "NUE", "ODFL", "KMI", "CPRT", "ENPH", "AME", "ALB", "VLO", "ZBRA", "DHI", "PEG", "ETSY", "AWK", "WST", "PCAR", "SWK", "FITB", "LUV", "WLTW", "OXY", "BBY", "BLL", "LEN", "GLW", "ANET", "EQR", "OKE", "ES", "ARE", "KR", "DAL", "IT", "URI", "WEC", "KSU", "FTV", "WY", "SYF", "ZBH", "RSG", "GNRC", "DVN", "VMC", "SWKS", "ED", "EXPE", "LH", "EXR", "MLM", "DLTR", "CDW", "HSY", "NTRS", "TSCO", "DOV", "KMX", "HIG", "EIX", "NDAQ", "KHC", "PAYC", "VFC", "IR", "LYB", "XYL", "TSN", "HES", "MPWR", "HBAN", "MAA", "RF", "VRSN", "KEY", "TER", "STE", "HAL", "TRMB", "TYL", "ESS", "PPL", "CHD", "CERN", "GRMN", "DTE", "TTWO", "ULTA", "CZR", "VIAC", "WAT", "AEE", "COO", "DRE", "CTLT", "EXPD", "POOL", "GWW", "BKR", "FE", "BR", "NTAP", "ETR", "TDY", "CLX", "CFG", "HPE", "DRI", "MKC", "FLT", "RCL", "VTR", "STX", "BBWI", "MTB", "PKI", "TECH", "CCL", "GPC", "CRL", "IP", "FANG", "CE", "MGM", "AMCR", "AVY", "J", "CINF", "RJF", "ABC", "DPZ", "PEAK", "WAB", "HOLX", "IEX", "AKAM", "VTRS", "QRVO", "NVR", "CMS", "CTRA", "DGX", "WDC", "TXT", "PFG", "UAL", "ABMD", "BXP", "PWR", "JBHT", "CDAY", "MAS", "TFX", "K", "AES", "BIO", "CAG", "LKQ", "CNP", "UDR", "LYV", "EMN", "AAP", "OMC", "BRO", "MKTX", "EVRG", "NLOK", "FBHS", "AAL", "CAH", "IPG", "KIM", "CBOE", "SJM", "LUMN", "LNT", "WHR", "IRM", "FMC", "CF", "MRO", "LVS", "FFIV", "PHM", "BF.B", "RHI", "FOXA", "HST", "MOS", "PTC", "WRK", "HWM", "LNC", "PKG", "LDOS", "HAS", "INCY", "CHRW", "PNR", "HRL", "XRAY", "ATO", "ALLE", "TPR", "JKHY", "L", "CMA", "SNA", "APA", "WRB", "REG", "CTXS", "BWA", "HSIC", "RE", "ZION", "AOS", "JNPR", "NCLH", "WYNN", "BEN", "NI", "UHS", "SEE", "MHK", "AIZ", "NWSA", "OGN", "NWL", "DISH", "FRT", "IVZ", "PENN", "PVH", "TAP", "GL", "NRG", "LW", "DXC", "CPB", "ROL", "HII", "PBCT", "NLSN", "DISCK", "ALK", "WU", "DVA", "PNW", "VNO", "HBI", "RL", "IPGP", "LEG", "FOX", "GPS", "UAA", "DISCA", "UA", "NWS"};

    public Main() {
        long time = System.currentTimeMillis();



        /*---------SELENIUM TO YAHOO TEST----------------*/
        /*
        //Setting up driver to Yahoo, and accepting cookies
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette",true);
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://finance.yahoo.com");
        driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/strong/div/button")).click();

        int amount = 5;
        Stock[] stocks = new Stock[amount];
        for(int i = 0; i < amount; i++) {
            stocks[i] = new Stock(symbols[i]);
            stocks[i].getStockFromYahoo(driver);
        }
        driver.close();

        for (int i = 0; i < amount; i++) {
            System.out.println(stocks[i].toString());
        }*/



        /*------------POLYGON API TEST-----------------------*/
        /* Polygon example on S&P500
        String key = "089ilp32IPk8A9DujSSGrVqluYLYSotj";
        Stock[] stocks = new Stock[symbols.length];

        for (int i = 0; i < stocks.length; i++) {
            stocks[i] = new Stock(symbols[i]);
            stocks[i].getValuesFromPolygonAPI(key);
            System.out.println(stocks[i].toString());
        }*/

        System.out.println("Execution time: " + (System.currentTimeMillis() - time) + "ms");
    }
}
