// --== CS400 File Header Information ==--
// Name: Gabriel Alexander
// Email: gmalexander@wisc.edu
// Team: BB
// Role: Back End Developer
// TA: Bri
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

public class ProjectOneBackEnd {

    private HashTableMap<String, CourseReading> hashTable;


    public ProjectOneBackEnd(String file) {
        this.hashTable = readCSV(file);
    }

    /**
     * @param ISBN the ISBN number of the book to be added
     * @param bookTitle title of the book to be added
     * @param course course associated with the book to be added
     * @return
     * @throws IOException
     */
    public boolean put(String ISBN, String bookTitle, String course) {
        CourseReading toBeAdded = new CourseReading();
        toBeAdded.setISBN(ISBN);
        toBeAdded.setBookTitle(bookTitle);
        toBeAdded.setCourse(course);
        return hashTable.put(ISBN, toBeAdded);
    }

    /**
     * @param ISBN the ISBN number of the book to get
     * @return the values of ISBN, bookTitle, and course in the removed CourseReading.
     *         returns null if the ISBN number doesn't exist in the hash table.
     */
    public String get(String ISBN) {
        try {
            CourseReading toGet = hashTable.get(ISBN);
            return toGet.toCSVContent();
        } catch (NoSuchElementException nsee) {
            return "This course reading does not exist for user-define ISBN.";
        } catch (NullPointerException npe) {
            return "This course reading does not exist for user-define ISBN.";
        }
    }

/**
 * @param ISBN the ISBN number of the book to be removed
 * @return the values of ISBN, bookTitle, and course in the removed CourseReading.
 *         returns null if the ISBN number doesn't exist in the hash table.
 */
    public String remove(String ISBN) {
        return hashTable.remove(ISBN)).toCSVContent();
}
}
