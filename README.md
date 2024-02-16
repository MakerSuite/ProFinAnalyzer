# ProFinAnalyzer\n**Motto:** Making investing easy!\n\n**Short description:** Provides a tool for technical analysis of financial data about companies indexed on the stock market using machine learning techniques.\n\n## Introduction\n\nProFinAnalyzer is a tool and library that is supposed to make investment easy. However, it should not be used as the only tool for financial analysis and we are not liable of any profit or loss made by users (see also disclaimer section). The aim of the tool is to provide easy access to the openly available information about companies indexed on the stock market and to provide a platform for analysis of these financial information. Two areas of analysis are identified - **technical** and **event** based. \n\nUnder technical analysis we consider technical indicators and values such as price, financial ratios (PE ration, Book/Price ration, etc.)\n\nUnder event driven analysis we identify events that are publicized by news articles. \n\nCurrently, the tool focuses on long term investment and price changes. \n\nAnalysis of technical indicator and prediction whether the price will grow (at least 10% over one year period) can be done by machine learning and I have already published a research on it (http://arxiv.org/abs/1603.00751).\n\nAnalysis of news can be also important part of the decision and it could be useful to analyze automatically sentiment of the titles.  \n\n![alt tag](https://github.com/MakerSuite/ProFinAnalyzer/blob/master/img/Screen1.png)\n\n\n## How does it work?\n\nAt the moment the ProFinAnalyzer obtains data from the API provided by Yahoo! Finance. News titles are obtained by using rss feed from the Yahoo! Finance as well. To the input field should be input symbol of the company at the stockmarket (in the future, company name will be possible as well). \n\nWe have automatic analyst of technical indicators that is based on Random Forests machine learning algorithm. Analyst based on 8 indicators and machine learning should be able to predict whether a price will move up at least 10% (he will say "Buy" in that case) over the period of one year in 71% of cases. Indicators that are used by analyst are:\n* Market Capitalization\n* Book Value\n* Dividend Yield\n* Earnings Per Share\n* P/E Ratio\n* Price/Book Ratio\n* Price/Sales Ratio\n* Current stock price \n\nAs we said we obtain news from the feed at Yahoo! Finance. They can be clicked and browser will fully open them.\n\n## As library\n\nMost of the actions application can perform can be used in library settings. Class DataCollector provides means for collecting currently 20 values:\n* Company Name (Name)\n* Symbol (symbol)\n* Stock exchange on which it is traded (StockExchange)\n* Market Capitalization (MarketCap)\n* Ask (Ask)\n* Bid(Bid)\n* Average daily volume (AverageDayVolume)\n* P/E Ratio (PERatio2)\n* Real time P/E Ratio (PERatioRT)\n* Dividend Yield (DividendYield)\n* Price/Book ratio (priceBook)\n* Earnings per share (EarningsPerShare)\n* Price/Sales ratio (PriceSales)\n* Book Value (BookValue)\n* 52 weeks low price (52weekLow)\n* 52 week high price ("52weekhigh")\n* Change from 52 week low (ChangeFromYearLow)\n* Price change in percentages (PriceChangePercent)\n* Price change real time (PriceChangeRT)\n\nThe values are returned as HashMap from the function with the following signature: \n`public Map<String, String> getData(String ticker)`\n\nNews can be retrieved using the following function:\n`public LinkedList<NewsItem> obtainNews(String ticker)`\n\nAt the end classification using our model can be done using following function after the data is obtained using getData:\n`public String Classify()`\n\n## Mailing list\n- To post on your mailing list, simply send email to finanalyzer@freelists.org.\n\n- Subscribers can join your list by sending email to finanalyzer-request@freelists.org with 'subscribe' in the Subject field OR by visiting your list page at http://www.freelists.org/list/finanalyzer. \n\n- Once subscribed, please introduce yourself and your interests.\n\n\n## Reference\nMilosevic, Nikola. "Equity forecast: Predicting long term stock price movement using machine learning." arXiv preprint arXiv:1603.00751 (2016). http://arxiv.org/abs/1603.00751\n\n## Contact\nIf you have any questions regarding the project, paper or would like 