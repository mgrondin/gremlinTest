package Quotely;

public class QuotelyGenerator {
    //Design Decisions:
    //  There is no need to make this class a singleton, but it totally could be

    //I have provided multiple (and redundant) examples of how to support a default language:
    //In this case, I am using a final string that is publicly available so we can see what the default is, and make use of it.
    //This String is used in the default constructor.
    public static final SupportedLanguage DEFAULT_LANGUAGE = SupportedLanguage.ENGLISH;
    private String languageCode; //Stored as language code (ie: "en", "ru")

    public QuotelyGenerator() {
        setLanguage(DEFAULT_LANGUAGE);
    }

    public QuotelyGenerator(SupportedLanguage language) {
        setLanguage(language);
    }

    public ForismaticQuote getQuote(){
        return getQuote(this.languageCode);
    }

    public void getQuote(SupportedLanguage supportedLanguageEnum){
        getQuote(supportedLanguageEnum.getCode());
    }

    //I chose to make the getQuote function accept a language code as a string instead of an enum
    //because this opens up the possibility of unit testing with other or new language codes.
    //This is also why the private attribute 'languageCode' is a string.
    //Also note that there is no public way to call parse with a String lang code.
    protected ForismaticQuote getQuote(String languageCode){
        return ForismaticAPIEndpoint.call(languageCode);
    }

    public void setLanguage(SupportedLanguage language){
        this.languageCode = language.getCode();
    }

    private String getLanguageCode(){
        return this.languageCode;
    }

    private SupportedLanguage getSupportedLanguage(){
        return SupportedLanguage.getSupportedLanguageEnum(this.languageCode);
    }
}
