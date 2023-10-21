# ProFinAnalyzer\n**Motto:** Making investing easy!\n\n**Short description:** Provides a tool for technical analysis of financial data about companies indexed on the stock market using machine learning techniques.\n\n## Introduction\n\nProFinAnalyzer is a tool and library that is supposed to make investment easy. However, it should not be used as the only tool for financial analysis and we are not liable of any profit or loss made by users (see also disclaimer section). The aim of the tool is to provide easy access to the openly available information about companies indexed on the stock market and to provide a platform for analysis of these financial information. Two areas of analysis are identified - **technical** and **event** based. \n\nUnder technical analysis we consider technical indicators and values such as price, financial ratios (PE ration, Book/Price ration, etc.)\n\nUnder event driven analysis we identify events that are publicized by news articles. \n\nCurrently, the tool focuses on long term investment and price changes. \n\nAnalysis of technical indicator and prediction whether the price will grow (at least 10% over one year period) can be done by machine learning and I have already published a research on it (http://arxiv.org/abs/1603.00751).\n\nAnalysis of news can be also important part of the decision and it could be useful to analyze automatically sentiment of the titles.  \n\n![alt tag](https://github.com/MakerSuite/ProFinAnalyzer/blob/master/img/Screen1.png)\n\n\n## How does it work?\n\nAt the moment the ProFinAnalyzer obtains data from the API provided by Yahoo! Finance. News titles are obtained by using rss feed from the Yahoo! Finance as well. To the input field should be input symbol of the company at the stockmarket (in the future, company name will be possible as well). \n\nWe have automatic analyst of technical indicators that is based on Random Forests machine learning algorithm. Analyst based on 8 indicators and machine learning should be able to predict whether a price will move up at least 10% (he will say "Buy" in that case) over the period of one year in 71% of cases. Indicators that are used by analyst are:\n* Market Capitalization\n* Book Value\n* Dividend Yield\n* Earnings Per Share\n* P/E Ratio\n* Price/Book Ratio\n* Price/Sales Ratio\n* 