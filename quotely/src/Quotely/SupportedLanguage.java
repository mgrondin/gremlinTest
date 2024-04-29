package Quotely;

public enum SupportedLanguage {
    ENGLISH("en"),
    RUSSIAN("ru");

    private final String code;
    SupportedLanguage(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public static SupportedLanguage getSupportedLanguageEnum(String langCode){
        if(langCode != null)
            for(SupportedLanguage langEnum : values()){
                if(langEnum.code.equals(langCode.toLowerCase()))
                    return langEnum;
            }
        return null;
    }
}
