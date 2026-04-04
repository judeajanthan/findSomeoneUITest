package ac.ucsc.uitest.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author aerok
 * @code @created 28/03/2026
 */
@Setter
@Getter
@ToString
public class BaseDataModel <T>{

    String testId;
    List<T> testData;

}
