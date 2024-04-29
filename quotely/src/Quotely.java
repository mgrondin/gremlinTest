import Quotely.QuotelyGenerator;
import Quotely.LanguageParser;
import Quotely.SupportedLanguage;

import Quotely.ForismaticQuote;

//Please run
public class Quotely {
    public static void main(String[] args) {
        System.out.println("Welcome to Quotely!");

        QuotelyGenerator generator;
        if(args.length == 0){
            generator = new QuotelyGenerator();
        } else {
            generator = new QuotelyGenerator( LanguageParser.parse(args[0], SupportedLanguage.ENGLISH) );
        }

        ForismaticQuote quote = generator.getQuote();

        System.out.println("Today's Quote: " + quote.getQuoteText());
        System.out.println("by: " + quote.getQuoteAuthor());
    }
}