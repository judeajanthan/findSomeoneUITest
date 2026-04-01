package ac.ucsc.uitest.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author aerok
 * {@code @created} 15/03/2026
 */

@Setter
@Getter
@ToString
public class SearchData {
    private String searchTerm;
    private String expectedCategory;

    //Find
    private String input;
    private String expectedNoResultMsg;
    private String expectedMainCategory;
    private String expectedSubCategory;
    private String selectedMainCategory;
    private String selectedSubCategory;
}
//    @Override
//    public String toString() {
//        return "SearchData{" +
//                "searchTerm='" + searchTerm + '\'' +
//                ", expectedCategory='" + expectedCategory + '\'' +
//                '}';
//    }
