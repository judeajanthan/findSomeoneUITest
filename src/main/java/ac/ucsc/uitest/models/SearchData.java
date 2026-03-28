package ac.ucsc.uitest.models;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aerok
 * {@code @created} 15/03/2026
 */

@Setter
@Getter
public class SearchData {
    private String searchTerm;
    private String expectedCategory;

    @Override
    public String toString() {
        return "SearchData{" +
                "searchTerm='" + searchTerm + '\'' +
                ", expectedCategory='" + expectedCategory + '\'' +
                '}';
    }
}
