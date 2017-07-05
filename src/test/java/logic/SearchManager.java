package logic;

/**
 * Created by Rihn Kornak on 24.06.2017.
 */
public interface SearchManager extends Manager {
    void searchWords(String words);
    int NumberOfResultsOnPage();
    void searchInFinded(String text);

}
