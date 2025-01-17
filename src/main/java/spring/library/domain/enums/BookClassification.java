package spring.library.domain.enums;

import lombok.Getter;

@Getter
public enum BookClassification {
    SCIENCE("과학"),
    ART("예술"),
    HISTORY("역사"),
    NOVEL("소설"),
    ESSAY("수필"),
    POETRY("시집"),
    ECONOMY("경제"),
    SELFHELP("자기계발"),
    RELIGION("종교"),
    LANGUAGE("외국어"),
    COMPUTER("컴퓨터"),
    COOKING("요리"),
    ETC("기타");

    private final String classification;

    BookClassification(String classification){
        this.classification = classification;
    }
    public static BookClassification from(String classification) {
        for (BookClassification bookClassification : BookClassification.values()) {
            if (bookClassification.getClassification().equals(classification)) {
                return bookClassification;
            }
        }
        return ETC;
    }
}
