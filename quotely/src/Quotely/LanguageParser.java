package Quotely;

//Parses any string object into one of the available languages as a SupportedLanguage enum
//It is not case sensitive
//Can be called with an optional parameter to specify the default language
//If a default language is specified, and the input string cannot be parsed, or matched, or is null,
//  then the default language will be returned.
//If parse is called without the default language parameter, or if it is set to null, and the input cannot be matched,
//  Then parse() will return NULL.
public class LanguageParser {

    public static SupportedLanguage parse(String input){
        return parse(input, null);
    }

    public static SupportedLanguage parse(String input, SupportedLanguage defaultLang){
        SupportedLanguage returnValue = null;
        if(defaultLang != null){
            returnValue = defaultLang;
        }

        if(input != null){
            input = input.toLowerCase(); //I am choosing to make this case-insensitive.
            switch (input){
                case "russian":
                    returnValue = SupportedLanguage.RUSSIAN;
                    break;
                case "english":
                    returnValue = SupportedLanguage.ENGLISH;
                    break;
                default:
                    returnValue = defaultLang;
            }
        }
        return returnValue;
    }
}
