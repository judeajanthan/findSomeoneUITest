package ac.ucsc.uitest.models;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aerok
 * @created 15/03/2026
 */

@Setter
@Getter
public class SearchModel {
    private String searchTerm;
    private String expectedCategory;
}
