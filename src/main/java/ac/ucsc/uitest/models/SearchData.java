package ac.ucsc.uitest.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchData {

    private String searchTerm;
    private String expectedCategory;

    // Find page test data
    private String input;
    private String expectedDefaultMainCategory;
    private String expectedPreferredCurrency;
    private String expectedNoResultMsg;
    private String expectedMainCategory;
    private String expectedSubCategory;
    private String selectedMainCategory;
    private String selectedSubCategory;
}